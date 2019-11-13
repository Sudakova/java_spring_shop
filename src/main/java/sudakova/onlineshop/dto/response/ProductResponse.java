package sudakova.onlineshop.dto.response;

import lombok.Getter;
import lombok.Setter;
import sudakova.onlineshop.entity.Products;


@Getter
@Setter
public class ProductResponse {

    private Long id;

    private String name;

    private Integer size;

    private Double price;

    private Long categoryId;

    private Long genderId;

    public ProductResponse(Products products){
        this.id = products.getId();
        this.name = products.getName();
        this.size = products.getSize();
        this.price = products.getPrice();
        this.categoryId = products.getCategory().getId();
        this.genderId = products.getGender().getId();
    }

}
