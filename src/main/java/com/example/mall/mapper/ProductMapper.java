package com.example.mall.mapper;

import com.example.mall.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> getAllProducts();

    void insertProduct(Product product);

    Product selectProductById(@Param("id") Integer id);

    void updateProduct(Product product);

    void deleteById(@Param("id") Integer id);

    BigDecimal getPriceById(@Param("id") Integer pId);

    void reduceStock(@Param("id") Integer pId);

    List<Integer> getPIdsByUName(@Param("username") String username);
}
