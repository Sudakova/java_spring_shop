package sudakova.onlineshop.dto.response;

import lombok.Getter;
import lombok.Setter;
import sudakova.onlineshop.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class UserResponse {
    private Long id;

    private Integer type;

    private String email;

    private List<HistoryResponse> history;

    private WishListResponse wishList;

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.type = user.getType();
        if (user.getHistories() != null) {
            this.history = user.getHistories().stream().map(HistoryResponse::new).collect(Collectors.toList());
        } else {
            this.history = new ArrayList<>();
        }
        if (user.getWishList() != null) {
            this.wishList = new WishListResponse(user.getWishList());
        }
    }
}
