package pl.piomin.services.jpa.controller;

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

import pl.piomin.services.jpa.model.Order;
import pl.piomin.services.jpa.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderRepository repository;

    @PostMapping
    public Order add(@RequestBody Order order) {
        LOGGER.info("Add order: {}", order);
        return repository.save(order);
    }

    @PutMapping
    public Order update(@RequestBody Order order) {
        LOGGER.info("Update order: {}", order);
        return repository.save(order);
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") Long id) {
        LOGGER.info("Find order: id={}", id);
        return repository.findById(id).orElseThrow();
    }


    @GetMapping
    public Iterable<Order> findAll() {
        LOGGER.info("Find orders");
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Delete order: id={}", id);
        repository.deleteById(id);
    }

}
