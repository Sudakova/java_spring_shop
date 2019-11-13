package sudakova.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class WishList extends idHolder {

    @OneToOne (mappedBy = "wishList")
    private Products products;

    @ManyToOne
    private User user;

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
