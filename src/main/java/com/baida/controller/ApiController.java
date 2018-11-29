package com.baida.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;


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
    public String helloSpringBootGet(ModelMap modelMap, HttpServletRequest request){
        logger.debug(request.getRequestURL().toString());
        modelMap.addAttribute("name","helllo");
        ModelAndView modelAndView = new ModelAndView("index");

        //判断为pc或mobil
        return "pc/login";
    }

    @RequestMapping(value = "/pc/login")
    public String helloSpringBootGeta(ModelMap modelMap){
        modelMap.addAttribute("name","helllo");
        ModelAndView modelAndView = new ModelAndView("pc/login");

        //判断为pc或mobil
        return "login";
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
    /**
     * Creat
     * @return
     */
    @RequestMapping(value = "/pc/index",method = RequestMethod.POST)
    public String helloSpringBootPost(){

        return "pc/index";
    }

    @RequestMapping(value = "/pc/index",method = RequestMethod.GET)
    public String helloSpringBootH(){

        return "pc/index";
    }
    @RequestMapping(value = "/pc/shop",method = RequestMethod.GET)
    public String helloSpringBoots(){

        return "pc/table_shop";
    }
    @RequestMapping(value = "/pc/user",method = RequestMethod.GET)
    public String helloSpringBootu(){

        return "pc/table_user";
    }
    @RequestMapping(value = "/pc/address",method = RequestMethod.GET)
    public String helloSpringBoota(){

        return "pc/table_address";
    }
    @RequestMapping(value = "/pc/goods",method = RequestMethod.GET)
    public String helloSpringBootg(){

        return "pc/table_goods";
    }
    @RequestMapping(value = "/pc/activity",method = RequestMethod.GET)
    public String helloSpringBooty(){

        return "pc/table_activity";
    }

    @RequestMapping(value = "/pc/order",method = RequestMethod.GET)
    public String helloSpringBooto(){

        return "pc/table_order";
    }

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
