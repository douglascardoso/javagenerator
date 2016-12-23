package org.gen.core.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.gen.core.beans.Archetype;
import org.gen.core.beans.Dependency;
import org.gen.core.beans.Plugin;
import org.gen.core.beans.PomXml;
import org.gen.core.service.ArchetypesService;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * Created by douglas on 02/12/16.
 */
@Service
public class ArchetypesServiceImpl implements ArchetypesService {

    @Override
    public List<Archetype> list() {
        List<Archetype> archetypes = createList();
        return archetypes;
    }

    private List<Archetype> createList() {
        List<Archetype> archetypes = new ArrayList<>();
        archetypes.add(new Archetype("test"));
        archetypes.add(new Archetype("test1"));
        archetypes.add(new Archetype("test2"));

        return archetypes;
    }

    @Override
    public void unzipFile() {

        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("ss"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PomXml loadArchetype(String archetypeName) {
        InputStream dependenciesStream = this.getClass().getClassLoader().getResourceAsStream(String.format("archetypes/%s/dependencies.json", archetypeName));
        InputStream pluginsStream = this.getClass().getClassLoader().getResourceAsStream(String.format("archetypes/%s/plugins.json", archetypeName));
        ObjectMapper objectMapper = new ObjectMapper();
        PomXml pom = new PomXml();
        try {
            Dependency[] dependencies = objectMapper.readValue(dependenciesStream, Dependency[].class);
            Plugin[] plugins = objectMapper.readValue(pluginsStream, Plugin[].class);

            pom.setDependencies(Arrays.asList(dependencies));
            pom.setPlugins(Arrays.asList(plugins));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pom;
    }
}
