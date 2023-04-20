package org.example.user.component.kgMybatis;
/*
author : Kigooo
verson : 0.0.3
update date : 2022-02-14
*/

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class KgDataSourceConfig {

    /**
     * 数据源 kgds1
     */
    @Primary
    @Bean(name = "kgds1")
    @ConfigurationProperties(prefix = "spring.datasource.kgds1")
    public DataSource kgds1(){
        return DataSourceBuilder.create().build();
    }
}
