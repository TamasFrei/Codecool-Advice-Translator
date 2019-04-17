package com.codecool.advicetranslator.controller;

import com.codecool.advicetranslator.service.AdviceService;
import com.codecool.advicetranslator.service.TranslatorService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceTranslatorController {

    @Autowired
    private AdviceService adviceService;

    @Autowired
    private TranslatorService translatorService;

    @GetMapping("/test")
    public void test() {
        System.out.println("test");
    }

    @GetMapping("/advice")
    public String getAdvice() {
        return adviceService.getAdvice();
    }

    @PostMapping("/translator")
    public String postTranslatedAdvice() {
        return translatorService.postTranslatedAdvice("balbla","yoda");
    }

}
