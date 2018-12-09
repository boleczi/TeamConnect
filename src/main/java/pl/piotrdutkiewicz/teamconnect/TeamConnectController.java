package pl.piotrdutkiewicz.teamconnect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import pl.piotrdutkiewicz.teamconnect.data.employee.EmployeeRepository;
import pl.piotrdutkiewicz.teamconnect.data.team.TeamsRepository;

@RestController
@Controller
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public final class TeamConnectController {

	private static final Logger logger = LogManager.getLogger(TeamConnectController.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TeamsRepository teamsRepository;

	private final ObjectMapper mapper = new ObjectMapper();

	@GetMapping(path = "/employee")
	public String getEmployees() {
		logger.debug(" getting all epmloyees");
		return convertToJson(employeeRepository.findAll());
	}

	@GetMapping(path = "/employee/name/{name}")
	public String getEmployeeByName(@PathVariable String name) {
		logger.debug(" getting employees by name");
		return convertToJson(employeeRepository.findByName(name));
	}

	@GetMapping(path = "/teams")
	public String getTeams() {
		logger.debug(" getting all teams");
		return convertToJson(teamsRepository.findAll());
	}

	@GetMapping(path = "/team")
	public String getTeamByName(@RequestParam("name") String name)  {
		logger.debug(" getting employees by name");
		return convertToJson(teamsRepository.findByName(name));

	}

	private String convertToJson(Object value) {

		try {
			return mapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			logger.error("JsonProcessingException", e);
			
		}
		return null;

	}
}
