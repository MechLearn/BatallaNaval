package com.battlegames.batallanaval.business;

import com.battlegames.batallanaval.models.Game;
import com.battlegames.batallanaval.models.GameConfig;
import com.battlegames.batallanaval.repositories.GameConfigRepository;
import com.battlegames.batallanaval.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameHandler {

    private final GameRepository gameRepository;
    private final GameConfigRepository configRepository;

    public GameHandler(GameRepository gameRepository, GameConfigRepository configRepository) {
        this.gameRepository = gameRepository;
        this.configRepository = configRepository;
    }

    // Lógica para CREAR una partida
    public String createNewGame(Integer hostId, Integer configId) {
        // 1. Buscamos la configuración elegida
        Optional<GameConfig> configOpt = configRepository.findById(configId);
        if (configOpt.isEmpty()) return "Error: Configuración no encontrada";

        // 2. Creamos la partida
        Game game = new Game();
        game.setId(UUID.randomUUID().toString().substring(0, 8)); // Generamos un código corto (ej: "a1b2c3d4")
        game.setPlayer1Id(hostId);
        game.setConfig(configOpt.get());
        game.setStatus("WAITING"); // Esperando rival
        game.setDate(LocalDateTime.now());

        gameRepository.save(game);
        return game.getId(); // Devolvemos el código de la sala para que se lo pase al amigo
    }

    // Lógica para UNIRSE a una partida
    public String joinGame(Integer guestId, String gameId) {
        Optional<Game> gameOpt = gameRepository.findById(gameId);

        if (gameOpt.isEmpty()) return "Error: Sala no encontrada";

        Game game = gameOpt.get();

        // Validaciones de negocio
        if (!game.getStatus().equals("WAITING")) return "Error: La partida ya empezó o terminó";
        if (game.getPlayer1Id().equals(guestId)) return "Error: No puedes jugar contra ti mismo";

        // Si todo está bien, entra el jugador 2
        game.setPlayer2Id(guestId);
        game.setStatus("PLAYING"); // ¡Cambia el estado a JUGANDO!
        gameRepository.save(game);

        return "¡Unido con éxito! Que comience la batalla.";
    }
}