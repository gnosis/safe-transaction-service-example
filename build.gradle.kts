plugins {
    kotlin("jvm") version "1.3.72"
}

group = "pm.gnosis.safe.sdk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://www.jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    implementation("com.github.gnosis.bivrost-kotlin:bivrost-solidity-types:0.8.0")

}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}