/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anilibrary.anilibrary.controllers;

import com.anilibrary.anilibrary.service.JikainService;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andesson
 */
@RestController
public class AnimeController {

    private final JikainService jikainService;

    @Autowired 
    public AnimeController(JikainService jikainService) {
        this.jikainService = jikainService;
    }

    @GetMapping("/animes")
    public ResponseEntity<List<AnimeDto>> animes() throws IOException {
        List<AnimeDto> animeDtos = jikainService.getAnimes();
        return ResponseEntity.ok(animeDtos);
    }
}

    
