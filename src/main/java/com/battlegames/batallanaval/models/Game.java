package com.battlegames.batallanaval.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "games")
public class Game {

    @Id
    private String id; // Usaremos un código como "SALA-A1" o "X7Z"

    private String status; // "WAITING" (Esperando), "PLAYING" (Jugando), "FINISHED" (Terminada)
    private LocalDateTime date; // Fecha y hora de inicio

    private Integer player1Id; // ID del anfitrión
    private Integer player2Id; // ID del retador (al principio está vacío)

    // Relación: Muchas partidas pueden usar la misma configuración (10x10)
    @ManyToOne
    @JoinColumn(name = "config_id")
    private GameConfig config;
}