import 'package:flutter/material.dart';
import '../data/sports_api_service.dart';

class MatchChannelsTab extends StatelessWidget {
  final String matchId;
  const MatchChannelsTab({super.key, required this.matchId});

  @override
  Widget build(BuildContext context) {
    final apiService = SportsApiService();

    return FutureBuilder<List<dynamic>>(
      future: apiService.getMatchChannels(matchId),
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) {
          return const Center(child: CircularProgressIndicator(color: Colors.amber));
        }
        if (!snapshot.hasData || snapshot.data!.isEmpty) {
          return const Center(child: Text("لا توجد قنوات ناقلة مسجلة", style: TextStyle(color: Colors.grey)));
        }

        final channels = snapshot.data!;

        return ListView.builder(
          padding: const EdgeInsets.all(15),
          itemCount: channels.length,
          itemBuilder: (context, index) {
            final channelInfo = channels[index];
            return Card(
              color: const Color(0xFF1E1E1E),
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
              child: ListTile(
                leading: const Icon(Icons.tv, color: Colors.blueAccent, size: 30),
                title: Text(channelInfo['channel_name'] ?? "قناة غير معروفة", style: const TextStyle(color: Colors.white, fontWeight: FontWeight.bold)),
                subtitle: Text("المعلق: ${channelInfo['commentator_name'] ?? "غير مدرج"}", style: const TextStyle(color: Colors.grey)),
                trailing: const Icon(Icons.play_circle_fill, color: Colors.amber),
              ),
            );
          },
        );
      },
    );
  }
}