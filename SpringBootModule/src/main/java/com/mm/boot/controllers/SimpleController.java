package com.mm.boot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SimpleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        LOGGER.debug("Entry point '/' is invoked");
        return "Hello world 2";
    }
}
