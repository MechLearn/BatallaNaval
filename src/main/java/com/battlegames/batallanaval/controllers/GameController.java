package com.battlegames.batallanaval.controllers;

import com.battlegames.batallanaval.business.GameHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameHandler handler;

    public GameController(GameHandler handler) {
        this.handler = handler;
    }

    // 1. Crear una partida nueva (Anfitrión)
    @PostMapping("/create")
    public String createGame(@RequestBody CreateGameRequest request) {
        return handler.createNewGame(request.hostId, request.configId);
    }

    // 2. Unirse a una partida existente (Invitado)
    @PostMapping("/join")
    public String joinGame(@RequestBody JoinGameRequest request) {
        return handler.joinGame(request.guestId, request.gameId);
    }

    // Clases auxiliares para recibir los datos del JSON (DTOs)
    // Esto evita tener que crear archivos separados.
    public static class CreateGameRequest {
        public Integer hostId;
        public Integer configId;
    }

    public static class JoinGameRequest {
        public Integer guestId;
        public String gameId;
    }
}