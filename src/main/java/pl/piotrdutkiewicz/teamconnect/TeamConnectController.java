package pl.piotrdutkiewicz.teamconnect;

import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import javassist.NotFoundException;
import pl.piotrdutkiewicz.teamconnect.data.employee.Employee;
import pl.piotrdutkiewicz.teamconnect.data.employee.EmployeeRepository;
import pl.piotrdutkiewicz.teamconnect.data.team.Team;
import pl.piotrdutkiewicz.teamconnect.data.team.TeamsRepository;
import pl.piotrdutkiewicz.teamconnect.exception.ApiError;
import pl.piotrdutkiewicz.teamconnect.exception.ApiResourceNotFoundException;

@RestController
@Controller
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
@Validated
public class TeamConnectController {

	private static final Logger logger = LogManager.getLogger(TeamConnectController.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TeamsRepository teamsRepository;

	private final ObjectMapper mapper = new ObjectMapper();

	@GetMapping(path = "/employees")
	public String getEmployees() {
		logger.debug(" getting all epmloyees");
		return convertToJson(employeeRepository.findAll());
	}

	@GetMapping(path = "/employee")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeeByName(@Valid @Length(max = 5) @RequestParam("name") String name)
			throws ApiResourceNotFoundException {
		Employee employee = employeeRepository.findByName(name).orElseThrow(() -> ApiResourceNotFoundException.builder()
				.withMessage("Resource not found").withDetail("For requested parameter employee not exist.").build());
		logger.debug(" getting employees by name");
		return convertToJson(employee);
	}

	@GetMapping(path = "/teams")
	public String getTeams() {
		logger.debug(" getting all teams");
		return convertToJson(teamsRepository.findAll());
	}

	@GetMapping(path = "/team")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTeamByName(@Valid @NotNull @Length(max = 5) @RequestParam("name") String name) 
		throws ApiResourceNotFoundException {
			Team team = teamsRepository.findByName(name).orElseThrow(()->ApiResourceNotFoundException.builder()
					.withMessage("Resource not found").withDetail("For requested parameter team not exist.").build());
			return convertToJson(team);
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
