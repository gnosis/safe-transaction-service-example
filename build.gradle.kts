plugins {
    kotlin("jvm") version "1.3.72"
}

group = "pm.gnosis.safe.sdk"
version = "1.0-SNAPSHOT"

val bivrost = "0.8.0"
val koinVersion = "2.1.5"
val retrofit = "2.9.0"
val moshi = "1.9.2"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://www.jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.moshi:moshi:$moshi")

    implementation("com.github.gnosis.bivrost-kotlin:bivrost-solidity-types:$bivrost")
    implementation("org.koin:koin-core:$koinVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}