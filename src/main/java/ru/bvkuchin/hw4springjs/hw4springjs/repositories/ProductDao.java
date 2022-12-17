package ru.bvkuchin.hw4springjs.hw4springjs.repositories;

import ru.bvkuchin.hw4springjs.hw4springjs.models.Product;

import java.util.Collections;
import java.util.List;

public interface ProductDao {
    public List<Product> getProducts();


    public Product getProductByID(Integer id);

    public void deleteProduct(Integer id);

}

