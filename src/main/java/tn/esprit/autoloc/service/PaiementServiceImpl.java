package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.ModePaiement;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.IPaiementRepository;

import java.util.List;

@Service
public class PaiementServiceImpl implements IPaiementService {

    @Autowired
    private IPaiementRepository paiementRepository;

    @Override
    public Paiement ajouterPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement modifierPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void supprimerPaiement(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }

    @Override
    public Paiement getPaiement(Long idPaiement) {
        return paiementRepository.findById(idPaiement).orElse(null);
    }

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public List<Paiement> getPaiementsByMode(ModePaiement modePaiement) {
        return paiementRepository.findByModePaiement(modePaiement);
    }

    @Override
    public List<Paiement> getPaiementsByContrat(Long idContrat) {
        return paiementRepository.findByContratIdContrat(idContrat);
    }
}