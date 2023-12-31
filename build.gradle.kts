plugins {
    id("java")
    application

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.java-websocket:Java-WebSocket:1.5.4")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "main.Main"
}