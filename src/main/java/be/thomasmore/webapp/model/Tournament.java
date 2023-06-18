package be.thomasmore.webapp.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Tournament {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tournament_generator")
    @SequenceGenerator(name = "tournament_generator", sequenceName = "tournament_seq", allocationSize = 1)
    @Id
    private Integer id;
    private String name;
    private Date date;
    private boolean free;
    private Double prizepool;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Game game;

    public Tournament(Integer id, String name, Date date, Game game, boolean free, Double prizepool) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.game = game;
        this.free = free;
        this.prizepool = prizepool;
    }

    public Tournament() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Double getPrizepool() {
        return prizepool;
    }

    public void setPrizepool(Double prizepool) {
        this.prizepool = prizepool;
    }
}
