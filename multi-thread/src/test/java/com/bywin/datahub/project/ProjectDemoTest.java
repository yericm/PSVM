package com.bywin.datahub.project;

import com.aliyun.datahub.client.DatahubClient;
import com.aliyun.datahub.client.model.CreateProjectResult;
import com.bywin.datahub.utils.DataHubClientUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * created by yeric on 2020/3/3
 */
public class ProjectDemoTest {

    private static DatahubClient dataHubClient;

    private String projectName = "projectByCode1";
    private String projectComment = "project's comment";

    @BeforeClass
    public static void setUp() {
        dataHubClient = DataHubClientUtil.getDataHubClient();
    }

    @Test
    public void createProject() {
        CreateProjectResult project = ProjectDemo.getInstance().createProject(dataHubClient, projectName, projectComment);
        assertNotNull(project);
    }

    @Test
    public void listProject() {
        ProjectDemo.getInstance().listProject(dataHubClient);
    }
    @Test
    public void updateProject() {
        ProjectDemo.getInstance().updateProject(dataHubClient, projectName, "新得秒大户");
    }
    @Test
    public void getProject() {
        ProjectDemo.getInstance().getProject(dataHubClient, projectName);
    }
    @Test
    public void deleteProject() {
        ProjectDemo.getInstance().deleteProject(dataHubClient, projectName);
    }
    @Test
    public void example() {
    }
}