package com.anilibrary.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
public class Anime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String imageUrl;
    
    @Column(length = 1000)
    private String synopsis;
}