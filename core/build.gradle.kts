plugins {
    java
    `java-library`
}

dependencies {
    implementation(libs.imgui.java.binding)
    implementation(libs.imgui.java.natives.windows)
    implementation(libs.imgui.java.natives.linux)
    implementation(libs.imgui.java.natives.macos)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}