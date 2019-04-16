package com.codecool.advice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AdviceService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${advice.url}")
    private String url;
}
