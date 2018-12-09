package pl.piotrdutkiewicz.teamconnect.data.team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pl.piotrdutkiewicz.teamconnect.MainApp;

@Entity
@Table(name = "Teams")
public final class Teams {

	private int id;
	private String name;
	private static final Logger logger = LogManager.getLogger(Teams.class);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		
		return id;
	}

	public void setId(int id) {
	
		this.id = id;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public String toString() {
		
		return id + " " + name;
	}
}
