package sudakova.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class WishList extends idHolder {

    @OneToOne (mappedBy = "wishList")
    private Product product;

    @ManyToOne
    private User user;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
