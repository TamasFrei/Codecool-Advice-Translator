package com.codecool.translator.controller;


import com.codecool.translator.service.TranslatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TranslatorController {

    @Autowired
    private TranslatorService translatorService;

    @PostMapping("/translator")
    public String translateText(@RequestParam("text") String textToTranslate, @RequestParam("language") String languageToTranslate) {
        log.info("Text to service" + textToTranslate);

        String translatedText = translatorService.getTranslatedText(textToTranslate, languageToTranslate);
        log.info("Translated text from translator controller:" + translatedText);
        return translatedText;
    }
}
