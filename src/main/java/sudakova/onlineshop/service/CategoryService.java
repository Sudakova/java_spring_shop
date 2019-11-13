package sudakova.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import sudakova.onlineshop.entity.Category;

import java.util.stream.Collectors;


public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    public DataResponse<CategoryResponse> getAllCategories(Integer page, Integer size,
                                                    String sortBy, Sort.Direction direction,
                                                    String name) {
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Category> categoryPage;
        if (name != null) {
            categoryPage = categoryRepository.findAllByNameLike("%" + name + "%", pageRequest);
        } else {
            categoryPage = categoryRepository.findAll(pageRequest);
        }
        return new DataResponse<>(categoryPage.getContent().stream().map(CategoryResponse::new).collect(Collectors.toList()), categoryPage);
    }

    public CategoryResponse getById(Long id) {
        return new CategoryResponse(getEntityObjectById(id));
    }

    public void save(CategoryRequest brandRequest) {
        Category brand = new Category();
        category.setName(brandRequest.getName());
        categoryRepository.save( category);
    }


    public void update(Long id, CategoryRequest categoryRequest) {
        Category category = getEntityObjectById(id);
        category.setName( categoryRequest.getName());
        categoryRepository.save(category);
    }

    public void delete(Long id) {
        Category category = getEntityObjectById(id);
        if (category.getCategory().isEmpty()) {
            categoryRepository.delete(category);
        } else {
            throw new WrongInputDataException("Category with id: " + id + " has some products.");
        }
    }

    private Category getEntityObjectById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Category with id: " + id + " not found."));
    }


}
