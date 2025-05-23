package it.lessons.pizzeria.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;


@Entity
public class User {
    
    @Id
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<Ruoli> ruoli;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Ruoli> getRuoli() {
        return ruoli;
    }

    public void setRuoli(List<Ruoli> ruoli) {
        this.ruoli = ruoli;
    }

}
