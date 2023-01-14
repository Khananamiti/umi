package com.github.khananamiti.umi.dao;

import com.github.khananamiti.umi.dao.entity.UserEntity;

import java.util.Optional;

public interface UserDao {
    Optional<UserEntity> findUserByLogin(String login);
}
