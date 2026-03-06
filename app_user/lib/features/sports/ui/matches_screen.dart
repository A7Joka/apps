import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:cached_network_image/cached_network_image.dart';
import '../data/sports_api_service.dart';
import 'match_details_screen.dart';
import 'championship_details_screen.dart';
import '../../../main.dart';

class MatchesScreen extends StatefulWidget {
  const MatchesScreen({super.key});

  @override
  State<MatchesScreen> createState() => _MatchesScreenState();
}

class _MatchesScreenState extends State<MatchesScreen> {
  final SportsApiService _apiService = SportsApiService();
  Map<int, Map<String, dynamic>> _groupedMatches = {};
  bool _isLoading = true;
  DateTime _currentDate = DateTime.now();

  late List<DateTime> _dateList;
  final ScrollController _scrollController = ScrollController(initialScrollOffset: 7 * 60.0);

  String t(String ar, String en) => localeNotifier.value.languageCode == 'ar' ? ar : en;

  @override
  void initState() {
    super.initState();
    _generateDateList();
    _fetchMatchesForDate();
  }

  @override
  void dispose() {
    _scrollController.dispose();
    super.dispose();
  }

  void _generateDateList() {
    DateTime today = DateTime.now();
    _dateList = List.generate(15, (index) => today.subtract(Duration(days: 7 - index)));
  }

  Future<void> _fetchMatchesForDate() async {
    setState(() => _isLoading = true);
    String formattedDate = DateFormat('yyyy-MM-dd').format(_currentDate);
    String currentLang = localeNotifier.value.languageCode;
    final matchesList = await _apiService.getMatchesByDate(formattedDate, currentLang);

    Map<int, Map<String, dynamic>> tempGrouped = {};
    for (var match in matchesList) {
      final champ = match['championship'];
      final champId = champ['id'] as int;

      if (!tempGrouped.containsKey(champId)) {
        tempGrouped[champId] = {'championship_info': champ, 'matches': <dynamic>[]};
      }
      tempGrouped[champId]!['matches'].add(match);
    }

    setState(() {
      _groupedMatches = tempGrouped;
      _isLoading = false;
    });
  }

  void _changeDate(int days) {
    setState(() => _currentDate = _currentDate.add(Duration(days: days)));
    _fetchMatchesForDate();
  }

  void _openCustomDatePicker() {
    final isDark = Theme.of(context).brightness == Brightness.dark;
    showModalBottomSheet(
      context: context,
      backgroundColor: isDark ? const Color(0xFF1E2026) : Colors.white,
      shape: const RoundedRectangleBorder(borderRadius: BorderRadius.vertical(top: Radius.circular(25))),
      builder: (context) {
        return SizedBox(
          height: 400,
          child: Column(
            children: [
              const SizedBox(height: 10),
              Container(width: 40, height: 5, decoration: BoxDecoration(color: Colors.grey.withAlpha(100), borderRadius: BorderRadius.circular(10))),
              Expanded(
                child: Theme(
                  data: Theme.of(context).copyWith(
                    colorScheme: ColorScheme.light(primary: Theme.of(context).primaryColor, onSurface: isDark ? Colors.white : Colors.black),
                  ),
                  child: CalendarDatePicker(
                    initialDate: _currentDate,
                    firstDate: DateTime(2020),
                    lastDate: DateTime(2030),
                    onDateChanged: (picked) {
                      setState(() => _currentDate = picked);
                      _fetchMatchesForDate();
                      Navigator.pop(context);
                    },
                  ),
                ),
              ),
            ],
          ),
        );
      },
    );
  }

  void _showSettingsSheet() {
    showModalBottomSheet(
      context: context,
      backgroundColor: Theme.of(context).scaffoldBackgroundColor,
      shape: const RoundedRectangleBorder(borderRadius: BorderRadius.vertical(top: Radius.circular(20))),
      builder: (context) {
        return Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Container(width: 40, height: 5, decoration: BoxDecoration(color: Colors.grey.withAlpha(100), borderRadius: BorderRadius.circular(10))),
              const SizedBox(height: 20),
              Text(t("إعدادات التطبيق", "App Settings"), style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              const SizedBox(height: 20),
              ListTile(
                leading: const Icon(Icons.dark_mode),
                title: Text(t("المظهر (Dark / Light)", "Theme (Dark / Light)")),
                trailing: Switch(
                  value: themeNotifier.value == ThemeMode.dark,
                  activeColor: Colors.amber,
                  onChanged: (val) {
                    themeNotifier.value = val ? ThemeMode.dark : ThemeMode.light;
                    Navigator.pop(context);
                  },
                ),
              ),
              ListTile(
                leading: const Icon(Icons.language),
                title: Text(t("اللغة (عربي / English)", "Language (Arabic / English)")),
                trailing: Switch(
                  value: localeNotifier.value.languageCode == 'ar',
                  activeColor: Colors.blue,
                  onChanged: (val) {
                    localeNotifier.value = val ? const Locale('ar') : const Locale('en');
                    _fetchMatchesForDate(); // إعادة تحميل الداتا باللغة الجديدة فوراً
                    Navigator.pop(context);
                  },
                ),
              ),
            ],
          ),
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    final isDark = Theme.of(context).brightness == Brightness.dark;
    final bgColor = isDark ? const Color(0xFF0F1115) : const Color(0xFFF0F2F5);

    return Scaffold(
      backgroundColor: bgColor,
      extendBodyBehindAppBar: true,
      body: Stack(
        children: [
          // قائمة المباريات
          _isLoading
              ? Center(child: CircularProgressIndicator(color: Theme.of(context).primaryColor))
              : _groupedMatches.isEmpty
              ? Center(child: Text(t("لا توجد مباريات", "No Matches"), style: const TextStyle(color: Colors.grey)))
              : ListView.builder(
            physics: const BouncingScrollPhysics(),
            padding: const EdgeInsets.only(top: 155, left: 15, right: 15, bottom: 100), // قللنا المساحة العلوية
            itemCount: _groupedMatches.length,
            itemBuilder: (context, index) {
              final key = _groupedMatches.keys.elementAt(index);
              return _buildChampionshipGroup(_groupedMatches[key]!, isDark);
            },
          ),

          // الهيرو (تم تصغير المساحات السفلية)
          Positioned(
            top: 0, left: 0, right: 0,
            child: ClipRRect(
              borderRadius: const BorderRadius.vertical(bottom: Radius.circular(25)),
              child: BackdropFilter(
                filter: ImageFilter.blur(sigmaX: 20, sigmaY: 20),
                child: Container(
                  padding: EdgeInsets.only(top: MediaQuery.of(context).padding.top + 5, bottom: 10),
                  decoration: BoxDecoration(
                    color: isDark ? const Color(0xFF1E2026).withAlpha(220) : Colors.white.withAlpha(230),
                    border: Border(bottom: BorderSide(color: isDark ? Colors.white.withAlpha(20) : Colors.grey.shade300, width: 1)),
                  ),
                  child: Column(
                    children: [
                      Padding(
                        padding: const EdgeInsets.symmetric(horizontal: 20),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            Text("MoviBall", style: TextStyle(fontSize: 24, fontWeight: FontWeight.w900, color: Theme.of(context).primaryColor)),
                            IconButton(icon: Icon(Icons.settings, color: isDark ? Colors.white : Colors.black87), onPressed: _showSettingsSheet),
                          ],
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.symmetric(horizontal: 15),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            IconButton(icon: Icon(Icons.chevron_left_rounded, color: Theme.of(context).primaryColor), onPressed: () => _changeDate(-1)),
                            GestureDetector(
                              onTap: _openCustomDatePicker,
                              child: Row(
                                children: [
                                  Text(
                                    DateFormat('EEEE, d MMMM', localeNotifier.value.languageCode).format(_currentDate),
                                    style: TextStyle(fontSize: 15, fontWeight: FontWeight.bold, color: isDark ? Colors.white : Colors.black87),
                                  ),
                                ],
                              ),
                            ),
                            IconButton(icon: Icon(Icons.chevron_right_rounded, color: Theme.of(context).primaryColor), onPressed: () => _changeDate(1)),
                          ],
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }

  // جروب البطولة (دخول للتفاصيل بدلاً من الطي)
  Widget _buildChampionshipGroup(Map<String, dynamic> group, bool isDark) {
    final champ = group['championship_info'];
    final matches = group['matches'] as List<dynamic>;
    final champLogo = "https://imgs.ysscores.com/championship/150/${champ['image']}";

    return Padding(
      padding: const EdgeInsets.only(bottom: 15.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // تم استبدال الـ ExpansionTile بـ GestureDetector لفتح شاشة تفاصيل البطولة
          GestureDetector(
            onTap: () {
              Navigator.push(context, MaterialPageRoute(builder: (context) => ChampionshipDetailsScreen(champData: champ)));
            },
            child: Container(
              padding: const EdgeInsets.symmetric(vertical: 8, horizontal: 5),
              color: Colors.transparent,
              child: Row(
                children: [
                  ModernLogo(url: champLogo, size: 24, isCup: true),
                  const SizedBox(width: 8),
                  Expanded(
                    child: Text(
                      champ['title'] ?? "بطولة",
                      style: TextStyle(fontSize: 15, fontWeight: FontWeight.w900, color: isDark ? Colors.white : Colors.black87),
                    ),
                  ),
                  Icon(Icons.chevron_right_rounded, color: Colors.grey.shade600, size: 20),
                ],
              ),
            ),
          ),
          const SizedBox(height: 5),
          ...matches.map((m) => SmartMatchCard(match: m, isDark: isDark)),
        ],
      ),
    );
  }
}

// ---------------------------------------------------------
// 🧠 الكارت الذكي (تصغير الوقت، تعديل المؤجل)
// ---------------------------------------------------------
class SmartMatchCard extends StatelessWidget {
  final dynamic match;
  final bool isDark;

  const SmartMatchCard({super.key, required this.match, required this.isDark});

  String _formatTime12H(String dateStr, String timeStr) {
    try {
      DateTime dt = DateFormat("yyyy-MM-dd HH:mm:ss").parse("$dateStr $timeStr");
      bool isAr = localeNotifier.value.languageCode == 'ar';
      String formattedTime = DateFormat('h:mm', 'en').format(dt);
      String ampm = dt.hour >= 12 ? (isAr ? "م" : "PM") : (isAr ? "ص" : "AM");
      return "$formattedTime $ampm";
    } catch (e) {
      return timeStr.substring(0, 5);
    }
  }

  String t(String ar, String en) => localeNotifier.value.languageCode == 'ar' ? ar : en;

  @override
  Widget build(BuildContext context) {
    final homeTeam = match['home_team']['title'] ?? "";
    final awayTeam = match['away_team']['title'] ?? "";
    final homeLogo = "https://imgs.ysscores.com/teams/150/${match['home_team']['image']}";
    final awayLogo = "https://imgs.ysscores.com/teams/150/${match['away_team']['image']}";

    final int status = match['status'] ?? 0;
    final String date = match['match_date'] ?? "";
    final String rawTime = match['match_time'] ?? "00:00:00";
    final String time12h = _formatTime12H(date, rawTime);

    final String homeScore = match['home_scores']?.toString() ?? "-";
    final String awayScore = match['away_scores']?.toString() ?? "-";

    String statusText = "";
    Color statusColor = Colors.grey;
    bool isLive = false;
    bool isPostponed = false;

    switch (status) {
      case 0: statusText = ""; break;
      case 1: statusText = t("شوط أول", "1st Half"); statusColor = Colors.green; isLive = true; break;
      case 2: statusText = t("شوط ثاني", "2nd Half"); statusColor = Colors.green; isLive = true; break;
      case 3: statusText = t("انتهت", "FT"); statusColor = isDark ? Colors.white54 : Colors.black54; break;
      case 4: statusText = t("انتهت", "FT"); statusColor = isDark ? Colors.white54 : Colors.black54; break;
      case 7: statusText = t("إضافي أول", "1st ET"); statusColor = Colors.green; isLive = true; break;
      case 9: statusText = t("إضافي ثاني", "2nd ET"); statusColor = Colors.green; isLive = true; break;
      case 5: case 6: case 8: case 10: case 11: case 14:
      statusText = t("مؤجلة", "Postponed"); statusColor = Colors.redAccent; isPostponed = true; break;
      default: statusText = t("مباشر", "Live"); statusColor = Colors.red; isLive = true;
    }

    final textColor = isDark ? Colors.white : Colors.black87;
    final cardBgColor = isDark ? const Color(0xFF16181E) : Colors.white;

    // تحديد النص المعروض في المنتصف (للمؤجل نعرض الوقت بدلاً من النتيجة)
    String centerDisplay;
    if (status == 0 || isPostponed) {
      centerDisplay = time12h;
    } else {
      centerDisplay = "$homeScore - $awayScore";
    }

    return GestureDetector(
      onTap: () => Navigator.push(context, MaterialPageRoute(builder: (context) => MatchDetailsScreen(matchId: match['match_id'].toString(), matchData: match))),
      child: Container(
        margin: const EdgeInsets.only(bottom: 8),
        padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 10),
        decoration: BoxDecoration(
          color: cardBgColor,
          borderRadius: BorderRadius.circular(16),
          border: Border.all(color: isDark ? Colors.white.withAlpha(15) : Colors.grey.shade200),
        ),
        child: isLive
            ? _buildLiveLayout(homeTeam, awayTeam, homeLogo, awayLogo, homeScore, awayScore, statusText, statusColor, textColor)
            : _buildStandardLayout(homeTeam, awayTeam, homeLogo, awayLogo, centerDisplay, statusText, statusColor, textColor),
      ),
    );
  }

  Widget _buildStandardLayout(String hTeam, String aTeam, String hLogo, String aLogo, String centerText, String statusText, Color statusColor, Color textColor) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Expanded(flex: 3, child: Text(hTeam, textAlign: TextAlign.center, maxLines: 2, style: TextStyle(fontSize: 12, fontWeight: FontWeight.bold, color: textColor), overflow: TextOverflow.ellipsis)),
        const SizedBox(width: 6),
        ModernLogo(url: hLogo, size: 28),

        Expanded(
          flex: 3,
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              if (statusText.isNotEmpty)
                Text(statusText, style: TextStyle(color: statusColor, fontSize: 9, fontWeight: FontWeight.bold)),

              // تم تصغير الخط من 18 لـ 15 ليكون أنيقاً
              Text(centerText, style: TextStyle(color: textColor, fontSize: 15, fontWeight: FontWeight.w900, fontFamily: 'Roboto')),
            ],
          ),
        ),

        ModernLogo(url: aLogo, size: 28),
        const SizedBox(width: 6),
        Expanded(flex: 3, child: Text(aTeam, textAlign: TextAlign.center, maxLines: 2, style: TextStyle(fontSize: 12, fontWeight: FontWeight.bold, color: textColor), overflow: TextOverflow.ellipsis)),
      ],
    );
  }

  Widget _buildLiveLayout(String hTeam, String aTeam, String hLogo, String aLogo, String hScore, String aScore, String statusText, Color statusColor, Color textColor) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ModernLogo(url: hLogo, size: 30),
            const Spacer(),
            Text(hScore, style: const TextStyle(color: Colors.amber, fontSize: 22, fontWeight: FontWeight.w900, fontFamily: 'Roboto')),

            Container(
              margin: const EdgeInsets.symmetric(horizontal: 10),
              padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 2),
              decoration: BoxDecoration(color: statusColor.withAlpha(40), borderRadius: BorderRadius.circular(8)),
              child: Row(
                children: [
                  Container(width: 5, height: 5, decoration: BoxDecoration(color: statusColor, shape: BoxShape.circle)),
                  const SizedBox(width: 4),
                  Text(statusText, style: TextStyle(color: statusColor, fontSize: 9, fontWeight: FontWeight.bold)),
                ],
              ),
            ),

            Text(aScore, style: const TextStyle(color: Colors.amber, fontSize: 22, fontWeight: FontWeight.w900, fontFamily: 'Roboto')),
            const Spacer(),
            ModernLogo(url: aLogo, size: 30),
          ],
        ),
        const SizedBox(height: 5),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Expanded(child: Text(hTeam, textAlign: TextAlign.start, maxLines: 2, style: TextStyle(fontSize: 11, fontWeight: FontWeight.bold, color: textColor), overflow: TextOverflow.ellipsis)),
            Expanded(child: Text(aTeam, textAlign: TextAlign.end, maxLines: 2, style: TextStyle(fontSize: 11, fontWeight: FontWeight.bold, color: textColor), overflow: TextOverflow.ellipsis)),
          ],
        )
      ],
    );
  }
}

class ModernLogo extends StatelessWidget {
  final String url;
  final double size;
  final bool isCup;
  const ModernLogo({super.key, required this.url, required this.size, this.isCup = false});

  @override
  Widget build(BuildContext context) {
    return CachedNetworkImage(
      imageUrl: url,
      width: size, height: size,
      httpHeaders: const {"Referer": "https://ysscores.com/"},
      imageBuilder: (context, imageProvider) => Container(
        decoration: BoxDecoration(image: DecorationImage(image: imageProvider, fit: BoxFit.contain)),
      ),
      placeholder: (context, url) => SizedBox(width: size, height: size, child: const Padding(padding: EdgeInsets.all(5.0), child: CircularProgressIndicator(strokeWidth: 1.5))),
      errorWidget: (context, url, error) => Icon(isCup ? Icons.emoji_events : Icons.shield, color: Colors.grey, size: size * 0.8),
    );
  }
}