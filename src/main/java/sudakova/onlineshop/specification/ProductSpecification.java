package sudakova.onlineshop.specification;

import org.springframework.data.jpa.domain.Specification;
import sudakova.onlineshop.dto.request.FilterProductRequest;
import sudakova.onlineshop.dto.request.OneFilterProductRequest;
import sudakova.onlineshop.entity.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification implements Specification<Product> {

    private FilterProductRequest filterProductRequest;

    public ProductSpecification(FilterProductRequest filterProductRequest) {
        this.filterProductRequest = filterProductRequest;
    }

    private Predicate filterBySize(Root<Product> root, CriteriaBuilder criteriaBuilder, OneFilterProductRequest oneFilterProductRequest) {
        return criteriaBuilder.equal(root.get("size"), oneFilterProductRequest.getFirstValue());
    }

    private Predicate filterByPrice(Root<Product> root, CriteriaBuilder criteriaBuilder, OneFilterProductRequest oneFilterProductRequest) {
        if (oneFilterProductRequest.getFirstValue() != null && oneFilterProductRequest.getSecondValue() != null) {
            return criteriaBuilder.between(root.get("price"), Double.parseDouble(oneFilterProductRequest.getFirstValue()),
                    Double.parseDouble(oneFilterProductRequest.getSecondValue()));
        } else {
            if (oneFilterProductRequest.getFirstValue() != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), Double.parseDouble(oneFilterProductRequest.getFirstValue()));
            } else {
                return criteriaBuilder.conjunction();
            }
        }
    }

    private Predicate createFilter(Root<Product> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        filterProductRequest.getOneFilterProductRequests().forEach(oneFilterProductRequest -> {
            switch (oneFilterProductRequest.getCriteriaForSearchProduct()) {
                case BY_SIZE: {
                    predicates.add(filterBySize(root, criteriaBuilder, oneFilterProductRequest));
                    break;
                }
                case BY_PRICE_LESS_THAN:
                case BY_PRICE_BETWEEN: {
                    predicates.add(filterByPrice(root, criteriaBuilder, oneFilterProductRequest));
                    break;
                }

            }
        });
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return createFilter(root, criteriaBuilder);
    }
}
