package com.ylf.config.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Slf4j
@Configuration
public class DataSourceConfig {

    @Value("${define.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    /**
     * 主数据源
     * @return
     */
    @Bean(name = "writeDataSource", destroyMethod = "close", initMethod="init")
    @Primary
    @ConfigurationProperties(prefix = "define.datasource.write")
    public DataSource writeDataSource() {
        log.debug("-----------------------writeDataSource init.-----------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * 从数据源1
     * @return
     */
    @Bean(name = "readDataSource1")
    @ConfigurationProperties(prefix = "define.datasource.read1")
    public DataSource readDataSource1() {
        log.debug("-----------------------readDataSource 1 init.-----------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

//    /**
//     * 从数据源2
//     * @return
//     */
//    @Bean(name = "readDataSource2")
//    @ConfigurationProperties(prefix = "define.datasource.read2")
//    public DataSource readDataSource2() {
//        log.debug("-----------------------readDataSource 2 init.-----------------------");
//        return DataSourceBuilder.create().type(dataSourceType).build();
//    }

    @Bean(name = "readDataSources")
    public List<DataSource> readDataSources() {
        List<DataSource> dataSources = new ArrayList<>();
        dataSources.add(readDataSource1());
//        dataSources.add(readDataSource2());
        return dataSources;
    }

}
