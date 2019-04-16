package com.codecool.translator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TranslatorServiceTest {

    @Autowired
    private TranslatorService translatorService;

    @Test
    public void testResponse() {
        String body = "{\"contents\":{\"translated\":\"Translated text\"}}";

        ResponseEntity<String> response = new ResponseEntity<>(body, HttpStatus.OK);
        assertEquals("Translated text", translatorService.provideTranslation(response));
    }

}