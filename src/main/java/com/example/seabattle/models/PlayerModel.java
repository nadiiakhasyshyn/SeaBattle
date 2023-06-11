package com.example.seabattle.models;

import jakarta.persistence.*;

@Entity
@Table(name="players")
public class PlayerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "victories")
    private int victories;

    @Column(name = "losses")
    private int losses;

    @Column(name = "totalGames")
    private int totalGames;

    public PlayerModel(String name, int victories, int losses, int totalGames) {
        this.name = name;
        this.victories = victories;
        this.losses = losses;
        this.totalGames = totalGames;
    }

    public PlayerModel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }
}

