package com.codecool.advicetranslator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdviceService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${advice.url}")
    private String adviceURL;

    public String getAdvice() {
        return restTemplate.getForObject(adviceURL, String.class);
    }

}
