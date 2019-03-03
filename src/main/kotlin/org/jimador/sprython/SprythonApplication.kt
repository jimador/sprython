package org.jimador.sprython

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Main App entry point
 *
 * @author James Dunnam
 */
@SpringBootApplication
class SprythonApplication

fun main(args: Array<String>) {
    runApplication<SprythonApplication>(*args)
}
