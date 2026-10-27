package tn.esprit.autoloc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JournalisationService {

    private static final Logger logger = LoggerFactory.getLogger(JournalisationService.class);

    public void logAjoutVehicule(String immatriculation) {
        logger.info("[AutoLoc] Ajout d'un véhicule : {}", immatriculation);
    }

    public void logModificationVehicule(String immatriculation) {
        logger.info("[AutoLoc] Modification du véhicule : {}", immatriculation);
    }

    public void logSuppressionVehicule(Long id) {
        logger.info("[AutoLoc] Suppression du véhicule avec ID : {}", id);
    }
}