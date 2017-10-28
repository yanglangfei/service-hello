package com.ylf.config.mybatis;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 */
@Slf4j
public class DataSourceContextHolder {
    private static final ThreadLocal<String> local = new ThreadLocal<>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    public static void read() {
        local.set(DataSourceType.read.getType());
    }

    public static void write() {
        local.set(DataSourceType.write.getType());
    }

    public static String getJdbcType() {
        return local.get();
    }
}
