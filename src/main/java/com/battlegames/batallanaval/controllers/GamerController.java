package com.battlegames.batallanaval.controllers;

import com.battlegames.batallanaval.business.GamerHandler;
import com.battlegames.batallanaval.models.Gamer;
import org.springframework.web.bind.annotation.*;

@RestController // 1. Dice que esta clase responde peticiones WEB
@RequestMapping("/api/gamers") // 2. Todas las rutas empiezan con esta dirección
public class GamerController {

    private final GamerHandler handler;

    public GamerController(GamerHandler handler) {
        this.handler = handler;
    }

    // Endpoint para REGISTRARSE
    // Se usa enviando un POST a: http://localhost:8080/api/gamers/register
    @PostMapping("/register")
    public String register(@RequestBody Gamer gamer) {
        // Usamos el objeto Gamer para recibir los datos del JSON
        boolean exito = handler.registerGamer(gamer.getNickname(), gamer.getEmail(), gamer.getPassword());

        if (exito) {
            return "Usuario registrado con exito";
        } else {
            return "Error: El usuario o email ya existe";
        }
    }

    // Endpoint para LOGIN
    // Se usa enviando un POST a: http://localhost:8080/api/gamers/login
    @PostMapping("/login")
    public String login(@RequestBody Gamer gamer) {
        Gamer encontrado = handler.login(gamer.getEmail(), gamer.getPassword());

        if (encontrado != null) {
            return "Login Correcto. Bienvenido " + encontrado.getNickname();
        } else {
            return "Error: Credenciales incorrectas";
        }
    }
}