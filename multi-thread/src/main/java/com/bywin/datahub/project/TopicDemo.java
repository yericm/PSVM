package com.bywin.datahub.project;

import com.aliyun.datahub.client.DatahubClient;
import com.aliyun.datahub.client.exception.*;
import com.aliyun.datahub.client.model.*;

/**
 * created by yeric on 2020/3/3
 */
public class TopicDemo {

    private static final TopicDemo instance = new TopicDemo();

    public static TopicDemo getInstance () {
        return instance;
    }

    /**
     * 创建 Tuple Topic
     * @param dataHubClient
     * @param projectName
     * @param topicName
     * @param shardCount
     * @param lifeCycle
     * @param comment
     */
    public void createTupleTopic(DatahubClient dataHubClient, String projectName, String topicName, int shardCount, int lifeCycle, String comment) {
        RecordSchema schema = new RecordSchema();
        schema.addField(new Field("bigint_field", FieldType.BIGINT));
        schema.addField(new Field("double_field", FieldType.DOUBLE));
        schema.addField(new Field("boolean_field", FieldType.BOOLEAN));
        schema.addField(new Field("timestamp_field", FieldType.TIMESTAMP));
        schema.addField(new Field("string_field", FieldType.STRING));
        try {
            dataHubClient.createTopic(projectName, topicName, shardCount, lifeCycle, RecordType.TUPLE, schema, comment);
            System.out.println("create topic successful");
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println(" project not found,please create project first");
            System.exit(1);
        } catch (ResourceAlreadyExistException e) {
            System.out.println("topic already exists,create topic successful");
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.exit(1);
        }
    }

    /**
     * Tuple Topic 新增 Field
     * @param dataHubClient
     * @param projectName
     * @param topicName
     */
    public void appendNewField(DatahubClient dataHubClient, String projectName, String topicName) {
        try {
            Field newField = new Field("newField", FieldType.STRING, true);
            dataHubClient.appendField(projectName, topicName, newField);
            System.out.println("append field successful");
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project or topic not found");
            System.exit(1);
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.exit(1);
        }
    }

    /**
     * 查询 Topic
     */
    public void getTopic(DatahubClient dataHubClient,  String projectName, String topicName) {
        try {
            GetTopicResult getTopicResult = dataHubClient.getTopic(projectName, topicName);
            System.out.println(getTopicResult.getShardCount() + "\t"
                    + getTopicResult.getLifeCycle() + "\t"
                    + getTopicResult.getRecordType() + "\t"
                    + getTopicResult.getComment());
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project or topic not found");
            System.exit(1);
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.exit(1);
        }
    }

    /**
     * 更新 Topic
     */
    public void updateTopic(DatahubClient dataHubClient,  String projectName, String topicName) {
        try {
            String newComment = "new topic comment";
            dataHubClient.updateTopic(projectName, topicName, newComment);
            System.out.println("update topic successful");
            //查看更新后结果
            GetTopicResult getTopicResult = dataHubClient.getTopic(projectName, topicName);
            System.out.println(getTopicResult.getComment());
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project or topic not found");
            System.exit(1);
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.exit(1);
        }
    }

    /**
     * 列出 Topic
     */
    public void listTopic(DatahubClient dataHubClient, String projectName) {
        try {
//            dataHubClient.deleteTopic(projectName, topicName);
            ListTopicResult listTopicResult = dataHubClient.listTopic(projectName);
            if (listTopicResult.getTopicNames().size() > 0) {
                for (String tName : listTopicResult.getTopicNames()) {
                    System.out.println(tName);
                }
            }
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project not found");
            System.exit(1);
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.exit(1);
        }
    }

    /**
     * 删除 Topic
     */
    public void deleteTopic(DatahubClient dataHubClient, String projectName, String topicName) {
        try {
            dataHubClient.deleteTopic(projectName, topicName);
            System.out.println("delete topic successful");
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project or topic not found");
            System.exit(1);
        } catch (ResourceAlreadyExistException e) {
            System.out.println("topic already exists,create topic successful");
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.exit(1);
        }
    }

    /**
     * 创建 Blob Topic
     */
    public void createBlobTopic(DatahubClient dataHubClient, String projectName, String blobTopicName, int shardCount, int lifeCycle,  String topicComment) {
        try {
            dataHubClient.createTopic(projectName, blobTopicName, shardCount, lifeCycle, RecordType.BLOB, topicComment);
            System.out.println("create topic successful");
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println(" project not found,please create project first");
            System.exit(1);
        } catch (ResourceAlreadyExistException e) {
            System.out.println("topic already exists,create topic successful");
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.exit(1);
        }
    }
}
