package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;

public interface IAgenceService {

    Agence ajouterAgence(Agence agence);

    Agence modifierAgence(Agence agence);

    void supprimerAgence(Long idAgence);

    Agence getAgence(Long idAgence);

    List<Agence> getAllAgences();

    List<Agence> getAgencesByVille(String ville);
}