package com.abnamro.nl.incidentmanagement.dto;

public class Incident {

	private String number;
	private String environment;
	private String project;
	
	

	public Incident() {
	}

	public Incident(String number, String environment, String project) {
		this.number = number;
		this.environment = environment;
		this.project = project;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

}
