package sudakova.onlineshop.dto.response;

import lombok.Getter;
import lombok.Setter;
import sudakova.onlineshop.entity.Product;


@Getter
@Setter
public class ProductResponse {

    private Long id;

    private String name;

    private Integer size;

    private Double price;

    private Long categoryId;

    private Long genderId;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.size = product.getSize();
        this.price = product.getPrice();
        if (product.getCategory() != null)
            this.categoryId = product.getCategory().getId();
        if (product.getGender() != null)
            this.genderId = product.getGender().getId();
    }

}
