package sudakova.onlineshop.dto.response;


import lombok.Getter;
import lombok.Setter;
import sudakova.onlineshop.entity.Discount;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DiscountResponse {

    private Long id;

    private String name;

    private List<UserResponse> userResponses;

    public DiscountResponse(Discount discount) {
        this.id = discount.getId();
        this.name = discount.getName();
        this.userResponses = discount.getUser().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

}
