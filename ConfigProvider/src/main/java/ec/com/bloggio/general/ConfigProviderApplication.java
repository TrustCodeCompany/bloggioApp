package ec.com.bloggio.general;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class ConfigProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigProviderApplication.class, args);
    }
}