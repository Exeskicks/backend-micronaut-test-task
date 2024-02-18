val javaVersion = JavaVersion.VERSION_17

val kotlin_version: String by project
val logback_version: String by project
val exposed_sql_version: String by project
val postgres_test_container_version: String by project


version = "0.1"
group = "com.example"

plugins {
	kotlin("jvm") version "1.9.22"
	kotlin("kapt") version "1.9.22"
	kotlin("plugin.allopen") version "1.9.22"
	kotlin("plugin.lombok") version "1.9.22"
	id("io.freefair.lombok") version "8.1.0"
	id("com.github.johnrengelman.shadow") version "8.1.1"
	id("io.micronaut.application") version "4.3.1"
	id("io.micronaut.aot") version "4.3.1"
	//id("org.jetbrains.kotlin.jvm") version "1.9.22"
	//id("org.jetbrains.kotlin.plugin.lombok") version "1.9.22"
}

repositories {
	mavenCentral()
}

dependencies {
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("io.micronaut:micronaut-http-validation")
	annotationProcessor("io.micronaut.data:micronaut-data-processor")
	annotationProcessor("io.micronaut.openapi:micronaut-openapi")

	/* Step 2 */
	compileOnly("org.projectlombok:lombok")
	// DI
	kapt("io.micronaut:micronaut-inject")

	// micronaut basics
	kapt("io.micronaut:micronaut-http-validation")

	implementation("io.micronaut:micronaut-http-client")
	implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")

	implementation("io.micronaut:micronaut-http-client")
	implementation("io.micronaut:micronaut-jackson-databind")
	implementation("io.micronaut.flyway:micronaut-flyway")
	implementation("io.micronaut.oraclecloud:micronaut-oraclecloud-atp")
	implementation("io.micronaut.oraclecloud:micronaut-oraclecloud-sdk")
	implementation("io.micronaut.sql:micronaut-jdbc-hikari")
	implementation("jakarta.annotation:jakarta.annotation-api")
	implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
	implementation("org.apache.commons:commons-lang3:3.12.0")
	implementation("io.swagger.core.v3:swagger-annotations")
	runtimeOnly("ch.qos.logback:logback-classic")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("io.micronaut:micronaut-http-validation")
	annotationProcessor("io.micronaut.data:micronaut-data-processor")
	annotationProcessor("io.micronaut.openapi:micronaut-openapi")

	/* Step 2 */
	compileOnly("org.projectlombok:lombok")
	// DI
	kapt("io.micronaut:micronaut-inject")

	// micronaut basics
	kapt("io.micronaut:micronaut-http-validation")

	implementation("io.micronaut:micronaut-http-client")
	implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")

	// database - SQL
	implementation("io.micronaut.flyway:micronaut-flyway")
	runtimeOnly("org.flywaydb:flyway-database-postgresql")
	implementation("io.micronaut.sql:micronaut-jdbc-hikari")

	implementation("org.postgresql:postgresql")

	runtimeOnly("org.jetbrains.exposed:exposed-jdbc:$exposed_sql_version")
	implementation("org.jetbrains.exposed:exposed-dao:$exposed_sql_version")
	implementation("org.jetbrains.exposed:exposed-core:$exposed_sql_version")

	// serialization
	implementation("io.micronaut:micronaut-jackson-databind")
	runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

	// documentation
	kapt("io.micronaut.openapi:micronaut-openapi")
	implementation("io.swagger.core.v3:swagger-annotations")
	implementation("io.micronaut.views:micronaut-views-thymeleaf")

	// logging
	implementation("ch.qos.logback:logback-classic")

	// testing
	testImplementation("org.testcontainers:postgresql:$postgres_test_container_version")


	testImplementation("org.hsqldb:hsqldb:2.7.2")
	implementation("jakarta.persistence:jakarta.persistence-api:3.2.0-M1")

	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("io.micronaut.data:micronaut-data-processor")
	implementation("io.micronaut.data:micronaut-data-model:4.6.1")
	compileOnly("org.projectlombok:lombok:1.18.30")
	annotationProcessor("org.projectlombok:lombok:1.18.30")

	implementation("org.jetbrains.kotlin.plugin.lombok:org.jetbrains.kotlin.plugin.lombok.gradle.plugin:2.0.0-Beta4")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:<kotlin_version>")

	//implementation("io.micronaut.security:micronaut-security:4.6.3")
	implementation("io.micronaut.problem:micronaut-problem-json")
	implementation("io.micronaut.data:micronaut-data-jdbc:4.6.1")

	implementation("io.micronaut.data:micronaut-data-hibernate-reactive:4.6.0")
	implementation("io.projectreactor:reactor-core:3.6.2")
}

application {
	mainClass.set("com.example.Application")
}
java {
	sourceCompatibility = javaVersion
}

kotlin {
	jvmToolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

tasks {
	compileKotlin {
		kotlinOptions {
			jvmTarget = javaVersion.toString()
		}
	}

	compileTestKotlin {
		kotlinOptions {
			jvmTarget = javaVersion.toString()
		}
	}
}

graalvmNative.toolchainDetection.set(false)
micronaut {
	runtime("netty")
	testRuntime("kotest5")
	processing {
		incremental(true)
		annotations("com.example.*")
	}

	aot {
		optimizeServiceLoading.set(false)
		convertYamlToJava.set(false)
		precomputeOperations.set(true)
		cacheEnvironment.set(true)
		optimizeClassLoading.set(true)
		deduceEnvironment.set(true)
		optimizeNetty.set(true)
	}
}
kapt {
	keepJavacAnnotationProcessors = true
}

