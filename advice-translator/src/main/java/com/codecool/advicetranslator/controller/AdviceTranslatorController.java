package com.codecool.advicetranslator.controller;

import com.codecool.advicetranslator.model.Advice;
import com.codecool.advicetranslator.model.Language;
import com.codecool.advicetranslator.service.AdviceService;
import com.codecool.advicetranslator.service.ImageServiceCaller;
import com.codecool.advicetranslator.service.TranslatorService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class AdviceTranslatorController {
    private String advice;

    @Autowired
    private AdviceService adviceService;

    @Autowired
    private TranslatorService translatorService;

    @Autowired
    private ImageServiceCaller imageServiceCaller;

    @ModelAttribute(value="language")
    public Language getLanguage() {
        return new Language();
    }

    @ModelAttribute(value="advice")
    public Advice getNewAdvice() {
        return new Advice();
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("test");
    }

    @GetMapping("/")
    public String getAdvice(Model model) {
        String adviceText = adviceService.getAdvice();
        model.addAttribute("advice", adviceText);
        this.advice = adviceText;
        return "translator";
    }

    @PostMapping("/translator")
    public String postTranslatedAdvice(Model model, @ModelAttribute("language") Language language) {
        log.info("ADVICE:" + this.advice);
        String languageToTranslate =  language.getLanguage();
        String translatedAdvice = translatorService.postTranslatedAdvice(this.advice, languageToTranslate);
        model.addAttribute("advice", translatedAdvice);

        String image = imageServiceCaller.getImageForLanguage(languageToTranslate);
        model.addAttribute("image", "http://localhost:8861/" + image);
        return "translator";
    }


    @GetMapping("/advice-translator")
    public String getAdviceTranslator() {
        return "translator";
    }
}
