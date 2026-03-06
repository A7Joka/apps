import 'package:flutter/material.dart';

class ChampionshipDetailsScreen extends StatelessWidget {
  final dynamic champData;
  const ChampionshipDetailsScreen({super.key, required this.champData});

  @override
  Widget build(BuildContext context) {
    final title = champData['title'] ?? "تفاصيل البطولة";

    return Scaffold(
      appBar: AppBar(
        title: Text(title),
        backgroundColor: const Color(0xFF1E2026),
      ),
      body: Center(
        child: Text("قريباً: الهدافين، الترتيب، وصناع اللعب لـ $title 🏆",
          style: const TextStyle(fontSize: 18, color: Colors.grey),
          textAlign: TextAlign.center,
        ),
      ),
    );
  }
}