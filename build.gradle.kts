plugins {
    kotlin("jvm") version "2.1.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.h2database:h2:2.2.224")
    implementation("com.zaxxer:HikariCP:5.1.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}