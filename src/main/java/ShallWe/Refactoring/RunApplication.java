package ShallWe.Refactoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.UUID;


@SpringBootApplication
public class RunApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class,args);
    }
    @Bean
    public AuditorAware<String> auditorProvider(){
        return ()-> Optional.of(UUID.randomUUID().toString());
    }
}
