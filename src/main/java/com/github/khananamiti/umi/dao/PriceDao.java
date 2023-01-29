package com.github.khananamiti.umi.dao;

import java.math.BigDecimal;

public interface PriceDao {
    BigDecimal resolvePrice(Integer fromCityId, Integer toCityId);
}
