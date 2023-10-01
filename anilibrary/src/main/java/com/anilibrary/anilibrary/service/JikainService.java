/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anilibrary.anilibrary.service;

import com.anilibrary.anilibrary.controllers.AnimeDto;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author andesson
 */
@Service
public class JikainService {
    
    private final String apiUrl = "https://api.jikan.moe/v3/search/anime?q=jikan";
    private final RestTemplate restTemplate;

    public JikainService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<AnimeDto> getAnimes() throws IOException {
        try {
            // Realize uma solicitação HTTP GET para a API da Jikain
            Map<String, Object> response = restTemplate.getForObject(apiUrl, Map.class);

            // Verifique se a resposta não é nula e se não contém erros
            if (response != null && response.containsKey("results")) {
                List<Map<String, Object>> animeList = (List<Map<String, Object>>) response.get("results");

                // Converta os dados dos animes em DTOs
                List<AnimeDto> animeDtos = animeList.stream()
                        .map(anime -> new AnimeDto(
                                (int) anime.get("id"),
                                (String) anime.get("title"),
                                (String) anime.get("image_url"),
                                (String) anime.get("synopsis")))
                        .collect(Collectors.toList());

                // Retorne os dados dos animes
                return animeDtos;
            } else {
                throw new IOException("Resposta inválida da API da Jikain");
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new IOException("Endpoint não encontrado na API da Jikain");
            } else {
                throw new IOException("Erro ao obter os dados dos animes da Jikain: " + e.getMessage());
            }
        }
    }
}

