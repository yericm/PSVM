package com.bywin.datahub.project;

import com.aliyun.datahub.client.DatahubClient;
import com.bywin.datahub.utils.DataHubClientUtil;
import org.apache.poi.ss.formula.functions.T;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * created by yeric on 2020/3/3
 */
public class TopicDemoTest {

    private static DatahubClient dataHubClient;

    private String projectName = "projectByCode";
    private String topicName = "BlobTopic";
    private String topicComment = "BlobTopic的描述信息";


    @BeforeClass
    public static void setUp() {
        dataHubClient = DataHubClientUtil.getDataHubClient();
    }

    @Test
    public void createTupleTopic() {
        TopicDemo.getInstance().createTupleTopic(dataHubClient, projectName, topicName, 3,2,topicComment);
    }

    @Test
    public void appendNewField() {
        TopicDemo.getInstance().appendNewField(dataHubClient, projectName, topicName);
    }

    @Test
    public void getTopic() {
        TopicDemo.getInstance().getTopic(dataHubClient, projectName, topicName);
    }

    @Test
    public void updateTopic() {
        TopicDemo.getInstance().updateTopic(dataHubClient,projectName, topicName);
    }

    @Test
    public void listTopic() {
        TopicDemo.getInstance().listTopic(dataHubClient, projectName);
    }

    @Test
    public void deleteTopic() {
        TopicDemo.getInstance().deleteTopic(dataHubClient, projectName, topicName);
    }

    @Test
    public void createBlobTopic() {
        TopicDemo.getInstance().createBlobTopic(dataHubClient, projectName, topicName, 1,2,topicComment);
    }
}