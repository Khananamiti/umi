package com.github.khananamiti.umi.dao.sqlite;

import com.github.khananamiti.umi.dao.PriceDao;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;

@RequiredArgsConstructor
public class PriceDaoSqliteImpl extends AbstractSqliteDao implements PriceDao {
    private final PriceDao priceDao;

    @Override
    public BigDecimal resolvePrice(Integer fromCityId, Integer toCityId) {
        final Lock readLock = LOCK.readLock();
        readLock.lock();
        try {
            return priceDao.resolvePrice(fromCityId, toCityId);
        } finally {
            readLock.unlock();
        }
    }
}
