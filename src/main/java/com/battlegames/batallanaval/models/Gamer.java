package com.battlegames.batallanaval.models;

import jakarta.persistence.*;

@Entity
@Table(name = "gamers")
public class Gamer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nickname;

    private String password; // Null si es invitado

    private Boolean isGuest;

    // 1. CONSTRUCTOR VACÍO (Obligatorio JPA)
    public Gamer() {
    }

    // 2. CONSTRUCTOR CON DATOS
    public Gamer(String nickname, String password, Boolean isGuest) {
        this.nickname = nickname;
        this.password = password;
        this.isGuest = isGuest;
    }

    // 3. GETTERS Y SETTERS MANUALES
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Boolean guest) {
        isGuest = guest;
    }
}