package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.StatutReservation;

import java.util.List;

public interface IReservationService {

    Reservation ajouterReservation(Reservation reservation);

    Reservation modifierReservation(Reservation reservation);

    void supprimerReservation(Long idReservation);

    Reservation getReservation(Long idReservation);

    List<Reservation> getAllReservations();

    List<Reservation> getReservationsByStatut(StatutReservation statut);

    List<Reservation> getReservationsByClient(Long idClient);

    List<Reservation> getReservationsByVehicule(Long idVehicule);
}