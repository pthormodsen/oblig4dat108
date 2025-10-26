package no.hvl.dat108.oblig4.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4.model.Deltager;
import no.hvl.dat108.oblig4.repo.DeltagerRepository;
import no.hvl.dat108.oblig4.service.PassordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InnloggingController {

    @Autowired
    private DeltagerRepository deltagerRepository;

    @Autowired
    private PassordService passordService;

    @GetMapping("/innlogging")
    public String innlogging(){
        return "innlogging";
    }

    @PostMapping("/innlogging")
    public String innlogging(Model model,
                             @RequestParam String mobil,
                             @RequestParam String passord,
                             HttpSession session) {

        var deltagerOpt = deltagerRepository.findById(mobil);

        if (deltagerOpt.isEmpty()) {
            model.addAttribute("melding", "Fant ingen bruker med dette mobilnummeret");
            return "innlogging";
        }

        Deltager d = deltagerOpt.get();

        boolean riktigPassord = passordService.erKorrektPassord(passord, d.getSalt(), d.getHash());

        if (riktigPassord) {
            Sort sortering = Sort.by("fornavn").ascending().and(Sort.by("etternavn").ascending());
            model.addAttribute("deltagere", deltagerRepository.findAll(sortering));
            session.setAttribute("innloggetMobil", d.getMobil());
            session.setAttribute("fornavn", d.getFornavn());
            session.setAttribute("etternavn", d.getEtternavn());
            session.setAttribute("innloggetMobil", d.getMobil());
            return "deltagerliste";
        } else {
            model.addAttribute("melding", "Feil passord");
            return "innlogging";
        }
    }
}
