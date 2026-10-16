package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public interface IClientService {

    Client ajouterClient(Client client);

    Client modifierClient(Client client);

    void supprimerClient(Long idClient);

    Client getClient(Long idClient);

    Client getClientByEmail(String email);

    List<Client> getAllClients();
}