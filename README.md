# Dibujos con Jetpack Compose (Android Studio)

Tres dibujos hechos con `Column`, `Row`, `Box` y `Alignment` en Kotlin.
Cada uno tiene `@Preview(showSystemUi = true)`, así que se ven en el panel **Split** de Android Studio.

El código está en `app/src/main/kotlin/com/example/dibujos/Dibujos.kt`.

## Abrir
1. Android Studio → `File > Open` y elige esta carpeta.
2. Espera a que Gradle sincronice.
3. Abre `Dibujos.kt` y pulsa **Split** para ver las previews.

## Compilar el APK

    ./gradlew assembleDebug      # Windows: .\gradlew.bat assembleDebug

El APK queda en `app/build/outputs/apk/debug/app-debug.apk`.
Una copia ya compilada está en `apk/dibujos.apk`.
