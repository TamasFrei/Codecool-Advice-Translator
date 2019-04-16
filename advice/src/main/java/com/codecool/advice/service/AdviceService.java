package com.codecool.advice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdviceService {

    @Value("${advice.url}")
    private String url;
}
