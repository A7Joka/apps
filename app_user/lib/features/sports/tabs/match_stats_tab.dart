import 'package:flutter/material.dart';
import '../data/sports_api_service.dart';
import '../../../../main.dart';

class MatchStatsTab extends StatelessWidget {
  final String matchId;
  final String homeTeamId;
  final String awayTeamId;

  const MatchStatsTab({super.key, required this.matchId, required this.homeTeamId, required this.awayTeamId});

  String t(String ar, String en) => localeNotifier.value.languageCode == 'ar' ? ar : en;

  @override
  Widget build(BuildContext context) {
    final isDark = Theme.of(context).brightness == Brightness.dark;
    final cardColor = isDark ? const Color(0xFF1E2026) : Colors.white;
    final borderColor = isDark ? Colors.white.withAlpha(15) : Colors.grey.shade200;

    return FutureBuilder<Map<String, dynamic>>(
      future: SportsApiService().getMatchStats(matchId),
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) return Center(child: CircularProgressIndicator(color: Theme.of(context).primaryColor));
        if (!snapshot.hasData || snapshot.data!.isEmpty) {
          return Center(child: Text(t("لا توجد إحصائيات", "No Stats"), style: const TextStyle(color: Colors.grey)));
        }

        final data = snapshot.data ?? {};
        // بناءً على الـ JSON الجديد، الداتا جوة مفتاح 'statics'
        final statics = data['statics'] ?? data;

        final homeStats = statics[homeTeamId] ?? {};
        final awayStats = statics[awayTeamId] ?? {};

        // 🗂️ تقسيم الإحصائيات لمجموعات
        final group1 = [
          {'key': 'ball_possession', 'ar': 'الاستحواذ (%)', 'en': 'Possession (%)'},
          {'key': 'total_shots', 'ar': 'إجمالي التسديدات', 'en': 'Total Shots'},
          {'key': 'goalkeeper_saves', 'ar': 'تصديات الحارس', 'en': 'GK Saves'},
          {'key': 'cross_ball', 'ar': 'العرضيات', 'en': 'Crosses'},
        ];

        final group2 = [
          {'key': 'total_passes', 'ar': 'إجمالي التمريرات', 'en': 'Total Passes'},
          {'key': 'passes_accurate', 'ar': 'التمريرات الصحيحة', 'en': 'Accurate Passes'},
          {'key': 'passes_percentage', 'ar': 'دقة التمرير (%)', 'en': 'Pass Accuracy (%)'},
        ];

        final group3 = [
          {'key': 'fouls', 'ar': 'المخالفات', 'en': 'Fouls'},
          {'key': 'corner_kicks', 'ar': 'الركنيات', 'en': 'Corners'},
          {'key': 'throwin', 'ar': 'رميات التماس', 'en': 'Throw-ins'},
          {'key': 'goalkick', 'ar': 'ضربات المرمى', 'en': 'Goal Kicks'},
          {'key': 'offsides', 'ar': 'التسلل', 'en': 'Offsides'},
          {'key': 'yellow_cards', 'ar': 'بطاقات صفراء', 'en': 'Yellow Cards'},
          {'key': 'red_cards', 'ar': 'بطاقات حمراء', 'en': 'Red Cards'},
        ];

        return ListView(
          physics: const BouncingScrollPhysics(),
          padding: const EdgeInsets.symmetric(horizontal: 15, vertical: 20),
          children: [
            _buildStatCard(t("الهجوم والاستحواذ", "Attack & Possession"), group1, homeStats, awayStats, isDark, cardColor, borderColor, context),
            _buildStatCard(t("التمريرات", "Passes"), group2, homeStats, awayStats, isDark, cardColor, borderColor, context),
            _buildStatCard(t("أخطاء وتوقفات", "Fouls & Stops"), group3, homeStats, awayStats, isDark, cardColor, borderColor, context),
            const SizedBox(height: 40),
          ],
        );
      },
    );
  }

  // بناء كارت مجمع لمجموعة من الإحصائيات
  Widget _buildStatCard(String title, List<Map<String, String>> items, Map hStats, Map aStats, bool isDark, Color cardColor, Color borderColor, BuildContext context) {
    // تصفية العناصر اللي ملهاش قيم في الـ API
    final validItems = items.where((item) => hStats[item['key']] != null || aStats[item['key']] != null).toList();
    if (validItems.isEmpty) return const SizedBox.shrink(); // إخفاء الكارت لو فاضي تماماً

    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Padding(
          padding: const EdgeInsets.only(bottom: 10, right: 5, left: 5),
          child: Text(title, style: const TextStyle(fontSize: 15, fontWeight: FontWeight.w900)),
        ),
        Container(
          margin: const EdgeInsets.only(bottom: 25),
          padding: const EdgeInsets.only(top: 20, bottom: 5, left: 15, right: 15),
          decoration: BoxDecoration(color: cardColor, borderRadius: BorderRadius.circular(16), border: Border.all(color: borderColor)),
          child: Column(
            children: validItems.map((item) {
              return _buildPremiumStatBar(
                title: t(item['ar']!, item['en']!),
                homeVal: hStats[item['key']]?.toString() ?? "0",
                awayVal: aStats[item['key']]?.toString() ?? "0",
                isDark: isDark,
                context: context,
              );
            }).toList(),
          ),
        ),
      ],
    );
  }

  // 💎 شريط الإحصائيات المطور (ألوان ناعمة جداً، نص فوق الشريط)
  Widget _buildPremiumStatBar({required String title, required String homeVal, required String awayVal, required bool isDark, required BuildContext context}) {
    // ألوان ناعمة جداً (Soft Colors) للعين
    final Color homeColor = isDark ? const Color(0xFFFBBF24) : const Color(0xFFD97706); // أصفر ذهبي هادئ
    final Color awayColor = isDark ? const Color(0xFF60A5FA) : const Color(0xFF2563EB); // أزرق سماوي هادئ

    final double hNum = double.tryParse(homeVal) ?? 0.0;
    final double aNum = double.tryParse(awayVal) ?? 0.0;
    final double total = hNum + aNum;

    double homeFlex = 0.5;
    if (total > 0) homeFlex = hNum / total;

    return Padding(
      padding: const EdgeInsets.only(bottom: 15.0),
      child: Column(
        children: [
          // النصوص (الرقم - الفئة - الرقم)
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(homeVal, style: TextStyle(fontSize: 14, fontWeight: FontWeight.w900, color: homeColor, fontFamily: 'Roboto')),
              Text(title, style: TextStyle(fontSize: 12, fontWeight: FontWeight.bold, color: isDark ? Colors.white70 : Colors.black87)),
              Text(awayVal, style: TextStyle(fontSize: 14, fontWeight: FontWeight.w900, color: awayColor, fontFamily: 'Roboto')),
            ],
          ),
          const SizedBox(height: 6),

          // الشريط النحيف المندمج (Opacity 50%)
          ClipRRect(
            borderRadius: BorderRadius.circular(10),
            child: Container(
              height: 6, // شريط نحيف جداً
              color: isDark ? Colors.white10 : Colors.black.withAlpha(15),
              child: total > 0 ? TweenAnimationBuilder<double>(
                tween: Tween<double>(begin: 0, end: homeFlex),
                duration: const Duration(milliseconds: 1000),
                curve: Curves.easeOutQuart,
                builder: (context, val, child) {
                  final hFlex = (val * 1000).toInt();
                  final aFlex = ((1 - val) * 1000).toInt();
                  return Row(
                    children: [
                      Expanded(
                        flex: hFlex > 0 ? hFlex : 1,
                        child: Container(
                          decoration: BoxDecoration(
                            color: homeColor.withAlpha(150), // شفافية 60% لراحة العين
                            borderRadius: const BorderRadius.only(topLeft: Radius.circular(10), bottomLeft: Radius.circular(10)),
                          ),
                        ),
                      ),
                      Expanded(
                        flex: aFlex > 0 ? aFlex : 1,
                        child: Container(
                          decoration: BoxDecoration(
                            color: awayColor.withAlpha(150), // شفافية 60% لراحة العين
                            borderRadius: const BorderRadius.only(topRight: Radius.circular(10), bottomRight: Radius.circular(10)),
                          ),
                        ),
                      ),
                    ],
                  );
                },
              ) : const SizedBox(),
            ),
          ),
        ],
      ),
    );
  }
}