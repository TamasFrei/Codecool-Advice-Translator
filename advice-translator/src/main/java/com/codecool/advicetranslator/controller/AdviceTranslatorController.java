package com.codecool.advicetranslator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceTranslatorController {

    @GetMapping("/test")
    public void test() {
        System.out.println("test");
    }

}
