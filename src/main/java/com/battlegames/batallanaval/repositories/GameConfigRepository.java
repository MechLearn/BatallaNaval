package com.battlegames.batallanaval.repositories;

import com.battlegames.batallanaval.models.GameConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameConfigRepository extends JpaRepository<GameConfig, Integer> {
    // No necesitamos métodos extra por ahora.
}