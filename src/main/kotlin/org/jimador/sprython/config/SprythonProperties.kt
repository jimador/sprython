package org.jimador.sprython.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.core.io.ClassPathResource

/**
 * Spring Configuration Properties to externalize configuration for loading the python sample.
 *
 * @author James Dunnam
 */
@ConfigurationProperties(prefix = "sprython")
class SprythonProperties {
    var pyFile: ClassPathResource? = null
}