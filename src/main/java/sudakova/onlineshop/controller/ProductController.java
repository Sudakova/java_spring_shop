package sudakova.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sudakova.onlineshop.dto.request.BuyRequest;
import sudakova.onlineshop.dto.request.FilterProductRequest;
import sudakova.onlineshop.dto.request.ProductRequest;
import sudakova.onlineshop.dto.request.WishListRequest;
import sudakova.onlineshop.dto.response.DataResponse;
import sudakova.onlineshop.dto.response.ProductResponse;
import sudakova.onlineshop.entity.Category;
import sudakova.onlineshop.service.ProductService;
import sudakova.onlineshop.service.ShopService;
import sudakova.onlineshop.service.WishListService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private WishListService wishListService;

    @GetMapping
    public DataResponse<ProductResponse> getAll(@RequestParam Integer page, @RequestParam Integer size,
                                                @RequestParam String sortBy, @RequestParam Sort.Direction direction,
                                                @RequestParam(required = false) Long categoryId) {
        return productService.getAllProducts(page, size, sortBy, direction, categoryId);
    }

    @GetMapping("/all")
    public DataResponse<ProductResponse> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public DataResponse<ProductResponse> getAllProductsByCategory(@PathVariable Long categoryId) {
        Category category = new Category();
        category.setId(categoryId);
        return productService.getAllProductsByCategory(category);
    }

    @PostMapping("/filter")
    public List<ProductResponse> filter(@RequestBody FilterProductRequest filterProductRequest){
        return productService.filter(filterProductRequest);
    }

    @PostMapping("/favorite")
    public boolean addToFavorite(@RequestBody WishListRequest wishListRequest){
        return wishListService.addToWishList(wishListRequest);
    }

    @DeleteMapping("/favorite")
    public boolean removeFromFavorite(@RequestBody WishListRequest wishListRequest){
        return wishListService.removeFromWishList(wishListRequest);
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
    public boolean buyProducts(@RequestBody BuyRequest buyRequest) {
        return shopService.buyProducts(buyRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        productService.update(id, productRequest);
    }

    @DeleteMapping
    public boolean delete(@RequestParam Long id) {
        return productService.delete(id);
    }
}
