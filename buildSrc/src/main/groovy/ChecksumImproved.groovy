import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class ChecksumImproved extends DefaultTask {
    ChecksumImproved() {
        // tag::improvement[]
        project.afterEvaluate {
            project.configurations.each {
                it.artifacts.each { artifact ->
                    this.dependsOn(artifact.buildDependencies)
                }
                it.artifacts.files.each { f ->
                    inputs.file(f)
                    outputs.file("${f}.MD5")
                }
            }
        }
        // end::improvement[]
    }

    @TaskAction
    void exec() {
        project.configurations.each {
            it.artifacts.files.each { f ->
                project.ant.checksum(file: f)
            }
        }
    }
}