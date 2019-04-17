package com.codecool.backgroundimage;

import com.codecool.backgroundimage.entity.Image;
import com.codecool.backgroundimage.entity.Language;
import com.codecool.backgroundimage.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@ComponentScan(basePackages = { "com.*"})
public class BackgroundImageApplication {

    @Autowired
    public ImageRepository imageRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackgroundImageApplication.class, args);
    }

    @Bean
    @Profile("default")
    public CommandLineRunner init(){
        return args -> {
            Image imageYoda = Image.builder()
                    .name("img/yoda.jpeg")
                    .language(Language.YODA)
                    .build();
            imageRepository.save(imageYoda);


            Image imageDothraki = Image.builder()
                    .name("img/dothraki.jpg")
                    .language(Language.DOTHRAKI)
                    .build();
            imageRepository.save(imageDothraki);

            Image imageKlingon = Image.builder()
                    .name("img/klingon.jpeg")
                    .language(Language.KLINGON)
                    .build();
            imageRepository.save(imageKlingon);

            Image imagePirate = Image.builder()
                    .name("img/pirate.jpg")
                    .language(Language.PIRATE)
                    .build();
            imageRepository.save(imagePirate);

            Image imageSith = Image.builder()
                    .name("img/sith.jpg")
                    .language(Language.SITH)
                    .build();
            imageRepository.save(imageSith);

            Image imageValyrian = Image.builder()
                    .name("img/valyrian.jpg")
                    .language(Language.VALYRIAN)
                    .build();
            imageRepository.save(imageValyrian);
        };
    }

}
