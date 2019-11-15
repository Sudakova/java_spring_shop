package sudakova.onlineshop.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends IdHolder {

    @ManyToOne
    private Discount discount;

    @OneToMany (mappedBy = "user")
    private List<History> histories = new ArrayList<>();

    @OneToOne
    private WishList wishList;

    private Integer type;

    @Column (unique = true)
    private String email;

    private String password;

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public Discount getDiscount() { return discount; }

    public void setDiscount(Discount discount) { this.discount = discount; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }
}
