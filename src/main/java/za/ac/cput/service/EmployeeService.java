package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee read(Long id) {
        return repository.findById(id).orElse(null);
    }

//    @Override
//    public Employee read(Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Employee with id " + id + " not found"));
//    }

    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }



    @Override
    public List<Employee> getall() {
        return repository.findAll();
    }
}
