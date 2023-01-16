package com.github.khananamiti.umi.dao.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ProductEntity {
    private final Long id;
    private String imageSource;
    private String imageName;
    private String name;
    private BigDecimal price;
}
