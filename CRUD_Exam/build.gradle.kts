import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "me.carlos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson-parent:2.10.1")
    implementation("com.solidfire.code.gson:gson-parent:2.6.2")
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation(kotlin("test"))

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}