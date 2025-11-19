package com.battlegames.batallanaval.controllers;

import com.battlegames.batallanaval.business.GameConfigHandler;
import com.battlegames.batallanaval.models.GameConfig;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configs")
public class GameConfigController {

    private final GameConfigHandler handler;

    public GameConfigController(GameConfigHandler handler) {
        this.handler = handler;
    }

    // Crear una nueva configuración de reglas
    @PostMapping
    public String createConfig(@RequestBody GameConfig config) {
        handler.createConfig(config.getBoardSize(), config.getShipsAmount());
        return "Configuración creada con éxito";
    }

    // Listar todas las configuraciones disponibles
    @GetMapping
    public List<GameConfig> getAll() {
        return handler.getAllConfigs();
    }
}