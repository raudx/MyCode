package com.abnamro.nl.incidentmanagement.restweb;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.abnamro.nl.incidentmanagement.dto.Incident;
import com.abnamro.nl.incidentmanagement.dto.IncidentWrapper;
import com.abnamro.nl.incidentmanagement.services.IncidentService;

@Path("incident")
public class IncidentRestWeb {

    @GET
    @Path("/readFile")
    @Produces(MediaType.APPLICATION_JSON)
    public IncidentWrapper convertExcelToJson() throws IOException {
    	IncidentWrapper incidentWrapper = new IncidentWrapper();
    	IncidentService service = new IncidentService();
    	ArrayList<Incident> incidents = (ArrayList<Incident>) service.readFromExcel();
    	incidentWrapper.setIncident(incidents);
		return incidentWrapper;
    	
    }
}
