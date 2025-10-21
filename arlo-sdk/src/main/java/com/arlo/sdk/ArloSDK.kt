package com.arlo.sdk

import android.content.Context
import android.util.Log
import com.arlo.sdk.ai.ArloAIEngine
import com.arlo.sdk.learning.BehaviorAnalyzer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * Main entry point for Arlo SDK
 *
 * Usage:
 * ```
 * val config = ArloConfig.default()
 * ArloSDK.initialize(context, config)
 * ```
 */
object ArloSDK {

    private const val TAG = "ArloSDK"
    private var isInitialized = false
    private lateinit var appContext: Context
    private lateinit var config: ArloConfig
    private lateinit var aiEngine: ArloAIEngine
    private lateinit var behaviorAnalyzer: BehaviorAnalyzer

    private val sdkScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    /**
     * Initialize the Arlo SDK
     *
     * @param context Application context
     * @param config SDK configuration
     * @throws IllegalStateException if SDK is already initialized
     */
    @JvmStatic
    fun initialize(context: Context, config: ArloConfig = ArloConfig.default()) {
        if (isInitialized) {
            log("SDK already initialized")
            return
        }

        appContext = context.applicationContext
        this.config = config

        log("Initializing Arlo SDK v1.0.0")

        // Initialize AI engine
        aiEngine = ArloAIEngine(appContext, config)
        aiEngine.initialize()

        // Initialize behavior analyzer
        if (config.enableLearning) {
            behaviorAnalyzer = BehaviorAnalyzer(appContext, config)
            behaviorAnalyzer.initialize()
        }

        isInitialized = true
        log("Arlo SDK initialized successfully")
    }

    /**
     * Check if SDK is initialized
     */
    @JvmStatic
    fun isInitialized(): Boolean = isInitialized

    /**
     * Get the current configuration
     */
    @JvmStatic
    fun getConfig(): ArloConfig {
        checkInitialized()
        return config
    }

    /**
     * Start behavior learning
     */
    @JvmStatic
    fun startLearning() {
        checkInitialized()
        if (config.enableLearning) {
            behaviorAnalyzer.startLearning()
            log("Learning started")
        } else {
            log("Learning is disabled in config")
        }
    }

    /**
     * Stop behavior learning
     */
    @JvmStatic
    fun stopLearning() {
        checkInitialized()
        if (config.enableLearning) {
            behaviorAnalyzer.stopLearning()
            log("Learning stopped")
        }
    }

    /**
     * Organize apps based on learned patterns
     */
    @JvmStatic
    suspend fun organizeApps(): Result<Unit> {
        checkInitialized()
        return if (config.enableAppOrganization) {
            aiEngine.organizeApps()
        } else {
            Result.failure(IllegalStateException("App organization is disabled"))
        }
    }

    /**
     * Organize photos based on AI analysis
     */
    @JvmStatic
    suspend fun organizePhotos(): Result<Unit> {
        checkInitialized()
        return if (config.enablePhotoManagement) {
            aiEngine.organizePhotos()
        } else {
            Result.failure(IllegalStateException("Photo management is disabled"))
        }
    }

    /**
     * Get AI engine instance (advanced usage)
     */
    @JvmStatic
    fun getAIEngine(): ArloAIEngine {
        checkInitialized()
        return aiEngine
    }

    /**
     * Get behavior analyzer instance (advanced usage)
     */
    @JvmStatic
    fun getBehaviorAnalyzer(): BehaviorAnalyzer {
        checkInitialized()
        if (!config.enableLearning) {
            throw IllegalStateException("Learning is disabled in config")
        }
        return behaviorAnalyzer
    }

    /**
     * Shutdown the SDK and cleanup resources
     */
    @JvmStatic
    fun shutdown() {
        if (!isInitialized) {
            return
        }

        log("Shutting down Arlo SDK")

        if (config.enableLearning) {
            behaviorAnalyzer.shutdown()
        }

        aiEngine.shutdown()
        isInitialized = false

        log("Arlo SDK shutdown complete")
    }

    private fun checkInitialized() {
        if (!isInitialized) {
            throw IllegalStateException("Arlo SDK not initialized. Call ArloSDK.initialize() first.")
        }
    }

    private fun log(message: String) {
        if (config.debugMode) {
            Log.d(TAG, message)
        }
    }

    /**
     * Get SDK version
     */
    @JvmStatic
    fun getVersion(): String = "1.0.0"
}
