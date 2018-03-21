package pl.piomin.services.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import pl.piomin.services.jpa.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
