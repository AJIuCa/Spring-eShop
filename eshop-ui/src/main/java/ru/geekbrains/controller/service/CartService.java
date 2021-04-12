package ru.geekbrains.controller.service;

import ru.geekbrains.controller.DTO.ProductDTO;
import ru.geekbrains.controller.service.model.LineItem;

import java.util.List;

public interface CartService {

    void addProductQty(ProductDTO productDTO,int qty);

    void removeProductQty(ProductDTO productDTO,int qty);

    List<LineItem> getLineItems();
}
