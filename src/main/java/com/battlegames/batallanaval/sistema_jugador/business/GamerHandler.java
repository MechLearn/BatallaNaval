package com.battlegames.batallanaval.sistema_jugador.business;

import com.battlegames.batallanaval.sistema_jugador.models.Gamer;
import com.battlegames.batallanaval.sistema_jugador.repositories.GamerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GamerHandler {

    private final GamerRepository repository;

    public GamerHandler(GamerRepository repository) {
        this.repository = repository;
    }

    // REGISTRO
    public boolean registerGamer(String nickname, String password) {
        if (repository.findByNickname(nickname).isPresent()) {
            return false; // Ya existe
        }
        // Usamos el constructor manual
        Gamer newGamer = new Gamer(nickname, password, false);
        repository.save(newGamer);
        return true;
    }

    // LOGIN
    public Gamer login(String nickname, String password) {
        Optional<Gamer> gamerOpt = repository.findByNickname(nickname);

        if (gamerOpt.isPresent()) {
            Gamer gamer = gamerOpt.get();
            // Usamos el Getter manual
            if (Boolean.FALSE.equals(gamer.getIsGuest()) && gamer.getPassword().equals(password)) {
                return gamer;
            }
        }
        return null;
    }

    // CREAR INVITADO
    public Gamer createGuest() {
        String randomName = "Guest_" + UUID.randomUUID().toString().substring(0, 4);

        // Constructor manual: Nick aleatorio, Password null, isGuest true
        Gamer guest = new Gamer(randomName, null, true);

        return repository.save(guest);
    }
}