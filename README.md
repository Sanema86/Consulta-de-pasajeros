# Info para Choferes - CHOFER S.A (prototipo Android)

Proyecto Android mínimo con interfaz WebView y pantalla compacta para consultar servicios de Almagroup.

## Abrir y compilar
1. Abrir esta carpeta en Android Studio.
2. Esperar la sincronización de Gradle.
3. Build > Build Bundle(s) / APK(s) > Build APK(s).

## Estado de la conexión
La pantalla intenta obtener el token desde la página pública y luego llama al endpoint `cmd.php` mediante POST. El patrón de extracción del token es provisional: hay que validarlo contra el HTML real de Micronauta. No se deben introducir tokens ni cookies manualmente ni distribuirlos dentro del APK.
