package no.hvl.dat108.oblig4.repo;

import no.hvl.dat108.oblig4.model.Deltager;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class DeltagerRepository {

    private List<Deltager> deltagere = new ArrayList<>();

    public DeltagerRepository() {
        deltagere.add(new Deltager("Anne", "Panne", "23456789", "kvinne"));
        deltagere.add(new Deltager("Arne", "Arnesen", "90123456", "mann"));
        deltagere.add(new Deltager("Lars-Petter", "Helland", "12345679", "mann"));
        deltagere.add(new Deltager("Per", "Viskelær", "34534534", "mann"));
        deltagere.add(new Deltager("Xx-x", "Xxx", "12321378", "kvinne"));
        deltagere.add(new Deltager("Patrik", "Thormodsen", "12312312", "mann"));
    }

    public List<Deltager> getDeltagere(){
        return deltagere.stream().
            sorted(Comparator.comparing(Deltager::getFornavn)
                .thenComparing(Deltager::getEtternavn))
            .toList();
    }

    public void lagre(Deltager d){
        deltagere.add(d);
    }

    public boolean finnes(String mobil){
        return deltagere.stream().
            anyMatch(d -> d.getMobil().equals(mobil));
    }

}
