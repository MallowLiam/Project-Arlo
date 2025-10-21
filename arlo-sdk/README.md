# Arlo SDK

AI-powered Android SDK for personal assistance with behavior learning, app organization, and photo management.

## Features

- **AI Learning Engine**: On-device machine learning for user behavior patterns
- **App Organization**: Intelligent app categorization and organization
- **Photo Management**: AI-powered photo organization and smart albums
- **File Organization**: Automatic file management based on learned preferences
- **Privacy First**: All processing happens on-device
- **Jetpack Compose**: Modern UI components included
- **Easy Integration**: Simple API with minimal setup

## Quick Start

```kotlin
// 1. Initialize in Application class
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ArloSDK.initialize(this)
    }
}

// 2. Use SDK features
ArloSDK.startLearning()

lifecycleScope.launch {
    ArloSDK.organizeApps()
    ArloSDK.organizePhotos()
}
```

## Installation

### From Source

```bash
./gradlew :arlo-sdk:publishToMavenLocal
```

Then add to your app:

```gradle
dependencies {
    implementation 'com.arlo:arlo-sdk:1.0.0'
}
```

### From AAR

Build the AAR:

```bash
./gradlew :arlo-sdk:assembleRelease
```

Output: `arlo-sdk/build/outputs/aar/arlo-sdk-release.aar`

## Documentation

See [SDK_DOCUMENTATION.md](../SDK_DOCUMENTATION.md) for complete documentation.

## Sample App

Check the `sample-app` module for a complete integration example.

## Requirements

- Min SDK: 26
- Target SDK: 34
- Kotlin: 1.9.20+

## License

Apache License 2.0
