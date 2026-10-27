package tn.esprit.autoloc.service.validator;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Vehicule;

@Component
public class VehiculeValidator {

    public void validerVehicule(Vehicule vehicule) {
        if (vehicule.getTarifJournalier() == null || vehicule.getTarifJournalier().doubleValue() <= 0) {
            throw new IllegalArgumentException("Le tarif journalier doit être positif.");
        }
        if (vehicule.getImmatriculation() == null || vehicule.getImmatriculation().trim().isEmpty()) {
            throw new IllegalArgumentException("L'immatriculation est obligatoire.");
        }
        if (vehicule.getMarque() == null || vehicule.getMarque().trim().isEmpty()) {
            throw new IllegalArgumentException("La marque est obligatoire.");
        }
    }
}