package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.IMaintenanceRepository;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements IMaintenanceService {

    @Autowired
    private IMaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void supprimerMaintenance(Long idMaintenance) {
        maintenanceRepository.deleteById(idMaintenance);
    }

    @Override
    public Maintenance getMaintenance(Long idMaintenance) {
        return maintenanceRepository.findById(idMaintenance).orElse(null);
    }

    @Override
    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    @Override
    public List<Maintenance> getMaintenancesByVehicule(Long idVehicule) {
        return maintenanceRepository.findByVehiculeIdVehicule(idVehicule);
    }
}