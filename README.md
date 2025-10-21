# Project Arlo

An Android-based AI system that learns user behaviour, organises apps and files, manages photos, and adapts to new apps autonomously. Built for seamless personal assistance, privacy, and evolving intelligence.

## Features

- **AI-Powered Learning**: Learns user behavior patterns and adapts to usage habits
- **Smart Organization**: Automatically organizes apps and files based on learned preferences
- **Photo Management**: Intelligent photo organization and management
- **Autonomous Adaptation**: Adapts to new apps and features automatically
- **Privacy-Focused**: All AI processing happens on-device for maximum privacy
- **Modern UI**: Built with Jetpack Compose for a native Android experience

## Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose with Material 3
- **AI/ML**: TensorFlow Lite, ML Kit
- **Architecture**: MVVM with Kotlin Coroutines
- **Database**: Room
- **Background Tasks**: WorkManager
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)

## Project Structure

```
Project-Arlo/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/arlo/app/
│   │       │   ├── ArloApplication.kt
│   │       │   ├── MainActivity.kt
│   │       │   ├── service/
│   │       │   │   └── ArloLearningService.kt
│   │       │   └── ui/theme/
│   │       │       ├── Theme.kt
│   │       │       └── Type.kt
│   │       ├── res/
│   │       │   ├── values/
│   │       │   ├── layout/
│   │       │   └── drawable/
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
├── settings.gradle
└── README.md
```

## Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 17 or newer
- Android SDK 34
- Gradle 8.4 or newer

### Building the Project

1. Clone the repository:
```bash
git clone https://github.com/MallowLiam/Project-Arlo.git
cd Project-Arlo
```

2. Open the project in Android Studio:
   - File > Open > Select the Project-Arlo directory

3. Sync Gradle:
   - Android Studio should automatically sync Gradle
   - Or manually: File > Sync Project with Gradle Files

4. Build the project:
```bash
./gradlew build
```

5. Run on an emulator or device:
   - Click the "Run" button in Android Studio
   - Or use: `./gradlew installDebug`

### Running from Command Line

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug

# Run tests
./gradlew test
```

## Permissions

The app requires the following permissions:
- `INTERNET`: For potential cloud sync features
- `READ_EXTERNAL_STORAGE`: To access and organize files
- `WRITE_EXTERNAL_STORAGE`: To manage file organization
- `CAMERA`: For photo capture and management
- `ACCESS_FINE_LOCATION`: For location-based features
- `ACCESS_COARSE_LOCATION`: For location-based features
- `QUERY_ALL_PACKAGES`: To learn and organize installed apps

## Development Roadmap

- [x] Initial project setup
- [x] Basic UI with Jetpack Compose
- [ ] Implement behavior learning engine
- [ ] Add file organization algorithms
- [ ] Implement photo management features
- [ ] Add app usage tracking
- [ ] Integrate on-device ML models
- [ ] Implement privacy controls
- [ ] Add settings and preferences
- [ ] Performance optimization

## License

Copyright 2025 Project Arlo

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
