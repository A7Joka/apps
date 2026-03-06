import 'package:flutter/material.dart';
import '../data/sports_api_service.dart';

class MatchEventsTab extends StatelessWidget {
  final String matchId;
  final String homeTeamId;
  final String awayTeamId;

  const MatchEventsTab({super.key, required this.matchId, required this.homeTeamId, required this.awayTeamId});

  @override
  Widget build(BuildContext context) {
    final apiService = SportsApiService();

    return FutureBuilder<List<dynamic>>(
      future: apiService.getMatchEvents(matchId),
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) {
          return const Center(child: CircularProgressIndicator(color: Colors.amber));
        }
        if (!snapshot.hasData || snapshot.data!.isEmpty) {
          return const Center(child: Text("لا توجد أحداث مسجلة حتى الآن", style: TextStyle(color: Colors.grey)));
        }

        final events = snapshot.data!;

        return ListView.builder(
          padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 10),
          itemCount: events.length,
          itemBuilder: (context, index) {
            final event = events[index];
            return _buildEventRow(event);
          },
        );
      },
    );
  }

  // دالة بناء صف الحدث (Timeline Row)
  Widget _buildEventRow(dynamic event) {
    final int type = event['type'] ?? 0;
    final String teamIdStr = event['team_id']?.toString() ?? "";
    final int time = event['time_minute'] ?? 0;
    final int timePlus = event['time_plus'] ?? 0;
    // عرض الوقت بشكل احترافي (مثلاً 90+3')
    final String timeDisplay = timePlus > 0 ? "$time+$timePlus'" : "$time'";

    // الـ type 100 يعبر عن صافرة البداية، النهاية، أو الاستراحة
    if (type == 100) {
      return Center(
        child: Container(
          margin: const EdgeInsets.symmetric(vertical: 10),
          padding: const EdgeInsets.symmetric(horizontal: 15, vertical: 5),
          decoration: BoxDecoration(color: Colors.grey.shade800, borderRadius: BorderRadius.circular(20)),
          child: const Text("صافرة الحكم ⏱️", style: TextStyle(color: Colors.white70, fontSize: 12)),
        ),
      );
    }

    // هل الحدث لصاحب الأرض أم للضيف؟
    final bool isHome = teamIdStr == homeTeamId;

    // استخراج أسماء اللاعبين
    final playerName = event['player_name']?['short_title'] ?? event['player_name']?['title'] ?? "";
    final assistName = event['assist_player_name']?['short_title'] ?? event['assist_player_name']?['title'] ?? "";
    final statusName = event['status_name'] ?? "";

    // تحديد الأيقونة بناءً على نوع الحدث
    Widget eventIcon = const Icon(Icons.info, color: Colors.grey, size: 20);
    if (type == 1) { // ⚽ هدف
      eventIcon = const Icon(Icons.sports_soccer, color: Colors.white, size: 20);
    } else if (type == 2) { // 🟨 بطاقة صفراء
      eventIcon = Container(width: 12, height: 18, color: Colors.yellow, margin: const EdgeInsets.symmetric(horizontal: 4));
    } else if (type == 3) { // 🟥 بطاقة حمراء
      eventIcon = Container(width: 12, height: 18, color: Colors.red, margin: const EdgeInsets.symmetric(horizontal: 4));
    } else if (type == 8 || statusName == "تبديل") { // 🔄 تبديل
      eventIcon = const Icon(Icons.sync, color: Colors.greenAccent, size: 20);
    }

    // بناء معلومات الحدث (اللاعب والمساعد)
    Widget content = Column(
      crossAxisAlignment: isHome ? CrossAxisAlignment.end : CrossAxisAlignment.start,
      children: [
        Text(playerName, style: const TextStyle(color: Colors.white, fontWeight: FontWeight.bold, fontSize: 14)),
        if (assistName.isNotEmpty)
          Text(
              (type == 8 || statusName == "تبديل") ? "خروج: $assistName" : "مساعدة: $assistName",
              style: const TextStyle(color: Colors.grey, fontSize: 12)
          ),
      ],
    );

    // الرصـّة النهائية (يمين - منتصف - يسار)
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 12.0),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          // الجانب الأيمن (المستضيف)
          Expanded(
            child: isHome
                ? Row(mainAxisAlignment: MainAxisAlignment.end, children: [content, const SizedBox(width: 8), eventIcon])
                : const SizedBox(),
          ),

          // دائرة التوقيت في المنتصف
          Container(
            width: 45, height: 45,
            alignment: Alignment.center,
            margin: const EdgeInsets.symmetric(horizontal: 10),
            decoration: BoxDecoration(
              shape: BoxShape.circle,
              border: Border.all(color: Colors.amber.withOpacity(0.5), width: 2),
              color: const Color(0xFF1E1E1E),
            ),
            child: Text(timeDisplay, style: const TextStyle(color: Colors.amber, fontWeight: FontWeight.bold, fontSize: 12)),
          ),

          // الجانب الأيسر (الضيف)
          Expanded(
            child: !isHome
                ? Row(mainAxisAlignment: MainAxisAlignment.start, children: [eventIcon, const SizedBox(width: 8), content])
                : const SizedBox(),
          ),
        ],
      ),
    );
  }
}