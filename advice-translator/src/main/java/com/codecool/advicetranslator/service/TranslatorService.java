package com.codecool.advicetranslator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TranslatorService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${translator.url}")
    private String translatorURL;

    public String postTranslatedAdvice(String advice, String language) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("text", advice);
        map.add("language", language);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, httpHeaders);
        log.info("Response: " + restTemplate.postForEntity(translatorURL, request, String.class));
        return restTemplate.postForEntity(translatorURL, request, String.class).getBody();
    }



}
