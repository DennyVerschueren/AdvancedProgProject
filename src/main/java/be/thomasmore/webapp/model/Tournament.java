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

    public Tournament(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
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
}
