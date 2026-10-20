package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.ModePaiement;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@Tag(name = "Gestion des Paiements", description = "API pour gérer les paiements des contrats")
@RestController
@RequestMapping("/paiements")
public class PaiementController {

    @Autowired
    private IPaiementService paiementService;

    @Operation(description = "Récupérer tous les paiements")
    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @Operation(description = "Récupérer un paiement par son ID")
    @GetMapping("/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiement(id);
    }

    @Operation(description = "Filtrer les paiements par mode (CARTE, ESPECES, VIREMENT)")
    @GetMapping("/mode/{mode}")
    public List<Paiement> getPaiementsByMode(@PathVariable ModePaiement mode) {
        return paiementService.getPaiementsByMode(mode);
    }

    @Operation(description = "Filtrer les paiements par contrat")
    @GetMapping("/contrat/{idContrat}")
    public List<Paiement> getPaiementsByContrat(@PathVariable Long idContrat) {
        return paiementService.getPaiementsByContrat(idContrat);
    }

    @Operation(description = "Créer un nouveau paiement")
    @PostMapping
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @Operation(description = "Modifier un paiement existant")
    @PutMapping("/{id}")
    public Paiement modifierPaiement(@PathVariable Long id, @RequestBody Paiement paiement) {
        paiement.setIdPaiement(id);
        return paiementService.modifierPaiement(paiement);
    }

    @Operation(description = "Supprimer un paiement par son ID")
    @DeleteMapping("/{id}")
    public void supprimerPaiement(@PathVariable Long id) {
        paiementService.supprimerPaiement(id);
    }
}