plugins {
    `java-library`
    `maven-publish`
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

tasks.jar {
    manifest {
        attributes("Implementation-Version" to project.version)
    }
}

publishing {
    repositories {
        maven("https://maven.canvasmc.io/snapshots") {
            name = "canvasmc"
            credentials {
                username=System.getenv("PUBLISH_USER")
                password=System.getenv("PUBLISH_TOKEN")
            }
        }
    }

    publications.create<MavenPublication>("maven") {
        artifactId = "jst"
        from(components["java"])
    }
}

tasks.register("printVersion") {
    doFirst {
        println(version)
    }
}
