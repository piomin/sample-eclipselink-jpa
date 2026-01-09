package pl.piomin.services.jpa;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.piomin.services.jpa.model.Customer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerControllerTests {

    static Long id;

    @Container
    @ServiceConnection
    static final OracleContainer oracle = new OracleContainer("gvenzl/oracle-xe:21-slim-faststart")
            .withDatabaseName("eclipselink")
            .withUsername("piomin")
            .withPassword("piomin123");

    @Autowired
    private WebApplicationContext context;
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        this.webTestClient = WebTestClient.bindToApplicationContext(context).build();
    }

    @Test
    @Order(1)
    void add() {
        Customer customer = new Customer();
        customer.setName("Test1");
        
        webTestClient.post()
                .uri("/customer/")
                .bodyValue(customer)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Customer.class)
                .value(c -> {
                    assertNotNull(c);
                    assertNotNull(c.getId());
                    id = c.getId();
                });
    }

    @Test
    @Order(2)
    void findById() {
        webTestClient.get()
                .uri("/customer/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Customer.class)
                .value(customer -> {
                    assertNotNull(customer);
                    assertEquals(id, customer.getId());
                });
    }

    @Test
    @Order(3)
    void findAll() {
        webTestClient.get()
                .uri("/customer")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Customer.class)
                .value(customers -> assertFalse(customers.isEmpty()));
    }
}
