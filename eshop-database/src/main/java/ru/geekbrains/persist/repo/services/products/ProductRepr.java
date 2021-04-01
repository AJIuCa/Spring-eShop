package ru.geekbrains.persist.repo.services.products;

import ru.geekbrains.persist.model.Product;

import javax.validation.constraints.NotEmpty;

public class ProductRepr {

    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String manufacturer;

    @NotEmpty
    private int price;

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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductRepr() {

    }

    public ProductRepr(String title, String manufacturer, int price) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public ProductRepr(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.manufacturer = product.getManufacturer();
        this.price = product.getPrice();
    }


}
