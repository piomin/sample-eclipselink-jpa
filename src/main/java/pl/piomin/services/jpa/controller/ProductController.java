package pl.piomin.services.jpa.controller;

import java.util.List;

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
@RequestMapping("/Product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductRepository repository;
	
	@PostMapping
	public Product add(@RequestBody Product Product) {
		return repository.save(Product);
	}
	
	@PutMapping
	public Product update(@RequestBody Product Product) {
		return repository.save(Product);
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}
	
	
	@GetMapping
	public Iterable<Product> findAll() {
		return repository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
	
}
