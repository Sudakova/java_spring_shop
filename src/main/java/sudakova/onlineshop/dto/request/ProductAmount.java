package sudakova.onlineshop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Setter
@Getter
public class ProductAmount {
    private Long productId;
    @Positive
    private int amount;
}
