package org.gen.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by douglas on 02/12/16.
 */
public interface GeneratorResource {

    String PATH = "/generator";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response listArchetypes();
}
