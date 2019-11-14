package sudakova.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sudakova.onlineshop.dto.request.BuyRequest;
import sudakova.onlineshop.dto.request.ProductAmount;
import sudakova.onlineshop.entity.History;
import sudakova.onlineshop.entity.Product;
import sudakova.onlineshop.entity.User;
import sudakova.onlineshop.repository.HistoryRepository;
import sudakova.onlineshop.repository.ProductRepository;
import sudakova.onlineshop.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private HistoryRepository historyRepository;

    public boolean buyProducts(BuyRequest buyRequest) {
        User user = userRepository.getOne(buyRequest.getUserId());
        List<Product> productList = buyRequest.getProducts()
                .stream()
                .mapToLong(ProductAmount::getProductId)
                .mapToObj(id -> productRepository.getOne(id))
                .collect(Collectors.toList());
        History history = new History();
        history.setDate(new Date());
        return true;
    }
}
