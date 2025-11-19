package com.battlegames.batallanaval.repositories;

import com.battlegames.batallanaval.models.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Integer> {

    // Buscar un jugador por su email (Para el Login)
    Optional<Gamer> findByEmail(String email);

    // Buscar un jugador por su nickname (Para ver si ya existe)
    Optional<Gamer> findByNickname(String nickname);
}