package org.jimador.sprython.service

import org.python.util.PythonInterpreter
import org.springframework.stereotype.Service
import java.io.InputStream

/**
 * Service class for executing an Python script file.
 *
 * @author James Dunnam
 */
@Service
class PythonService(val jython: PythonInterpreter) {

    fun execute(pyFile: InputStream) = jython.execfile(pyFile)

}