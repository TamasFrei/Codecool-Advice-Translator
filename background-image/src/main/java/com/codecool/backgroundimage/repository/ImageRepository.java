package com.codecool.backgroundimage.repository;

import com.codecool.backgroundimage.entity.Image;
import com.codecool.backgroundimage.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findAll();

    Image findImageByLanguage(Language language);






}
