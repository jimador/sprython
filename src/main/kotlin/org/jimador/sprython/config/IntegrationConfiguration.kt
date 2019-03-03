package org.jimador.sprython.config

import org.jimador.sprython.service.PythonService
import org.jimador.sprython.util.logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.config.EnableIntegration
import org.springframework.integration.dsl.IntegrationFlow
import org.springframework.integration.dsl.IntegrationFlows

/**
 * Configuration class for Spring Integration
 *
 * @author James Dunnam
 */
@Configuration
@EnableIntegration
class IntegrationConfiguration {

    @Bean(name = [EXEC_REQUEST_CHANNEL])
    fun execRequestChannel() = DirectChannel()

    @Bean
    fun jythonExecFlow(pythonService: PythonService): IntegrationFlow {
        return IntegrationFlows.from(EXEC_REQUEST_CHANNEL)
                .handle { message ->
                    run {
                        val resource = message.payload as ClassPathResource
                        LOGGER.info("File is @ ${resource.path}")
                        pythonService.execute(resource.inputStream)
                    }
                }
                .get()
    }

    companion object {
        const val EXEC_REQUEST_CHANNEL = "execRequestChannel"
        val LOGGER = logger(this::class.java)
    }
}

