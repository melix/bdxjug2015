package com.acme

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.bundling.Jar

// tag::main_body[]
class SourcesJarPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.afterEvaluate {
            def sourcesJarTask = project.tasks.create('sourcesJar')
            project.sourceSets.each { sourceSet ->
                Task t = project.tasks.create(name: "${sourceSet.name}SourcesJar", type: Jar) {
                    classifier = sourceSet.name == 'main' ? 'sources' : "${sourceSet.name}-sources"
                    from sourceSet.allSource
                }
                sourcesJarTask.dependsOn(t)
            }
        }
    }
}
// end::main_body[]