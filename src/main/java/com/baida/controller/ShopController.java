package com.baida.controller;

import com.baida.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

/**
 * @author ShiQing_Chen
 * @Description //TODO
 * @date 2018/12/4 23:39
 */

@EnableAutoConfiguration
@Controller
public class ShopController {
    private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    ShopService shopService;
}
