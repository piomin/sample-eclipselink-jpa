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

import pl.piomin.services.jpa.model.Product;
import pl.piomin.services.jpa.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductRepository repository;

    @PostMapping("/")
    public Product add(@RequestBody Product product) {
        LOGGER.info("Add product: {}", product);
        return repository.save(product);
    }

    @PutMapping("/")
    public Product update(@RequestBody Product product) {
        LOGGER.info("Update product: {}", product);
        return repository.save(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        LOGGER.info("Find product: id={}", id);
        return repository.findById(id).orElseThrow();
    }


    @GetMapping("/")
    public Iterable<Product> findAll() {
        LOGGER.info("Find products");
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Delete product: id={}", id);
        repository.deleteById(id);
    }

}
