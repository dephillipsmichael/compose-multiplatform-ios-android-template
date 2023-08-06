plugins {
    // Repo Template Plugins
    kotlin("multiplatform").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)

    // IR Added
    id("org.jetbrains.kotlin.plugin.serialization").apply(false)
}
