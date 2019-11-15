
package sudakova.onlineshop.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DiscountRequest {

    @NotBlank
    @Size(min = 4, max = 15)
    private String name;

    @Positive
    private Float sale;

    @NotNull
    private Long userId;
}
