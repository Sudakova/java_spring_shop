package sudakova.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sudakova.onlineshop.dto.request.CategoryRequest;
import sudakova.onlineshop.dto.response.CategoryResponse;
import sudakova.onlineshop.entity.Category;
import sudakova.onlineshop.exception.WrongInputDataException;
import sudakova.onlineshop.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


//    public DataResponse<CategoryResponse> getAllCategories(Integer page, Integer size,
//                                                           String sortBy, Sort.Direction direction,
//                                                           String name) {
//        Sort sort = Sort.by(direction, sortBy);
//        PageRequest pageRequest = PageRequest.of(page, size, sort);
//        Page<Category> categoryPage;
//        if (name != null) {
//            categoryPage = categoryRepository.findAllByNameLike("%" + name + "%", pageRequest);
//        } else {
//            categoryPage = categoryRepository.findAll(pageRequest);
//        }
//        return new DataResponse<>(categoryPage.getContent().stream().map(CategoryResponse::new).collect(Collectors.toList()), categoryPage);
//    }

    public CategoryResponse getById(Long id) {
        return new CategoryResponse(getEntityObjectById(id));
    }

    public CategoryResponse save(CategoryRequest brandRequest) {
        Category category = new Category();
        category.setName(brandRequest.getName());
        return new CategoryResponse(categoryRepository.save(category));
    }


    public void update(Long id, CategoryRequest categoryRequest) {
        Category category = getEntityObjectById(id);
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
    }

    public boolean delete(Long id) {
        Category category = getEntityObjectById(id);
        if (category.getProducts().isEmpty()) {
            categoryRepository.delete(category);
            return true;
        } else {
            throw new WrongInputDataException("Category with id: " + id + " has some products.");
        }
    }

    private Category getEntityObjectById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Category with id: " + id + " not found."));
    }


}
