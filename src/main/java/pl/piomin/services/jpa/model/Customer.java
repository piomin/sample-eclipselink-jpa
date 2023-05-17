package pl.piomin.services.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "JPA_CUSTOMER")
public class Customer {

    @Id
    @SequenceGenerator(sequenceName = "SEQ_CUSTOMER", allocationSize = 1, initialValue = 1, name = "customerSequence")
    @GeneratedValue(generator = "customerSequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + "]";
    }

}
