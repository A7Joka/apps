import 'package:dio/dio.dart';
import 'package:shared_preferences/shared_preferences.dart';

class SportsApiService {
  final Dio _dio = Dio();

  // جلب الـ Base URL حسب اللغة
  Future<String> _getBaseUrl() async {
    final prefs = await SharedPreferences.getInstance();
    final lang = prefs.getString('app_lang') ?? 'ar';
    return 'https://api-$lang.ysscores.com/api';
  }

  // 1. جلب جدول المباريات
  // أضفنا متغير lang هنا
  Future<List<dynamic>> getMatchesByDate(String date, String lang) async {
    try {
      // استخدمنا المتغير المرر لتحديد رابط الـ API
      final endpoint = 'https://api-$lang.ysscores.com/api/matches/matches_date_get/$date/[]/[]/[]/180';
      final response = await _dio.get(endpoint);

      if (response.statusCode == 200 && response.data['status'] == true) {
        return response.data['data'] ?? [];
      }
      return [];
    } catch (e) {
      print("Error in getMatchesByDate: $e");
      return [];
    }
  }

  // 2. جلب معلومات المباراة (Match Info)
  Future<Map<String, dynamic>> getMatchInfo(String matchId) async {
    try {
      final baseUrl = await _getBaseUrl();
      final response = await _dio.get('$baseUrl/matches/match_info/$matchId');
      return response.data['data'] ?? {};
    } catch (e) {
      return {};
    }
  }

  // 3. جلب أحداث المباراة (الأهداف، البطاقات)
  // 3. جلب أحداث المباراة (الأهداف، البطاقات، التبديلات)
  Future<List<dynamic>> getMatchEvents(String matchId) async {
    try {
      final baseUrl = await _getBaseUrl();
      final response = await _dio.get('$baseUrl/matches/matches_event/$matchId');

      // الدخول لمفتاح events مباشرة
      if (response.data['data'] != null && response.data['data']['events'] != null) {
        return response.data['data']['events'];
      }
      return [];
    } catch (e) {
      print("⚠️ خطأ في أحداث المباراة: $e");
      return [];
    }
  }

  // 4. جلب التشكيل (Lineup)
  Future<Map<String, dynamic>> getMatchLineup(String matchId) async {
    try {
      final baseUrl = await _getBaseUrl();
      final response = await _dio.get('$baseUrl/matches/matches_lineup/$matchId');
      return response.data['data'] ?? {};
    } catch (e) {
      return {};
    }
  }

  // 5. جلب الإحصائيات (Statistics)

  Future<Map<String, dynamic>> getMatchStats(String matchId) async {
    try {
      final baseUrl = await _getBaseUrl();
      final response = await _dio.get('$baseUrl/matches/statics_match/$matchId');

      if (response.data['data'] != null && response.data['data']['statics'] != null) {
        return response.data['data']['statics'];
      }
      return {};
    } catch (e) {
      print("⚠️ خطأ في إحصائيات المباراة: $e");
      return {};
    }
  }

  // 6. جلب القنوات الناقلة والمعلقين (Channels)
  Future<List<dynamic>> getMatchChannels(String matchId) async {
    try {
      final baseUrl = await _getBaseUrl();
      final response = await _dio.get('$baseUrl/matches/channel_match/$matchId');
      return response.data['data'] ?? [];
    } catch (e) {
      return [];
    }
  }
}