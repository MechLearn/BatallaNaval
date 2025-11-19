package com.battlegames.batallanaval.repositories;

import com.battlegames.batallanaval.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {

    // Método para encontrar partidas que estén en estado "WAITING" (Esperando jugador)
    List<Game> findByStatus(String status);
}