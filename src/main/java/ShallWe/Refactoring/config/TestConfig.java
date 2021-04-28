package ShallWe.Refactoring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile(value = "test")
@PropertySource({"classpath:test/application-test.yml"})
public class TestConfig {

}
