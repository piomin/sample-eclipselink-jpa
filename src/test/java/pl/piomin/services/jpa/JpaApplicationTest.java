package pl.piomin.services.jpa;

import org.springframework.boot.SpringApplication;

public class JpaApplicationTest {

    public static void main(String[] args) {
        SpringApplication.from(JpaApplication::main)
                .with(OracleContainerDevMode.class)
                .run(args);
    }

}
