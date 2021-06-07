package com.test.markettest.domain.repository;

import com.test.markettest.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository  {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoriaId);
    Optional<List<Product>> getByCategoryOrder(int categoriaId);
    Optional<List<Product>> getScarseProducts(int quentity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
