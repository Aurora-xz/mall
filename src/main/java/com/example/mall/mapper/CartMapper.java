package com.example.mall.mapper;

import com.example.mall.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {


    List<Integer> getProductIdsByUserId(@Param("userId") Integer userId);

    void insertCart(@Param("userId") Integer userId, @Param("PId") Integer pId);

    Cart findByUIdAndPId(@Param("UId") Integer userId, @Param("PId") Integer pId);

    void deleteByTwoId(@Param("UId") Integer userId, @Param("PId") Integer pid);
}
