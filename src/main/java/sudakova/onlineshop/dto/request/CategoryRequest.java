package sudakova.onlineshop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class CategoryRequest {

    @NotNull
    @NotBlank
    @Size(min = 4, max = 1000)
    private String name;

    @Max(value = 55)
    @Min(value = 16)
    private Integer age;

}
