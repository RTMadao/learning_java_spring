package com.test.markettest.domain.service;

import com.test.markettest.domain.Product;
import com.test.markettest.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return  productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoriaId) {
        return productRepository.getByCategory(categoriaId).filter(purchases -> !purchases.isEmpty());
    }

    public Optional<List<Product>> getByCategoryOrder(int categoriaId) {
        return  productRepository.getByCategoryOrder(categoriaId).filter(purchases -> !purchases.isEmpty());
    }

    public Optional<List<Product>> getScarseProducts(int quentity) {
        return productRepository.getScarseProducts(quentity);
    }

    public Product save(Product product) {
        return  productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
