package pl.piomin.services.jpa;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.piomin.services.jpa.model.Customer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerControllerTests {

    @Container
    static final OracleContainer oracle = new OracleContainer("gvenzl/oracle-xe:21-slim-faststart")
            .withDatabaseName("eclipselink")
            .withUsername("piomin")
            .withPassword("Piot_123");

    @DynamicPropertySource
    static void oracleProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", oracle::getJdbcUrl);
    }

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void add() {
        Customer c = new Customer();
        c.setName("Test1");
        c = restTemplate.postForObject("/customer/", c, Customer.class);
        assertNotNull(c);
        assertNotNull(c.getId());
    }

    @Test
    @Order(2)
    void findById() {
        Customer customer = restTemplate.getForObject("/customer/{id}", Customer.class, 1);
        assertNotNull(customer);
        assertEquals(1, customer.getId());
    }

    @Test
    @Order(2)
    void findAll() {
        Customer[] customers = restTemplate.getForObject("/customer", Customer[].class);
        assertTrue(customers.length > 0);
    }
}
