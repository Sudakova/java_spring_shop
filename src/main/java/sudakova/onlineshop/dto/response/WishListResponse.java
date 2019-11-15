package sudakova.onlineshop.dto.response;

import lombok.Getter;
import lombok.Setter;
import sudakova.onlineshop.entity.WishList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class WishListResponse {

    private List<ProductResponse> products;

    public WishListResponse(WishList wishList) {
        if (wishList.getProduct() != null) {
            this.products = wishList.getProduct().stream().map(ProductResponse::new).collect(Collectors.toList());
        } else {
            this.products = new ArrayList<>();
        }
    }
}
