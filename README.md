# My Wallet
## Proyecto Bedu

Este proyecto fue creado pr el Equipo 17 del Grupo 1 para el Modulo Kotlin Fundamentals, del curso de Desarrollo Movil con Kotlin

Los commits anteriores son mostrados en la rama ``old``. Por favor revisarlos, ahi está mucha parte del trabajo.

Esta rama fue creada para implementar las corrutinas en en un nuevo proyecto. Así que se volvió la rama principal, favor de clonar desde aquí.

## Ejecutar en Android Studio

Este proyecto es una aplicación de consola Kotlin/JVM. Se ejecuta en la consola de Android Studio; no genera un APK ni se instala en un emulador.

1. Abre la carpeta raíz del proyecto en Android Studio.
2. En Settings > Build, Execution, Deployment > Build Tools > Gradle, selecciona el wrapper del proyecto y JDK 21 (el JDK incluido con Android Studio).
3. Sincroniza el proyecto con Gradle.
4. Selecciona la configuración **MyWallet** y pulsa Run. También puedes abrir `src/main/kotlin/main.kt` y ejecutar `main` desde el margen del editor.
5. Introduce las respuestas en la ventana Run para registrarte, iniciar sesión y usar el menú.

Desde la terminal de Android Studio también puedes ejecutar:

```sh
./gradlew run --console=plain
```

Para compilar y verificar el proyecto:

```sh
./gradlew build
```

## Contribuidores:
- Hannia Jellian Rodríguez Vargas
- Luis Angel Alvarado Hernández
- David Perez Morales
