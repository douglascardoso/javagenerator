package org.gen.core.beans;

/**
 * Created by douglas on 02/12/16.
 */
public class Dependency {

    private String groupId;
    private String artifactId;
    private String version;
    private String scope;

    public Dependency() {
    }

    public Dependency(String groupId, String artifactId) {
        this(groupId, artifactId, null, null);
    }

    public Dependency(String groupId, String artifactId, String version) {
        this(groupId, artifactId, version, null);
    }

    public Dependency(String groupId, String artifactId, Scope scope) {
        this(groupId, artifactId, null, scope);
    }

    public Dependency(String groupId, String artifactId, String version, Scope scope) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.scope = (scope != null) ? scope.value() : null;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public enum Scope {

        RUNTIME("runtime"),
        TEST("test"),
        COMPILE("compile"),
        PROVIDED("provided"),
        SYSTEM("system");

        private String version;

        Scope(String version) {
            this.version = version;
        }

        public String value() {
            return this.version;
        }
    }
}
