package ac.kr.smu.tacos.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ac.kr.smu.tacos")
@EnableJpaRepositories("ac.kr.smu.tacos.repository")
@EntityScan("ac.kr.smu.tacos.domain")
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class,args);
    }

}
