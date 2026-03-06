import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:cached_network_image/cached_network_image.dart';

import '../tabs/match_stats_tab.dart';
import '../tabs/match_lineup_tab.dart';
import '../tabs/match_events_tab.dart';
import '../tabs/match_info_tab.dart';
import '../../../main.dart';

class MatchDetailsScreen extends StatelessWidget {
  final String matchId;
  final dynamic matchData;

  const MatchDetailsScreen({super.key, required this.matchId, required this.matchData});

  String t(String ar, String en) => localeNotifier.value.languageCode == 'ar' ? ar : en;

  String _getLocalTime(int timestamp) {
    if (timestamp == 0) return "00:00";
    DateTime dt = DateTime.fromMillisecondsSinceEpoch(timestamp * 1000);
    String formattedTime = DateFormat('h:mm', 'en').format(dt);
    bool isAr = localeNotifier.value.languageCode == 'ar';
    String ampm = dt.hour >= 12 ? (isAr ? "م" : "PM") : (isAr ? "ص" : "AM");
    return "$formattedTime $ampm";
  }

  @override
  Widget build(BuildContext context) {
    final isDark = Theme.of(context).brightness == Brightness.dark;
    final bgColor = isDark ? const Color(0xFF0F1115) : const Color(0xFFF0F2F5);
    final glassColor = isDark ? const Color(0xFF1E2026).withAlpha(230) : Colors.white.withAlpha(240);
    final isAr = localeNotifier.value.languageCode == 'ar';

    final homeTeam = matchData['home_team']['title'] ?? "";
    final awayTeam = matchData['away_team']['title'] ?? "";
    final homeLogo = "https://imgs.ysscores.com/teams/150/${matchData['home_team']['image']}";
    final awayLogo = "https://imgs.ysscores.com/teams/150/${matchData['away_team']['image']}";
    final homeId = matchData['home_team']['row_id'].toString();
    final awayId = matchData['away_team']['row_id'].toString();

    final int status = matchData['status'] ?? 0;
    final int timestamp = matchData['match_timestamp'] ?? 0;
    final String localTime = _getLocalTime(timestamp);
    final String homeScore = matchData['home_scores']?.toString() ?? "-";
    final String awayScore = matchData['away_scores']?.toString() ?? "-";

    String statusText = "";
    Color statusColor = Colors.grey;
    bool isLive = false;
    bool isPostponed = false;

    switch (status) {
      case 0: statusText = ""; break;
      case 1: statusText = t("شوط 1", "1st H"); statusColor = Colors.greenAccent; isLive = true; break;
      case 2: statusText = t("شوط 2", "2nd H"); statusColor = Colors.greenAccent; isLive = true; break;
      case 3: case 4: statusText = t("انتهت", "FT"); statusColor = isDark ? Colors.white54 : Colors.black54; break;
      case 7: statusText = t("إضافي 1", "ET 1"); statusColor = Colors.greenAccent; isLive = true; break;
      case 9: statusText = t("إضافي 2", "ET 2"); statusColor = Colors.greenAccent; isLive = true; break;
      case 5: case 6: case 8: case 10: case 11: case 14:
      statusText = t("مؤجلة", "Postponed"); statusColor = Colors.redAccent; isPostponed = true; break;
      default: statusText = t("مباشر", "Live"); statusColor = Colors.redAccent; isLive = true;
    }

    String centerDisplay = (status == 0 || isPostponed) ? localTime : "$homeScore - $awayScore";

    final double expandedHeight = 220.0;
    final double collapsedHeight = kToolbarHeight + 45.0;

    return DefaultTabController(
      length: 4, // 👈 التابات بقوا 4 عشان المساحة تبقى مريحة
      child: Scaffold(
        backgroundColor: bgColor,
        body: NestedScrollView(
          headerSliverBuilder: (BuildContext context, bool innerBoxIsScrolled) {
            return <Widget>[
              SliverAppBar(
                expandedHeight: expandedHeight,
                collapsedHeight: collapsedHeight,
                pinned: true,
                automaticallyImplyLeading: false,
                backgroundColor: Colors.transparent,
                elevation: 0,
                flexibleSpace: LayoutBuilder(
                  builder: (context, constraints) {
                    final top = constraints.biggest.height;
                    final safeArea = MediaQuery.of(context).padding.top;
                    final minHeight = safeArea + collapsedHeight;
                    final maxHeight = expandedHeight + safeArea;

                    double progress = (top - minHeight) / (maxHeight - minHeight);
                    progress = progress.clamp(0.0, 1.0);

                    // 🎯 السر هنا: انتقال حاسم (Hard Switch) بدون شبح ورا الشاشة
                    final bool showExpanded = progress > 0.4;

                    return Stack(
                      fit: StackFit.expand,
                      children: [
                        ClipRRect(
                          borderRadius: const BorderRadius.vertical(bottom: Radius.circular(25)),
                          child: BackdropFilter(
                            filter: ImageFilter.blur(sigmaX: 20, sigmaY: 20),
                            child: Container(
                              decoration: BoxDecoration(
                                color: glassColor,
                                border: Border(bottom: BorderSide(color: isDark ? Colors.white.withAlpha(15) : Colors.transparent, width: 1)),
                              ),
                            ),
                          ),
                        ),

                        Positioned(
                          top: safeArea + 5,
                          left: isAr ? null : 10,
                          right: isAr ? 10 : null,
                          child: IconButton(
                            icon: Icon(isAr ? Icons.arrow_forward_ios_rounded : Icons.arrow_back_ios_new_rounded, color: Theme.of(context).primaryColor, size: 22),
                            onPressed: () => Navigator.pop(context),
                          ),
                        ),

                        // 🎯 الأنيميشن السريع لتغيير المحتوى
                        AnimatedSwitcher(
                          duration: const Duration(milliseconds: 150), // سريع جداً عشان ميعملش لغوشة
                          child: showExpanded
                              ? Padding(
                            key: const ValueKey("expanded"),
                            padding: EdgeInsets.only(top: safeArea + 30, left: 15, right: 15),
                            child: _buildExpandedLayout(homeTeam, awayTeam, homeLogo, awayLogo, centerDisplay, statusText, statusColor, isLive, isDark, context),
                          )
                              : Padding(
                            key: const ValueKey("collapsed"),
                            padding: EdgeInsets.only(top: safeArea + 15, left: 50, right: 50),
                            child: _buildCollapsedLayout(homeTeam, awayTeam, homeLogo, awayLogo, centerDisplay, isDark, context),
                          ),
                        ),
                      ],
                    );
                  },
                ),
                bottom: PreferredSize(
                  preferredSize: const Size.fromHeight(45.0),
                  child: TabBar(
                    isScrollable: false,
                    indicatorSize: TabBarIndicatorSize.tab,
                    indicatorColor: Theme.of(context).primaryColor,
                    indicatorWeight: 3,
                    labelColor: Theme.of(context).primaryColor,
                    unselectedLabelColor: Colors.grey.shade500,
                    dividerColor: Colors.transparent,
                    labelStyle: const TextStyle(fontWeight: FontWeight.bold, fontSize: 13),
                    tabs: [
                      Tab(text: t("التفاصيل", "Info")), // التاب الجديد
                      Tab(text: t("التشكيل", "Lineup")),
                      Tab(text: t("إحصائيات", "Stats")),
                      Tab(text: t("أحداث", "Events")),
                    ],
                  ),
                ),
              ),
            ];
          },
          body: Container(
            color: bgColor,
            child: TabBarView(
              physics: const BouncingScrollPhysics(),
              children: [
                MatchInfoTab(matchId: matchId, homeTeamName: homeTeam, awayTeamName: awayTeam),
                MatchLineupTab(matchId: matchId, homeTeamId: homeId, awayTeamId: awayId, homeTeamName: homeTeam, awayTeamName: awayTeam),
                MatchStatsTab(matchId: matchId, homeTeamId: homeId, awayTeamId: awayId),
                MatchEventsTab(matchId: matchId, homeTeamId: homeId, awayTeamId: awayId),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Widget _buildExpandedLayout(String hTeam, String aTeam, String hLogo, String aLogo, String centerDisplay, String statusText, Color statusColor, bool isLive, bool isDark, BuildContext context) {
    final textColor = isDark ? Colors.white : Colors.black87;
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Expanded(
              flex: 3,
              child: Column(
                children: [
                  ModernDetailsLogo(url: hLogo, size: 65),
                  const SizedBox(height: 10),
                  Text(hTeam, textAlign: TextAlign.center, maxLines: 2, style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold, color: textColor), overflow: TextOverflow.ellipsis),
                ],
              ),
            ),
            Expanded(
              flex: 4,
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  if (statusText.isNotEmpty)
                    Container(
                      padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 3),
                      margin: const EdgeInsets.only(bottom: 8),
                      decoration: BoxDecoration(color: statusColor.withAlpha(25), borderRadius: BorderRadius.circular(10)),
                      child: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          if (isLive) ...[
                            Container(width: 6, height: 6, decoration: BoxDecoration(color: statusColor, shape: BoxShape.circle)),
                            const SizedBox(width: 5),
                          ],
                          Text(statusText, style: TextStyle(color: statusColor, fontSize: 10, fontWeight: FontWeight.bold)),
                        ],
                      ),
                    ),
                  Text(
                    centerDisplay,
                    style: TextStyle(color: isLive ? Theme.of(context).primaryColor : textColor, fontSize: isLive ? 34 : 26, fontWeight: FontWeight.w900, fontFamily: 'Roboto', letterSpacing: 1),
                  ),
                ],
              ),
            ),
            Expanded(
              flex: 3,
              child: Column(
                children: [
                  ModernDetailsLogo(url: aLogo, size: 65),
                  const SizedBox(height: 10),
                  Text(aTeam, textAlign: TextAlign.center, maxLines: 2, style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold, color: textColor), overflow: TextOverflow.ellipsis),
                ],
              ),
            ),
          ],
        ),
      ],
    );
  }

  Widget _buildCollapsedLayout(String hTeam, String aTeam, String hLogo, String aLogo, String centerDisplay, bool isDark, BuildContext context) {
    final textColor = isDark ? Colors.white : Colors.black87;
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Expanded(child: Text(hTeam, textAlign: TextAlign.end, maxLines: 1, style: TextStyle(fontSize: 12, fontWeight: FontWeight.bold, color: textColor), overflow: TextOverflow.ellipsis)),
        const SizedBox(width: 8),
        ModernDetailsLogo(url: hLogo, size: 28),
        Padding(
          padding: const EdgeInsets.symmetric(horizontal: 12),
          child: Text(centerDisplay, style: TextStyle(color: Theme.of(context).primaryColor, fontSize: 18, fontWeight: FontWeight.w900, fontFamily: 'Roboto')),
        ),
        ModernDetailsLogo(url: aLogo, size: 28),
        const SizedBox(width: 8),
        Expanded(child: Text(aTeam, textAlign: TextAlign.start, maxLines: 1, style: TextStyle(fontSize: 12, fontWeight: FontWeight.bold, color: textColor), overflow: TextOverflow.ellipsis)),
      ],
    );
  }
}

class ModernDetailsLogo extends StatelessWidget {
  final String url;
  final double size;
  const ModernDetailsLogo({super.key, required this.url, required this.size});

  @override
  Widget build(BuildContext context) {
    return CachedNetworkImage(
      imageUrl: url, width: size, height: size,
      httpHeaders: const {"Referer": "https://ysscores.com/"},
      imageBuilder: (context, imageProvider) => Container(decoration: BoxDecoration(image: DecorationImage(image: imageProvider, fit: BoxFit.contain))),
      placeholder: (context, url) => SizedBox(width: size, height: size, child: const Padding(padding: EdgeInsets.all(8.0), child: CircularProgressIndicator(strokeWidth: 2))),
      errorWidget: (context, url, error) => Icon(Icons.shield, color: Colors.grey.withAlpha(100), size: size * 0.8),
    );
  }
}