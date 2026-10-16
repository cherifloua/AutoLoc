package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employee;
import tn.esprit.autoloc.domain.RoleEmployee;

import java.util.List;

public interface IEmployeeService {

    Employee ajouterEmployee(Employee employee);

    Employee modifierEmployee(Employee employee);

    void supprimerEmployee(Long idEmployee);

    Employee getEmployee(Long idEmployee);

    List<Employee> getAllEmployees();

    List<Employee> getEmployeesByRole(RoleEmployee role);

    List<Employee> getEmployeesByAgence(Long idAgence);
}