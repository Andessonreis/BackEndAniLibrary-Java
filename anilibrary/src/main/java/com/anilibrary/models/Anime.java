package com.anilibrary.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Anime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private Long id;
    private String title;
    private String imageUrl;
    private String synopsis;
}