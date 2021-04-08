package ru.geekbrains.persist.repo.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.persist.model.Product;

public class ProductSpecification {

    public static Specification<Product> titleLike(String title) {
        return (root, query, cb) -> cb.like(root.get("title"),  title);
    }

    public static Specification<Product> minPrice(Integer minPrice) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> maxPrice(Integer maxPrice) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("price"), maxPrice);
    }


}