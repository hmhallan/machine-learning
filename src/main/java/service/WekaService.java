package service;

import entity.Flor;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/weka")
public class WekaService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/classificar")
    public String classificar(Flor flor){
        System.out.println(flor);
        return "Vai planeta";
    }

}



