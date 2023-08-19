import java.io.FileInputStream
import java.util.*

val localProperties = Properties().apply {
    val file = File(rootProject.projectDir, "local.properties")
    FileInputStream(file).use { load(it) }
}

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/jianastrero/compose-permissions")
            credentials {
                username = localProperties.getProperty("githubUsername")
                password = localProperties.getProperty("githubKey")
            }
        }
    }
}

rootProject.name = "QR Delivery"
include(":app")
