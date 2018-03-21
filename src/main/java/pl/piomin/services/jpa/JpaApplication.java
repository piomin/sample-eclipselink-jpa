package pl.piomin.services.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JpaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(JpaApplication.class).web(WebApplicationType.NONE).run(args);
	}
	
}
