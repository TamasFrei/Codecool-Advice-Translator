package com.codecool.advicetranslator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ImageServiceCaller {

    @Value("${image.url}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    public String getImageForLanguage(String language) {
        String image = restTemplate.getForEntity(baseUrl + language, String.class).getBody();
        return image;
    }

}
