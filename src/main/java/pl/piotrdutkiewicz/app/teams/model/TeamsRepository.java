package pl.piotrdutkiewicz.app.teams.model;

import org.springframework.data.repository.CrudRepository;

public interface TeamsRepository extends CrudRepository<Teams, Integer> {
	Teams findByName(String name);
}
