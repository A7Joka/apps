import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import '../../sports/ui/matches_screen.dart';
import '../../../main.dart';

class MainWrapperScreen extends StatefulWidget {
  const MainWrapperScreen({super.key});

  @override
  State<MainWrapperScreen> createState() => _MainWrapperScreenState();
}

class _MainWrapperScreenState extends State<MainWrapperScreen> {
  int _currentIndex = 0;

  final List<Widget> _screens = [
    const MatchesScreen(),
    const Center(child: Text("الأخبار")),
    const Center(child: Text("الأفلام")),
    const Center(child: Text("البث المباشر")),
  ];

  // دالة الترجمة السريعة
  String t(String ar, String en) => localeNotifier.value.languageCode == 'ar' ? ar : en;

  @override
  Widget build(BuildContext context) {
    final isDark = Theme.of(context).brightness == Brightness.dark;

    // دمج لون شريط الإشعارات (Status Bar) مع لون الهيرو
    SystemChrome.setSystemUIOverlayStyle(SystemUiOverlayStyle(
      statusBarColor: Colors.transparent,
      statusBarIconBrightness: isDark ? Brightness.light : Brightness.dark,
    ));

    return Scaffold(
      extendBody: true,
      body: IndexedStack(index: _currentIndex, children: _screens),
      bottomNavigationBar: Padding(
        padding: const EdgeInsets.only(left: 20, right: 20, bottom: 20),
        child: ClipRRect(
          borderRadius: BorderRadius.circular(25),
          child: BackdropFilter(
            filter: ImageFilter.blur(sigmaX: 20, sigmaY: 20),
            child: Container(
              height: 65,
              decoration: BoxDecoration(
                color: isDark ? const Color(0xFF1E2026).withAlpha(200) : Colors.white.withAlpha(220),
                border: Border.all(color: isDark ? Colors.white.withAlpha(20) : Colors.grey.withAlpha(50), width: 1.5),
                borderRadius: BorderRadius.circular(25),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  _buildNavItem(0, Icons.sports_soccer, Icons.sports_soccer_outlined, t("المباريات", "Matches")),
                  _buildNavItem(1, Icons.article, Icons.article_outlined, t("الأخبار", "News")),
                  _buildNavItem(2, Icons.movie, Icons.movie_outlined, t("أفلام", "Movies")),
                  _buildNavItem(3, Icons.tv, Icons.tv_outlined, t("البث", "Live TV")),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }

  Widget _buildNavItem(int index, IconData filledIcon, IconData outlinedIcon, String label) {
    final isSelected = _currentIndex == index;
    final activeColor = Theme.of(context).primaryColor;
    final inactiveColor = Colors.grey;

    return GestureDetector(
      onTap: () => setState(() => _currentIndex = index),
      behavior: HitTestBehavior.opaque,
      child: AnimatedContainer(
        duration: const Duration(milliseconds: 300),
        curve: Curves.easeOutCubic,
        padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 10),
        decoration: BoxDecoration(
          color: isSelected ? activeColor.withAlpha(30) : Colors.transparent,
          borderRadius: BorderRadius.circular(20),
        ),
        child: Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(isSelected ? filledIcon : outlinedIcon, color: isSelected ? activeColor : inactiveColor, size: 24),
            if (isSelected) ...[
              const SizedBox(width: 8),
              Text(label, style: TextStyle(color: activeColor, fontWeight: FontWeight.bold, fontSize: 13)),
            ]
          ],
        ),
      ),
    );
  }
}