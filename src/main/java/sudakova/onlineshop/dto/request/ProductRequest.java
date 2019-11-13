package sudakova.onlineshop.dto.request;

import lombok.Getter;
import lombok.Setter;
import sudakova.onlineshop.entity.Category;
import sudakova.onlineshop.entity.Gender;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


@Getter
@Setter
public class ProductRequest {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 1000)
    private String name;

    private Integer size;

    @NotNull
    @PositiveOrZero
    private Double price;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long genderId;
}
