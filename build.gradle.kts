plugins {
    application
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    id("org.jetbrains.kotlinx.kover") version "0.8.3"
}

application {
    mainClass.set("link.kotlin.scripts.Application")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlinx.coroutines)
    implementation(libs.komok.tech.to.be.injected)
    implementation(libs.komok.tech.logging)

    implementation(libs.jackson.module.kotlin)
    implementation(libs.jackson.dataformat.xml)

    implementation(libs.logback)

    implementation(libs.rome)
    implementation(libs.sitemapgen4j)
    implementation(libs.jsoup)

    implementation(libs.kotlin.scripting.common)
    implementation(libs.kotlin.scripting.jvm)
    implementation(libs.kotlin.scripting.jvm.host)

    implementation(libs.commonmark)
    implementation(libs.commonmark.ext.gfm.tables)

    implementation(libs.ktor.client.apache)
    implementation(libs.ktor.client.jackson)

    testImplementation(libs.mockk)
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.test {
    useJUnitPlatform()
}

kover {
    reports {
        total {
            xml {
                onCheck = false
            }
        }
    }
    merge {
        allProjects()
    }
}
