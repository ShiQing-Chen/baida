package com.baida.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * @Description //TODO RESTful接口 api
 * @author ShiQing_Chen
 * @date 2018/11/13 22:10
 */

@EnableAutoConfiguration //加上后dao不会报错
@Controller
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    /**
     *
     * RESTful接口
     *
     */

    /**
     * Get 1/List
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView helloSpringBootGet(Model model){
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("ff", "欢迎进入HTML页面");
        return modelAndView;
    }

//    /**
//     * Update
//     * @return
//     */
//    @RequestMapping(value = "/api",method = RequestMethod.PUT)
//    public String helloSpringBootPut(){
//        return "Hello SpringBootPUT!";
//    }
//
//    /**
//     * Creat
//     * @return
//     */
//    @RequestMapping(value = "/api",method = RequestMethod.POST)
//    public String helloSpringBootPost(){
//        return "Hello SpringBootPOST!";
//    }
//
//
//    /**
//     * Delete
//     * @return
//     */
//    @RequestMapping(value = "/api",method = RequestMethod.DELETE)
//    public String helloSpringBootDelete(){
//        return "Hello SpringBootDELETE!";
//    }
}
