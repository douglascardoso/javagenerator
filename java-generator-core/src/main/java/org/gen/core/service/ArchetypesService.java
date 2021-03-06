package org.gen.core.service;

import org.gen.core.beans.Archetype;
import org.gen.core.beans.PomXml;

import java.util.List;

/**
 * Created by douglas on 02/12/16.
 */
public interface ArchetypesService {

    List<Archetype> list();

    void unzipFile();

    PomXml loadArchetype(String name);
}
