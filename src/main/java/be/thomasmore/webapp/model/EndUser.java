package be.thomasmore.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class EndUser {
    @SequenceGenerator(name = "UserSeqGen", sequenceName = "UserSeq", allocationSize = 1)
    @GeneratedValue(generator = "UserSeqGen")
    @Id
    private Integer id;
    private String emailAddress;
    private String username;
    private String password;
    private String role;

    public EndUser(String emailAddress, String username, String password, String role) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public EndUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
