import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import '../data/sports_api_service.dart';
import '../../../../main.dart';

class MatchInfoTab extends StatelessWidget {
  final String matchId;
  final String homeTeamName;
  final String awayTeamName;

  const MatchInfoTab({
    super.key,
    required this.matchId,
    required this.homeTeamName,
    required this.awayTeamName,
  });

  String t(String ar, String en) => localeNotifier.value.languageCode == 'ar' ? ar : en;

  @override
  Widget build(BuildContext context) {
    final isDark = Theme.of(context).brightness == Brightness.dark;
    final cardColor = isDark ? const Color(0xFF1E2026) : Colors.white;
    final borderColor = isDark ? Colors.white.withAlpha(15) : Colors.grey.shade200;

    return FutureBuilder<Map<String, dynamic>>(
      future: SportsApiService().getMatchInfo(matchId),
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) return Center(child: CircularProgressIndicator(color: Theme.of(context).primaryColor));

        final data = snapshot.data ?? {};

        // 1. استخراج بيانات المباراة الأساسية
        final championship = data['championship']?['title'] ?? "";
        final round = data['round'] ?? "";
        final stadium = data['Stadium'] ?? t("غير محدد", "Unknown");
        final timestamp = data['match_timestamp'] ?? 0;

        String dayStr = "-";
        String timeStr = "-";
        if (timestamp > 0) {
          DateTime dt = DateTime.fromMillisecondsSinceEpoch(timestamp * 1000);
          dayStr = DateFormat('EEEE, d MMMM yyyy', localeNotifier.value.languageCode).format(dt);
          bool isAr = localeNotifier.value.languageCode == 'ar';
          timeStr = DateFormat('h:mm', 'en').format(dt) + (dt.hour >= 12 ? (isAr ? " م" : " PM") : (isAr ? " ص" : " AM"));
        }

        // 2. الحكام والقنوات (من الـ JSON الجديد)
        final referees = data['referees']; // قد يكون Map أو List
        final List<dynamic> refList = referees is List ? referees : (referees != null ? [referees] : []);
        final channels = data['channel_commm'] as List<dynamic>? ?? [];

        // 3. المواجهات
        final playedResult = data['played_result'] ?? {};
        final homeLast5 = (playedResult['home'] as Map<String, dynamic>? ?? {}).values.take(5).toList();
        final awayLast5 = (playedResult['away'] as Map<String, dynamic>? ?? {}).values.take(5).toList();
        final h2hMatches = (playedResult['between'] as Map<String, dynamic>? ?? {}).values.take(5).toList();

        return ListView(
          physics: const BouncingScrollPhysics(),
          padding: const EdgeInsets.symmetric(horizontal: 15, vertical: 20),
          children: [

            // --- 1. معلومات المباراة الأساسية ---
            _buildSectionTitle(t("معلومات المباراة", "Match Info")),
            Container(
              decoration: BoxDecoration(color: cardColor, borderRadius: BorderRadius.circular(16), border: Border.all(color: borderColor)),
              child: Column(
                children: [
                  if (championship.isNotEmpty) _buildInfoRow(Icons.emoji_events_outlined, t("البطولة", "Championship"), championship, isDark),
                  if (round.isNotEmpty) _buildInfoRow(Icons.flag_outlined, t("الجولة", "Round"), round, isDark),
                  _buildInfoRow(Icons.calendar_today_rounded, t("التاريخ", "Date"), dayStr, isDark),
                  _buildInfoRow(Icons.access_time_rounded, t("التوقيت", "Time"), timeStr, isDark),
                  _buildInfoRow(Icons.stadium_rounded, t("الملعب", "Stadium"), stadium, isDark, isLast: true),
                ],
              ),
            ),
            const SizedBox(height: 20),

            // --- 2. القنوات الناقلة (قابلة للطي) ---
            if (channels.isNotEmpty)
              _buildExpandableSection(
                title: t("القنوات الناقلة", "Broadcasting"),
                icon: Icons.live_tv_rounded,
                isDark: isDark,
                children: channels.map((ch) => _buildChannelRow(
                  channelName: ch['channel_name'] ?? t("قناة", "Channel"),
                  commentator: ch['commentator_name'] ?? t("بدون معلق", "No Commentator"),
                  isDark: isDark,
                )).toList(),
              ),

            // --- 3. طاقم التحكيم (قابل للطي) ---
            if (refList.isNotEmpty)
              _buildExpandableSection(
                title: t("طاقم التحكيم", "Referees"),
                icon: Icons.sports,
                isDark: isDark,
                children: refList.map((ref) => _buildRefereeRow(
                  name: ref['title'] ?? t("غير معروف", "Unknown"),
                  role: ref['referee_type'] ?? t("حكم", "Referee"),
                  isDark: isDark,
                )).toList(),
              ),

            // --- 4. المواجهات المباشرة (H2H) ---
            if (h2hMatches.isNotEmpty) ...[
              _buildSectionTitle(t("المواجهات المباشرة (H2H)", "Head to Head")),
              Container(
                padding: const EdgeInsets.symmetric(vertical: 10),
                decoration: BoxDecoration(color: cardColor, borderRadius: BorderRadius.circular(16), border: Border.all(color: borderColor)),
                child: Column(children: h2hMatches.map((m) => _buildH2HRow(m, isDark)).toList()),
              ),
              const SizedBox(height: 20),
            ],

            // --- 5. آخر 5 مباريات ---
            if (homeLast5.isNotEmpty || awayLast5.isNotEmpty) ...[
              _buildSectionTitle(t("آخر 5 مباريات", "Last 5 Matches")),
              Container(
                padding: const EdgeInsets.symmetric(vertical: 15, horizontal: 15),
                decoration: BoxDecoration(color: cardColor, borderRadius: BorderRadius.circular(16), border: Border.all(color: borderColor)),
                child: Column(
                  children: [
                    if (homeLast5.isNotEmpty) _buildTeamLastMatches(homeTeamName, homeLast5, isDark),
                    if (homeLast5.isNotEmpty && awayLast5.isNotEmpty) Padding(padding: const EdgeInsets.symmetric(vertical: 12), child: Divider(color: borderColor, height: 1)),
                    if (awayLast5.isNotEmpty) _buildTeamLastMatches(awayTeamName, awayLast5, isDark),
                  ],
                ),
              ),
              const SizedBox(height: 40),
            ],
          ],
        );
      },
    );
  }

  // ---------------------------------------------------------
  // 🎨 تصميمات الـ Widgets الداخلية
  // ---------------------------------------------------------

  Widget _buildSectionTitle(String title) {
    return Padding(
      padding: const EdgeInsets.only(bottom: 10, right: 5, left: 5),
      child: Text(title, style: const TextStyle(fontSize: 15, fontWeight: FontWeight.w900)),
    );
  }

  Widget _buildInfoRow(IconData icon, String title, String value, bool isDark, {bool isLast = false}) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 15, vertical: 12),
      decoration: BoxDecoration(border: Border(bottom: BorderSide(color: isLast ? Colors.transparent : (isDark ? Colors.white.withAlpha(10) : Colors.grey.shade200)))),
      child: Row(
        children: [
          Icon(icon, size: 18, color: Colors.grey),
          const SizedBox(width: 12),
          Text(title, style: TextStyle(color: Colors.grey.shade500, fontSize: 13, fontWeight: FontWeight.bold)),
          const Spacer(),
          Expanded(flex: 2, child: Text(value, textAlign: TextAlign.end, style: TextStyle(color: isDark ? Colors.white : Colors.black87, fontSize: 13, fontWeight: FontWeight.bold), overflow: TextOverflow.ellipsis)),
        ],
      ),
    );
  }

  // 🔽 قسم قابل للطي (للقنوات والحكام)
  Widget _buildExpandableSection({required String title, required IconData icon, required bool isDark, required List<Widget> children}) {
    final cardColor = isDark ? const Color(0xFF1E2026) : Colors.white;
    final borderColor = isDark ? Colors.white.withAlpha(15) : Colors.grey.shade200;

    return Container(
      margin: const EdgeInsets.only(bottom: 20),
      decoration: BoxDecoration(color: cardColor, borderRadius: BorderRadius.circular(16), border: Border.all(color: borderColor)),
      child: Theme(
        data: ThemeData().copyWith(dividerColor: Colors.transparent), // إزالة خطوط الـ ExpansionTile
        child: ExpansionTile(
          initiallyExpanded: true, // مفتوح كافتراضي
          iconColor: Colors.amber,
          collapsedIconColor: Colors.grey,
          title: Row(
            children: [
              Icon(icon, size: 20, color: Colors.amber),
              const SizedBox(width: 10),
              Text(title, style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold, color: isDark ? Colors.white : Colors.black87)),
            ],
          ),
          children: children,
        ),
      ),
    );
  }

  Widget _buildChannelRow({required String channelName, required String commentator, required bool isDark}) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 15, vertical: 8),
      child: Row(
        children: [
          Container(width: 4, height: 25, decoration: BoxDecoration(color: Colors.blueAccent, borderRadius: BorderRadius.circular(2))),
          const SizedBox(width: 10),
          Expanded(child: Text(channelName, style: TextStyle(color: isDark ? Colors.white : Colors.black87, fontSize: 13, fontWeight: FontWeight.bold))),
          Row(
            children: [
              const Icon(Icons.mic_rounded, size: 14, color: Colors.grey),
              const SizedBox(width: 4),
              Text(commentator, style: const TextStyle(color: Colors.grey, fontSize: 11, fontWeight: FontWeight.bold)),
            ],
          ),
        ],
      ),
    );
  }

  Widget _buildRefereeRow({required String name, required String role, required bool isDark}) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 15, vertical: 8),
      child: Row(
        children: [
          Container(width: 4, height: 25, decoration: BoxDecoration(color: Colors.amber, borderRadius: BorderRadius.circular(2))),
          const SizedBox(width: 10),
          Expanded(child: Text(name, style: TextStyle(color: isDark ? Colors.white : Colors.black87, fontSize: 13, fontWeight: FontWeight.bold))),
          Text(role, style: const TextStyle(color: Colors.grey, fontSize: 11, fontWeight: FontWeight.bold)),
        ],
      ),
    );
  }

  Widget _buildH2HRow(dynamic match, bool isDark) {
    final hTeam = match['home_team']?['title'] ?? "فريق";
    final aTeam = match['away_team']?['title'] ?? "فريق";
    final hScore = match['home_scores']?.toString() ?? "-";
    final aScore = match['away_scores']?.toString() ?? "-";
    final textColor = isDark ? Colors.white : Colors.black87;

    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 15, vertical: 8),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Expanded(child: Text(hTeam, textAlign: TextAlign.end, maxLines: 1, style: TextStyle(color: textColor, fontSize: 12, fontWeight: FontWeight.bold), overflow: TextOverflow.ellipsis)),
          Container(
            margin: const EdgeInsets.symmetric(horizontal: 12),
            padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 4),
            decoration: BoxDecoration(color: isDark ? Colors.white10 : Colors.grey.shade200, borderRadius: BorderRadius.circular(8)),
            child: Text("$hScore - $aScore", style: TextStyle(color: textColor, fontWeight: FontWeight.w900, fontFamily: 'Roboto', fontSize: 14)),
          ),
          Expanded(child: Text(aTeam, textAlign: TextAlign.start, maxLines: 1, style: TextStyle(color: textColor, fontSize: 12, fontWeight: FontWeight.bold), overflow: TextOverflow.ellipsis)),
        ],
      ),
    );
  }

  Widget _buildTeamLastMatches(String teamName, List<dynamic> matches, bool isDark) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Expanded(child: Text(teamName, style: TextStyle(color: isDark ? Colors.white : Colors.black87, fontSize: 13, fontWeight: FontWeight.bold), overflow: TextOverflow.ellipsis)),
        Row(
          children: matches.reversed.map((m) {
            final winType = m['win_type'] ?? "";
            Color bgColor = winType == "win" ? Colors.green : (winType == "lose" ? Colors.redAccent : Colors.grey);
            String text = winType == "win" ? t("ف", "W") : (winType == "lose" ? t("خ", "L") : t("ت", "D"));

            return Container(
              margin: const EdgeInsets.only(left: 6),
              width: 24, height: 24,
              alignment: Alignment.center,
              decoration: BoxDecoration(color: bgColor, shape: BoxShape.circle),
              child: Text(text, style: const TextStyle(color: Colors.white, fontSize: 10, fontWeight: FontWeight.w900, fontFamily: 'Roboto')),
            );
          }).toList(),
        ),
      ],
    );
  }
}