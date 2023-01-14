package com.github.khananamiti.umi.dao.impl;

import com.github.khananamiti.umi.dao.UserDao;
import com.github.khananamiti.umi.dao.entity.UserEntity;
import com.github.khananamiti.umi.dao.sqlite.AbstractSqliteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

@RequiredArgsConstructor
public class UserDaoImpl extends AbstractSqliteDao implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<UserEntity> findUserByLogin(String login) {
        return jdbcTemplate.query(
            connection -> connection.prepareStatement("select * from users where login = ?"),
            preparedStatement -> preparedStatement.setString(1, login),
            resultSet -> {
                if (resultSet.next()) {
                    final UserEntity userEntity = UserEntity.builder()
                        .id(resultSet.getLong("id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .login(resultSet.getString("login"))
                        .email(resultSet.getString("email"))
                        .password(resultSet.getString("password"))
                        .build();
                    return Optional.of(userEntity);
                } else {
                    return Optional.empty();
                }
            }
        );
    }
}
