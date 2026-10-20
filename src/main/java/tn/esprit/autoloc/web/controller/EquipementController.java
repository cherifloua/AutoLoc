package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@Tag(name = "Gestion des Équipements", description = "API pour gérer les équipements des véhicules")
@RestController
@RequestMapping("/equipements")
public class EquipementController {

    @Autowired
    private IEquipementService equipementService;

    @Operation(description = "Récupérer tous les équipements")
    @GetMapping
    public List<Equipement> getAllEquipements() {
        return equipementService.getAllEquipements();
    }

    @Operation(description = "Récupérer un équipement par son ID")
    @GetMapping("/{id}")
    public Equipement getEquipementById(@PathVariable Long id) {
        return equipementService.getEquipement(id);
    }

    @Operation(description = "Créer un nouvel équipement")
    @PostMapping
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @Operation(description = "Modifier un équipement existant")
    @PutMapping("/{id}")
    public Equipement modifierEquipement(@PathVariable Long id, @RequestBody Equipement equipement) {
        equipement.setIdEquipement(id);
        return equipementService.modifierEquipement(equipement);
    }

    @Operation(description = "Supprimer un équipement par son ID")
    @DeleteMapping("/{id}")
    public void supprimerEquipement(@PathVariable Long id) {
        equipementService.supprimerEquipement(id);
    }
}