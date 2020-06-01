package com.example.euraka_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: Hello
 * @Description: description of class
 * @Author: Albert
 * @CreateDate: 2020/1/15 14:25
 */

@Controller
public class Hello {

    @RequestMapping(value = "/printHello")
    @ResponseBody
    public String printHello(){
        return "郭哥是现在最帅的吗？";
    }

    @RequestMapping(value = "/printHi")
    @ResponseBody
    public String printHi(){
        return "不,郭哥是从古至今最帅的男淫";
    }
}
