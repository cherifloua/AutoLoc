package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@Tag(name = "Gestion des Agences", description = "API pour gérer les agences AutoLoc")
@RestController
@RequestMapping("/agences")
public class AgenceController {

    @Autowired
    private IAgenceService agenceService;

    @Operation(description = "Récupérer toutes les agences de la base de données")
    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.getAllAgences();
    }

    @Operation(description = "Récupérer une agence par son ID")
    @GetMapping("/{id}")
    public Agence getAgenceById(@PathVariable Long id) {
        return agenceService.getAgence(id);
    }

    @Operation(description = "Créer une nouvelle agence")
    @PostMapping
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @Operation(description = "Modifier une agence existante")
    @PutMapping("/{id}")
    public Agence modifierAgence(@PathVariable Long id, @RequestBody Agence agence) {
        agence.setIdAgence(id);
        return agenceService.modifierAgence(agence);
    }

    @Operation(description = "Supprimer une agence par son ID")
    @DeleteMapping("/{id}")
    public void supprimerAgence(@PathVariable Long id) {
        agenceService.supprimerAgence(id);
    }

    @Operation(description = "Filtrer les agences par ville")
    @GetMapping("/ville/{ville}")
    public List<Agence> getAgencesByVille(@PathVariable String ville) {
        return agenceService.getAgencesByVille(ville);
    }
}