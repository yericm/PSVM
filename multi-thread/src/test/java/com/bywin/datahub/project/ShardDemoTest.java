package com.bywin.datahub.project;

import com.aliyun.datahub.client.DatahubClient;
import com.bywin.datahub.utils.DataHubClientUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * created by yeric on 2020/3/3
 */
public class ShardDemoTest {

    private static DatahubClient dataHubClient;

    private String projectName = "projectbycode";
    private String tupleTopic = "topicbycode";
    private String blobTopic = "blobtopic";


    @BeforeClass
    public static void setUp() {
        dataHubClient = DataHubClientUtil.getDataHubClient();
    }

    @Test
    public void listShard() {
        ShardDemo.getInstance().listShard(dataHubClient, projectName, tupleTopic);
    }

    @Test
    public void splitShard() {
        ShardDemo.getInstance().splitShard(dataHubClient, projectName, tupleTopic, "2");
    }

    @Test
    public void mergeShard() {
        ShardDemo.getInstance().mergeShard(dataHubClient, projectName, tupleTopic, "4","3");
    }
    @Test
    public void getcursor() {
        ShardDemo.getInstance().getcursor(dataHubClient, projectName, tupleTopic, "7");
    }
    @Test
    public void tupleExample() {
        ShardDemo.getInstance().tupleExample(dataHubClient, projectName, tupleTopic, "7");
    }
    @Test
    public void blobExample() {
        ShardDemo.getInstance().blobExample(dataHubClient, projectName, blobTopic, "2");
    }
    @Test
    public void readBlobTopic() {
        ShardDemo.getInstance().readBlobTopic(dataHubClient, projectName, blobTopic, "2");
    }
    @Test
    public void readTupleTopic() {
        ShardDemo.getInstance().readTupleTopic(dataHubClient, projectName, tupleTopic, "7");
    }
}