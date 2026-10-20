package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@Tag(name = "Gestion des Véhicules", description = "API pour gérer la flotte de véhicules AutoLoc")
@RestController
@RequestMapping("/vehicules")
public class VehiculeController {

    @Autowired
    private IVehiculeService vehiculeService;

    @Operation(description = "Récupérer tous les véhicules de la base de données")
    @GetMapping
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }

    @Operation(description = "Récupérer un véhicule par son ID")
    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeService.getVehicule(id);
    }

    @Operation(description = "Créer un nouveau véhicule dans la base de données")
    @PostMapping
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @Operation(description = "Modifier un véhicule existant")
    @PutMapping("/{id}")
    public Vehicule modifierVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        return vehiculeService.modifierVehicule(vehicule);
    }

    @Operation(description = "Supprimer un véhicule par son ID")
    @DeleteMapping("/{id}")
    public void supprimerVehicule(@PathVariable Long id) {
        vehiculeService.supprimerVehicule(id);
    }

    @Operation(description = "Filtrer les véhicules par leur statut (DISPONIBLE, LOUE, MAINTENANCE)")
    @GetMapping("/statut/{statut}")
    public List<Vehicule> getVehiculesByStatut(@PathVariable StatutVehicule statut) {
        return vehiculeService.getVehiculesByStatut(statut);
    }
}