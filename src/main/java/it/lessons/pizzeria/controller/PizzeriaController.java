package it.lessons.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.lessons.pizzeria.model.Pizza;
import it.lessons.pizzeria.repository.PizzaRepository;


@Controller
@RequestMapping("/")
public class PizzeriaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/pizzeria")
    public String startMenu(Model model) {
        return "/pizzeria/menu";
    }

    @GetMapping("/pizzeria/pizze")
    public String listaPizze(Model model) {
        List<Pizza> listaPizze = pizzaRepository.findAll();
        model.addAttribute("pizze", listaPizze);
        return "/pizzeria/pizze";
    }

    @GetMapping("/pizzeria/pizze/{id}")
    public String dettaglioPizza(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pizza", pizzaRepository.findById(id).get());
        return "pizzeria/dettaglioPizze";
    }
    

}
        