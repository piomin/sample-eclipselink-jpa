package pl.piomin.services.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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

    @Version
    private long version;

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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", model=" + model + ", price=" + price + "]";
    }

}
