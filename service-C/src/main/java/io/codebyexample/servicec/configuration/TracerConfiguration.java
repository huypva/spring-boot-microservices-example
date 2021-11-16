package io.codebyexample.servicec.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huypva
 */

@ConditionalOnProperty(value = "opentracing.jaeger.enabled", havingValue = "false", matchIfMissing = false)
@Configuration
public class TracerConfiguration {

  @Bean
  public io.opentracing.Tracer jaegerTracer() {
    return io.opentracing.noop.NoopTracerFactory.create();
  }
}
