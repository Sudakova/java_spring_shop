package sudakova.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sudakova.onlineshop.dto.request.BuyRequest;
import sudakova.onlineshop.dto.request.ProductRequest;
import sudakova.onlineshop.dto.response.DataResponse;
import sudakova.onlineshop.dto.response.ProductResponse;
import sudakova.onlineshop.service.ProductService;
import sudakova.onlineshop.service.ShopService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShopService shopService;

//    @GetMapping
//    public DataResponse<ProductResponse> getAll(@RequestParam Integer page, @RequestParam Integer size,
//                                                @RequestParam String sortBy, @RequestParam Sort.Direction direction,
//                                                @RequestParam(required = false) String name) {
//        return productService.getAllProducts(page, size, sortBy, direction, name);
//    }

    @GetMapping("/all")
    public DataResponse<ProductResponse> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public ProductResponse save(@RequestBody @Valid ProductRequest productRequest) {
        return productService.save(productRequest);
    }

    @PostMapping("/buy")
    public boolean buyProducts(@RequestBody BuyRequest buyRequest){
        return shopService.buyProducts(buyRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ProductRequest brandRequest) {
        productService.update(id, brandRequest);
    }

    @DeleteMapping
    public boolean delete(@RequestParam Long id) {
        return productService.delete(id);
    }
}
