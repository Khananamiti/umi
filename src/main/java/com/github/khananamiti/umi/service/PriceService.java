package com.github.khananamiti.umi.service;

import com.github.khananamiti.umi.api.dto.ResolvePriceRequest;

import java.math.BigDecimal;

public interface PriceService {

    BigDecimal resolvePrice(ResolvePriceRequest resolvePriceRequest);
}
