package ru.bvkuchin.hw4springjs.hw4springjs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bvkuchin.hw4springjs.hw4springjs.models.Product;
import ru.bvkuchin.hw4springjs.hw4springjs.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public void changeQuantity(Integer id, Integer delta) {
        Product product = productRepository.getProductByID(id);
        if (!((product.getQuantity() < 2) && (delta < 0))) {
            product.setQuantity(product.getQuantity() + delta);
        }
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteProduct(id);
    }
}
