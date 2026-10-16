package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;

public interface IEquipementService {

    Equipement ajouterEquipement(Equipement equipement);

    Equipement modifierEquipement(Equipement equipement);

    void supprimerEquipement(Long idEquipement);

    Equipement getEquipement(Long idEquipement);

    List<Equipement> getAllEquipements();
}