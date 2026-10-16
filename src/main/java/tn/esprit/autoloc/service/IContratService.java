package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;

import java.util.List;

public interface IContratService {

    Contrat ajouterContrat(Contrat contrat);

    Contrat modifierContrat(Contrat contrat);

    void supprimerContrat(Long idContrat);

    Contrat getContrat(Long idContrat);

    List<Contrat> getAllContrats();

    List<Contrat> getContratsValides(Boolean valide);
}