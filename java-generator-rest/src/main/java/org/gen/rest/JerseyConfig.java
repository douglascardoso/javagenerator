package org.gen.rest;

import org.gen.rest.api.impl.GeneratorResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by douglas on 02/12/16.
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(GeneratorResourceImpl.class);
    }
}
