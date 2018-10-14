package pl.piotrdutkiewicz.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.piotrdutkiewicz.app.employees.data.employee.Employee;
import pl.piotrdutkiewicz.app.employees.data.employee.EmployeeRepository;

@RestController
public class AppController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path = "/")
	public String get() {
		Employee employee = employeeRepository.findByName("John");
		return employee.toString() ;

	}

}
