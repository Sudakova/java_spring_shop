package sudakova.onlineshop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishListRequest {
    private Long productId;
    private Long userId;
}
