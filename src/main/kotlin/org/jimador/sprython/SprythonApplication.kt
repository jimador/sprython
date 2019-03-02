package org.jimador.sprython

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SprythonApplication

fun main(args: Array<String>) {
    runApplication<SprythonApplication>(*args)
}
