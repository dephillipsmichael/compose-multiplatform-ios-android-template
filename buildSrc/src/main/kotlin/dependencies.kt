object Versions {
  const val androidBuildTools = "29.0.2"
  const val appCompat = "1.0.2"
  const val coil = "2.2.2"
  const val composeBOM = "2023.03.00"
  const val composeActivity = "1.5.1"
  const val composeNavigation = "2.5.3"
  const val minSdk = 24
  const val targetSdk = 33
  const val compileSdk = 33
  const val kotlinCompilerExtension = "1.4.4"
  const val coroutines = "1.6.4"
  const val kotlin = "1.9.0"
  const val ktor = "2.2.3"
  const val serialization = "0.20.0"
  const val slf4j = "1.7.30"
  const val koinCore    = "3.3.0"
  const val kamel = "0.7.1"
}

object AndroidX {
  object Compose {
    const val billOfMaterials = "androidx.compose:compose-bom:${Versions.composeBOM}"
    const val ui = "androidx.compose.ui:ui"
    const val uiTooling = "androidx.compose.ui:ui-tooling"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val foundation = "androidx.compose.foundation:foundation"
    const val material = "androidx.compose.material:material"
    const val iconsExt = "androidx.compose.material:material-icons-extended"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
  }
}

object Coroutines {
  const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.ktor}"

  object Core {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Versions.coroutines}"
    const val native = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.coroutines}"
  }
}

object Ktor {
  const val android = "io.ktor:ktor-client-android:${Versions.ktor}"
  const val ios = "io.ktor:ktor-client-ios:${Versions.ktor}"

  object Android {
    const val okHttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
  }

  object Ios {
    const val darvin = "io.ktor:ktor-client-darwin:${Versions.ktor}"
  }

  object Core {
    const val common = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val jvm = "io.ktor:ktor-client-core-jvm:${Versions.ktor}"
    const val native = "io.ktor:ktor-client-core-native:${Versions.ktor}"
  }

  object Json {
    const val common = "io.ktor:ktor-client-json:${Versions.ktor}"
    const val jvm = "io.ktor:ktor-client-json-jvm:${Versions.ktor}"
    const val native = "io.ktor:ktor-client-json-native:${Versions.ktor}"
  }

  object Logging {
    const val common = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val jvm = "io.ktor:ktor-client-logging-jvm:${Versions.ktor}"
    const val slf4j = "org.slf4j:slf4j-simple:${Versions.slf4j}"
    const val native = "io.ktor:ktor-client-logging-native:${Versions.ktor}"
  }

  object Mock {
    const val common = "io.ktor:ktor-client-mock:${Versions.ktor}"
    const val jvm = "io.ktor:ktor-client-mock-jvm:${Versions.ktor}"
    const val native = "io.ktor:ktor-client-mock-native:${Versions.ktor}"
  }

  object Serialization {
    const val common = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val jvm = "io.ktor:ktor-client-serialization-jvm:${Versions.ktor}"
    const val native = "io.ktor:ktor-client-serialization-native:${Versions.ktor}"
    const val content = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val json = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
  }
}

object Serialization {
  const val runtime =
      "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.serialization}"
  const val runtimeNative =
      "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:${Versions.serialization}"
}

object Kamel {
  const val asyncImage = "media.kamel:kamel-image:${Versions.kamel}"
}