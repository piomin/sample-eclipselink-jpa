package pl.piomin.services.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(JpaApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
