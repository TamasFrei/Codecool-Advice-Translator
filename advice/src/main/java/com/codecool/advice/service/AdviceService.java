package com.codecool.advice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdviceService {

    @Value("${advice.url}")
    private String url;
}
