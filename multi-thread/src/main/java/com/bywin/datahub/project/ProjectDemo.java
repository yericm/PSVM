package com.bywin.datahub.project;

import com.aliyun.datahub.client.DatahubClient;
import com.aliyun.datahub.client.exception.*;
import com.aliyun.datahub.client.model.*;
import com.aliyun.datahub.exception.OffsetResetedException;
import com.aliyun.datahub.exception.OffsetSessionChangedException;
import com.bywin.datahub.utils.DataHubClientUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by yeric on 2020/3/3
 */
public class ProjectDemo {

    private static final ProjectDemo instance = new ProjectDemo();

    public static ProjectDemo getInstance () {
        return instance;
    }

    /**
     * 创建 Project
     * @param dataHubClient
     * @param projectName
     * @param projectComment
     * @return
     */
    public CreateProjectResult createProject (DatahubClient dataHubClient, String projectName, String projectComment) {
        try {
            return DataHubClientUtil.getDataHubClient().createProject(projectName, projectComment);
        } catch (InvalidParameterException e) {
            throw new RuntimeException("invalid parameter");
        } catch (AuthorizationFailureException e) {
            throw new RuntimeException("AK error, please check your accessId and accessKey");
        } catch (ResourceAlreadyExistException e) {
            throw new RuntimeException("project already exists");
        } catch (DatahubClientException e) {
            throw new RuntimeException("other error");
        }
    }

    /**
     * 删除 Project
     * @param dataHubClient
     * @param projectName
     * @return
     */
    public void deleteProject(DatahubClient dataHubClient, String projectName) {
        try {
            DeleteProjectResult deleteProjectResult = dataHubClient.deleteProject(projectName);
            System.out.println("delete project successful");
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project not found, delete successful");
        } catch (NoPermissionException e) {
            System.out.println("project has topic, can not delete, please delete topic first");
            System.exit(1);
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.exit(1);
        }
    }

    /**
     * 更新 Project
     * @param dataHubClient
     * @param projectName
     * @param newComment
     */
    public  void updateProject(DatahubClient dataHubClient, String projectName, String newComment) {
        try {
            dataHubClient.updateProject(projectName, newComment);
            System.out.println("update project successful");
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
     * 列出 Project
     * @param dataHubClient
     */
    public  void listProject(DatahubClient dataHubClient) {
        try {
            ListProjectResult listProjectResult = dataHubClient.listProject();
            if (listProjectResult.getProjectNames().size() > 0) {
                for (String pName : listProjectResult.getProjectNames()) {
                    System.out.println(pName);
                }
            }
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.exit(1);
        }
    }

    /**
     * 查询 Project
     * @param dataHubClient
     * @param projectName
     */
    public void getProject(DatahubClient dataHubClient, String projectName) {
        try {
            GetProjectResult getProjectResult = dataHubClient.getProject(projectName);
            System.out.println(getProjectResult.getCreateTime() + "\t"
                    + getProjectResult.getLastModifyTime() + "\t"
                    + getProjectResult.getComment());
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project not found, get project failed");
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.exit(1);
        }
    }

    //点位消费示例，并在消费过程中进行点位的提交
/*    public static void example(DatahubClient dataHubClient, String projectName, String topicName, String subId) {
        DatahubClient datahubClient = DataHubClientUtil.getDataHubClient();
        String shardId = "0";
        List<String> shardIds = Arrays.asList("0", "1");
        OpenSubscriptionSessionResult openSubscriptionSessionResult = datahubClient.openSubscriptionSession(projectName, topicName, subId, shardIds);
        SubscriptionOffset subscriptionOffset = openSubscriptionSessionResult.getOffsets().get(shardId);
        // 1、获取当前点位的cursor，如果当前点位已过期则获取生命周期内第一条record的cursor，未消费同样获取生命周期内第一条record的cursor
        String cursor = null;
        //sequence < 0说明未消费
        if (subscriptionOffset.getSequence() < 0) {
            // 获取生命周期内第一条record的cursor
            cursor = datahubClient.getCursor(projectName, topicName, shardId, CursorType.OLDEST).getCursor();
        } else {
            // 获取下一条记录的Cursor
            long nextSequence = subscriptionOffset.getSequence() + 1;
            try {
                //按照SEQUENCE getCursor可能报SeekOutOfRange错误，表示当前cursor的数据已过期
                cursor = datahubClient.getCursor(projectName, topicName, shardId, CursorType.SEQUENCE, nextSequence).getCursor();
            } catch (SeekOutOfRangeException e) {
                // 获取生命周期内第一条record的cursor
                cursor = datahubClient.getCursor(projectName, topicName, shardId, CursorType.OLDEST).getCursor();
            }
        }
        // 2、读取并保存点位，这里以读取Tuple数据为例，并且每1000条记录保存一次点位
        long recordCount = 0L;
        // 每次读取10条record
        int fetchNum = 10;
        while (true) {
            try {
                GetRecordsResult getRecordsResult = datahubClient.getRecords(projectName, topicName, shardId, schema, cursor, fetchNum);
                if (getRecordsResult.getRecordCount() <= 0) {
                    // 无数据，sleep后读取
                    Thread.sleep(1000);
                    continue;
                }
                for (RecordEntry recordEntry : getRecordsResult.getRecords()) {
                    //消费数据
                    TupleRecordData data = (TupleRecordData) recordEntry.getRecordData();
                    System.out.println("field1:" + data.getField("field1") + "\t"
                            + "field2:" + data.getField("field2"));
                    // 处理数据完成后，设置点位
                    ++recordCount;
                    subscriptionOffset.setSequence(recordEntry.getSequence());
                    subscriptionOffset.setTimestamp(recordEntry.getSystemTime());
                    if (recordCount % 1000 == 0) {
                        //提交点位点位
                        Map<String, SubscriptionOffset> offsetMap = new HashMap<>();
                        offsetMap.put(shardId, subscriptionOffset);
                        datahubClient.commitSubscriptionOffset(projectName, topicName, subId, offsetMap);
                        System.out.println("commit offset successful");
                    }
                }
                cursor = getRecordsResult.getNextCursor();
            } catch (SubscriptionOfflineException | OffsetSessionChangedException e) {
                // 退出. Offline: 订阅下线; SessionChange: 表示订阅被其他客户端同时消费
                break;
            } catch (OffsetResetedException e) {
                // 表示点位被重置，重新获取SubscriptionOffset信息，这里以Sequence重置为例
                // 如果以Timestamp重置，需要通过CursorType.SYSTEM_TIME获取cursor
                subscriptionOffset = datahubClient.getSubscriptionOffset(projectName, topicName, subId, shardIds).getOffsets().get(shardId);
                long nextSequence = subscriptionOffset.getSequence() + 1;
                cursor = datahubClient.getCursor(projectName, topicName, shardId, CursorType.SEQUENCE, nextSequence).getCursor();
            } catch (DatahubClientException e) {
                // TODO: 针对不同异常决定是否退出
            } catch (Exception e) {
                break;
            }
        }
    }*/
}
