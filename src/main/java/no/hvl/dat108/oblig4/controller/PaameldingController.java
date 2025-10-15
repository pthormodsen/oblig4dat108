package no.hvl.dat108.oblig4.controller;

import no.hvl.dat108.oblig4.model.Deltager;
import no.hvl.dat108.oblig4.repo.DeltagerRepository;
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

    @GetMapping("/paamelding")
    public String visSkjema() {
        return "paamelding_med_melding";
    }

    @PostMapping("/paamelding")
    public String behandlePaamelding(Model model,
                                     @RequestParam String fornavn,
                                     @RequestParam String etternavn,
                                     @RequestParam String mobil,
                                     @RequestParam String passord,
                                     @RequestParam String passord2,
                                     @RequestParam String kjonn){



        if (!passord.equals(passord2)) {
            model.addAttribute("melding","Passordene matcher ikke");
            return "paamelding_med_melding";
        }

        if(repo.finnes(mobil)){
            model.addAttribute("melding","Det finnes allerede en deltager med dette nummeret");
            return "paamelding_med_melding";
        }

        Deltager d = new Deltager(fornavn, etternavn, mobil, kjonn);
        repo.lagre(d);
        model.addAttribute("deltager", d);
        return "paameldt";
    }
}
