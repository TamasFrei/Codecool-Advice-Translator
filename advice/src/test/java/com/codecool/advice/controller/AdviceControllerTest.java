package com.codecool.advice.controller;

import com.codecool.advice.service.AdviceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AdviceControllerTest {

    @Mock
    private AdviceService adviceService;

    @InjectMocks
    private AdviceController adviceController;

    @Test
    void getAdvice() throws IOException {
        Mockito.when(adviceService.getRandomAdvice()).thenReturn("This is a test.");
        assertThat(adviceController.getAdvice()).isEqualTo("This is a test.");
    }
}