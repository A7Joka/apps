import 'package:flutter/material.dart';
import 'package:cached_network_image/cached_network_image.dart';

class ModernMatchCard extends StatelessWidget {
  final dynamic match;
  final VoidCallback onTap;

  const ModernMatchCard({super.key, required this.match, required this.onTap});

  @override
  Widget build(BuildContext context) {
    final homeTeam = match['home_team']['title'] ?? "";
    final awayTeam = match['away_team']['title'] ?? "";
    final homeLogo = "https://cdn.ysscores.com/teams/${match['home_team']['image']}";
    final awayLogo = "https://cdn.ysscores.com/teams/${match['away_team']['image']}";

    final int status = match['status'] ?? 0;
    final String time = match['match_time']?.substring(0, 5) ?? "00:00";
    final String homeScore = match['home_scores']?.toString() ?? "-";
    final String awayScore = match['away_scores']?.toString() ?? "-";

    // 2. منطق الحالة والألوان (UI Logic)
    String statusText;
    Color statusColor;
    bool isLive = false;

    switch (status) {
      case 0: statusText = "لم تبدأ"; statusColor = Colors.grey.shade500; break;
      case 1: statusText = "شوط أول"; statusColor = Colors.greenAccent; isLive = true; break;
      case 2: statusText = "شوط ثاني"; statusColor = Colors.greenAccent; isLive = true; break;
      case 3: statusText = "استراحة"; statusColor = Colors.orangeAccent; break;
      case 4: statusText = "انتهت"; statusColor = Colors.white54; break;
      default: statusText = "مؤجلة"; statusColor = Colors.redAccent;
    }

    // 3. التصميم (Theming) - يقبل الدارك واللايت
    final isDark = Theme.of(context).brightness == Brightness.dark;
    final bgColor = isDark ? const Color(0xFF1A1D24) : Colors.white;
    final textColor = isDark ? Colors.white : const Color(0xFF1A1D24);
    final gradientColors = isDark
        ? [const Color(0xFF232732), const Color(0xFF1A1D24)]
        : [Colors.grey.shade100, Colors.white];

    return GestureDetector(
      onTap: onTap,
      child: Container(
        margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
        decoration: BoxDecoration(
          gradient: LinearGradient(colors: gradientColors, begin: Alignment.topLeft, end: Alignment.bottomRight),
          borderRadius: BorderRadius.circular(20),
          boxShadow: [
            BoxShadow(
              color: isDark ? Colors.black.withOpacity(0.4) : Colors.grey.withOpacity(0.2),
              blurRadius: 10,
              offset: const Offset(0, 5),
            ),
          ],
          border: Border.all(color: isDark ? Colors.white.withOpacity(0.05) : Colors.grey.shade200),
        ),
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            children: [
              // الهيدر: وقت المباراة وحالتها
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  if (isLive)
                    Container(
                      margin: const EdgeInsets.only(left: 8, right: 8),
                      width: 8, height: 8,
                      decoration: const BoxDecoration(color: Colors.redAccent, shape: BoxShape.circle),
                    ),
                  Text(
                    statusText,
                    style: TextStyle(color: statusColor, fontSize: 12, fontWeight: FontWeight.w600),
                  ),
                ],
              ),
              const SizedBox(height: 12),

              // القلب: الفرق والنتيجة
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  // الفريق المضيف (يمين في العربي، يسار في الإنجليزي تلقائياً)
                  Expanded(
                    child: Column(
                      children: [
                        ModernTeamLogo(url: homeLogo),
                        const SizedBox(height: 8),
                        Text(homeTeam, textAlign: TextAlign.center, maxLines: 2, overflow: TextOverflow.ellipsis,
                            style: TextStyle(color: textColor, fontSize: 14, fontWeight: FontWeight.bold)),
                      ],
                    ),
                  ),

                  // النتيجة أو التوقيت في المنتصف
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 16.0),
                    child: Column(
                      children: [
                        Text(
                          status == 0 ? time : "$homeScore - $awayScore",
                          style: TextStyle(
                            color: status == 0 ? textColor.withOpacity(0.7) : Colors.amber.shade600,
                            fontSize: status == 0 ? 22 : 28,
                            fontWeight: FontWeight.w900,
                            letterSpacing: 2,
                          ),
                        ),
                      ],
                    ),
                  ),

                  // الفريق الضيف
                  Expanded(
                    child: Column(
                      children: [
                        ModernTeamLogo(url: awayLogo),
                        const SizedBox(height: 8),
                        Text(awayTeam, textAlign: TextAlign.center, maxLines: 2, overflow: TextOverflow.ellipsis,
                            style: TextStyle(color: textColor, fontSize: 14, fontWeight: FontWeight.bold)),
                      ],
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}

// ويدجت ذكي لجلب الصور الحقيقية وتجاوز حماية السيرفرات
class ModernTeamLogo extends StatelessWidget {
  final String url;
  const ModernTeamLogo({super.key, required this.url});

  @override
  Widget build(BuildContext context) {
    return CachedNetworkImage(
      imageUrl: url,
      width: 55,
      height: 55,
      // الـ Headers هذه هي سر ظهور الصورة الحقيقية بدلاً من الدرع الرصاصي
      httpHeaders: const {
        "Referer": "https://ysscores.com/", // خداع السيرفر ليظن أن الطلب من موقعهم
        "User-Agent": "Mozilla/5.0",
      },
      imageBuilder: (context, imageProvider) => Container(
        decoration: BoxDecoration(
          shape: BoxShape.circle,
          image: DecorationImage(image: imageProvider, fit: BoxFit.contain),
        ),
      ),
      placeholder: (context, url) => const SizedBox(
        width: 55, height: 55,
        child: CircularProgressIndicator(strokeWidth: 2, color: Colors.amber),
      ),
      errorWidget: (context, url, error) => Container(
        width: 55, height: 55,
        decoration: BoxDecoration(color: Colors.grey.shade800, shape: BoxShape.circle),
        child: const Icon(Icons.shield, color: Colors.white54, size: 30), // يظهر فقط لو الرابط مكسور فعلاً
      ),
    );
  }
}