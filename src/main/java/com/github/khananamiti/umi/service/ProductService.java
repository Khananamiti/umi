package com.github.khananamiti.umi.service;

import com.github.khananamiti.umi.service.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<List<ProductDto>> productGroups();
}
