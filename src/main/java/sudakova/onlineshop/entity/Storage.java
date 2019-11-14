package sudakova.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Storage extends IdHolder {

    @OneToOne (mappedBy = "storage")
    private Product product;

    private Integer goodsAmount;

}
