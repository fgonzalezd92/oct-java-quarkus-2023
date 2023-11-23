package com.herbalife.resource;

import com.herbalife.service.TrainingService;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/training")
public class TrainingResource {

    @Inject
    TrainingService trainingService;

    @GET
    @Path("/{title}")
    public String getInformation(@PathParam("title") String title) {
        //Log.info("Getting information about " + title);
        Log.infov("Getting information about {0}", title);
        return trainingService.getInformation(title);
    }

}
