import 'package:flutter/material.dart';
import 'package:cached_network_image/cached_network_image.dart';
import '../data/sports_api_service.dart';
import 'soccer_pitch_widget.dart';
import '../../../../main.dart';

class MatchLineupTab extends StatefulWidget {
  final String matchId;
  final String homeTeamId;
  final String awayTeamId;
  final String homeTeamName;
  final String awayTeamName;

  const MatchLineupTab({
    super.key,
    required this.matchId,
    required this.homeTeamId,
    required this.awayTeamId,
    required this.homeTeamName,
    required this.awayTeamName,
  });

  @override
  State<MatchLineupTab> createState() => _MatchLineupTabState();
}

class _MatchLineupTabState extends State<MatchLineupTab> {
  final SportsApiService _apiService = SportsApiService();
  bool _isHomeSelected = true;

  String t(String ar, String en) => localeNotifier.value.languageCode == 'ar' ? ar : en;

  @override
  Widget build(BuildContext context) {
    final isDark = Theme.of(context).brightness == Brightness.dark;

    return FutureBuilder<Map<String, dynamic>>(
      future: _apiService.getMatchLineup(widget.matchId),
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) return Center(child: CircularProgressIndicator(color: Theme.of(context).primaryColor));

        if (!snapshot.hasData || snapshot.data!.isEmpty || snapshot.data!['lineup'] == null) {
          return Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(Icons.shield_outlined, size: 60, color: Colors.grey.withAlpha(100)),
                const SizedBox(height: 15),
                Text(t("التشكيل لم يصدر بعد", "Lineup not published yet"), style: const TextStyle(color: Colors.grey, fontSize: 16, fontWeight: FontWeight.bold)),
              ],
            ),
          );
        }

        final data = snapshot.data!;
        final lineups = data['lineup'] as Map<String, dynamic>? ?? {};
        final injureds = data['lineup_injureds'] as Map<String, dynamic>? ?? {};
        final matchInfo = data['0'] ?? {};

        final selectedTeamId = _isHomeSelected ? widget.homeTeamId : widget.awayTeamId;
        final teamData = lineups[selectedTeamId] ?? {};

        final startingXI = teamData['lineup'] as List<dynamic>? ?? [];
        final subs = teamData['substitutions'] as List<dynamic>? ?? [];
        final teamInjureds = injureds[selectedTeamId] as List<dynamic>? ?? [];

        final formation = _isHomeSelected ? matchInfo['home_formation'] : matchInfo['away_formation'];
        final coach = _isHomeSelected ? matchInfo['home_coach'] : matchInfo['away_coach'];

        return Column(
          children: [
            Padding(
              padding: const EdgeInsets.all(15.0),
              child: Container(
                height: 45,
                decoration: BoxDecoration(
                  color: isDark ? const Color(0xFF16181E) : Colors.grey.shade200,
                  borderRadius: BorderRadius.circular(25),
                  border: Border.all(color: isDark ? Colors.white.withAlpha(15) : Colors.transparent),
                ),
                child: Row(
                  children: [
                    _buildToggleBtn(widget.homeTeamName, true, isDark),
                    _buildToggleBtn(widget.awayTeamName, false, isDark),
                  ],
                ),
              ),
            ),

            Expanded(
              child: ListView(
                physics: const BouncingScrollPhysics(),
                padding: const EdgeInsets.symmetric(horizontal: 15),
                children: [
                  if (startingXI.isNotEmpty) ...[
                    SoccerPitchWidget(
                      startingXI: startingXI,
                      formation: formation?.toString() ?? "",
                    ),
                    const SizedBox(height: 20),
                  ],

                  if (coach != null && coach.isNotEmpty) ...[
                    _buildSectionHeader(t("المدير الفني", "Manager")),
                    _buildCoachRow(coach, isDark),
                    const SizedBox(height: 20),
                  ],

                  if (subs.isNotEmpty) ...[
                    _buildSectionHeader(t("دكة البدلاء", "Substitutes")),
                    ...subs.map((p) => _buildModernPlayerRow(p, isDark, false)),
                    const SizedBox(height: 20),
                  ],

                  if (teamInjureds.isNotEmpty) ...[
                    _buildSectionHeader(t("الغيابات والمصابين", "Missing Players")),
                    ...teamInjureds.map((p) => _buildModernPlayerRow(p, isDark, true)),
                    const SizedBox(height: 30),
                  ],
                ],
              ),
            ),
          ],
        );
      },
    );
  }

  Widget _buildToggleBtn(String title, bool isHome, bool isDark) {
    final isSelected = _isHomeSelected == isHome;
    return Expanded(
      child: GestureDetector(
        onTap: () => setState(() => _isHomeSelected = isHome),
        child: AnimatedContainer(
          duration: const Duration(milliseconds: 200),
          alignment: Alignment.center,
          decoration: BoxDecoration(
            color: isSelected ? Theme.of(context).primaryColor : Colors.transparent,
            borderRadius: BorderRadius.circular(25),
            boxShadow: isSelected ? [BoxShadow(color: Theme.of(context).primaryColor.withAlpha(50), blurRadius: 5, offset: const Offset(0, 2))] : [],
          ),
          child: Text(
            title,
            style: TextStyle(
              color: isSelected ? Colors.black87 : (isDark ? Colors.white54 : Colors.black54),
              fontWeight: isSelected ? FontWeight.bold : FontWeight.normal,
              fontSize: 13,
            ),
            overflow: TextOverflow.ellipsis,
          ),
        ),
      ),
    );
  }

  Widget _buildSectionHeader(String title) {
    return Padding(
      padding: const EdgeInsets.only(bottom: 12, top: 5),
      child: Text(title, style: TextStyle(color: Theme.of(context).primaryColor, fontSize: 15, fontWeight: FontWeight.w900)),
    );
  }

  Widget _buildCoachRow(dynamic coach, bool isDark) {
    final String name = coach['title'] ?? "غير معروف";
    // 👈 تم إصلاح رابط المدرب هنا (/coach/ بدلا من /player/)
    final String imgUrl = "https://imgs.ysscores.com/coach/150/${coach['image']}";

    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 8),
      decoration: BoxDecoration(
        color: isDark ? const Color(0xFF1E2026) : Colors.white,
        borderRadius: BorderRadius.circular(12),
        border: Border.all(color: isDark ? Colors.white.withAlpha(15) : Colors.grey.shade200),
      ),
      child: Row(
        children: [
          _buildPlayerImage(imgUrl, ""),
          const SizedBox(width: 12),
          Expanded(child: Text(name, style: TextStyle(color: isDark ? Colors.white : Colors.black87, fontWeight: FontWeight.bold, fontSize: 14))),
          Icon(Icons.cases_rounded, color: Colors.grey.withAlpha(150), size: 20),
        ],
      ),
    );
  }

  Widget _buildModernPlayerRow(dynamic playerObj, bool isDark, bool isInjured) {
    final player = playerObj['player'] ?? {};
    final String name = player['short_title'] ?? player['title'] ?? "لاعب";
    final String position = player['position'] ?? "";
    final String number = player['player_number']?.toString() ?? "";
    final String imgUrl = "https://imgs.ysscores.com/player/150/${player['image']}";

    final String reason = playerObj['type_name'] ?? "";
    final String rating = playerObj['rating']?.toString() ?? "";
    final double ratingVal = double.tryParse(rating) ?? 0.0;
    final Color ratingColor = ratingVal >= 7.0 ? Colors.green : (ratingVal > 0 ? Colors.orange : Colors.transparent);

    final bool isSubIn = playerObj['substitute'] == 1 && !isInjured;
    final String subTime = playerObj['substitute_time']?.toString() ?? "";

    // 👈 قراءة اللاعب الذي خرج (Player Out)
    final playerOut = playerObj['player_lineup'];

    final bool hasGoal = playerObj['goal'] != null;

    return Container(
      padding: const EdgeInsets.symmetric(vertical: 8),
      decoration: BoxDecoration(border: Border(bottom: BorderSide(color: isDark ? Colors.white.withAlpha(10) : Colors.grey.shade200))),
      child: Row(
        children: [
          _buildPlayerImage(imgUrl, number),
          const SizedBox(width: 12),

          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(name, style: TextStyle(color: isDark ? Colors.white : Colors.black87, fontWeight: FontWeight.bold, fontSize: 13)),
                const SizedBox(height: 3),
                Row(
                  children: [
                    if (position.isNotEmpty)
                      Text(position, style: TextStyle(color: Colors.grey.shade500, fontSize: 11, fontWeight: FontWeight.bold)),

                    // 👈 عرض التبديل بشياكة (سهم أخضر للدخول، وسهم أحمر للاعب الخارج)
                    if (isSubIn && subTime.isNotEmpty) ...[
                      const SizedBox(width: 8),
                      Icon(Icons.arrow_upward_rounded, color: Colors.greenAccent.shade400, size: 14),
                      Text("$subTime'", style: TextStyle(color: Colors.greenAccent.shade400, fontSize: 11, fontWeight: FontWeight.bold, fontFamily: 'Roboto')),
                      if (playerOut != null) ...[
                        const SizedBox(width: 6),
                        const Icon(Icons.arrow_downward_rounded, color: Colors.redAccent, size: 14),
                        Text(playerOut['short_title'] ?? "", style: const TextStyle(color: Colors.redAccent, fontSize: 11, fontWeight: FontWeight.bold)),
                      ]
                    ],

                    if (hasGoal) ...[
                      const SizedBox(width: 8),
                      const Icon(Icons.sports_soccer, color: Colors.amber, size: 13),
                    ]
                  ],
                ),
              ],
            ),
          ),

          if (isInjured)
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
              decoration: BoxDecoration(color: Colors.redAccent.withAlpha(30), borderRadius: BorderRadius.circular(8)),
              child: Row(
                children: [
                  const Icon(Icons.healing_rounded, color: Colors.redAccent, size: 12),
                  const SizedBox(width: 4),
                  Text(reason, style: const TextStyle(color: Colors.redAccent, fontSize: 10, fontWeight: FontWeight.bold)),
                ],
              ),
            )
          else if (rating.isNotEmpty && rating != "-")
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
              decoration: BoxDecoration(color: ratingColor.withAlpha(40), borderRadius: BorderRadius.circular(8)),
              child: Text(rating, style: TextStyle(color: ratingColor, fontSize: 12, fontWeight: FontWeight.w900, fontFamily: 'Roboto')),
            )
          else
            Text(number, style: TextStyle(color: isDark ? Colors.white54 : Colors.black54, fontSize: 16, fontWeight: FontWeight.w900, fontFamily: 'Roboto')),
        ],
      ),
    );
  }

  Widget _buildPlayerImage(String url, String fallbackNumber) {
    return Container(
      width: 40, height: 40,
      decoration: BoxDecoration(
        color: Theme.of(context).cardColor,
        shape: BoxShape.circle,
        border: Border.all(color: Colors.grey.withAlpha(50), width: 1),
      ),
      child: ClipRRect(
        borderRadius: BorderRadius.circular(20),
        child: CachedNetworkImage(
          imageUrl: url,
          fit: BoxFit.cover,
          httpHeaders: const {"Referer": "https://ysscores.com/"},
          placeholder: (context, url) => const Padding(padding: EdgeInsets.all(10), child: CircularProgressIndicator(strokeWidth: 1.5)),
          errorWidget: (context, url, error) => Center(
            child: Text(fallbackNumber, style: const TextStyle(color: Colors.grey, fontWeight: FontWeight.bold, fontFamily: 'Roboto')),
          ),
        ),
      ),
    );
  }
}