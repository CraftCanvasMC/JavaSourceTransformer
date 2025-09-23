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
        maven {
            name = "canvasmc"
            url = uri("https://maven.canvasmc.io/snapshots")
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
