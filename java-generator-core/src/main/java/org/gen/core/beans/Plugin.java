package org.gen.core.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by douglas on 05/12/16.
 */
public class Plugin {

    private String groupId;
    private String artifactId;
    private List<Execution> executions = new ArrayList<>();

    public Plugin() {

    }

    public Plugin(String groupId, String artifactId) {
        this(groupId, artifactId, null);
    }

    public Plugin(String groupId, String artifactId, List<Execution> executions) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.executions = executions;
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

    public List<Execution> getExecutions() {
        return executions;
    }

    public void setExecutions(List<Execution> executions) {
        this.executions = executions;
    }

    public static class Execution {

        List<String> goals = new ArrayList<>();

        public List<String> getGoals() {
            return goals;
        }

        public void setGoals(List<String> goals) {
            this.goals = goals;
        }
    }
}
