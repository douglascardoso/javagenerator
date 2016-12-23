package org.gen.core.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.gen.core.beans.Dependency;
import org.gen.core.beans.Plugin;
import org.gen.core.beans.PomXml;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by douglas on 05/12/16.
 */
public class FreemarkerTemplateTest {

    @Test
    public void openFreemarkerTemplate() {

        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        URL templatesUrl = this.getClass().getClassLoader().getResource("templates/");

        try {
            cfg.setDirectoryForTemplateLoading(new File(templatesUrl.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
        Map root = new HashMap();
        PomXml pom = getPom();
        root.put("pom", pom);

        /* Get the template (uses cache internally) */
        Template temp = null;
        try {
            temp = cfg.getTemplate("pom.xml.ftlh");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        try {
            temp.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
    }

    private PomXml getPom() {
        PomXml pom = new PomXml();

        pom.getDependencies().add(new Dependency("org.springframework", "spring-webmvc"));
        pom.getDependencies().add(new Dependency("junit4", "junit4", Dependency.Scope.TEST));
        List<Plugin.Execution> executions = new ArrayList<>();
        List<String> goals = new ArrayList<>();
        goals.add("repackage");
        Plugin.Execution execution = new Plugin.Execution();
        execution.setGoals(goals);
        executions.add(execution);
        pom.getPlugins().add(new Plugin("org.springframework.boot", "spring-boot-maven-plugin", executions));

        return pom;
    }

}
