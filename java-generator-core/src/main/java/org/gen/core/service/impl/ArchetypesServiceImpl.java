package org.gen.core.service.impl;

import org.gen.core.beans.Archetype;
import org.gen.core.service.ArchetypesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
