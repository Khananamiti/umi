package com.github.khananamiti.umi.dao.sqlite;

import com.github.khananamiti.umi.dao.UserDao;
import com.github.khananamiti.umi.dao.entity.UserEntity;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.concurrent.locks.Lock;

@RequiredArgsConstructor
public class UserDaoSqliteImpl extends AbstractSqliteDao implements UserDao {
    private final UserDao userDao;

    @Override
    public Optional<UserEntity> findUserByLogin(String login) {
        final Lock readLock = LOCK.readLock();
        readLock.lock();
        try {
            return userDao.findUserByLogin(login);
        } finally {
            readLock.unlock();
        }
    }
}
