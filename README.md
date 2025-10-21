# Project Arlo

An Android SDK for AI-powered personal assistance that learns user behaviour, organises apps and files, manages photos, and adapts to new apps autonomously. Built for seamless integration, privacy-first processing, and evolving intelligence.

## 🚀 Now Available as SDK!

Project Arlo is now packaged as an Android SDK library that you can integrate into your own applications. See the [SDK Documentation](SDK_DOCUMENTATION.md) for integration guide.

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
├── arlo-sdk/                      # SDK Library Module
│   ├── src/main/
│   │   ├── java/com/arlo/sdk/
│   │   │   ├── ArloSDK.kt        # Main SDK entry point
│   │   │   ├── ArloConfig.kt     # Configuration
│   │   │   ├── ai/
│   │   │   │   └── ArloAIEngine.kt
│   │   │   ├── learning/
│   │   │   │   └── BehaviorAnalyzer.kt
│   │   │   └── ui/
│   │   │       └── ArloStatusCard.kt
│   │   └── AndroidManifest.xml
│   ├── build.gradle              # Library build config
│   └── README.md
├── sample-app/                    # Sample Integration App
│   ├── src/main/
│   │   ├── java/com/arlo/sample/
│   │   │   ├── SampleApplication.kt
│   │   │   └── MainActivity.kt
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── app/                           # Original Standalone App
│   ├── src/main/
│   │   ├── java/com/arlo/app/
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── SDK_DOCUMENTATION.md           # Complete SDK docs
├── build.gradle
├── settings.gradle
└── README.md
```

## Quick Start

### For App Developers (Using the SDK)

See [SDK Documentation](SDK_DOCUMENTATION.md) for integration guide.

**Quick integration:**

```kotlin
// 1. Add dependency
dependencies {
    implementation 'com.arlo:arlo-sdk:1.0.0'
}

// 2. Initialize in your Application
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ArloSDK.initialize(this)
    }
}

// 3. Use SDK features
ArloSDK.startLearning()
```

### For SDK Developers (Building from Source)

#### Prerequisites

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 17 or newer
- Android SDK 34
- Gradle 8.4 or newer

#### Building the SDK Library

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

4. Build the SDK library:
```bash
# Build SDK AAR
./gradlew :arlo-sdk:assembleRelease

# Publish to local Maven
./gradlew :arlo-sdk:publishToMavenLocal
```

5. Run the sample app:
```bash
# Install sample app
./gradlew :sample-app:installDebug

# Or run from Android Studio
# Select "sample-app" configuration and click Run
```

### Building Different Modules

```bash
# Build SDK library only
./gradlew :arlo-sdk:build

# Build sample app
./gradlew :sample-app:assembleDebug

# Build original standalone app
./gradlew :app:assembleDebug

# Run all tests
./gradlew test

# Publish SDK to local Maven repository
./gradlew :arlo-sdk:publishToMavenLocal

# Publish to GitHub Packages
./gradlew :arlo-sdk:publish
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

### SDK
- [x] Initial SDK architecture
- [x] Core SDK API (ArloSDK, ArloConfig)
- [x] AI Engine framework
- [x] Behavior Analyzer framework
- [x] Jetpack Compose UI components
- [x] Maven publishing setup
- [x] Sample app with integration examples
- [x] Comprehensive documentation
- [ ] Implement behavior learning algorithms
- [ ] Add file organization algorithms
- [ ] Implement photo management with ML Kit
- [ ] Add app usage tracking
- [ ] Integrate TensorFlow Lite models
- [ ] Add Room database for learning data
- [ ] Implement WorkManager for background tasks
- [ ] Add privacy controls and settings
- [ ] Performance optimization
- [ ] Unit and integration tests

### Standalone App
- [x] Initial project setup
- [x] Basic UI with Jetpack Compose
- [ ] Feature parity with SDK
- [ ] Advanced UI features

## SDK vs Standalone App

This repository contains:

1. **arlo-sdk**: Android library for integration into other apps
2. **sample-app**: Demonstrates how to use the SDK
3. **app**: Original standalone application

Most developers should use the **arlo-sdk** module and refer to **sample-app** for integration examples.

## Documentation

- [SDK Documentation](SDK_DOCUMENTATION.md) - Complete SDK integration guide
- [SDK README](arlo-sdk/README.md) - Quick SDK overview
- Sample App - See `sample-app` module for working example

## License

Copyright 2025 Project Arlo

Licensed under the Apache License, Version 2.0

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Support

- **Issues**: https://github.com/MallowLiam/Project-Arlo/issues
- **Discussions**: https://github.com/MallowLiam/Project-Arlo/discussions
