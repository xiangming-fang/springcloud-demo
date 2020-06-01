package com.example.feign.controller;

import com.example.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: FeignController
 * @Description: description of class
 * @Author: Albert
 * @CreateDate: 2020/1/16 15:08
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/getHi")
    public String getHi(){
      return  feignService.sayHi();
    }
}
