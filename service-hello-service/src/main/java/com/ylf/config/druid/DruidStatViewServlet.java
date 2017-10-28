package com.ylf.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author Administrator
 *
 * 请求的url  是  /druid/*  自动加载  initParams 定义的参数
 *
 * 1、@WebServlet
 *   1>、根据配置中的url-pattern来访问内置监控页面，如果是下边的配置，内置监控页面的首页是/druid/index.html
 *   2>、StatViewSerlvet展示出来的监控信息比较敏感，是系统运行的内部情况，如果你需要做访问控制，可以配置allow和deny这两个参数
 *   3>在StatViewSerlvet输出的html页面中，有一个功能是Reset All，执行这个操作之后，会导致所有计数器清零，重新计数。你可以通过配置参数关闭它
 * 2、Druid内置提供了一个StatViewServlet用于展示Druid的统计信息。
 * 这个StatViewServlet的用途包括：
 * 提供监控信息展示的html页面
 * 提供监控信息的JSON API
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
//                @WebInitParam(name="allow",value="192.168.4.66,127.0.0.1"),// IP白名单 (没有配置或者为空，则允许所有访问)
//                @WebInitParam(name="deny",value="192.168.4.66"),// IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name = "loginUsername", value = "admin"),// 用户名
                @WebInitParam(name = "loginPassword", value = "admin123"),// 密码
                @WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet extends StatViewServlet {

}
