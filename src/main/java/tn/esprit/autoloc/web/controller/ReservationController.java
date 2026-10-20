package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.StatutReservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@Tag(name = "Gestion des Réservations", description = "API pour gérer les réservations de véhicules")
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @Operation(description = "Récupérer toutes les réservations")
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @Operation(description = "Récupérer une réservation par son ID")
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservation(id);
    }

    @Operation(description = "Filtrer les réservations par statut")
    @GetMapping("/statut/{statut}")
    public List<Reservation> getReservationsByStatut(@PathVariable StatutReservation statut) {
        return reservationService.getReservationsByStatut(statut);
    }

    @Operation(description = "Filtrer les réservations par client")
    @GetMapping("/client/{idClient}")
    public List<Reservation> getReservationsByClient(@PathVariable Long idClient) {
        return reservationService.getReservationsByClient(idClient);
    }

    @Operation(description = "Filtrer les réservations par véhicule")
    @GetMapping("/vehicule/{idVehicule}")
    public List<Reservation> getReservationsByVehicule(@PathVariable Long idVehicule) {
        return reservationService.getReservationsByVehicule(idVehicule);
    }

    @Operation(description = "Créer une nouvelle réservation")
    @PostMapping
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @Operation(description = "Modifier une réservation existante")
    @PutMapping("/{id}")
    public Reservation modifierReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setIdReservation(id);
        return reservationService.modifierReservation(reservation);
    }

    @Operation(description = "Supprimer une réservation par son ID")
    @DeleteMapping("/{id}")
    public void supprimerReservation(@PathVariable Long id) {
        reservationService.supprimerReservation(id);
    }
}