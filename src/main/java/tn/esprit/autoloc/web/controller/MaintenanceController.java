package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@Tag(name = "Gestion des Maintenances", description = "API pour gérer les maintenances des véhicules")
@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {

    @Autowired
    private IMaintenanceService maintenanceService;

    @Operation(description = "Récupérer toutes les maintenances")
    @GetMapping
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.getAllMaintenances();
    }

    @Operation(description = "Récupérer une maintenance par son ID")
    @GetMapping("/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.getMaintenance(id);
    }

    @Operation(description = "Filtrer les maintenances par véhicule")
    @GetMapping("/vehicule/{idVehicule}")
    public List<Maintenance> getMaintenancesByVehicule(@PathVariable Long idVehicule) {
        return maintenanceService.getMaintenancesByVehicule(idVehicule);
    }

    @Operation(description = "Créer une nouvelle maintenance")
    @PostMapping
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @Operation(description = "Modifier une maintenance existante")
    @PutMapping("/{id}")
    public Maintenance modifierMaintenance(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        maintenance.setIdMaintenance(id);
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @Operation(description = "Supprimer une maintenance par son ID")
    @DeleteMapping("/{id}")
    public void supprimerMaintenance(@PathVariable Long id) {
        maintenanceService.supprimerMaintenance(id);
    }
}