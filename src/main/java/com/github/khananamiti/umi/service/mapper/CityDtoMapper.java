package com.github.khananamiti.umi.service.mapper;

import com.github.khananamiti.umi.dao.entity.CityEntity;
import com.github.khananamiti.umi.service.dto.CityDto;
import org.mapstruct.Mapper;

@Mapper
public interface CityDtoMapper {

    CityDto toCityDto(CityEntity cityEntity);
}
