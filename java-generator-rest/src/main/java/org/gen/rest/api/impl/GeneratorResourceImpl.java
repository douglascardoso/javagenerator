package org.gen.rest.api.impl;

import org.gen.core.beans.Archetype;
import org.gen.core.service.ArchetypesService;
import org.gen.rest.api.GeneratorResource;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by douglas on 02/12/16.
 */
@Component
@Path(GeneratorResourceImpl.PATH)
public class GeneratorResourceImpl implements GeneratorResource {

    @Inject
    private ArchetypesService archetypesService;

    @Override
    public Response listArchetypes() {
        List<Archetype> archetypes = archetypesService.list();
        return Response.ok(archetypes).build();
    }
}
