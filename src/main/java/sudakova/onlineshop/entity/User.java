package sudakova.onlineshop.entity;


import sun.net.ftp.FtpDirEntry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends idHolder{

    @OneToOne
    private Discount discount;

    @OneToMany (mappedBy = "user")
    private List<History> histories = new ArrayList<>();

    @OneToMany (mappedBy = "user")
    private List<WishList> wishLists = new ArrayList<>();

    private Integer type;

    @Column (unique = true)
    private String email;

    private String password;



    public List<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<WishList> wishLists) {
        this.wishLists = wishLists;
    }

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
}
