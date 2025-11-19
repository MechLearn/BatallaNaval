package com.battlegames.batallanaval.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "game_configs")
public class GameConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer boardSize;   // Ej: 10 para 10x10
    private Integer shipsAmount; // Ej: 5 barcos

    public GameConfig() {}

    public GameConfig(Integer boardSize, Integer shipsAmount) {
        this.boardSize = boardSize;
        this.shipsAmount = shipsAmount;
    }
}