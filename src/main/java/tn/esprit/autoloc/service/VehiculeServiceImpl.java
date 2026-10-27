package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.IVehiculeRepository;
import tn.esprit.autoloc.service.validator.VehiculeValidator;

import java.util.List;

@Service
public class VehiculeServiceImpl implements IVehiculeService {

    @Autowired
    private IVehiculeRepository vehiculeRepository;

    @Autowired
    private VehiculeValidator vehiculeValidator;

    @Autowired
    private JournalisationService journalisationService;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        vehiculeValidator.validerVehicule(vehicule);
        journalisationService.logAjoutVehicule(vehicule.getImmatriculation());
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        journalisationService.logModificationVehicule(vehicule.getImmatriculation());
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void supprimerVehicule(Long idVehicule) {
        journalisationService.logSuppressionVehicule(idVehicule);
        vehiculeRepository.deleteById(idVehicule);
    }

    @Override
    public Vehicule getVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule).orElse(null);
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public List<Vehicule> getVehiculesByStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }

    @Override
    public List<Vehicule> getVehiculesByAgence(Long idAgence) {
        return vehiculeRepository.findByAgenceIdAgence(idAgence);
    }
}