package com.github.khananamiti.umi.dao.impl;

import com.github.khananamiti.umi.dao.PriceDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class PriceDaoImpl implements PriceDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public BigDecimal resolvePrice(Integer fromCityId, Integer toCityId) {
        return jdbcTemplate.query(
                connection -> connection.prepareStatement("""
                        select price
                        from prices
                        where (city_id_from = ? and city_id_to = ?)
                            or (city_id_from = ? and city_id_to = ?)
                        """),
                preparedStatement -> {
                    preparedStatement.setInt(1, fromCityId);
                    preparedStatement.setInt(2, toCityId);
                    preparedStatement.setInt(3, toCityId);
                    preparedStatement.setInt(4, fromCityId);
                },
                resultSet -> resultSet.getBigDecimal("price")
        );
    }
}
