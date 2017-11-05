package com.mm.movies_rest_api.controller;

import com.mm.movies_rest_api.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class CustomErrorController implements ErrorController {

    private Messages messages;

    @Autowired
    public CustomErrorController(Messages messages) {
        this.messages = messages;
    }

    @RequestMapping(path="/error", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity error() {
        String errMsg = messages.getMessage("resource.not.found");
        return new ResponseEntity<String>(errMsg, HttpStatus.NOT_FOUND);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
