package pl.piomin.services.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_ORDER")
public class Order {

	@Id
	@SequenceGenerator(sequenceName = "SEQ_ORDER", allocationSize = 1, initialValue = 1, name = "orderSequence")
	@GeneratedValue(generator = "orderSequence", strategy = GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne
	private Product product;
	@Enumerated
	private OrderStatus status;
	private int count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", product=" + product + ", status=" + status + ", count=" + count + "]";
	}

}
