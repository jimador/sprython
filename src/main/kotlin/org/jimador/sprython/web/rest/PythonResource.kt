package org.jimador.sprython.web.rest

import org.jimador.sprython.config.SprythonProperties
import org.jimador.sprython.service.PythonService
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@EnableConfigurationProperties(SprythonProperties::class)
class PythonResource(val pythonService: PythonService,
                     val sprythonProperties: SprythonProperties) {

    @GetMapping
    fun home() : String = "Hello World"

    @GetMapping("/execute")
    fun execute() : Unit = pythonService.execute(sprythonProperties.pyFile!!.inputStream)
}