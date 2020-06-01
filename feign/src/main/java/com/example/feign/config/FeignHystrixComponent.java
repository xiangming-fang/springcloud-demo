package com.example.feign.config;

import com.example.feign.service.FeignTwoService;
import org.springframework.stereotype.Component;

/**
 * @ClassName: FeignHystrixComponent
 * @Description: feign 中的 Hystrix,访问不到指定服务走的方法
 * @Author: Albert
 * @CreateDate: 2020/1/16 16:55
 */
@Component
public class FeignHystrixComponent implements FeignTwoService {
    @Override
    public String printHello() {
        return "feign中自带hystrix，但是默认是没有开启的，这个方法是feign访问不到服务的时候所走的。现在所访问的是Hello接口出问题后的方法";
    }

    @Override
    public String printHi() {
        return "feign中自带hystrix，但是默认是没有开启的，这个方法是feign访问不到服务的时候所走的。现在所访问的是Hi接口出问题后的方法";
    }

}
