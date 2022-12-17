package ru.bvkuchin.hw4springjs.hw4springjs.repositories;

import org.h2.command.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hw4springjs.hw4springjs.models.Product;

import java.util.List;
import java.util.Queue;

@Component
public class ProductDaoImpl implements ProductDao {

    SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public void setSessionFactoryUtils(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Product> getProducts() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product getProductByID(Integer id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session
                    .createQuery("select p from Product p where p.id = :id", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    public void updateProductById(Integer id, Integer delta) {

        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session
                    .createQuery("select p from Product p where p.id = :id", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            product.setQuantity(product.getQuantity() + delta);

            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session
                    .createQuery("select p from Product p where p.id = :id",Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(product);
            session.getTransaction().commit();
        }

    }
}
