package it.lessons.pizzeria.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Pizze")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il nome della pizza è obbligatorio")
    @Column(nullable = false, unique = true, name="nome")
    private String name;

    @NotBlank(message = "La descrizione della pizza è obbligatoria")
    @Column(nullable = false)
    private String descrizione;

    @NotNull(message="Inserire una cifra valida")
    @Min(value = 0)
    @Column(nullable = false)
    private BigDecimal prezzo;

    private String urlFoto;

    @OneToMany(mappedBy="pizza")
    private List<Offerte> offerte;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "pizze_ingredienti", joinColumns= @JoinColumn(name= "pizza_id"),inverseJoinColumns = @JoinColumn(name = "id_ingredienti"))
    private List<Ingredienti> ingredienti;

    public List<Ingredienti> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(List<Ingredienti> ingredienti) {
        this.ingredienti = ingredienti;
    }

    public List<Offerte> getOfferte() {
        return offerte;
    }

    public void setOfferte(List<Offerte> offerte) {
        this.offerte = offerte;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

}
