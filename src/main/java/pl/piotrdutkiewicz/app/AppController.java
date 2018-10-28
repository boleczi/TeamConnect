package pl.piotrdutkiewicz.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.piotrdutkiewicz.app.employees.data.employee.EmployeeRepository;
import pl.piotrdutkiewicz.app.teams.model.TeamsRepository;

@RestController
@Controller
public final class AppController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TeamsRepository teamsRepository;

	private final ObjectMapper mapper = new ObjectMapper();

	@GetMapping(path = "/employee")
	public String getEmployees() throws JsonProcessingException {
		return mapper.writeValueAsString(employeeRepository.findAll());
	}

	@GetMapping(path = "/employee/name/{name}")
	public String getEmployeeByName(@PathVariable String name) throws JsonProcessingException {
		return mapper.writeValueAsString(employeeRepository.findByName(name));
	}

	@GetMapping(path = "/team")
	public String getTeams() throws JsonProcessingException {
		return mapper.writeValueAsString(teamsRepository.findAll());
	}

	@GetMapping(path = "/teams/name/{name}")
	public String getTeamByName(@PathVariable String name) throws JsonProcessingException {
		return mapper.writeValueAsString(teamsRepository.findByName(name));
	}

}
