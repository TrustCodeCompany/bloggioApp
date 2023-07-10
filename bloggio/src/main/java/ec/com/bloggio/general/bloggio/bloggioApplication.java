package ec.com.bloggio.general.bloggio;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.Registry;
import io.jkratz.mediator.spring.SpringMediator;
import io.jkratz.mediator.spring.SpringRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main application
 * @author trustcode
 * @version 1.0
 */


@SpringBootApplication(scanBasePackages = {"ec.com.bloggio.general.bloggio","ec.com.bloggio.general"})
@EnableJpaRepositories({"ec.com.bloggio.general.bloggio"/*,"ec.com.bloggio.general"*/})
@EnableFeignClients(basePackages = {"ec.com.bloggio.general.bloggio"} )
@EntityScan({"ec.com.bloggio.general.bloggio","ec.com.bloggio.general"})
@ComponentScan({"ec.com.bloggio.general.bloggio","ec.com.bloggio.general"})
@EnableDiscoveryClient
public class bloggioApplication {

    private final ApplicationContext applicationContext;

    @Autowired
    public bloggioApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public Registry registry() {
        return new SpringRegistry(applicationContext);
    }

    @Bean
    public Mediator mediator(Registry registry) {
        return new SpringMediator(registry);
    }

    public static void main(String[] args) {
        SpringApplication.run(bloggioApplication.class, args);
    }
}