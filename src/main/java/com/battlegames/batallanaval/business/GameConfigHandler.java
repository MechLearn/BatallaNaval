package com.battlegames.batallanaval.business;

import com.battlegames.batallanaval.models.GameConfig;
import com.battlegames.batallanaval.repositories.GameConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameConfigHandler {

    private final GameConfigRepository repository;

    public GameConfigHandler(GameConfigRepository repository) {
        this.repository = repository;
    }

    public void createConfig(Integer boardSize, Integer shipsAmount) {
        // Aquí podrías validar que el tablero no sea negativo, etc.
        GameConfig config = new GameConfig(boardSize, shipsAmount);
        repository.save(config);
    }

    public List<GameConfig> getAllConfigs() {
        return repository.findAll();
    }
}