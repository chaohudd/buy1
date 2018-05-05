package com.buy.core.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller Demo
 *
 * @author: zhengkai
 * @create: 2018-05-05
 **/
@Controller
public class DemoController {
    @RequestMapping(value = "/demo",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> demoController() {
        Map<String, Object> map = new HashMap<>();
        map.put("desc", "this is a demo");
        map.put("component", Arrays.asList("Spring", "SpringMVC", "MyBatis"));
        return map;
    }
//
//    @RequestMapping(value = "/demo/array",produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public String[] acceptBrowserName(String[] name) {
//        return name;
//    }
//
//    // If you want to set headers for every response for a controller you can use @ModelAttribute annotation.
//    @ModelAttribute
//    public void setVaryResponseHeader(HttpServletResponse response) {
//        response.setHeader("Vary", "Accept");
//    }
}
