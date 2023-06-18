package be.thomasmore.webapp.model;

import jakarta.persistence.*;

@Entity
public class Game {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_generator")
    @SequenceGenerator(name = "game_generator", sequenceName = "game_seq", allocationSize = 1)
    @Id
    private Integer id;
    private String name;
    private String gameImage;
    @Column(length = 1000)
    private String gameDescription;

    public Game(Integer id, String name, String gameImage, String gameDescription) {
        this.id = id;
        this.name = name;
        this.gameImage = gameImage;
        this.gameDescription = gameDescription;
    }

    public Game() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameImage() {
        return gameImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }
}
