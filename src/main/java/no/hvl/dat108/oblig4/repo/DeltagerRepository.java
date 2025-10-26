package no.hvl.dat108.oblig4.repo;

import jakarta.annotation.PostConstruct;
import no.hvl.dat108.oblig4.model.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

    @Repository
    public interface DeltagerRepository extends JpaRepository<Deltager, String> {
        boolean existsByMobil(String mobil);
}
