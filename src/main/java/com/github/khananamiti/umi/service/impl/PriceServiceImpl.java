package com.github.khananamiti.umi.service.impl;

import com.github.khananamiti.umi.api.dto.ResolvePriceRequest;
import com.github.khananamiti.umi.dao.PriceDao;
import com.github.khananamiti.umi.service.PriceService;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private static final BigDecimal INSIDE_CITY_STATIC_PRICE = BigDecimal.valueOf(500L);

    private final PriceDao priceDao;

    @Override
    public BigDecimal resolvePrice(ResolvePriceRequest resolvePriceRequest) {
        final Integer fromCityId = resolvePriceRequest.getFrom();
        final Integer toCityId = resolvePriceRequest.getTo();

        if (fromCityId.equals(toCityId)) {
            return INSIDE_CITY_STATIC_PRICE;
        } else {
            return priceDao.resolvePrice(fromCityId, toCityId);
        }
    }
}
