package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.persist.repo.services.products.ProductDTO;
import ru.geekbrains.persist.repo.services.products.ProductService;


import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String usersPage(Model model,
                            @RequestParam("productTitleFilter") Optional<String> productTitleFilter,
                            @RequestParam("minPriceFilter") Optional<Integer> minPriceFilter,
                            @RequestParam("maxPriceFilter") Optional<Integer> maxPriceFilter,
                            @RequestParam("pageNumber") Optional<Integer> pageNumber,
                            @RequestParam("tableSize") Optional<Integer> tableSize,
                            @RequestParam("sort") Optional<String> sortBy) {

        Page<ProductDTO> products = productService.findWithFilter(
                productTitleFilter.orElse(null),
                minPriceFilter.orElse(null),
                maxPriceFilter.orElse(null),
                pageNumber.orElse(1) - 1,
                tableSize.orElse(5),
                sortBy.orElse(null)
        );

        model.addAttribute("products", products);
        return "products";
    }

}
