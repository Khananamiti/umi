package com.github.khananamiti.umi.service.impl;

import com.github.khananamiti.umi.api.dto.AuthRequest;
import com.github.khananamiti.umi.dao.UserDao;
import com.github.khananamiti.umi.dao.entity.UserEntity;
import com.github.khananamiti.umi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public boolean checkAuthentication(AuthRequest authRequest) {
        if (StringUtils.isAnyBlank(authRequest.getLogin(), authRequest.getPassword())) {
            log.debug("Данные запроса на авторизацию не были переданы");
            return false;
        } else {
            return userDao.findUserByLogin(authRequest.getLogin())
                .map(UserEntity::getPassword)
                .filter(authRequest.getPassword()::equals)
                .isPresent();
        }
    }
}
