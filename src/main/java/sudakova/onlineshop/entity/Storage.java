package sudakova.onlineshop.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Storage extends idHolder {

    @OneToOne (mappedBy = "storage")
    private Products products;

    private Integer goodsAmount;

}
