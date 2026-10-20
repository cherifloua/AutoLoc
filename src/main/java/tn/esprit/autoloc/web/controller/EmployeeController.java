package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employee;
import tn.esprit.autoloc.domain.RoleEmployee;
import tn.esprit.autoloc.service.IEmployeeService;

import java.util.List;

@Tag(name = "Gestion des Employés", description = "API pour gérer les employés AutoLoc")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Operation(description = "Récupérer tous les employés")
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Operation(description = "Récupérer un employé par son ID")
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @Operation(description = "Filtrer les employés par rôle (AGENT, MANAGER)")
    @GetMapping("/role/{role}")
    public List<Employee> getEmployeesByRole(@PathVariable RoleEmployee role) {
        return employeeService.getEmployeesByRole(role);
    }

    @Operation(description = "Filtrer les employés par agence")
    @GetMapping("/agence/{idAgence}")
    public List<Employee> getEmployeesByAgence(@PathVariable Long idAgence) {
        return employeeService.getEmployeesByAgence(idAgence);
    }

    @Operation(description = "Créer un nouvel employé")
    @PostMapping
    public Employee ajouterEmployee(@RequestBody Employee employee) {
        return employeeService.ajouterEmployee(employee);
    }

    @Operation(description = "Modifier un employé existant")
    @PutMapping("/{id}")
    public Employee modifierEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setIdEmployee(id);
        return employeeService.modifierEmployee(employee);
    }

    @Operation(description = "Supprimer un employé par son ID")
    @DeleteMapping("/{id}")
    public void supprimerEmployee(@PathVariable Long id) {
        employeeService.supprimerEmployee(id);
    }
}