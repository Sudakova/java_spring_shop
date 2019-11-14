package sudakova.onlineshop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class BuyRequest {

    @NotEmpty
    private List<ProductAmount> products;

    @NotNull
    private Long userId;

}

