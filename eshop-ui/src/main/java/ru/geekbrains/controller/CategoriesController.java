package ru.geekbrains.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.service.PictureService;
import ru.geekbrains.service.products.ProductService;

@Controller
@RequestMapping
public class CategoriesController {

    private final ProductService productService;
    private final PictureService pictureService;

    public CategoriesController(ProductService productService, PictureService pictureService) {
        this.productService = productService;
        this.pictureService = pictureService;
    }



    @GetMapping("/categories")
    public String indexPage(Model model) {
        model.addAttribute("activePage", "Products");
        model.addAttribute("products", productService.showAllProducts());
        model.addAttribute("product1", productService.findProductById((long) 4));
        model.addAttribute("product2", productService.findProductById((long) 24));
        model.addAttribute("product3", productService.findProductById((long) 25));
        model.addAttribute("product4", productService.findProductById((long) 26));
        model.addAttribute("product5", productService.findProductById((long) 27));
        model.addAttribute("product6", productService.findProductById((long) 28));
        model.addAttribute("picture1", pictureService.getPictureDataById(1));
        model.addAttribute("picture2", pictureService.getPictureDataById(2));
        model.addAttribute("picture3", pictureService.getPictureDataById(3));
        model.addAttribute("picture4", pictureService.getPictureDataById(4));
        model.addAttribute("picture5", pictureService.getPictureDataById(5));
        model.addAttribute("picture6", pictureService.getPictureDataById(6));
        return "shop-sidebar";
    }
}


