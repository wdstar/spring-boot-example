// Spring Boot porovides the default console logging settings.
// See: https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-logging.html
// This customized configuration file could be bundled on the application's classpath
// (e.g. src/main/resources/).

import static ch.qos.logback.classic.Level.*

import java.nio.charset.Charset

import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import ch.qos.logback.classic.encoder.PatternLayoutEncoder

def defaultCharset = Charset.forName("UTF-8")
def defaultHistory = 365
def defaultFilename = "./spring-boot-example.log"

// ref.: https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot/src/main/resources/org/springframework/boot/logging/logback/defaults.xml
appender("CONSOLE", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    charset = defaultCharset
    pattern = "%d{HH:mm:ss.SSS} [%thread] %highlight(%-5level) %cyan(%logger{36}) - %msg%n"
  }
}

appender("FILE", RollingFileAppender) {
  fileName = defaultFilename

  encoder(PatternLayoutEncoder) {
    charset = defaultCharset
    pattern = "%d [%thread] %-5level %logger{36} - %msg%n"
  }

  rollingPolicy(TimeBasedRollingPolicy) {
    maxHistory = defaultHistory
    fileNamePattern = "${defaultFilename}.%d{yyyy-MM-dd}.gz"
  }
}

// default level: DEBUG
root INFO, ["CONSOLE", "FILE"]
