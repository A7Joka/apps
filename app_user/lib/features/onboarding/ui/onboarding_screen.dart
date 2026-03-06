import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../../home/ui/main_wrapper_screen.dart';

class OnboardingScreen extends StatelessWidget {
  const OnboardingScreen({super.key});

  Future<void> _saveInterestAndNavigate(BuildContext context, String interest) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setString('user_interest', interest);

    if (context.mounted) {
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(builder: (context) => const MainWrapperScreen()),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFF121212),
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              const SizedBox(height: 40),
              const Text(
                "أهلاً بك في عالمك 🌍",
                style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold, color: Colors.white),
                textAlign: TextAlign.center,
              ),
              const SizedBox(height: 10),
              const Text(
                "ما هو اهتمامك الرئيسي؟ (سنقوم بضبط التطبيق ليناسبك)",
                style: TextStyle(fontSize: 16, color: Colors.grey),
                textAlign: TextAlign.center,
              ),
              const SizedBox(height: 50),

              _buildInterestCard(
                context,
                title: "⚽ الملاعب والمباريات",
                subtitle: "جدول مباريات، إحصائيات، وأخبار حية",
                interestKey: "sports",
                color: Colors.green.shade700,
              ),
              const SizedBox(height: 15),
              _buildInterestCard(
                context,
                title: "🍿 الأفلام والمسلسلات",
                subtitle: "أحدث الإصدارات بجودات عالية",
                interestKey: "vod",
                color: Colors.red.shade700,
              ),
              const SizedBox(height: 15),
              _buildInterestCard(
                context,
                title: "📺 البث المباشر والتلفاز",
                subtitle: "قنوات رياضية وترفيهية بدون تقطيع",
                interestKey: "live_tv",
                color: Colors.blue.shade700,
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildInterestCard(BuildContext context, {required String title, required String subtitle, required String interestKey, required Color color}) {
    return InkWell(
      onTap: () => _saveInterestAndNavigate(context, interestKey),
      borderRadius: BorderRadius.circular(15),
      child: Ink(
        padding: const EdgeInsets.all(20),
        decoration: BoxDecoration(
          color: const Color(0xFF1E1E1E),
          borderRadius: BorderRadius.circular(15),
          border: Border.all(color: color.withOpacity(0.5), width: 1.5),
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(title, style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: color)),
            const SizedBox(height: 5),
            Text(subtitle, style: const TextStyle(fontSize: 14, color: Colors.white70)),
          ],
        ),
      ),
    );
  }
}