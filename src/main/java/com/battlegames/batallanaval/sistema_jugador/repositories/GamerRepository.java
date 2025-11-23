package com.battlegames.batallanaval.sistema_jugador.repositories;

import com.battlegames.batallanaval.sistema_jugador.models.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Integer> {


    Optional<Gamer> findByNickname(String nickname);
}