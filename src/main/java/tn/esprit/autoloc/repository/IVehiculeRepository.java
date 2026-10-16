package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

@Repository
public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> {

    // Query derivation — Spring Data JPA génère le SQL automatiquement
    List<Vehicule> findByMarque(String marque);

    List<Vehicule> findByStatut(StatutVehicule statut);

    List<Vehicule> findByAgenceIdAgence(Long idAgence);
}