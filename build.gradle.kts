plugins {
    java
    kotlin("jvm") version "1.4.31"
    `maven-publish`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/martinpaoloni/testproject1")
            credentials {
                val githubUser: String by project
                val githubToken: String by project
                username = githubUser
                password = githubToken
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.example"
            artifactId = "testproject2"
            version = "1.1"

            from(components["java"])
        }
    }
}