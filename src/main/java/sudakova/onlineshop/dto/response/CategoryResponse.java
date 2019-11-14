package sudakova.onlineshop.dto.response;


import lombok.Getter;
import lombok.Setter;
import sudakova.onlineshop.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoryResponse {

    private Long id;

    private String name;

    private List<ProductResponse> productResponses;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.productResponses = category.getProducts().stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }
}
