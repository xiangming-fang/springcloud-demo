package com.example.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @InterfaceName: FeignService
 * @Description: description of interface
 * @Author: Albert
 * @CreateDate: 2020/1/16 14:28
 */
@Service
@FeignClient("RIBBON-CONSUMER") // 指定注册服务的名字
public interface FeignService {

    @RequestMapping(method = RequestMethod.GET,value = "/hello01") // 指定的注册服务下的方法
    String hello();

    @RequestMapping(method = RequestMethod.GET,value = "/hello02") // 指定的注册服务下的方法
    String sayHi();
}
