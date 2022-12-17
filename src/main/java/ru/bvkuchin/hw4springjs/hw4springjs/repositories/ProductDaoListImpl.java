package ru.bvkuchin.hw4springjs.hw4springjs.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hw4springjs.hw4springjs.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductDaoListImpl implements ProductDao{
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1, "Шорты", 68.35d),
                new Product(2, "Носки", 15.5d),
                new Product(3, "Джинсы", 100d),
                new Product(4, "Куртка", 150.65d),
                new Product(5, "Шапка", 50.5d)
        ));

    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductByID(Integer id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());
    }

    public void deleteProduct(Integer id) {
        System.out.println(id);
        products.removeIf(p -> p.getId().equals(id));
    }
}
