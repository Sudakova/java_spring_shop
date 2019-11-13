package sudakova.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends idHolder {

    @OneToOne (mappedBy = "category")
    private List<Products> products = new ArrayList<>();

    private String name;


    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
