package org.jimador.sprython.config

import org.python.util.PythonInterpreter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Spring Bean definitions for Jython/Python integration.
 * @author James Dunnam
 * @see PythonInterpreter
 */
@Configuration
class PythonConfiguration {

    @Bean
    fun jython(): PythonInterpreter = PythonInterpreter()
}