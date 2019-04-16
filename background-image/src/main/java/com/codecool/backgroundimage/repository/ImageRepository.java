package com.codecool.backgroundimage.repository;

import com.codecool.backgroundimage.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
