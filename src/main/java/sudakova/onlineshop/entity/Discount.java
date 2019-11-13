package sudakova.onlineshop.entity;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Discount extends idHolder{

    @OneToOne (mappedBy = "discount")
    private User user;

    private Float sale;

    private String name;

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Float getSale() { return sale; }

    public void setSale(Float sale) { this.sale = sale; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
