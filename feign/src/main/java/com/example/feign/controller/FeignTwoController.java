package com.example.feign.controller;

import com.example.feign.service.FeignService;
import com.example.feign.service.FeignTwoService;
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
public class FeignTwoController {

    @Autowired
    private FeignTwoService feignTwoService;

    @RequestMapping(value = "/obtainHi")
    public String obtainHi(){
      return  feignTwoService.printHi();
    }

    @RequestMapping(value = "/obtainHello")
    public String obtainHello(){
        return  feignTwoService.printHello();
    }
}
