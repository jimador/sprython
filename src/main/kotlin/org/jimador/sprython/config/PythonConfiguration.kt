package org.jimador.sprython.config

import org.python.util.PythonInterpreter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PythonConfiguration {

    @Bean
    fun jython() : PythonInterpreter = PythonInterpreter()
}