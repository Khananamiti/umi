package com.github.khananamiti.umi.config;

import com.github.khananamiti.umi.dao.UserDao;
import com.github.khananamiti.umi.dao.impl.UserDaoImpl;
import com.github.khananamiti.umi.dao.sqlite.UserDaoSqliteImpl;
import com.github.khananamiti.umi.service.UserService;
import com.github.khananamiti.umi.service.impl.UserServiceImpl;
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
}
