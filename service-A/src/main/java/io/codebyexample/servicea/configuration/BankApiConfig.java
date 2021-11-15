package io.codebyexample.servicea.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author sateam
 */
@ToString
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "service-b")
public class BankApiConfig {

  private String target;
}
