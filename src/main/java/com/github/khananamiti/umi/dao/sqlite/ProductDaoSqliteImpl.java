package com.github.khananamiti.umi.dao.sqlite;

import com.github.khananamiti.umi.dao.ProductDao;
import com.github.khananamiti.umi.dao.entity.ProductEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.locks.Lock;

@RequiredArgsConstructor
public class ProductDaoSqliteImpl extends AbstractSqliteDao implements ProductDao {
    private final ProductDao productDao;

    @Override
    public List<ProductEntity> allProducts() {
        final Lock readLock = LOCK.readLock();
        readLock.lock();
        try {
            return productDao.allProducts();
        } finally {
            readLock.unlock();
        }
    }
}
