package ru.geekbrains.controller.DTO.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.geekbrains.errors.NotFoundException;
import ru.geekbrains.persist.model.Picture;
import ru.geekbrains.persist.model.Product;
import ru.geekbrains.persist.repo.ProductRepository;
import ru.geekbrains.persist.repo.specification.ProductSpecification;
import ru.geekbrains.controller.DTO.picture.PictureService;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService, Serializable {

    private final ProductRepository productRepository;
    private final PictureService pictureService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, PictureService pictureService) {
        this.productRepository = productRepository;
        this.pictureService = pictureService;
    }

    @Override
    public List<ProductDTO> showAllProducts() {
        return productRepository.findAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> findProductById(Long id) {
        return Optional.empty();
    }

    @Override
    public void saveProduct(ProductDTO productDTO) throws IOException {

        Product product = (productDTO.getId() != null) ? productRepository.findById(productDTO.getId())
                .orElseThrow(NotFoundException::new) : new Product();
//        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setManufacturer(productDTO.getManufacturer());
        product.setCategory(productDTO.getCategory());

        if (productDTO.getNewPictures() != null) {
            for (MultipartFile newPicture : productDTO.getNewPictures()) {
//                logger.info("Product {} file {} size {} contentType {}", productRepr.getId(),
//                        newPicture.getOriginalFilename(), newPicture.getSize(), newPicture.getContentType());

                if (product.getPictures() == null) {
                    product.setPictures(new ArrayList<>());
                }

                product.getPictures().add(new Picture(
                        newPicture.getOriginalFilename(),
                        newPicture.getContentType(),
                        pictureService.createPictureData(newPicture.getBytes()),
                        product
                ));
            }
        }

        productRepository.save(product);

    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProductDTO> findWithFilter(String productTitleFilter,
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
            return productRepository.findAll(spec, PageRequest.of(pageNumber, tableSize)).map(ProductDTO::new);

        } else if (sort.isEmpty()){
            return productRepository.findAll(spec, PageRequest.of(pageNumber, tableSize)).map(ProductDTO::new);
        } else {
            return productRepository.findAll(spec, PageRequest.of(pageNumber, tableSize, Sort.by(sort).ascending())).map(ProductDTO::new);
        }
    }


}
