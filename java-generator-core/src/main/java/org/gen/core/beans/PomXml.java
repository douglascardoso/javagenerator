package org.gen.core.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by douglas on 05/12/16.
 */
public class PomXml {

    private Dependency parent;

    private String modelVersion;

    private Packaging packaging;

    private String groupId;
    private String artifactId;
    private String name;
    private String description;

    private List<Dependency> dependencies = new ArrayList<>();

    private List<Plugin> plugins = new ArrayList<>();

    public Dependency getParent() {
        return parent;
    }

    public void setParent(Dependency parent) {
        this.parent = parent;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    public List<Plugin> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<Plugin> plugins) {
        this.plugins = plugins;
    }

    public enum Packaging {
        WAR("war"),
        POM("pom"),
        JAR("jar");

        private String value;

        Packaging(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
