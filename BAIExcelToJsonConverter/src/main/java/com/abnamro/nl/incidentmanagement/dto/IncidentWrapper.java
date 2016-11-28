package com.abnamro.nl.incidentmanagement.dto;

import java.util.ArrayList;
import java.util.List;

public class IncidentWrapper {

	List<Incident> incident = new ArrayList<Incident>();

	public List<Incident> getIncident() {
		return incident;
	}

	public void setIncident(List<Incident> incident) {
		this.incident = incident;
	}

}
