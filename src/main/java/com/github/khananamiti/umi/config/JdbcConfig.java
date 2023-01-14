package com.github.khananamiti.umi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    private static final String JDBC_URL = "jdbc:sqlite:umi_db.sqlite3";

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        final SQLiteConfig config = new SQLiteConfig();
        config.setEncoding(SQLiteConfig.Encoding.UTF8);
        config.setReadOnly(false);
        final SQLiteDataSource sqLiteDataSource = new SQLiteDataSource(config);
        sqLiteDataSource.setUrl(JDBC_URL);
        return sqLiteDataSource;
    }
}
