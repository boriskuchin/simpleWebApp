package ru.bvkuchin.hw4springjs.hw4springjs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bvkuchin.hw4springjs.hw4springjs.models.Product;
import ru.bvkuchin.hw4springjs.hw4springjs.repositories.ProductDao;
import ru.bvkuchin.hw4springjs.hw4springjs.repositories.ProductDaoImpl;
import ru.bvkuchin.hw4springjs.hw4springjs.repositories.ProductDaoListImpl;

import java.util.List;

@Service
public class ProductService {

    private ProductDao repository;

    @Autowired
    public void setRepository(ProductDaoImpl repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        return repository.getProducts();
    }

    public void changeQuantity(Integer id, Integer delta) {
        Product product = repository.getProductByID(id);
        if (!((product.getQuantity() < 1) && (delta < 0))) {
            repository.updateProductById(id, delta);
        }


    }

    public void deleteProduct(Integer id) {
        repository.deleteProduct(id);
    }
}
