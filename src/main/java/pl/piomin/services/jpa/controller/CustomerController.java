package pl.piomin.services.jpa.controller;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.services.jpa.model.Customer;
import pl.piomin.services.jpa.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerRepository repository;

    @PostMapping("/")
//    @Transactional
    public Customer add(@RequestBody Customer customer) {
        LOGGER.info("Add product: {}", customer);
        return repository.save(customer);
    }

    @PutMapping("/")
    public Customer update(@RequestBody Customer customer) {
        LOGGER.info("Update product: {}", customer);
        return repository.save(customer);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") Long id) {
        return repository.findById(id).orElseThrow();
    }


    @GetMapping
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

}
