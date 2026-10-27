package tn.esprit.autoloc.service.tarification;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TarificationService {

    private final Map<String, StrategieTarification> strategies;

    public TarificationService(Map<String, StrategieTarification> strategies) {
        this.strategies = strategies;
    }

    public double calculer(String typeTarif, double tarifJournalier, int jours) {
        StrategieTarification strategie = strategies.get(typeTarif.toUpperCase());
        if (strategie == null) {
            throw new IllegalArgumentException("Type de tarification inconnu : " + typeTarif);
        }
        return strategie.calculer(tarifJournalier, jours);
    }
}