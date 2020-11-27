package com.codegym.repository.implement;

import com.codegym.model.Product;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> getAllProduct() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from products p", Product.class);
        return typedQuery.getResultList();
    }



    @Override
    public Product selectProductById(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void saveProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if(product.getId() != null) {
            BaseRepository.entityManager.merge(product);
        } else {
            BaseRepository.entityManager.persist(product);
        }
        entityTransaction.commit();
    }

    @Override
    public void deleteProduct(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(id);
    }

    @Override
    public List<Product> searchProductName(String name) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from products p where p.name like :name", Product.class);
        typedQuery.setParameter("name", name);
        return typedQuery.getResultList();
    }
}
