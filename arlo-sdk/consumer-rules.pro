# Consumer ProGuard rules for apps using Arlo SDK

# Keep SDK public API
-keep public class com.arlo.sdk.ArloSDK { *; }
-keep public class com.arlo.sdk.ArloConfig { *; }
-keep public interface com.arlo.sdk.** { *; }
