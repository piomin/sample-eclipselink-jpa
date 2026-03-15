package pl.piomin.services.jpa;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.oracle.OracleContainer;

@TestConfiguration(proxyBeanMethods = false)
public class OracleContainerDevMode {

    @Bean
    @ServiceConnection
    public OracleContainer oracle() {
       return new OracleContainer("gvenzl/oracle-free:23.4-slim-faststart")
               .withDatabaseName("eclipselink")
               .withUsername("piomin")
               .withPassword("piomin123");
    }

}
