package com.nam077.spring_advanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HomeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/greet")
    public String greet(Locale locale) {
        return messageSource.getMessage("welcome.message", null, locale);
    }
}
