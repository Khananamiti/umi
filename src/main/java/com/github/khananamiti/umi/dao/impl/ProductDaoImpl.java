package com.github.khananamiti.umi.dao.impl;

import com.github.khananamiti.umi.dao.ProductDao;
import com.github.khananamiti.umi.dao.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductEntity> allProducts() {
        return jdbcTemplate.query("select * from products",
            (resultSet, rowNum) ->
                ProductEntity.builder()
                    .id(resultSet.getLong("id"))
                    .imageSource(resultSet.getString("image_src"))
                    .imageName(resultSet.getString("image_name"))
                    .name(resultSet.getString("name"))
                    .price(resultSet.getBigDecimal("price"))
                    .build());
    }
}
