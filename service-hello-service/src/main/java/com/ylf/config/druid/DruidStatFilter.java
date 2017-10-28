package com.ylf.config.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author Administrator
 *
 *    1、@WebFilter将一个实现了javax.servlet.Filte接口的类定义为过滤器组件
 *        属性filterName声明过滤器的名称,可选；
 *        属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 *        属性 exclusions  要排除监控的url
 *    2、Druid内置提供了一个功能强大的StatFilter插件，能够详细统计SQL的执行性能，这对于线上分析数据库访问性能有帮助
 *        WebStatFilter用于采集web-jdbc关联监控的数据。
 *
 *
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        })
public class DruidStatFilter extends WebStatFilter {



}
