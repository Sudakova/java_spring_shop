package sudakova.onlineshop.dto.response;

import lombok.Getter;
import lombok.Setter;
import sudakova.onlineshop.entity.User;


@Getter
@Setter
public class UserResponse {
    private Long id;

    private Integer type;

    private String email;

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.type = user.getType();
    }
}
