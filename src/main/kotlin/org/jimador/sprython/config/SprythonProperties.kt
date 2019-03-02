package org.jimador.sprython.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.core.io.ClassPathResource

@ConfigurationProperties(prefix = "sprython")
class SprythonProperties {
    var pyFile : ClassPathResource? = null
}