package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Contrat;

import java.util.List;

@Repository
public interface IContratRepository extends JpaRepository<Contrat, Long> {

    List<Contrat> findByValide(Boolean valide);
}