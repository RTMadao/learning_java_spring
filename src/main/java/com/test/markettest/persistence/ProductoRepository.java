package com.test.markettest.persistence;

import com.test.markettest.domain.Product;
import com.test.markettest.domain.repository.ProductRepository;
import com.test.markettest.persistence.crud.ProductoCrudRepository;
import com.test.markettest.persistence.entity.Producto;
import com.test.markettest.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int idCategoria) {
        List<Producto> productos = productoCrudRepository.findByIdCategoria(idCategoria);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getByCategoryOrder(int idCategoria) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        return Optional.of(mapper.toProducts(productos));
    }


    @Override
    public Optional<List<Product>> getScarseProducts(int quentity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quentity,true);
        return productos.map(prod -> mapper.toProducts(prod));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(productoCrudRepository.save(mapper.toProducto(product)));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
