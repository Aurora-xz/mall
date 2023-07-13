package com.example.mall.service;

import com.example.mall.dao.ProductDao;
import com.example.mall.pojo.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public Product getProductById(Integer id) {
        return productDao.getProductById(id);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    public void deleteById(Integer id) {
        productDao.deleteById(id);
    }

    public List<Integer> getPIdsByUName(String username) {
        return productDao.getPIdsByUName(username);
    }

}
