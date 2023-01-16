package com.github.khananamiti.umi.service.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String imageSource;
    private String imageName;
    private String name;
    private String price;
}
