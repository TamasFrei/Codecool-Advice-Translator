package com.codecool.translator.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@Slf4j
public class TranslatorService {

    @Value("${translator.url}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    public String getTranslatedText(String text, String language) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("text", text);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl + language + ".json", request, String.class);
        log.info("Response from translating API: " + response.getBody());
        log.info("Status of response from translating API: " + response.getStatusCodeValue());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
        } catch (IOException e) {
            System.out.println("Problem with JSON");
        }

        JsonNode translation = root.path("contents").path("translated");

        log.info("TRanslated text from translating API: " + translation.asText());

        return translation.asText();
    }
}
