package pl.piomin.services.jpa;

import static springfox.documentation.builders.PathSelectors.any;

import javax.sql.DataSource;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JpaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(JpaApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
                .apis(RequestHandlerSelectors.basePackage("pl.piomin.services.jpa"))
                .paths(any())
            .build()
            .apiInfo(new ApiInfoBuilder().version("1.0").title("JPA API").description("Documentation JPA API v1.0").build());
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@192.168.99.100:1521:xe");
        dataSource.setUsername("piomin");
        dataSource.setPassword("Piot_123");
        return dataSource;
    }

}
