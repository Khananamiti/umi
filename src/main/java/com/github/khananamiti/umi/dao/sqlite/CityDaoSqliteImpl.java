package com.github.khananamiti.umi.dao.sqlite;

import com.github.khananamiti.umi.dao.CityDao;
import com.github.khananamiti.umi.dao.entity.CityEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.locks.Lock;

@RequiredArgsConstructor
public class CityDaoSqliteImpl extends AbstractSqliteDao implements CityDao {
    private final CityDao cityDao;

    @Override
    public List<CityEntity> allCities() {
        final Lock readLock = LOCK.readLock();
        readLock.lock();
        try {
            return cityDao.allCities();
        } finally {
            readLock.unlock();
        }
    }
}
