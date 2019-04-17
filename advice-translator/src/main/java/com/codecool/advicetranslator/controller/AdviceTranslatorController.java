package com.codecool.advicetranslator.controller;

import com.codecool.advicetranslator.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceTranslatorController {

    @Autowired
    private AdviceService adviceService;

    @GetMapping("/test")
    public void test() {
        System.out.println("test");
    }

    @GetMapping("/advice")
    public String getAdvice() {
        return adviceService.getAdvice();
    }

}
