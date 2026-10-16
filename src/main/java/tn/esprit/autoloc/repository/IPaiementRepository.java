package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.ModePaiement;
import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

@Repository
public interface IPaiementRepository extends JpaRepository<Paiement, Long> {

    List<Paiement> findByModePaiement(ModePaiement modePaiement);

    List<Paiement> findByContratIdContrat(Long idContrat);
}