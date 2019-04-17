package com.codecool.backgroundimage.controller;

import com.codecool.backgroundimage.entity.Image;
import com.codecool.backgroundimage.entity.Language;
import com.codecool.backgroundimage.repository.ImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ImageController {

    @Autowired
    ImageRepository imageRepository;



    @GetMapping("/test")
    public String test(){
        return "test page";
    }
;
    @GetMapping("/image/{language}")
    public String showImage(@PathVariable("language") String language){
        Image image = imageRepository.findImageByLanguage(Language.valueOf(language.toUpperCase()));
        return image.getName();
    }


}
