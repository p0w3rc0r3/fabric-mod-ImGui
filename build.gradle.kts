allprojects {
    group = "cn.enaium"
    //version = rootProject.property("version").toString()
    version = "26.2-1.1.0-BekaZid"

    repositories {
        mavenLocal()
        mavenCentral {
            metadataSources {
                mavenPom()
                artifact()
                ignoreGradleMetadataRedirection()
            }
        }
        maven {
            name = "Fabric"
            url = uri("https://maven.fabricmc.net/")
        }
        maven {
            name = "legacy-fabric"
            url = uri("https://repo.legacyfabric.net/repository/legacyfabric/")
        }
        maven { url = uri("https://jitpack.io") }
    }
}