package com.ylf.config.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * @author Administrator
 */
@Slf4j
@Aspect
@Component
public class DataSourceAop {

    @Before("execution(* com.ylf.mapper..*.select*(..)) " +
            "|| execution(* com.ylf.mapper..*.query*(..))" +
            "|| execution(* com.ylf.mapper..*.find*(..))" +
            "|| execution(* com.ylf.mapper..*.get*(..))" +
            "|| execution(* com.ylf.mapper..*.count*(..))"
    )
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        log.debug("dataSource switch -> Read");
    }

    @Before("execution(* com.ylf.mapper..*.insert*(..)) " +
            "|| execution(* com.ylf.mapper..*.update*(..)) " +
            "|| execution(* com.ylf.mapper..*.save*(..)) " +
            "|| execution(* com.ylf.mapper..*.delete*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        log.debug("dataSource switch -> write");
    }
}
