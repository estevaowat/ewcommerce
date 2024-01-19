plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.ewcode"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.0.7")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-log4j2:3.0.4")
    implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")
    implementation("org.springframework.cloud:spring-cloud-starter-aws-messaging:2.2.6.RELEASE")
    testImplementation("org.instancio:instancio-junit:4.0.0")
    developmentOnly("org.springframework.boot:spring-boot-devtools:3.1.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
}

configurations.all {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
