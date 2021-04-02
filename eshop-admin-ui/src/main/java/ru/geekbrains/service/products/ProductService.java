package ru.geekbrains.controller.DTO.products;

import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDTO> showAllProducts();

    Optional<ProductDTO> findProductById (Long id);

    void saveProduct (ProductDTO productDTO) throws IOException;

    void deleteProductById (Long id);

    Page<ProductDTO> findWithFilter(String productTitleFilter,
                                    Integer minPriceFiler,
                                    Integer maxPriceFilter,
                                    Integer pageNumber,
                                    Integer tableSize,
                                    String sort);

}
