package pl.piotrdutkiewicz.teamconnect.data.team;

import org.springframework.data.repository.CrudRepository;

public interface TeamsRepository extends CrudRepository<Team, Integer> {
	Team findByName(String name);
}
