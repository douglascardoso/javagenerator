<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>java-generator</artifactId>
        <groupId>org.gen</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <packaging>jar</packaging>

    <artifactId>java-generator-rest</artifactId>
    <dependencies>
      <#list pom.dependencies as dependency>
        <dependency>
            <groupId>${dependency.groupId}</groupId>
            <artifactId>${dependency.artifactId}</artifactId>
            <#if dependency.scope??>
            <scope>${dependency.scope}</scope>
            </#if>
        </dependency>
      </#list>
    </dependencies>
    <build>
        <#if pom.plugins?has_content>
        <plugins>
            <#list pom.plugins as plugin>
            <plugin>
                <groupId>${plugin.groupId}</groupId>
                <artifactId>${plugin.artifactId}</artifactId>
                <#if plugin.executions?has_content>
                <executions>
                    <#list plugin.executions as execution>
                    <execution>
                        <#if execution.goals?has_content>
                        <goals>
                            <#list execution.goals as goal>
                            <goal>${goal}</goal>
                            </#list>
                        </goals>
                        </#if>
                    </execution>
                    </#list>
                </executions>
                </#if>
            </plugin>
            </#list>
        </plugins>
        </#if>
    </build>
</project>