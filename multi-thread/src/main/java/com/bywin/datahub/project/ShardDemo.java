package com.bywin.datahub.project;

import com.aliyun.datahub.client.DatahubClient;
import com.aliyun.datahub.client.exception.*;
import com.aliyun.datahub.client.model.*;
import com.aliyun.datahub.exception.InvalidCursorException;
import com.github.pagehelper.Constant;
import com.google.common.base.Charsets;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * created by yeric on 2020/3/3
 */
public class ShardDemo {
    private static final ShardDemo instance = new ShardDemo();

    public static ShardDemo getInstance () {
        return instance;
    }

    /**
     * 列出 Shard
     */
    public void listShard(DatahubClient dataHubClient, String projectName, String topicName) {
        try {
            ListShardResult listShardResult = dataHubClient.listShard(projectName, topicName);
            if (listShardResult.getShards().size() > 0) {
                for (ShardEntry entry : listShardResult.getShards()) {
                    System.out.println(entry.getShardId() + "\t"
                            + entry.getState() + "\t"
                            + entry.getLeftShardId() + "\t"
                            + entry.getRightShardId());
                }
            }
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
     * 分裂 Shard
     */
    public void splitShard(DatahubClient dataHubClient, String projectName, String topicName, String shardId) {
        try {
            SplitShardResult splitShardResult = dataHubClient.splitShard(projectName, topicName, shardId);
            for (ShardEntry entry : splitShardResult.getNewShards()) {
                System.out.println(entry.getShardId());
            }
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
            System.out.println(e);
            System.exit(1);
        }
    }

    /**
     * 合并 Shard
     */
    public void mergeShard(DatahubClient dataHubClient, String projectName, String topicName, String shardId, String adjacentShardId) {
        try {
            MergeShardResult mergeShardResult = dataHubClient.mergeShard(projectName, topicName, shardId, adjacentShardId);
            System.out.println("merge successful");
            System.out.println(mergeShardResult.getShardId());
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
            System.out.println(e);
            System.exit(1);
        }
    }

    /**
     * 获取cursor
     */
    public void getcursor(DatahubClient datahubClient, String projectName, String topicName, String shardId) {
        try {
            /* OLDEST用法示例 */
            String oldestCursor = datahubClient.getCursor(projectName, topicName, shardId, CursorType.OLDEST).getCursor();
            /* LATEST用法示例 */
            String latestCursor = datahubClient.getCursor(projectName, topicName, shardId, CursorType.LATEST).getCursor();
            /* SEQUENCE用法示例 */
            //获取最新数据的sequence
            long seq = datahubClient.getCursor(projectName, topicName, shardId, CursorType.LATEST).getSequence();
            //获取最新的十条数据的读取位置
            String seqCursor = datahubClient.getCursor(projectName, topicName, shardId, CursorType.SEQUENCE, seq - 9).getCursor();
            /* SYSTEM_TIME用法示例 */
            //将时间转为时间戳形式
            String time = "2019-07-01 10:00:00";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long timestamp = 0L;
            try {
                Date date = simpleDateFormat.parse(time);
                timestamp = date.getTime();//获取时间的时间戳
                //System.out.println(timestamp);
            } catch (ParseException e) {
                System.exit(-1);
            }
            //获取时间time之后的数据读取位置
            String timeCursor = datahubClient.getCursor(projectName, topicName, shardId, CursorType.SYSTEM_TIME, timestamp).getCursor();
            System.out.println("get cursor successful");
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project or topic or shard not found");
            System.exit(1);
        } catch (SeekOutOfRangeException e) {
            System.out.println("offset invalid or has expired");
            System.exit(1);
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.out.println(e);
            System.exit(1);
        }
    }

    /**
     * 写入Tuple型数据
     */
    public static void tupleExample(DatahubClient datahubClient, String projectName, String topicName, String shardId) {
        // 获取schema
        RecordSchema recordSchema = datahubClient.getTopic(projectName, topicName).getRecordSchema();
        // 生成十条数据
        List<RecordEntry> recordEntries = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            RecordEntry recordEntry = new RecordEntry();
            // 对每条数据设置额外属性
            recordEntry.addAttribute("key1", "value1");
            TupleRecordData data = new TupleRecordData(recordSchema);
            data.setField("bigint_field", (int)(Math.random()*100+1));
            data.setField("double_field", 1234567.0);
            data.setField("boolean_field", true);
            data.setField("timestamp_field", System.currentTimeMillis());
            data.setField("string_field", RandomStringUtils.random(5));
            data.setField("newfield", RandomStringUtils.random(3));
            recordEntry.setRecordData(data);
            recordEntry.setShardId(shardId);
            recordEntries.add(recordEntry);
        }
        try {
            // 服务端从2.12版本开始支持，之前版本请使用putRecords接口
            datahubClient.putRecordsByShard(projectName, topicName, shardId, recordEntries);
//            datahubClient.putRecords(projectName, topicName, recordEntries);
            System.out.println("write data successful");
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project or topic or shard not found");
            System.exit(1);
        } catch (ShardSealedException e) {
            System.out.println("shard status is CLOSED, can not write");
            System.exit(1);
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.out.println(e);
            System.exit(1);
        }
    }

    /**
     * 写入blob型数据
     */
    public static void blobExample(DatahubClient datahubClient, String projectName, String topicName, String shardId) {
        // 生成十条数据
        List<RecordEntry> recordEntries = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            RecordEntry recordEntry = new RecordEntry();
            // 对每条数据设置额外属性
            recordEntry.addAttribute("key1", "value1");
            BlobRecordData data = new BlobRecordData("123456".getBytes(Charsets.UTF_8));
            recordEntry.setRecordData(data);
            recordEntry.setShardId(shardId);
            recordEntries.add(recordEntry);
//            recordEntry.setShardId("0");
        }
        while (true) {
            try {
                // 服务端从2.12版本开始支持，之前版本请使用putRecords接口
                //datahubClient.putRecordsByShard(projectName, topicName, shardId, recordEntries);
                datahubClient.putRecords(projectName, topicName, recordEntries);
                System.out.println("write data  successful");
                break;
            } catch (InvalidParameterException e) {
                System.out.println("invalid parameter, please check your parameter");
                System.exit(1);
            } catch (AuthorizationFailureException e) {
                System.out.println("AK error, please check your accessId and accessKey");
                System.exit(1);
            } catch (ResourceNotFoundException e) {
                System.out.println("project or topic or shard not found");
                System.exit(1);
            } catch (ShardSealedException e) {
                System.out.println("shard status is CLOSED, can not write");
                System.exit(1);
            } catch (LimitExceededException e) {
                System.out.println("maybe qps exceed limit, retry");
            } catch (DatahubClientException e) {
                System.out.println("other error");
                System.out.println(e);
                System.exit(1);
            }
        }
    }

    /**
     * 读取Tuple topic数据
     */
    public void readTupleTopic(DatahubClient datahubClient, String projectName, String topicName, String shardId) {
        //每次最多读取数据量
        int recordLimit = 1000;
        // 获取cursor, 这里获取有效数据中时间最久远的record游标
        // 注: 正常情况下，getCursor只需在初始化时获取一次，然后使用getRecords的nextCursor进行下一次读取
        String cursor = "";
        try {
            cursor = datahubClient.getCursor(projectName, topicName, shardId, CursorType.OLDEST).getCursor();
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project or topic or shard not found");
            System.exit(1);
        } catch (SeekOutOfRangeException e) {
            System.out.println("offset invalid or has expired");
            System.exit(1);
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.out.println(e);
            System.exit(1);
        }
        // 获取schema
        RecordSchema recordSchema = datahubClient.getTopic(projectName, topicName).getRecordSchema();
        while (true) {
            try {
                GetRecordsResult result = datahubClient.getRecords(projectName, topicName, shardId, recordSchema, cursor, recordLimit);
                if (result.getRecordCount() <= 0) {
                    // 无数据，sleep后读取
                    Thread.sleep(10000);
                    continue;
                }
                for (RecordEntry entry : result.getRecords()) {
                    TupleRecordData data = (TupleRecordData) entry.getRecordData();
//                    System.out.println("field1:" + data.getField("field1") + "\t"
//                            + "field2:" + data.getField("field2"));
                }
                // 拿到下一个游标
                cursor = result.getNextCursor();
            } catch (InvalidCursorException ex) {
                // 非法游标或游标已过期，建议重新定位后开始消费
                cursor = datahubClient.getCursor(projectName, topicName, shardId, CursorType.OLDEST).getCursor();
            } catch (SeekOutOfRangeException e) {
                System.out.println("offset invalid");
                System.exit(1);
            } catch (ResourceNotFoundException e) {
                System.out.println("project or topic or shard not found");
                System.exit(1);
            } catch (ShardSealedException e) {
                System.out.println("shard is closed, all data has been read");
                System.exit(1);
            } catch (LimitExceededException e) {
                System.out.println("maybe exceed limit, retry");
            } catch (DatahubClientException e) {
                System.out.println("other error");
                System.out.println(e);
                System.exit(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  读取Blob topic数据
     */
    public void readBlobTopic(DatahubClient datahubClient, String projectName, String blobTopicName, String shardId) {
        //每次最多读取数据量
        int recordLimit = 1000;
        // 获取cursor, 这里获取有效数据中时间最久远的record游标
        // 注: 正常情况下，getCursor只需在初始化时获取一次，然后使用getRecords的nextCursor进行下一次读取
        String cursor = "";
        try {
            cursor = datahubClient.getCursor(projectName, blobTopicName, shardId, CursorType.OLDEST).getCursor();
        } catch (InvalidParameterException e) {
            System.out.println("invalid parameter, please check your parameter");
            System.exit(1);
        } catch (AuthorizationFailureException e) {
            System.out.println("AK error, please check your accessId and accessKey");
            System.exit(1);
        } catch (ResourceNotFoundException e) {
            System.out.println("project or topic or shard not found");
            System.exit(1);
        } catch (SeekOutOfRangeException e) {
            System.out.println("offset invalid or has expired");
            System.exit(1);
        } catch (DatahubClientException e) {
            System.out.println("other error");
            System.out.println(e);
            System.exit(1);
        }
        // 获取schema
        RecordSchema recordSchema = datahubClient.getTopic(projectName, blobTopicName).getRecordSchema();
        while (true) {
            try {
                GetRecordsResult result = datahubClient.getRecords(projectName, blobTopicName, shardId, recordSchema, cursor, recordLimit);
                if (result.getRecordCount() <= 0) {
                    // 无数据，sleep后读取
                    Thread.sleep(10000);
                    continue;
                }
                /* 消费数据 */
                for (RecordEntry record: result.getRecords()){
                    BlobRecordData data = (BlobRecordData) record.getRecordData();
                    System.out.println(new String(data.getData()));
                }
                // 拿到下一个游标
                cursor = result.getNextCursor();
            } catch (InvalidCursorException ex) {
                // 非法游标或游标已过期，建议重新定位后开始消费
                cursor = datahubClient.getCursor(projectName, blobTopicName, shardId, CursorType.OLDEST).getCursor();
            } catch (SeekOutOfRangeException e) {
                System.out.println("offset invalid");
                System.exit(1);
            } catch (ResourceNotFoundException e) {
                System.out.println("project or topic or shard not found");
                System.exit(1);
            } catch (ShardSealedException e) {
                System.out.println("shard is closed, all data has been read");
                System.exit(1);
            } catch (LimitExceededException e) {
                System.out.println("maybe exceed limit, retry");
            } catch (DatahubClientException e) {
                System.out.println("other error");
                System.out.println(e);
                System.exit(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
