package com.ylf.config.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    private final int readDataSourceSize;
    private AtomicInteger count = new AtomicInteger(0);

    public DynamicDataSource(int readDataSourceSize) {
        this.readDataSourceSize = readDataSourceSize;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceContextHolder.getJdbcType();
        if (typeKey.equals(DataSourceType.write.getType())) {
            return DataSourceType.write.getType();
        }
        // 读,简单轮询负载均衡
        int number = count.getAndAdd(1);
        int lookupKey = number % readDataSourceSize;
        log.debug("readDataSource " + lookupKey + " use.");
        return new Integer(lookupKey);
    }
}
