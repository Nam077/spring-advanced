package com.nam077.spring_advanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nam077.spring_advanced.exception.UnauthorizedException;

import java.util.Locale;

@RestController
public class HomeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/greet")
    public String greet(Locale locale) {
        throw new UnauthorizedException(messageSource.getMessage("error.resource.not.found", null, locale));
    }
}
