package it.lessons.pizzeria.controller.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.lessons.pizzeria.model.Pizza;
import it.lessons.pizzeria.repository.PizzaRepository;
import it.lessons.pizzeria.service.PizzeriaService;
import jakarta.validation.Valid;





@RestController
@RequestMapping("/api/pizzeria/pizze")
public class PizzeriaRestController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzeriaService pizzeriaService;

    @GetMapping
    public List<Pizza> listaPizze(Model model, @RequestParam(name = "keyword", required = false) String name) {
        List<Pizza> listaPizze;
        if (name != null && !name.isBlank()) {
            listaPizze = pizzaRepository.findByNameContainingIgnoreCase(name);
        } else {
            listaPizze = pizzaRepository.findAll();
        }
        model.addAttribute("pizze", listaPizze);
        return pizzaRepository.findAll();
    }

    @PostMapping
    public Pizza create(@Valid @RequestBody Pizza pizza) { 
        return pizzeriaService.create(pizza);
    }
    
    @PutMapping("/{id}")
    public Pizza putMethodName(@PathVariable Integer id, @RequestBody Pizza pizza) {
        
        return pizza;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){

        pizzeriaService.deleteById(id);
    }
}
