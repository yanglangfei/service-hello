package com.ylf.config.mybatis;


import lombok.Getter;
/**
 * @author Administrator
 */

public enum DataSourceType {
    read("read", "从库"), write("write", "主库");

    @Getter
    private String type;
    @Getter
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

}
