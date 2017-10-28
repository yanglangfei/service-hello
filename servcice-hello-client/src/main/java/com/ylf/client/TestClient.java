package com.ylf.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author YangLF
 * @Date 2017/10/28
 */
@FeignClient(name = "service-hello")
public interface TestClient {


    /**
     *  sayHello
     * @param name
     * @return
     */
    @RequestMapping("/hello")
    String sayHello(@RequestParam("name") String name);

}
