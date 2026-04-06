package controller;

import dto.RequestDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.PatientAgent;

@Path("/request")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RequestController {

    @Inject
    PatientAgent agent;

    @POST
    public String request(RequestDTO request){

        return agent.chat(request.request());
    }
}
