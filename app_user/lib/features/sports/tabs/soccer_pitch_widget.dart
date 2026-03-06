import 'package:flutter/material.dart';
import 'package:cached_network_image/cached_network_image.dart';

class SoccerPitchWidget extends StatelessWidget {
  final List<dynamic> startingXI;
  final String formation;

  const SoccerPitchWidget({super.key, required this.startingXI, this.formation = ""});

  // دالة أمان لجلب رقم المركز
  int _getPos(dynamic p) => int.tryParse(p['formation_position']?.toString() ?? '0') ?? 0;

  @override
  Widget build(BuildContext context) {
    final List<dynamic> gk = startingXI.where((p) => p['position'] == 'G').toList();
    final List<dynamic> def = startingXI.where((p) => p['position'] == 'D').toList();
    final List<dynamic> mid = startingXI.where((p) => p['position'] == 'M').toList();
    final List<dynamic> fwd = startingXI.where((p) => p['position'] == 'F' || p['position'] == 'S').toList();

    // الترتيب حسب المركز
    def.sort((a, b) => _getPos(a).compareTo(_getPos(b)));
    mid.sort((a, b) => _getPos(a).compareTo(_getPos(b)));
    fwd.sort((a, b) => _getPos(a).compareTo(_getPos(b)));

    return Column(
      children: [
        if (formation.isNotEmpty)
          Padding(
            padding: const EdgeInsets.only(bottom: 10.0),
            child: Text(
                formation,
                style: const TextStyle(color: Colors.grey, fontSize: 18, fontWeight: FontWeight.w900, letterSpacing: 4, fontFamily: 'Roboto')
            ),
          ),

        Directionality(
          textDirection: TextDirection.ltr, // تثبيت الاتجاه
          child: AspectRatio(
            aspectRatio: 2.3 / 3.6, // أبعاد ملعب واقعية جداً
            child: Container(
              decoration: BoxDecoration(
                color: const Color(0xFF1B5E20),
                borderRadius: BorderRadius.circular(12),
                border: Border.all(color: Colors.white.withAlpha(60), width: 2),
              ),
              child: Stack(
                children: [
                  // تخطيط الملعب (المنتصف ومنطقة الجزاء)
                  Align(alignment: Alignment.topCenter, child: Container(height: 2, color: Colors.white.withAlpha(60))),
                  Align(
                    alignment: Alignment.topCenter,
                    child: Container(
                      width: 90, height: 45,
                      decoration: BoxDecoration(
                        border: Border(bottom: BorderSide(color: Colors.white.withAlpha(60), width: 2), left: BorderSide(color: Colors.white.withAlpha(60), width: 2), right: BorderSide(color: Colors.white.withAlpha(60), width: 2)),
                        borderRadius: const BorderRadius.only(bottomLeft: Radius.circular(90), bottomRight: Radius.circular(90)),
                      ),
                    ),
                  ),
                  Align(
                    alignment: Alignment.bottomCenter,
                    child: Container(
                      width: 160, height: 70,
                      decoration: BoxDecoration(
                        border: Border(top: BorderSide(color: Colors.white.withAlpha(60), width: 2), left: BorderSide(color: Colors.white.withAlpha(60), width: 2), right: BorderSide(color: Colors.white.withAlpha(60), width: 2)),
                      ),
                    ),
                  ),

                  // توزيع الخطوط بـ Expanded لتأخذ المسافات الصحيحة عمودياً
                  Column(
                    children: [
                      const SizedBox(height: 15),
                      Expanded(child: _buildLine(fwd)),
                      Expanded(child: _buildLine(mid)),
                      Expanded(child: _buildLine(def)),
                      Expanded(child: _buildLine(gk)),
                      const SizedBox(height: 10),
                    ],
                  ),
                ],
              ),
            ),
          ),
        ),
      ],
    );
  }

  Widget _buildLine(List<dynamic> linePlayers) {
    if (linePlayers.isEmpty) return const SizedBox.shrink();
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceAround, // 👈 بتخلي الأطراف يفرشوا لبره
      crossAxisAlignment: CrossAxisAlignment.center,
      children: linePlayers.map((p) => _buildPlayerNode(p)).toList(),
    );
  }

  Widget _buildPlayerNode(dynamic playerObj) {
    final player = playerObj['player'] ?? {};
    final String fullName = player['short_title'] ?? player['title'] ?? "لاعب";
    final String name = fullName.split(' ').first;
    final String number = player['player_number']?.toString() ?? "";
    final String imgUrl = "https://imgs.ysscores.com/player/150/${player['image']}";

    final String rating = playerObj['rating']?.toString() ?? "";
    final bool hasYellow = playerObj['yellow'] != null;
    final bool hasRed = playerObj['red'] != null;
    final bool isSub = playerObj['substitute'] == 1;
    final bool hasGoal = playerObj['goal'] != null;

    // مساحة ثابتة لكل لاعب عشان ميكسروش الصف لو اسمهم طويل
    return SizedBox(
      width: 55,
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Stack(
            clipBehavior: Clip.none,
            alignment: Alignment.center,
            children: [
              Container(
                width: 38, height: 38,
                decoration: BoxDecoration(
                  color: Colors.white,
                  shape: BoxShape.circle,
                  border: Border.all(color: Colors.white, width: 1.5),
                  boxShadow: [BoxShadow(color: Colors.black.withAlpha(100), blurRadius: 4, offset: const Offset(0, 2))],
                ),
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(19),
                  child: CachedNetworkImage(
                    imageUrl: imgUrl,
                    fit: BoxFit.cover,
                    httpHeaders: const {"Referer": "https://ysscores.com/"},
                    errorWidget: (context, url, error) => Center(child: Text(number, style: const TextStyle(color: Colors.black, fontWeight: FontWeight.bold))),
                  ),
                ),
              ),

              if (rating.isNotEmpty && rating != "-")
                Positioned(
                  bottom: -4, right: -8,
                  child: Container(
                    padding: const EdgeInsets.all(2),
                    decoration: BoxDecoration(color: (double.tryParse(rating) ?? 0) >= 7.0 ? Colors.green : Colors.orange, borderRadius: BorderRadius.circular(4)),
                    child: Text(rating, style: const TextStyle(color: Colors.white, fontSize: 8, fontWeight: FontWeight.bold, fontFamily: 'Roboto')),
                  ),
                ),

              Positioned(
                top: -4, right: -6,
                child: Container(
                  padding: const EdgeInsets.all(3),
                  decoration: const BoxDecoration(color: Colors.black87, shape: BoxShape.circle),
                  child: Text(number, style: const TextStyle(color: Colors.white, fontSize: 8, fontWeight: FontWeight.bold, fontFamily: 'Roboto')),
                ),
              ),

              if (hasRed || hasYellow || hasGoal)
                Positioned(
                  top: -4, left: -6,
                  child: hasGoal
                      ? const Icon(Icons.sports_soccer, color: Colors.white, size: 14)
                      : Container(width: 8, height: 12, decoration: BoxDecoration(color: hasRed ? Colors.red : Colors.yellow, borderRadius: BorderRadius.circular(2), border: Border.all(color: Colors.black, width: 0.5))),
                ),

              if (isSub)
                const Positioned(
                  bottom: -8, left: 0, right: 0,
                  child: Icon(Icons.sync, color: Colors.greenAccent, size: 14),
                ),
            ],
          ),
          const SizedBox(height: 8),

          Container(
            padding: const EdgeInsets.symmetric(horizontal: 4, vertical: 2),
            decoration: BoxDecoration(color: Colors.black.withAlpha(150), borderRadius: BorderRadius.circular(4)),
            child: Text(name, style: const TextStyle(color: Colors.white, fontSize: 9, fontWeight: FontWeight.bold), overflow: TextOverflow.ellipsis, maxLines: 1),
          ),
        ],
      ),
    );
  }
}