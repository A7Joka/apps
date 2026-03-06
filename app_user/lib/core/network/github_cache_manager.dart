import 'package:dio/dio.dart';
import 'package:hive_flutter/hive_flutter.dart';
import 'package:shared_preferences/shared_preferences.dart';

class GithubCacheManager {
  static const String _versionUrl = "https://raw.githubusercontent.com/A7Joka/JOKA/main/version.json";
  static const String _dataUrl = "https://raw.githubusercontent.com/A7Joka/JOKA/main/data.json";
  static const String _boxName = "super_app_box";
  static const String _dataKey = "live_tv_channels";
  final Dio _dio = Dio();
  Future<void> initializeData() async {
    final prefs = await SharedPreferences.getInstance();
    final localTimestamp = prefs.getInt('last_timestamp') ?? 0;

    try {
      final versionResponse = await _dio.get(_versionUrl);
      final serverTimestamp = int.parse(versionResponse.data['timestamp'].toString());
      if (serverTimestamp > localTimestamp) {
        print("💡 تم اكتشاف تحديث جديد! جاري التحميل من GitHub...");
        final dataResponse = await _dio.get(_dataUrl);
        final box = Hive.box(_boxName);
        await box.put(_dataKey, dataResponse.data);
        await prefs.setInt('last_timestamp', serverTimestamp);
        print("✅ تم التحديث والحفظ بنجاح.");
      } else {
        print("⚡ الداتا الحالية هي الأحدث، لا داعي لاستهلاك الإنترنت.");
      }
    } catch (e) {
      print("⚠️ خطأ في الاتصال، سيتم استخدام البيانات المحلية: $e");
    }
  }
  Map<dynamic, dynamic>? getCachedLiveTvData() {
    final box = Hive.box(_boxName);
    return box.get(_dataKey);
  }
}