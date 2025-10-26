package no.hvl.dat108.oblig4.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4.repo.DeltagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class DeltagerlisteController {

    @Autowired
    private DeltagerRepository deltagerRepository;

    @GetMapping("/deltagerliste")
    public String visListe(HttpSession session, Model model) {
        var innloggetMobil = (String) session.getAttribute("innloggetMobil");
        if (innloggetMobil == null) {
            model.addAttribute("melding", "Du må logge inn for å se deltagerlisten");
            return "innlogging";
        }
        Sort sortering = Sort.by("fornavn").ascending().and(Sort.by("etternavn").ascending());
        model.addAttribute("deltagere", deltagerRepository.findAll(sortering));
        model.addAttribute("innloggetMobil", innloggetMobil);
        return "deltagerliste";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("melding", "Du er nå logget ut");
        return "redirect:/innlogging";
    }
}
