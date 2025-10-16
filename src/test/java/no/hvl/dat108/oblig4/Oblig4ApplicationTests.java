package no.hvl.dat108.oblig4;

import no.hvl.dat108.oblig4.model.Deltager;
import no.hvl.dat108.oblig4.repo.DeltagerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Oblig4ApplicationTests {

    private DeltagerRepository repo;

    @BeforeEach
    void setUp() {
        repo = new DeltagerRepository();
    }

    @Test
    void tomDeltagerListe(){
        assertFalse(repo.getDeltagere().isEmpty());
    }

    @Test
    void testFinnes(){
        assertTrue(repo.finnes("23456789"));
    }

    @Test
    void leggTilDeltager(){
        int antall = repo.getDeltagere().size();
        repo.lagre(new Deltager("Test", "Testtest", "12446678", "1235", "mann"));
        assertEquals(antall+1, repo.getDeltagere().size());
    }

    @Test
    void testAtManIkkeKanLagreToMedSammeMobil() {
        Deltager d1 = new Deltager("Ola", "Nordmann", "88888888", "1234", "mann");
        Deltager d2 = new Deltager("Kari", "Nordmann", "88888888", "abcd", "kvinne");

        repo.lagre(d1);
        int antallFor = repo.getDeltagere().size();
        repo.lagre(d2);
        int antallEtter = repo.getDeltagere().size();

        assertEquals(antallFor, antallEtter);
    }


    @Test
    void contextLoads() {
    }

}
