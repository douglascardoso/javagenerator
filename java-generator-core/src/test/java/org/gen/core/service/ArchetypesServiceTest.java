package org.gen.core.service;

import org.gen.core.beans.PomXml;
import org.gen.core.service.impl.ArchetypesServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by douglas on 02/12/16.
 */

public class ArchetypesServiceTest {

    @Test
    public void openZipFileFromClassLoaderAsInputStream() {
        InputStream zipStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("default.zip");
        Assert.assertNotNull(zipStream);
    }

    @Test
    public void loadPom() {
        ArchetypesService service = new ArchetypesServiceImpl();
        PomXml pom = service.loadArchetype("webservice-jersey");
        Assert.assertNotNull(pom);
        Assert.assertNotNull(pom.getDependencies());
        Assert.assertNotNull(pom.getPlugins());
    }


}
