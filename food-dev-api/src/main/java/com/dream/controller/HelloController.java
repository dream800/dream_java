package com.dream.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-03
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return  "hello";
    }

}
