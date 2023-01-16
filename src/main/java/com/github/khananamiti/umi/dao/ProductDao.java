package com.github.khananamiti.umi.dao;

import com.github.khananamiti.umi.dao.entity.ProductEntity;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> allProducts();
}
