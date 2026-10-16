package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Employee;
import tn.esprit.autoloc.domain.RoleEmployee;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByRole(RoleEmployee role);

    List<Employee> findByAgenceIdAgence(Long idAgence);
}