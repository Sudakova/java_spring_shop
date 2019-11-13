package sudakova.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gender extends idHolder {

    private Integer name;

    @OneToMany(mappedBy = "gender")
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }
}
