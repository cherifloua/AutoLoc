package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {

    Vehicule ajouterVehicule(Vehicule vehicule);

    Vehicule modifierVehicule(Vehicule vehicule);

    void supprimerVehicule(Long idVehicule);

    Vehicule getVehicule(Long idVehicule);

    List<Vehicule> getAllVehicules();

    List<Vehicule> getVehiculesByStatut(StatutVehicule statut);

    List<Vehicule> getVehiculesByAgence(Long idAgence);
}