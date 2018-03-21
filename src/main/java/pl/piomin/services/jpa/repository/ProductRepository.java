package pl.piomin.services.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import pl.piomin.services.jpa.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
