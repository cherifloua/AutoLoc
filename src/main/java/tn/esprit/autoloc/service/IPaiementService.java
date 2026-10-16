package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.ModePaiement;
import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IPaiementService {

    Paiement ajouterPaiement(Paiement paiement);

    Paiement modifierPaiement(Paiement paiement);

    void supprimerPaiement(Long idPaiement);

    Paiement getPaiement(Long idPaiement);

    List<Paiement> getAllPaiements();

    List<Paiement> getPaiementsByMode(ModePaiement modePaiement);

    List<Paiement> getPaiementsByContrat(Long idContrat);
}