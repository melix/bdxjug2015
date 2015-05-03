package com.acme

import org.codehaus.plexus.util.FileUtils
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class SourcesJarPluginTest extends Specification {

    @Rule
    TemporaryFolder temporaryFolder

    File projectDir

    File setup() {
        projectDir = temporaryFolder.newFolder()
        FileUtils.copyDirectory(new File('src/test/resources/testproject'), projectDir)
    }

    // tag::plugin_test[]
   def "tasks are created when plugin is applied"() {
        given: "A sample project"
        Project project = ProjectBuilder.builder()
                .withProjectDir(projectDir).build()

        when: "We apply the sourcesjar plugin"
        project.apply(plugin:'com.acme.sourcesjar')

        then: "the sourcesJar task is created"
        project.getTasksByName('sourcesJar', false).size() == 1
    }
    // end::plugin_test[]
}
