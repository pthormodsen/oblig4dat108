package no.hvl.dat108.oblig4.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4.model.Deltager;
import no.hvl.dat108.oblig4.repo.DeltagerRepository;
import no.hvl.dat108.oblig4.service.PassordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaameldingController {

    @Autowired
    private DeltagerRepository repo;

    @Autowired
    private PassordService passordService;

    @GetMapping("/paamelding")
    public String visSkjema() {
        return "paamelding_med_melding";
    }

    @PostMapping("/paamelding")
    public String behandlePaamelding(Model model,
                                     HttpSession session,
                                     @RequestParam String fornavn,
                                     @RequestParam String etternavn,
                                     @RequestParam String mobil,
                                     @RequestParam String passord,
                                     @RequestParam String passord2,
                                     @RequestParam String kjonn) {


        if (!passord.equals(passord2)) {
            model.addAttribute("melding", "Passordene matcher ikke");
            return "paamelding_med_melding";
        }

        if (repo.existsByMobil(mobil)) {
            model.addAttribute("melding", "Det finnes allerede en deltager med dette nummeret");
            return "paamelding_med_melding";
        }

        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt(passord, salt);


        Deltager d = new Deltager(fornavn, etternavn, mobil, hash, salt, kjonn);
        repo.save(d);
        session.setAttribute("innloggetMobil", d.getMobil());
        session.setAttribute("fornavn", d.getFornavn());
        session.setAttribute("etternavn", d.getEtternavn());
        model.addAttribute("deltager", d);
        return "paameldt";
    }
}
