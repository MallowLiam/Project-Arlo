package com.arlo.sdk

/**
 * Configuration class for Arlo SDK initialization
 */
data class ArloConfig(
    /**
     * Enable AI learning features
     */
    val enableLearning: Boolean = true,

    /**
     * Enable app organization features
     */
    val enableAppOrganization: Boolean = true,

    /**
     * Enable photo management features
     */
    val enablePhotoManagement: Boolean = true,

    /**
     * Enable file organization features
     */
    val enableFileOrganization: Boolean = true,

    /**
     * Enable background behavior analysis
     */
    val enableBackgroundAnalysis: Boolean = true,

    /**
     * Privacy mode - keeps all data on device
     */
    val privacyMode: Boolean = true,

    /**
     * Debug mode for logging
     */
    val debugMode: Boolean = false,

    /**
     * Custom API key for cloud features (if privacy mode is disabled)
     */
    val apiKey: String? = null
) {
    companion object {
        /**
         * Default configuration with all features enabled
         */
        fun default() = ArloConfig()

        /**
         * Minimal configuration with only basic features
         */
        fun minimal() = ArloConfig(
            enableBackgroundAnalysis = false,
            enablePhotoManagement = false,
            enableFileOrganization = false
        )
    }
}
