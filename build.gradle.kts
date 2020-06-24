plugins {
    java
    kotlin("jvm") version "1.3.72"
    kotlin("kapt") version "1.3.72"
    application
}

group = "pm.gnosis.safe.sdk"
version = "1.0-SNAPSHOT"
application {
    mainClass.set("pm.gnosis.safe.sdk.MainKt")
}

val bivrost = "0.8.0"
val koin = "2.1.5"
val retrofit = "2.9.0"
val moshi = "1.9.2"
val bouncycastle = "1.61"
val okio = "2.4.1"
val svalinn = "3b8797c15c"
val okhttp = "3.14.4"
val coroutines = "1.3.7"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://www.jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofit") {
        exclude(group = "com.squareup.moshi", module = "moshi")
    }

    implementation("com.squareup.moshi:moshi:$moshi")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshi")

    implementation("com.github.gnosis.bivrost-kotlin:bivrost-solidity-types:$bivrost")
    implementation("org.koin:koin-core:$koin")

    implementation("org.bouncycastle:bcprov-jdk15on:$bouncycastle") {
        exclude("junit", "junit")
    }

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")

    implementation("com.squareup.okhttp3:logging-interceptor:$okhttp")
    implementation("com.squareup.okio:okio:$okio")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
