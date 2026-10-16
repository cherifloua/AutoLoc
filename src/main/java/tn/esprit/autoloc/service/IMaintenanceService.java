package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;

public interface IMaintenanceService {

    Maintenance ajouterMaintenance(Maintenance maintenance);

    Maintenance modifierMaintenance(Maintenance maintenance);

    void supprimerMaintenance(Long idMaintenance);

    Maintenance getMaintenance(Long idMaintenance);

    List<Maintenance> getAllMaintenances();

    List<Maintenance> getMaintenancesByVehicule(Long idVehicule);
}