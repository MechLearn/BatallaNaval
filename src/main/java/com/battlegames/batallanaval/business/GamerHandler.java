package com.battlegames.batallanaval.business;

import com.battlegames.batallanaval.models.Gamer;
import com.battlegames.batallanaval.repositories.GamerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // ¡Importante! Le dice a Spring que aquí está la Lógica de Negocio
public class GamerHandler {

    private final GamerRepository repository;

    // Conectamos el Repositorio automáticamente (Inyección de Dependencias)
    public GamerHandler(GamerRepository repository) {
        this.repository = repository;
    }

    /**
     * Registra un nuevo jugador si el email y nickname están libres.
     */
    public boolean registerGamer(String nickname, String email, String password) {
        // 1. Preguntar a la BD si ya existe el email o el nickname
        if (repository.findByEmail(email).isPresent() || repository.findByNickname(nickname).isPresent()) {
            return false; // Falló: Ya existe
        }

        // 2. Crear el objeto Gamer
        Gamer newGamer = new Gamer();
        newGamer.setNickname(nickname);
        newGamer.setEmail(email);
        newGamer.setPassword(password); // En un futuro aquí encriptaremos la contraseña

        // 3. Guardar en la BD
        repository.save(newGamer);
        return true; // Éxito
    }

    /**
     * Busca al usuario y verifica su contraseña.
     */
    public Gamer login(String email, String password) {
        // 1. Buscar por email
        Optional<Gamer> gamerOpt = repository.findByEmail(email);

        // 2. Si existe, verificar la contraseña
        if (gamerOpt.isPresent()) {
            Gamer gamer = gamerOpt.get();
            if (gamer.getPassword().equals(password)) {
                return gamer; // ¡Login correcto!
            }
        }
        return null; // Login fallido
    }
}