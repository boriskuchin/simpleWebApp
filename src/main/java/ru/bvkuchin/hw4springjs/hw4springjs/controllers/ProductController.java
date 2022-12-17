package ru.bvkuchin.hw4springjs.hw4springjs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bvkuchin.hw4springjs.hw4springjs.models.Product;
import ru.bvkuchin.hw4springjs.hw4springjs.services.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/change_quantity")
    public void changeQuantity(@RequestParam Integer id, @RequestParam Integer delta) {
        productService.changeQuantity(id, delta);
    }

    @GetMapping("/products/delete")
    public void deleteProduct(@RequestParam Integer id) {
        productService.deleteProduct(id);
    }


}
