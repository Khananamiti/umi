package com.github.khananamiti.umi.service.mapper;

import com.github.khananamiti.umi.dao.entity.ProductEntity;
import com.github.khananamiti.umi.service.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductDtoMapper {
    ProductDto toProductDto(ProductEntity productEntity);
}
