package pl.piomin.services.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_PRODUCT")
public class Product {

	@Id
	@SequenceGenerator(sequenceName = "SEQ_PRODUCT", allocationSize = 1, initialValue = 1, name = "productSequence")
	@GeneratedValue(generator = "productSequence", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String model;
	private int price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
