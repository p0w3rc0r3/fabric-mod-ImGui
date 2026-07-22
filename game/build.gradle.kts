import org.gradle.util.internal.VersionNumber

plugins {
    id("cn.enaium.fabric-multi-game")
}

fmg {
    common.set(project(":core"))
}
val bindingVersion = "1.92.0-BekaZid"
val imguiVersion = "1.92.0"

subprojects {
    apply(plugin = "mod-publish")

    repositories {
        mavenLocal()
        maven("https://jitpack.io")
    }


    val minecraftVersion = property("minecraft.version")
    version = "$minecraftVersion-${rootProject.version}+imgui.$imguiVersion"
    val publishing = gradle.startParameter.taskNames.any {
        it.split(":").any { split -> split.startsWith("publishToMaven") }
    }

    fun include(dependency: Any) {
        if (publishing) {
            return
        }
        dependencies.add("include", dependency)
    }

    dependencies {
        include(add("api", "io.github.spair:imgui-java-binding:$bindingVersion")!!)
        include(add("api", "io.github.spair:imgui-java-lwjgl3:$bindingVersion"){
            exclude(group = "org.lwjgl")
        }!!)

        include(add("api", "io.github.spair:imgui-java-natives-windows:$imguiVersion")!!)
        include(add("api", "io.github.spair:imgui-java-natives-linux:$imguiVersion")!!)
        include(add("api", "io.github.spair:imgui-java-natives-macos:$imguiVersion")!!)

        if (VersionNumber.parse(minecraftVersion.toString()) < VersionNumber.parse("1.14")) {
            include(add("api", "com.github.Enaium:ImGui-LWJGL2:323f99019f")!!)
        }
    }
}