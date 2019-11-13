package sudakova.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import sudakova.onlineshop.dto.request.ProductRequest;
import sudakova.onlineshop.dto.response.DataResponse;
import sudakova.onlineshop.dto.response.ProductResponse;
import sudakova.onlineshop.entity.Product;
import sudakova.onlineshop.exception.WrongInputDataException;
import sudakova.onlineshop.repository.ProductsRepository;

import java.util.stream.Collectors;

public class ProductService {

    @Autowired
    private ProductsRepository productRepository;


    public DataResponse<ProductResponse> getAllProducts(Integer page, Integer size,
                                                        String sortBy, Sort.Direction direction,
                                                        String name) {
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Product> productPage;
        if (name != null) {
            productPage = productRepository.findAllByNameLike("%" + name + "%", pageRequest);
        } else {
            productPage = productRepository.findAll(pageRequest);
        }
        return new DataResponse<>(productPage.getContent().stream().map(ProductResponse::new).collect(Collectors.toList()), productPage);
    }

    public ProductResponse getById(Long id) {
        return new ProductResponse(getEntityObjectById(id));
    }

    public void save(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        productRepository.save(product);
    }


    public void update(Long id, ProductRequest productRequest) {
        Product product = getEntityObjectById(id);
        product.setName(productRequest.getName());
        productRepository.save(product);
    }

    public void delete(Long id) {
        Product product = getEntityObjectById(id);
        productRepository.delete(product);
    }

    private Product getEntityObjectById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Product with id: " + id + " not found."));
    }


}

