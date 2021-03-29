package ru.geekbrains.persist.repo.services.products;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductRepr> showAllProducts();

    Optional<ProductRepr> findProductById (Long id);

    void saveProduct (ProductRepr productRepr);

    void deleteProductById (Long id);

    Page<ProductRepr> findWithFilter(String productTitleFilter,
                                     Integer minPriceFiler,
                                     Integer maxPriceFilter,
                                     Integer pageNumber,
                                     Integer tableSize,
                                     String sort);

}
