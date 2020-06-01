package com.example.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: RibbonController
 * @Description: description of class
 * @Author: Albert
 * @CreateDate: 2020/1/16 10:53
 */
@Controller
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${hello.service-url-one}")
    private String service_url_one;

    /**
     * 非负载均衡请求,不需要在启动类里加 @LoadBalance
     * @return
     */
    @GetMapping("/hello01")
    @ResponseBody
    public String hello01(){
        System.out.println(service_url_one);
        return restTemplate.getForObject(service_url_one, String.class);
    }

    /**
     * 负载均衡请求 EURAKA-CLIENT 服务在Eureka上注册的名字
     * @return
     */
    @GetMapping("/hello02")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "isError")
    public String hello02(){
        // 当访问http://euraka-client/printHi接口时候，该接口已经关闭了那么就不会继续访问，而是走断路器指定的isError方法
        return restTemplate.getForObject("http://euraka-client/printHi", String.class);
    }


    public String isError(){
        return "@HystrixCommand该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法";
    }
}
