plugins {
    java
}

group = "ca.ardentgaming"
val manifestVersion = Regex("\"Version\"\\s*:\\s*\"([^\"]+)\"")
    .find(file("src/main/resources/manifest.json").readText(Charsets.UTF_8))
    ?.groupValues
    ?.get(1)
    ?: "0.0.0"
version = manifestVersion

repositories {
    mavenCentral()
    maven("https://maven.hytale.com/release")
}

dependencies {
    compileOnly("com.hypixel.hytale:Server:+")
    compileOnly("org.jetbrains:annotations:26.0.2-1")
    compileOnly("org.jspecify:jspecify:1.0.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.jar {
    archiveFileName.set("HyRCON-${project.version}.jar")
}
