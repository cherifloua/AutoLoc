package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.StatutReservation;
import tn.esprit.autoloc.repository.IReservationRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimerReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation getReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByStatut(StatutReservation statut) {
        return reservationRepository.findByStatut(statut);
    }

    @Override
    public List<Reservation> getReservationsByClient(Long idClient) {
        return reservationRepository.findByClientIdClient(idClient);
    }

    @Override
    public List<Reservation> getReservationsByVehicule(Long idVehicule) {
        return reservationRepository.findByVehiculeIdVehicule(idVehicule);
    }
}