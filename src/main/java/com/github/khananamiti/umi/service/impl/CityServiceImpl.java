package com.github.khananamiti.umi.service.impl;

import com.github.khananamiti.umi.dao.CityDao;
import com.github.khananamiti.umi.service.CityService;
import com.github.khananamiti.umi.service.dto.CityDto;
import com.github.khananamiti.umi.service.mapper.CityDtoMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityDao cityDao;
    private final CityDtoMapper cityDtoMapper;

    @Override
    public List<CityDto> allCities() {
        return cityDao.allCities().stream()
                .map(cityDtoMapper::toCityDto)
                .toList();
    }
}
