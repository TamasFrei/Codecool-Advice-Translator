package com.codecool.advice.controller;

import com.codecool.advice.service.AdviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AdviceController {

    @Autowired
    private AdviceService adviceService;
}
