package sudakova.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sudakova.onlineshop.dto.request.CategoryRequest;
import sudakova.onlineshop.dto.response.CategoryResponse;
import sudakova.onlineshop.dto.response.DataResponse;
import sudakova.onlineshop.service.CategoryService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    @GetMapping
//    public DataResponse<ProductResponse> getAll(@RequestParam Integer page, @RequestParam Integer size,
//                                                @RequestParam String sortBy, @RequestParam Sort.Direction direction,
//                                                @RequestParam(required = false) String name) {
//        return productService.getAllProducts(page, size, sortBy, direction, name);
//    }
//
    @GetMapping("/all")
    public DataResponse<CategoryResponse> getAll() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public CategoryResponse save(@RequestBody @Valid CategoryRequest categoryRequest) {
        return categoryService.save(categoryRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
        categoryService.update(id, categoryRequest);
    }

    @DeleteMapping
    public boolean delete(@RequestParam Long id) {
        return categoryService.delete(id);
    }
}
