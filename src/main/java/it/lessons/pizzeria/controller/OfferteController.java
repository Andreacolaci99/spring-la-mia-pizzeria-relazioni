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

import it.lessons.pizzeria.model.Offerte;
import it.lessons.pizzeria.repository.OfferteRepository;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/offerte")
public class OfferteController {

    @Autowired
    private OfferteRepository offerteRepository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("offerte") Offerte formOfferte, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("editMode", false);
            return "offerte/edit";
        }

        offerteRepository.save(formOfferte);

        return "redirect:/pizzeria/pizze/" + formOfferte.getPizza().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){

        Offerte offerte = offerteRepository.findById(id).get();
        model.addAttribute("offerte", offerte);
        model.addAttribute("editMode", true);

        return "pizzeria/offerte/edit";
    }
    
    @PostMapping("/edit/{id}")
    public String doEdit(@Valid @ModelAttribute("offerte") Offerte offerte, BindingResult bindingResult, Model model) {
        
        if(bindingResult.hasErrors()){
            model.addAttribute("editMode",true);
            model.addAttribute("offerte",offerte);
            return "pizzeria/offerte/edit";
        }
        offerteRepository.save(offerte);
        return "redirect:/pizzeria/pizze/" + offerte.getPizza().getId();
    }

    @PostMapping("/delete/{id}")
    public String deleteOfferta(@PathVariable("id") Integer id) {
        Offerte offerta = offerteRepository.findById(id).get();
        Integer pizzaId = offerta.getPizza().getId();

        offerteRepository.deleteById(id);
        return "redirect:/pizzeria/pizze/" + pizzaId;
    }
    

}
