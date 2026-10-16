package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Agence;

import java.util.List;

@Repository
public interface IAgenceRepository extends JpaRepository<Agence, Long> {

    List<Agence> findByVille(String ville);
}