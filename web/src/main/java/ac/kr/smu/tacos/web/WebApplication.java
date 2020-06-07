package ac.kr.smu.tacos.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@RefreshScope
@SpringBootApplication
@EnableJpaRepositories("ac.kr.smu.tacos.repository")
@EntityScan("ac.kr.smu.tacos.domain")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
