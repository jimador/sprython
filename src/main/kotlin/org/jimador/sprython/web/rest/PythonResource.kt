package org.jimador.sprython.web.rest

import org.jimador.sprython.config.SprythonProperties
import org.jimador.sprython.util.logger
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.support.GenericMessage
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Rest Controller for requesting python file execution
 *
 * @author James Dunnam
 */
@RestController
@RequestMapping("/api")
@EnableConfigurationProperties(SprythonProperties::class)
class PythonResource(val sprythonProperties: SprythonProperties,
                     @Qualifier("execRequestChannel") val executionRequestChannel: MessageChannel) {

    @GetMapping("/execute")
    fun activate() = executionRequestChannel
            .send(GenericMessage(sprythonProperties.pyFile!!))
            .also { log.info("Requesting execution for python file.") }

    companion object {
        val log = logger(this::class.java)
    }
}