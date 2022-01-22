package com.deniswen.spark22client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author deniswen
 * @date 2022/1/22 15:13
 * @description controller层
 */
@RestController
public class Spark22Controller {

    @PostMapping("/test")
    public Map<String,Object> test(){

        Map<String,Object> result = new HashMap<>();

        result.put("status","ok");
        result.put("code","200");
        return result;
    }
}
