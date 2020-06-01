package com.example.feign.service;

import com.example.feign.config.FeignHystrixComponent;
import org.springframework.cloud.openfeign.FeignClient;
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
@FeignClient(value = "EURAKA-CLIENT",fallback = FeignHystrixComponent.class) // 指定注册服务的名字
public interface FeignTwoService {

    @RequestMapping(method = RequestMethod.GET,value = "/printHello") // 指定的注册服务下的方法
    String printHello();

    @RequestMapping(method = RequestMethod.GET,value = "/printHi") // 指定的注册服务下的方法
    String printHi();

}
