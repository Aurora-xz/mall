package com.example.mall.dao;

import com.example.mall.mapper.ProductMapper;
import com.example.mall.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    public void addProduct(Product product) {
        productMapper.insertProduct(product);
    }

    public Product getProductById(Integer id) {
        return productMapper.selectProductById(id);
    }

    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    public void deleteById(Integer id) {
        productMapper.deleteById(id);
    }

    public BigDecimal getPriceById(Integer pId) {
        return productMapper.getPriceById(pId);
    }

    public void reduceStock(Integer pId) {
        productMapper.reduceStock(pId);
    }

    public List<Integer> getPIdsByUName(String username) {
        return productMapper.getPIdsByUName(username);
    }
}
