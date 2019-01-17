package pl.piotrdutkiewicz.teamconnect.data.team;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TeamsRepository extends CrudRepository<Team, Integer> {
	Optional<Team> findByName(String name);
}
