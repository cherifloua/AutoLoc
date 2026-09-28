package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @Column(nullable = false, name = "date_signature")
    private LocalDate dateSignature;

    @Column(nullable = false, precision = 10, scale = 2, name = "montant_total")
    private BigDecimal montantTotal;

    @Column(nullable = false)
    private Boolean valide;

    // 1 Contrat ↔ 1 Reservation (côté propriétaire)
    @OneToOne
    @JoinColumn(name = "reservation_id", unique = true)
    private Reservation reservation;

    // 1 Contrat → N Paiement (cascade = ALL)
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL)
    private List<Paiement> paiements = new ArrayList<>();
}