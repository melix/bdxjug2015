import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class Checksum extends DefaultTask {
    Checksum() {
        project.afterEvaluate {
            project.configurations.each {
                it.artifacts.each { artifact ->
                    this.dependsOn(artifact.buildDependencies)
                }
            }
        }
    }

    @TaskAction
    void exec() {
        project.configurations.each {
            it.artifacts.files.each { f ->
                project.ant.checksum(file:f)
            }
        }
    }
}