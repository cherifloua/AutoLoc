package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employee;
import tn.esprit.autoloc.domain.RoleEmployee;
import tn.esprit.autoloc.repository.IEmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee ajouterEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee modifierEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void supprimerEmployee(Long idEmployee) {
        employeeRepository.deleteById(idEmployee);
    }

    @Override
    public Employee getEmployee(Long idEmployee) {
        return employeeRepository.findById(idEmployee).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesByRole(RoleEmployee role) {
        return employeeRepository.findByRole(role);
    }

    @Override
    public List<Employee> getEmployeesByAgence(Long idAgence) {
        return employeeRepository.findByAgenceIdAgence(idAgence);
    }
}