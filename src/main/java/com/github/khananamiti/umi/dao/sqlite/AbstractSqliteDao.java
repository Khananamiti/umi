package com.github.khananamiti.umi.dao.sqlite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * SQLite БД является не потокобезопасной, потому необходимо соблюдать ограничения на сихронизацию:
 * - Может быть только одна write операция одновременно
 * - Может быть множество read операций одновременно
 * - read и write операции не могут быть одновременно
 * <p>
 * В классах наследниках следует использовать общий LOCK
 */
public abstract class AbstractSqliteDao {
    protected static final ReadWriteLock LOCK = new ReentrantReadWriteLock();
}
