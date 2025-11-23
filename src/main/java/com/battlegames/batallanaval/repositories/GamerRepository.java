package com.battlegames.batallanaval.repositories;

import com.battlegames.batallanaval.models.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Integer> {

    // Spring crea el código de esto automáticamente
    Optional<Gamer> findByNickname(String nickname);
}