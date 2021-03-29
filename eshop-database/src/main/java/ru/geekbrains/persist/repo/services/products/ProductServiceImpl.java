package ru.geekbrains.persist.repo.services.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.model.Product;
import ru.geekbrains.persist.repo.ProductRepository;
import ru.geekbrains.persist.repo.specification.ProductSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductRepr> showAllProducts() {
        return productRepository.findAll().stream().map(ProductRepr::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductRepr> findProductById(Long id) {
        return Optional.empty();
    }

    @Override
    public void saveProduct(ProductRepr productRepr) {

    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public Page<ProductRepr> findWithFilter(String productTitleFilter,
                                            Integer minPriceFilter,
                                            Integer maxPriceFilter,
                                            Integer pageNumber,
                                            Integer tableSize,
                                            String sort) {

        Specification <Product> spec = Specification.where(null);

        if (productTitleFilter != null && !productTitleFilter.isBlank()) {
            spec = spec.and(ProductSpecification.titleLike(productTitleFilter));
        }
        if (minPriceFilter != null) {
            spec = spec.and(ProductSpecification.minPrice(minPriceFilter));
        }
        if (maxPriceFilter != null) {
            spec = spec.and(ProductSpecification.maxPrice(maxPriceFilter));
        }
        if (sort == null) {
            return productRepository.findAll(spec, PageRequest.of(pageNumber, tableSize)).map(ProductRepr::new);

        } else if (sort.isEmpty()){
            return productRepository.findAll(spec, PageRequest.of(pageNumber, tableSize)).map(ProductRepr::new);
        } else {
            return productRepository.findAll(spec, PageRequest.of(pageNumber, tableSize, Sort.by(sort).ascending())).map(ProductRepr::new);
        }
    }


}
