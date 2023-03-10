package com.github.khananamiti.umi.config;

import com.github.khananamiti.umi.dao.ProductDao;
import com.github.khananamiti.umi.dao.UserDao;
import com.github.khananamiti.umi.dao.impl.ProductDaoImpl;
import com.github.khananamiti.umi.dao.impl.UserDaoImpl;
import com.github.khananamiti.umi.dao.sqlite.ProductDaoSqliteImpl;
import com.github.khananamiti.umi.dao.sqlite.UserDaoSqliteImpl;
import com.github.khananamiti.umi.service.ProductService;
import com.github.khananamiti.umi.service.UserService;
import com.github.khananamiti.umi.service.impl.ProductServiceImpl;
import com.github.khananamiti.umi.service.impl.UserServiceImpl;
import com.github.khananamiti.umi.service.mapper.ProductDtoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UmiApplicationConfig {

    @Bean
    public UserService userService(UserDao userDao) {
        return new UserServiceImpl(userDao);
    }

    @Bean
    public UserDao userDao(JdbcTemplate jdbcTemplate) {
        return new UserDaoSqliteImpl(new UserDaoImpl(jdbcTemplate));
    }

    @Bean
    public ProductService productService(ProductDao productDao, ProductDtoMapper productDtoMapper) {
        return new ProductServiceImpl(productDao, productDtoMapper);
    }

    @Bean
    public ProductDao productDao(JdbcTemplate jdbcTemplate) {
        return new ProductDaoSqliteImpl(new ProductDaoImpl(jdbcTemplate));
    }

    @Bean
    public ProductDtoMapper productDtoMapper() {
        return Mappers.getMapper(ProductDtoMapper.class);
    }
}
