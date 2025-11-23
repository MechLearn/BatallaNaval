package com.battlegames.batallanaval.sistema_jugador.controllers;

import com.battlegames.batallanaval.sistema_jugador.business.GamerHandler;
import com.battlegames.batallanaval.sistema_jugador.models.Gamer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gamers")
public class GamerController {

    private final GamerHandler handler;

    public GamerController(GamerHandler handler) {
        this.handler = handler;
    }

    @PostMapping("/register")
    public String register(@RequestBody Gamer gamer) {
        // Usamos los Getters manuales para leer el JSON que entra
        boolean exito = handler.registerGamer(gamer.getNickname(), gamer.getPassword());
        if (exito) return "Registro Exitoso";
        else return "Error: El Nickname ya existe";
    }

    @PostMapping("/login")
    public String login(@RequestBody Gamer gamer) {
        Gamer encontrado = handler.login(gamer.getNickname(), gamer.getPassword());
        if (encontrado != null) return "Bienvenido " + encontrado.getNickname();
        else return "Error: Credenciales incorrectas";
    }

    @PostMapping("/login-guest")
    public String loginGuest() {
        Gamer guest = handler.createGuest();
        return "Entraste como invitado: " + guest.getNickname();
    }
}