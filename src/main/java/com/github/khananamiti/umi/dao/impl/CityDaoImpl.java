package com.github.khananamiti.umi.dao.impl;

import com.github.khananamiti.umi.dao.CityDao;
import com.github.khananamiti.umi.dao.entity.CityEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RequiredArgsConstructor
public class CityDaoImpl implements CityDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<CityEntity> allCities() {
        return jdbcTemplate.query("select * from dict_cities",
                (resultSet, rowNum) -> new CityEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name")));
    }
}
