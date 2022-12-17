package ru.bvkuchin.hw4springjs.hw4springjs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bvkuchin.hw4springjs.hw4springjs.models.Product;
import ru.bvkuchin.hw4springjs.hw4springjs.repositories.ProductDao;

import java.util.List;

@Service
public class ProductService {

    private ProductDao repository;

    @Autowired
    public void setRepository(ProductDao repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        return repository.getProducts();
    }

    public void changeQuantity(Integer id, Integer delta) {
        Product product = repository.getProductByID(id);
        if (!((product.getQuantity() < 2) && (delta < 0))) {
            product.setQuantity(product.getQuantity() + delta);
        }
    }

    public void deleteProduct(Integer id) {
        repository.deleteProduct(id);
    }
}
