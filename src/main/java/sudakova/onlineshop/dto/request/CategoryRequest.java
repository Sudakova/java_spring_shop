package sudakova.onlineshop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CategoryRequest {

    @NotNull
    @NotBlank
    @Size(min = 4, max = 1000)
    private String name;


}
