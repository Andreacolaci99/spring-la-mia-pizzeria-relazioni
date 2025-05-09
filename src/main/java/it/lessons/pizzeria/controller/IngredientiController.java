package it.lessons.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.lessons.pizzeria.model.Ingredienti;
import it.lessons.pizzeria.model.Pizza;
import it.lessons.pizzeria.repository.IngredientiRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredienti")
public class IngredientiController {

    @Autowired
    private IngredientiRepository ingredientiRepository;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("ingredienti", ingredientiRepository.findAll());
        model.addAttribute("ingredientiObj", new Ingredienti());

        return "/pizzeria/ingredienti/index";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("ingredientiObj") Ingredienti ingredienti, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            ingredientiRepository.save(ingredienti);
        }

        return "redirect:/ingredienti";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        Ingredienti ing = ingredientiRepository.findById(id).get();

        for(Pizza p : ing.getPizze()){
            p.getIngredienti().remove(ing);
        }

        ingredientiRepository.deleteById(id);

        return "redirect:/ingredienti";
    }

}
