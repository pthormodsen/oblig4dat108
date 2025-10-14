package no.hvl.dat108.oblig4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaameldingController {

    @GetMapping("/paamelding")
    public String visSkjema() {
        return "paamelding_med_melding";
    }

    @PostMapping("/paamelding")
    public String behandlePaamelding(){
        return "paameldt";
    }
}
