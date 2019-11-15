package sudakova.onlineshop.dto.response;

import lombok.Getter;
import lombok.Setter;
import sudakova.onlineshop.entity.History;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class HistoryResponse {

    private Date date;

    private Double totalPrice;

    private List<ProductResponse> products;

    public HistoryResponse(History history) {
        this.date = history.getDate();
        this.products = history.getProductList().stream().map(ProductResponse::new).collect(Collectors.toList());
        this.totalPrice = history.getTotalPrice();

    }
}
