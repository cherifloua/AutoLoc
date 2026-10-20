package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@Tag(name = "Gestion des Clients", description = "API pour gérer les clients AutoLoc")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @Operation(description = "Récupérer tous les clients")
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @Operation(description = "Récupérer un client par son ID")
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @Operation(description = "Récupérer un client par son adresse email")
    @GetMapping("/email/{email}")
    public Client getClientByEmail(@PathVariable String email) {
        return clientService.getClientByEmail(email);
    }

    @Operation(description = "Créer un nouveau client")
    @PostMapping
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @Operation(description = "Modifier un client existant")
    @PutMapping("/{id}")
    public Client modifierClient(@PathVariable Long id, @RequestBody Client client) {
        client.setIdClient(id);
        return clientService.modifierClient(client);
    }

    @Operation(description = "Supprimer un client par son ID")
    @DeleteMapping("/{id}")
    public void supprimerClient(@PathVariable Long id) {
        clientService.supprimerClient(id);
    }
}