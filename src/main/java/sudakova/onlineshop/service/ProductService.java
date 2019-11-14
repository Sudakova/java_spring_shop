package sudakova.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sudakova.onlineshop.dto.request.ProductRequest;
import sudakova.onlineshop.dto.response.DataResponse;
import sudakova.onlineshop.dto.response.ProductResponse;
import sudakova.onlineshop.entity.Product;
import sudakova.onlineshop.exception.WrongInputDataException;
import sudakova.onlineshop.repository.ProductRepository;

import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


//    public DataResponse<ProductResponse> getAllProducts(Integer page, Integer size,
//                                                        String sortBy, Sort.Direction direction,
//                                                        String name) {
//        Sort sort = Sort.by(direction, sortBy);
//        PageRequest pageRequest = PageRequest.of(page, size, sort);
//        Page<Product> productPage;
////        if (name != null) {
////         //   productPage = productRepository.findAllByNameLike("%" + name + "%", pageRequest);
////        } else {
////            productPage = productRepository.findAll(pageRequest);
////        }
//        return new DataResponse<>(productPage.getContent().stream().map(ProductResponse::new).collect(Collectors.toList()), productPage);
//    }

    public DataResponse<ProductResponse> getAllProducts(){
        return new DataResponse<>(productRepository.findAll().stream().map(ProductResponse::new).collect(Collectors.toList()));

    }

    public ProductResponse getById(Long id) {
        return new ProductResponse(getEntityObjectById(id));
    }

    public ProductResponse save(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        return new ProductResponse(productRepository.save(product));
    }


    public void update(Long id, ProductRequest productRequest) {
        Product product = getEntityObjectById(id);
        product.setName(productRequest.getName());
        productRepository.save(product);
    }

    public boolean delete(Long id) {
        Product product = getEntityObjectById(id);
        productRepository.delete(product);
        return true;
    }

    private Product getEntityObjectById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Product with id: " + id + " not found."));
    }


}

