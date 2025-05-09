package it.lessons.pizzeria.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ingredienti {

    @Id()
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotBlank(message="Inserire un nome valido")
    private String ingredienti;

    @ManyToMany(mappedBy="ingredienti")
    @JsonBackReference
    private List<Pizza> pizze;


    public List<Pizza> getPizze() {
        return pizze;
    }


    public void setPizze(List<Pizza> pizze) {
        this.pizze = pizze;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getIngredienti() {
        return ingredienti;
    }


    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }
    
}
