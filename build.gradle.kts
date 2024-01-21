plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.ewcode"
version = "0.0.1-SNAPSHOT"
var springCloudAwsVersion = "3.1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("io.awspring.cloud:spring-cloud-aws-dependencies:${springCloudAwsVersion}")
        mavenBom("software.amazon.awssdk:bom:2.18.28")
    }

}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("org.springframework.boot:spring-boot-starter-validation")
//    implementation("io.awspring.cloud:spring-cloud-aws-starter-s3") not using for now
    implementation("io.awspring.cloud:spring-cloud-aws-starter-sqs")
    testImplementation("org.instancio:instancio-junit:4.0.0")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configurations.all {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
