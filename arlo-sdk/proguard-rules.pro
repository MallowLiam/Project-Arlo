# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Keep SDK public API
-keep public class com.arlo.sdk.ArloSDK { *; }
-keep public class com.arlo.sdk.ArloConfig { *; }
-keep public interface com.arlo.sdk.** { *; }

# Keep AI/ML model classes
-keep class com.arlo.sdk.ai.** { *; }
-keep class com.arlo.sdk.model.** { *; }

# Keep TensorFlow Lite classes
-keep class org.tensorflow.** { *; }
-keep class com.google.mlkit.** { *; }

# Keep Room entities
-keep @androidx.room.Entity class * { *; }

# Preserve line numbers for debugging
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile
