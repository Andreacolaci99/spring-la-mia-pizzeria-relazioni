package it.lessons.pizzeria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.lessons.pizzeria.model.Pizza;
import it.lessons.pizzeria.repository.PizzaRepository;

@Service
public class PizzeriaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza create(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza update(Pizza pizza) {
        Optional<Pizza> optPizza = pizzaRepository.findById(pizza.getId());
        if(optPizza.isEmpty()){
            throw new IllegalArgumentException("Non puoi aggiornare una pizza senza l'id");
        }
        return pizzaRepository.save(pizza);
    }

    public void deleteById(Integer id){
        
        pizzaRepository.deleteById(id);
    }
}
