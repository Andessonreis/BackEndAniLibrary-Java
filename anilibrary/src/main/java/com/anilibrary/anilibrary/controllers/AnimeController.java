/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anilibrary.anilibrary.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andesson
 */

@RestController
public class AnimeController {
    @GetMapping("/animes")
    public ResponseEntity<List<AnimeDto>> animes() throws IOException {
        
    }
}
    
