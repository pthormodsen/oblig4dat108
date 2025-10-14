package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.repo.DeltagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;



@Controller
public class DeltagerlisteController {

    @Autowired
    private DeltagerRepository deltagerRepository;

    @GetMapping("/deltagerliste")
    public String visSkjema(Model model) {
        model.addAttribute("deltagere", deltagerRepository.getDeltagere());
        return "deltagerliste";
    }

}
