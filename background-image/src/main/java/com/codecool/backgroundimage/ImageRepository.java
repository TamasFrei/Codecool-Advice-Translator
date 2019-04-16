package com.codecool.backgroundimage;

import com.codecool.backgroundimage.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
