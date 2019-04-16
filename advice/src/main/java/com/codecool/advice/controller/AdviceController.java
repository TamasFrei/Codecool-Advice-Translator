package com.codecool.advice.controller;

import com.codecool.advice.service.AdviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @GetMapping("/advice")
    public String getAdvice() {
        try {
            return adviceService.getRandomAdvice();
        } catch (IOException e) {
            e.printStackTrace();
            return "Advice API is not working.";
        }
    }
}
