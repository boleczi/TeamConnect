package pl.piotrdutkiewicz.teamconnect.data.employee;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.swagger.annotations.ApiModelProperty;
import pl.piotrdutkiewicz.teamconnect.data.team.Teams;

@Entity
@Table(name = "Employee")
public final class Employee {
	@ApiModelProperty(notes = " ID")
	private int id;
	@ApiModelProperty(notes = "name")
	private String name;
	@ApiModelProperty(notes = "surname")
	private String surname;
	@ApiModelProperty(notes = "position")
	private String position;
	@ApiModelProperty(notes = "department")
	private String department;
	@ApiModelProperty(notes = "employmentDate")
	private Date employmentDate;
	@ApiModelProperty(notes = "salary")
	private int salary;
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

	public String getSurname() {
	
		return surname;
	}

	public void setSurname(String surname) {
		
		this.surname = surname;
	}

	public String getPosition() {
	
		return position;
	}

	public void setPosition(String position) {
		
		this.position = position;
	}

	public String getDepartment() {
	
		return department;
	}

	public void setDepartment(String department) {
		
		this.department = department;
	}

	public Date getEmploymentDate() {
	
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate) {
		
		this.employmentDate = employmentDate;
	}

	public int getSalary() {
		
		return salary;
	}

	public void setSalary(int salary) {
		
		this.salary = salary;
	}

	public String toString() {
		

		return name + " " + surname + " " + position + " " + department + " " + " " + salary;

	}
}
