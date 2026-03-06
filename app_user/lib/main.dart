import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:intl/date_symbol_data_local.dart';
import 'features/home/ui/main_wrapper_screen.dart';

final ValueNotifier<ThemeMode> themeNotifier = ValueNotifier(ThemeMode.dark);
final ValueNotifier<Locale> localeNotifier = ValueNotifier(const Locale('ar'));

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await initializeDateFormatting('ar', null);

  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return ValueListenableBuilder<ThemeMode>(
      valueListenable: themeNotifier,
      builder: (_, ThemeMode currentMode, __) {
        return ValueListenableBuilder<Locale>(
          valueListenable: localeNotifier,
          builder: (_, Locale currentLocale, __) {
            return MaterialApp(
              debugShowCheckedModeBanner: false,
              title: 'Super App',

              // اللغات والترجمة
              locale: currentLocale,
              supportedLocales: const [Locale('ar'), Locale('en')],
              localizationsDelegates: const [
                GlobalMaterialLocalizations.delegate,
                GlobalWidgetsLocalizations.delegate,
                GlobalCupertinoLocalizations.delegate,
              ],

              // الثيم الفاتح
              theme: ThemeData(
                brightness: Brightness.light,
                primaryColor: Colors.amber,
                scaffoldBackgroundColor: const Color(0xFFF5F7FA), // لون رمادي فاتح مريح للعين
                fontFamily: 'Neo Sans Arabic', // اسم الخط الخاص بك
              ),

              // الثيم الداكن
              darkTheme: ThemeData(
                brightness: Brightness.dark,
                primaryColor: Colors.amber,
                scaffoldBackgroundColor: const Color(0xFF121212),
                fontFamily: 'Neo Sans Arabic',
              ),

              themeMode: currentMode,
              home: const MainWrapperScreen(),
            );
          },
        );
      },
    );
  }
}