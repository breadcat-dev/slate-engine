plugins {
    id("java")
    id("application")
}

group = "cat.breadcat.slate"
version = "0.2.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("cat.breadcat.slate:math:0.2.0")

    implementation(platform("org.lwjgl:lwjgl-bom:3.3.6"))

    implementation("org.lwjgl:lwjgl")
    implementation("org.lwjgl:lwjgl-glfw")
    implementation("org.lwjgl:lwjgl-opengl")

    runtimeOnly("org.lwjgl:lwjgl::natives-linux")
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-linux")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-linux")
}

application {
    mainClass.set("cat.breadcat.Main")
}