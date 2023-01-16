package com.github.khananamiti.umi.service.impl;

import com.github.khananamiti.umi.dao.ProductDao;
import com.github.khananamiti.umi.service.ProductService;
import com.github.khananamiti.umi.service.dto.ProductDto;
import com.github.khananamiti.umi.service.mapper.ProductDtoMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.ListUtils;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final ProductDtoMapper productDtoMapper;

    @Override
    public List<List<ProductDto>> productGroups() {
        final List<ProductDto> productEntities = productDao.allProducts().stream()
            .map(productDtoMapper::toProductDto)
            .toList();
        if (productEntities.isEmpty()) {
            return Collections.emptyList();
        } else {
            return ListUtils.partition(productEntities, 3);
        }
    }
}
