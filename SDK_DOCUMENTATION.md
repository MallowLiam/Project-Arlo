# Arlo SDK Documentation

## Overview

The Arlo SDK is an Android library that provides AI-powered personal assistance features including behavior learning, app organization, photo management, and file organization. All AI processing happens on-device for maximum privacy.

## Version

Current Version: **1.0.0**

## Requirements

- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)
- **Kotlin**: 1.9.20+
- **Java**: 17

## Installation

### Gradle (Build from source)

1. Clone the repository:
```bash
git clone https://github.com/MallowLiam/Project-Arlo.git
```

2. Build the SDK:
```bash
./gradlew :arlo-sdk:build
```

3. Publish to local Maven:
```bash
./gradlew :arlo-sdk:publishToMavenLocal
```

4. Add to your app's `build.gradle`:
```gradle
dependencies {
    implementation 'com.arlo:arlo-sdk:1.0.0'
}
```

### GitHub Packages

Add to your project's `settings.gradle`:
```gradle
dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/MallowLiam/Project-Arlo")
            credentials {
                username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.token") ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
```

Then add the dependency:
```gradle
dependencies {
    implementation 'com.arlo:arlo-sdk:1.0.0'
}
```

## Quick Start

### 1. Initialize the SDK

In your `Application` class:

```kotlin
import android.app.Application
import com.arlo.sdk.ArloSDK
import com.arlo.sdk.ArloConfig

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize with default configuration
        ArloSDK.initialize(this)

        // Or with custom configuration
        val config = ArloConfig(
            enableLearning = true,
            enableAppOrganization = true,
            enablePhotoManagement = true,
            privacyMode = true,
            debugMode = BuildConfig.DEBUG
        )
        ArloSDK.initialize(this, config)
    }
}
```

### 2. Update AndroidManifest.xml

Add required permissions:

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"
    android:maxSdkVersion="32" />
<uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
<uses-permission android:name="android.permission.READ_MEDIA_VIDEO" />
```

Declare your Application class:

```xml
<application
    android:name=".MyApplication"
    ...>
</application>
```

### 3. Use SDK Features

```kotlin
import com.arlo.sdk.ArloSDK
import kotlinx.coroutines.launch

// Start behavior learning
ArloSDK.startLearning()

// Organize apps
lifecycleScope.launch {
    val result = ArloSDK.organizeApps()
    if (result.isSuccess) {
        // Apps organized successfully
    }
}

// Organize photos
lifecycleScope.launch {
    val result = ArloSDK.organizePhotos()
    if (result.isSuccess) {
        // Photos organized successfully
    }
}

// Stop learning
ArloSDK.stopLearning()
```

## Configuration

### ArloConfig Options

| Option | Type | Default | Description |
|--------|------|---------|-------------|
| `enableLearning` | Boolean | true | Enable AI learning features |
| `enableAppOrganization` | Boolean | true | Enable app organization |
| `enablePhotoManagement` | Boolean | true | Enable photo management |
| `enableFileOrganization` | Boolean | true | Enable file organization |
| `enableBackgroundAnalysis` | Boolean | true | Enable background analysis |
| `privacyMode` | Boolean | true | Keep all data on device |
| `debugMode` | Boolean | false | Enable debug logging |
| `apiKey` | String? | null | API key for cloud features |

### Predefined Configurations

```kotlin
// Default configuration (all features enabled)
val defaultConfig = ArloConfig.default()

// Minimal configuration (basic features only)
val minimalConfig = ArloConfig.minimal()
```

## API Reference

### ArloSDK (Main Entry Point)

#### Initialization

```kotlin
fun initialize(context: Context, config: ArloConfig = ArloConfig.default())
```

Initialize the SDK. Must be called before using any other SDK features.

#### Learning Control

```kotlin
fun startLearning()
```
Start behavior learning and analysis.

```kotlin
fun stopLearning()
```
Stop behavior learning.

#### Organization Features

```kotlin
suspend fun organizeApps(): Result<Unit>
```
Organize apps based on learned patterns. Returns a Result indicating success or failure.

```kotlin
suspend fun organizePhotos(): Result<Unit>
```
Organize photos using AI image analysis.

#### SDK Information

```kotlin
fun isInitialized(): Boolean
```
Check if SDK is initialized.

```kotlin
fun getVersion(): String
```
Get the current SDK version.

```kotlin
fun getConfig(): ArloConfig
```
Get the current configuration.

#### Advanced Usage

```kotlin
fun getAIEngine(): ArloAIEngine
```
Get direct access to the AI engine (advanced).

```kotlin
fun getBehaviorAnalyzer(): BehaviorAnalyzer
```
Get direct access to the behavior analyzer (advanced).

```kotlin
fun shutdown()
```
Shutdown the SDK and cleanup resources.

## UI Components

The SDK provides pre-built Compose components:

### ArloStatusCard

Display SDK status in your UI:

```kotlin
import com.arlo.sdk.ui.ArloStatusCard

@Composable
fun MyScreen() {
    ArloStatusCard(
        title = "AI Status",
        status = "Learning active",
        modifier = Modifier.fillMaxWidth()
    )
}
```

## Permissions

The SDK requires the following permissions:

- `INTERNET` - For potential cloud features
- `READ_EXTERNAL_STORAGE` - To access files (API 32 and below)
- `READ_MEDIA_IMAGES` - To access images (API 33+)
- `READ_MEDIA_VIDEO` - To access videos (API 33+)
- `CAMERA` - For photo capture features

**Note**: Permissions must be requested at runtime on Android 6.0+

## Privacy

By default, the SDK operates in privacy mode:
- All AI processing happens on-device
- No data is sent to external servers
- User data stays on the device

Set `privacyMode = false` in configuration to enable cloud features (requires API key).

## ProGuard/R8

The SDK includes consumer ProGuard rules. No additional configuration needed.

If you have issues, add to your `proguard-rules.pro`:

```proguard
-keep class com.arlo.sdk.** { *; }
```

## Sample App

See the `sample-app` module for a complete integration example.

To run the sample:

```bash
./gradlew :sample-app:installDebug
```

## Building the SDK

### Build Library AAR

```bash
./gradlew :arlo-sdk:assembleRelease
```

Output: `arlo-sdk/build/outputs/aar/arlo-sdk-release.aar`

### Publish to Local Maven

```bash
./gradlew :arlo-sdk:publishToMavenLocal
```

### Publish to GitHub Packages

Set environment variables:
```bash
export GITHUB_ACTOR=your-username
export GITHUB_TOKEN=your-token
```

Then publish:
```bash
./gradlew :arlo-sdk:publish
```

## Troubleshooting

### SDK Not Initialized Error

**Error**: `IllegalStateException: Arlo SDK not initialized`

**Solution**: Call `ArloSDK.initialize()` in your Application's `onCreate()` method.

### Permission Denied Errors

**Solution**: Request runtime permissions before using SDK features:

```kotlin
if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES)
    != PackageManager.PERMISSION_GRANTED) {
    ActivityCompat.requestPermissions(this,
        arrayOf(Manifest.permission.READ_MEDIA_IMAGES), REQUEST_CODE)
}
```

### ProGuard Issues

**Solution**: Ensure consumer ProGuard rules are applied, or add keep rules manually.

## Support

- **GitHub Issues**: https://github.com/MallowLiam/Project-Arlo/issues
- **Documentation**: https://github.com/MallowLiam/Project-Arlo

## License

Copyright 2025 Project Arlo

Licensed under the Apache License, Version 2.0

## Changelog

### Version 1.0.0 (2025-01-XX)
- Initial release
- AI-powered learning engine
- App organization features
- Photo management features
- On-device privacy mode
- Jetpack Compose UI components
