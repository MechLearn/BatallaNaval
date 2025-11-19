package com.battlegames.batallanaval.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gamers")
public class Gamer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
}