package pl.piomin.services.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import pl.piomin.services.jpa.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
