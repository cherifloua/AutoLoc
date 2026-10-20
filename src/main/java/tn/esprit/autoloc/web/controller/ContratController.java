package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@Tag(name = "Gestion des Contrats", description = "API pour gérer les contrats de location")
@RestController
@RequestMapping("/contrats")
public class ContratController {

    @Autowired
    private IContratService contratService;

    @Operation(description = "Récupérer tous les contrats")
    @GetMapping
    public List<Contrat> getAllContrats() {
        return contratService.getAllContrats();
    }

    @Operation(description = "Récupérer un contrat par son ID")
    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.getContrat(id);
    }

    @Operation(description = "Filtrer les contrats par validité (true/false)")
    @GetMapping("/valide/{valide}")
    public List<Contrat> getContratsValides(@PathVariable Boolean valide) {
        return contratService.getContratsValides(valide);
    }

    @Operation(description = "Créer un nouveau contrat")
    @PostMapping
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @Operation(description = "Modifier un contrat existant")
    @PutMapping("/{id}")
    public Contrat modifierContrat(@PathVariable Long id, @RequestBody Contrat contrat) {
        contrat.setIdContrat(id);
        return contratService.modifierContrat(contrat);
    }

    @Operation(description = "Supprimer un contrat par son ID")
    @DeleteMapping("/{id}")
    public void supprimerContrat(@PathVariable Long id) {
        contratService.supprimerContrat(id);
    }
}