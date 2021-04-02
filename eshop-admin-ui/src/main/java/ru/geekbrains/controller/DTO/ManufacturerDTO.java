package ru.geekbrains.controller.DTO.manufacturer;

import ru.geekbrains.persist.model.Manufacturer;
import ru.geekbrains.persist.model.Product;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ManufacturerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String title;

    private List<Product> products;

    public ManufacturerDTO() {
    }

    public ManufacturerDTO(@NotEmpty String title, List<Product> products) {
        this.title = title;
        this.products = products;
    }

    public ManufacturerDTO(Manufacturer manufacturer) {
        this.id = manufacturer.getId();
        this.title = manufacturer.getTitle();
        this.products = manufacturer.getProducts();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}