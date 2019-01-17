package pl.piotrdutkiewicz.teamconnect.data.employee;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	Optional<Employee> findByName(String name);
}
