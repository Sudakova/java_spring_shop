package sudakova.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Products extends idHolder {

    private String name;

    private Integer size;

    private Double price;

    @OneToOne
    private Category category;

    @ManyToOne
    private Gender gender;

    @OneToOne
    private WishList wishList;

    @ManyToOne
    private History history;

    @OneToOne
    private Storage storage;


    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", category=" + category +
                ", gender=" + gender +
                ", wishList=" + wishList +
                ", history=" + history +
                '}';
    }
}
