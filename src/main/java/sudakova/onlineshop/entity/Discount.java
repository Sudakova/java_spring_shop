package sudakova.onlineshop.entity;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Discount extends IdHolder {

    @OneToMany(mappedBy = "discount")
    private List<User> user;

    private Float sale;

    private String name;

    public List<User> getUser() { return user; }

    public void setUser(List<User> user) { this.user = user; }

    public Float getSale() { return sale; }

    public void setSale(Float sale) { this.sale = sale; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
