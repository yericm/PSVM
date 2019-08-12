/*
Navicat MySQL Data Transfer

Source Server         : 172.18.109.89_prod
Source Server Version : 50634
Source Host           : 172.18.109.89:3306
Source Database       : citybrain_service

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2019-08-12 09:59:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app_info`
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_info_id` bigint(20) NOT NULL COMMENT '业务唯一code',
  `app_name` varchar(64) NOT NULL DEFAULT '' COMMENT '接入系统的名称',
  `description` varchar(256) DEFAULT '' COMMENT '接入系统的描述',
  `department_type` varchar(255) DEFAULT NULL COMMENT '系统所属部门',
  `is_online` tinyint(1) DEFAULT NULL,
  `approval_state` varchar(64) DEFAULT NULL COMMENT '审核状态',
  `reason` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `app_type` varchar(16) DEFAULT NULL COMMENT '接入方类型:AREA、DEPT、PUB_SERV',
  `area_code` varchar(64) DEFAULT NULL COMMENT '所属区域:如果接入类型为AREA,填写接入区域,如果接入类型为部门，则需要填写该部门所属的区域',
  `dept_code` varchar(64) DEFAULT NULL COMMENT '所属部门:如果接入类型为DEPT,该字段必须填写，否则无须填写',
  `pub_serv_code` varchar(64) DEFAULT NULL COMMENT '公共服务商编码',
  `app_short_name` varchar(64) DEFAULT NULL,
  `sys_name` varchar(64) DEFAULT NULL COMMENT '系统名',
  `seq` tinyint(4) DEFAULT '127',
  `create_by` bigint(20) DEFAULT NULL COMMENT '接入方信息创建人',
  `modify_by` bigint(20) DEFAULT NULL COMMENT '接入方信息修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `app_name` (`app_name`),
  UNIQUE KEY `app_info_id` (`app_info_id`),
  UNIQUE KEY `app_info_id_2` (`app_info_id`),
  UNIQUE KEY `app_name_2` (`app_name`),
  KEY `index_app_info_id` (`app_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1359 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='app信息表';

-- ----------------------------
-- Records of app_info
-- ----------------------------
INSERT INTO `app_info` VALUES ('990', '63', '交警', '', '6000001887186883', '1', 'APPROVAL_PASS', '', '2018-11-26 16:05:20', '2018-11-26 16:05:20', 'DEPT', null, null, null, '交警', '交警系统', '100', null, null);
INSERT INTO `app_info` VALUES ('991', '64', '杭州市城市管理局（杭州市综合行政执法局）', '', '6000000052747125', '1', 'APPROVAL_PASS', '', '2018-11-26 16:05:55', '2018-11-26 16:05:55', 'DEPT', null, null, null, '市城管局', '城管系统', '101', null, null);
INSERT INTO `app_info` VALUES ('992', '65', '环保1', '', '6000001523131571', '1', 'APPROVAL_PASS', '', '2018-11-26 16:06:31', '2018-11-26 16:06:31', 'DEPT', null, null, null, '环保', '环保系统', '127', null, null);
INSERT INTO `app_info` VALUES ('993', '66', '杭州市公安局', '', '6000000445522676', '1', 'APPROVAL_PASS', '', '2018-11-26 16:07:00', '2018-11-26 16:07:00', 'DEPT', '330100000000', '33010001070000', null, '市公安局', '公安系统', '110', null, null);
INSERT INTO `app_info` VALUES ('994', '67', '杭州市文化广电旅游局', '', '6000001666198641', '1', 'APPROVAL_PASS', '', '2018-11-26 16:07:32', '2018-11-26 16:07:32', 'DEPT', '330100000000', '33010001210000', null, '市文化广电旅游局', '文旅系统', '103', null, null);
INSERT INTO `app_info` VALUES ('995', '68', '杭州市发展和改革委员会', '', '6000002005986879', '1', 'APPROVAL_PASS', '', '2018-11-26 16:08:10', '2018-11-26 16:08:10', 'DEPT', '330100000000', '33010001020000', null, '市发改委', '发改委系统', '127', null, null);
INSERT INTO `app_info` VALUES ('996', '69', '数管', '', '6000002044165832', '1', 'APPROVAL_PASS', '', '2018-11-26 16:08:43', '2018-11-26 16:08:43', 'DEPT', '330100000000', '33010001370000', null, '数管', '数管系统', '127', null, null);
INSERT INTO `app_info` VALUES ('997', '70', '富阳区', '', '6000001345234311', '1', 'APPROVAL_PASS', '', '2018-11-26 16:09:15', '2018-11-26 16:09:15', 'AREA', '330111000000', null, null, '富阳区', '富阳区平台', '127', null, null);
INSERT INTO `app_info` VALUES ('998', '71', '萧山区', '', '6000000907143269', '1', 'APPROVAL_PASS', '', '2018-11-26 16:10:00', '2018-11-26 16:10:00', 'AREA', '330109000000', null, null, '萧山区', '萧山区平台', '127', null, null);
INSERT INTO `app_info` VALUES ('999', '72', '云栖小镇', '', '6000000793191036', '1', 'APPROVAL_PASS', '', '2018-11-26 16:10:39', '2018-11-26 16:10:39', 'DEPT', null, null, null, '云栖小镇', '云栖小镇平台', '104', null, null);
INSERT INTO `app_info` VALUES ('1000', '73', '桐庐县', '', '6000000897691188', '1', 'APPROVAL_PASS', '', '2018-11-26 16:11:18', '2018-11-26 16:11:18', 'OTHER', '330122000000', null, null, '桐庐县', '桐庐县平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1001', '74', '华数传媒控股股份有限公司', '', '6000000320785603', '1', 'APPROVAL_PASS', '', '2018-11-26 16:11:53', '2018-11-26 16:11:53', 'PUB_SERV', null, null, '10000015', '华数', '华数系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1002', '75', '卫星', '', '6000000011962046', '1', 'APPROVAL_PASS', '', '2018-11-26 16:12:25', '2018-11-26 16:12:25', 'PUB_SERV', null, null, null, '卫星', '卫星系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1003', '76', '运营商', '', '6000001089166286', '1', 'APPROVAL_PASS', '', '2018-11-26 16:13:02', '2018-11-26 16:13:02', 'PUB_SERV', null, null, null, '运营商', '运营商系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1004', '78', '微巴士系统', '微巴士系统', '6000000342103945', '1', 'APPROVAL_PASS', '', '2018-11-26 21:01:32', '2018-11-26 21:01:32', 'DEPT', null, null, null, '微巴士系统', '微巴士系统', '105', null, null);
INSERT INTO `app_info` VALUES ('1005', '79', '运营', '', '6000000383514985', '1', 'APPROVAL_PASS', '', '2018-11-27 11:26:49', '2018-11-27 11:26:49', 'OTHER', null, null, null, '运营', '运营系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1006', '92', '桐庐1', '', '6000000897691188', '1', 'APPROVAL_PASS', '', '2018-11-28 19:42:36', '2018-11-28 19:42:36', 'OTHER', null, null, null, '桐庐1', '桐庐1系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1007', '95', '杭州市生态环境局', '', '6000001523131571', '1', 'APPROVAL_PASS', '', '2018-11-29 19:38:53', '2018-11-29 19:38:55', 'DEPT', null, null, null, '市生态环境局', '环保系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1008', '98', '云栖超管', '', '6000000320055443', '1', 'APPROVAL_PASS', '', '2018-12-01 11:25:40', '2018-12-01 11:25:40', 'DEPT', null, null, null, '云栖超管', '云栖超管系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1009', '99', '发改2', '', '6000002005986879', '1', 'APPROVAL_PASS', '', '2018-12-04 14:38:12', '2018-12-04 14:38:19', 'DEPT', null, null, null, '发改2', '发改2系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1010', '101', '拱墅区', '', '6000001444637882', '1', 'APPROVAL_PASS', '', '2018-12-06 19:07:08', '2018-12-06 19:07:08', 'AREA', '330105000000', null, null, '拱墅区', '拱墅区平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1011', '112', '城管2', '', '6000000052747125', '1', 'APPROVAL_PASS', '', '2018-12-11 13:21:55', '2018-12-11 13:21:55', 'DEPT', '330100000000', '33010001330000', null, '城管', '城管系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1012', '116', '建德区1', '', '6000001735551568', '1', 'APPROVAL_PASS', '', '2018-12-11 17:53:46', '2018-12-11 17:53:46', 'OTHER', '330182000000', null, null, '建德', '建德平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1013', '120', '西湖区1', '', '6000000158534990', '1', 'APPROVAL_PASS', '', '2018-12-13 13:32:38', '2018-12-13 13:32:38', 'OTHER', '330106000000', null, null, '西湖区1', '西湖区平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1014', '121', '湖滨街道', '', '6000000256409977', '1', 'APPROVAL_PASS', '', '2018-12-13 13:33:42', '2018-12-13 13:33:42', 'DEPT', '330102003000', null, null, '湖滨街道', '湖滨街区平台', '102', null, null);
INSERT INTO `app_info` VALUES ('1015', '122', '杭州市经济和信息化局', '', '6000000619326498', '1', 'APPROVAL_PASS', '', '2018-12-13 13:34:46', '2018-12-13 13:34:46', 'DEPT', null, null, null, '市经信局', '经信系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1016', '123', '上海脉策数据科技有限公司', '', '6000001934153081', '1', 'APPROVAL_PASS', '', '2018-12-13 13:35:21', '2018-12-13 13:35:21', 'PUB_SERV', null, null, '10000011', '脉策', '脉策系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1018', '125', '交警信号灯', '', '6000001250965848', '1', 'APPROVAL_PASS', '', '2018-12-20 10:41:04', '2018-12-20 10:41:04', 'DEPT', null, null, null, '交警信号灯', '交警信号灯系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1019', '126', '内部超级用户', '', '6000001236183274', '1', 'APPROVAL_PASS', '', '2018-12-20 18:33:52', '2018-12-20 18:33:52', 'OTHER', null, null, null, '内部超级用户', '内部超管系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1020', '127', '云栖小镇综合管理', '', '6000000761420483', '1', 'APPROVAL_PASS', '', '2018-12-20 21:00:47', '2018-12-20 21:00:47', 'DEPT', null, null, null, '云栖小镇综合管理', '云栖综合系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1022', '129', '淳安县', '', '6000001963603132', '0', 'APPROVAL_PASS', '', '2019-05-31 16:54:12', '2019-05-27 15:24:30', 'AREA', '330127000000', null, null, '淳安区', '淳安平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1023', '131', '下城区', '', '6000000790988039', '0', 'APPROVAL_PASS', '', '2019-04-03 10:51:50', '2019-04-03 10:58:31', 'AREA', '330103000000', null, null, '下城区', '下城平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1024', '133', '交警02', '', '6000001605894574', '0', 'APPROVAL_PASS', '', '2019-04-28 10:31:51', '2019-04-28 10:33:12', 'DEPT', null, null, null, '交警02', '交警02系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1025', '134', '萧山护航', '', '6000001191258671', '0', 'APPROVAL_PASS', '', '2019-05-17 11:19:07', '2019-05-17 11:21:03', 'DEPT', null, null, null, '萧山护航', '萧山护航系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1026', '135', '江干区', '', '6000002140955631', '0', 'APPROVAL_PASS', '', '2019-05-29 09:55:47', '2019-05-29 10:00:45', 'AREA', '330104000000', null, null, '江干区', '江干平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1027', '136', '杭州市卫生健康委员会', '', '6000000218043071', '0', 'APPROVAL_PASS', '', '2019-05-29 10:38:30', '2019-05-29 10:43:37', 'DEPT', '330100000000', '33010001220000', null, '市卫生健康委', '卫健系统', '106', null, null);
INSERT INTO `app_info` VALUES ('1028', '137', '余杭区', '', '6000001202638162', '0', 'APPROVAL_PASS', '', '2019-05-30 13:44:15', '2019-05-30 13:45:03', 'AREA', '330110000000', null, null, '余杭区', '余杭平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1030', '139', '国网杭州供电公司', '', '6000000681414819', '0', 'APPROVAL_PASS', '', '2019-05-31 11:11:39', '2019-05-31 11:12:42', 'DEPT', null, null, null, '市国电', '电力系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1031', '140', '杭州市住房保障和房产管理局', '', '6000002034866133', '0', 'APPROVAL_PASS', '', '2019-05-31 14:14:27', '2019-05-31 14:14:56', 'DEPT', null, null, null, '市住保房管局', '房管系统', '107', null, null);
INSERT INTO `app_info` VALUES ('1032', '141', '西湖区', '', '6000000320979520', '0', 'APPROVAL_PASS', '', '2019-05-31 14:34:52', '2019-05-31 14:35:25', 'AREA', '330106000000', null, null, '西湖区', '西湖区平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1053', '138', '杭州市市场监督管理局（杭州市知识产权局）', '', '6000001513175341', '0', 'APPROVAL_PASS', '', '2019-05-31 19:37:53', '2019-05-31 19:23:32', 'DEPT', null, null, null, '市市场监管局', '市监局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1054', '142', '电梯', '', '6000001513175341', '0', 'APPROVAL_PASS', '', '2019-05-31 19:20:09', '2019-05-31 19:21:02', 'DEPT', null, null, null, '电梯', '电梯系统', '107', null, null);
INSERT INTO `app_info` VALUES ('1055', '143', '建德区', '', '6000000346565124', '0', 'APPROVAL_PASS', '', '2019-05-31 22:38:03', '2019-05-31 22:39:08', 'AREA', null, null, null, '建德区', '建德交警系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1056', '144', '云栖城市大脑科技（杭州）有限公司', '', '6000000674909349', '0', 'APPROVAL_PASS', '', '2019-06-01 10:41:30', '2019-06-01 10:41:51', 'PUB_SERV', null, null, '10000017', '运营公司', '运营公司系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1057', '145', '杭州市农业农村局', '', '6000000518955159', '0', 'APPROVAL_PASS', '', '2019-06-01 14:30:30', '2019-06-01 14:31:11', 'DEPT', null, null, null, '市农业农村局', '农业系统', '108', null, null);
INSERT INTO `app_info` VALUES ('1058', '146', '临安区', '', '6000000100168046', '0', 'APPROVAL_PASS', '', '2019-06-01 21:52:28', '2019-06-01 21:53:00', 'AREA', '330112000000', null, null, '临安区', '临安平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1059', '147', '上城区', '', '6000001056949469', '0', 'APPROVAL_PASS', '', '2019-06-02 18:18:24', '2019-06-02 18:18:55', 'AREA', '330102000000', null, null, '上城区', '上城平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1060', '148', '杭州市云栖工程院', '', '6000000121977862', '0', 'APPROVAL_PASS', '', '2019-06-04 18:27:51', '2019-06-04 18:28:18', 'PUB_SERV', null, null, '10000000', '工程院', '工程院系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1061', '149', '中共杭州市委政法委员会', '', '6000000450342484', '0', 'APPROVAL_PASS', '', '2019-06-05 14:32:00', '2019-06-05 14:32:27', 'DEPT', null, null, null, '市委政法委', '政法系统', '109', null, null);
INSERT INTO `app_info` VALUES ('1062', '150', '杭州市应急管理局', '', '6000001543594179', '0', 'APPROVAL_PASS', '', '2019-06-05 14:35:05', '2019-06-05 14:35:32', 'DEPT', null, null, null, '市应急管理局', '应急系统', '110', null, null);
INSERT INTO `app_info` VALUES ('1063', '152', '钱塘新区', '', '6000001605387626', '0', 'APPROVAL_PASS', '', '2019-06-06 10:54:31', '2019-06-06 10:55:37', 'AREA', null, null, null, '钱塘新区', '钱塘新区平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1065', '153', '滨江区', '', '6000000179780939', '0', 'APPROVAL_PASS', '', '2019-06-10 15:32:58', '2019-06-10 15:33:38', 'AREA', null, null, null, '滨江区', '滨江平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1066', '200', '微巴士', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000001', '微巴士', '微巴士系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1067', '201', '杭州市公交集团', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000002', '公交', '公交系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1068', '202', '浙江深大智能科技有限公司', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000003', '深大', '深大系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1069', '203', '杭州中智游科技有限公司', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000004', '中智游', '中智游系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1070', '204', '杭州旅步科技有限公司', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000005', '旅步', '旅步系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1071', '205', '未来酒店', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000006', '未来酒店', '未来酒店系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1072', '206', '杭州睿沃科技有限公司', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000007', '睿沃', '睿沃系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1073', '207', '杭州市民卡有限公司', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000008', '市民卡', '市民卡系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1074', '208', '浙江每日互动网络科技有限公司', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000009', '每日互动', '每日互动系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1075', '209', '去哪儿网', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000010', '去哪儿网', '去哪儿网系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1077', '211', 'GDS万国数据服务有限公司', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000012', '万国数据', '万国数据系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1078', '212', '中国民航信息网络股份有限公司', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000013', '民航', '民航系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1079', '213', '中国银联', '', null, '1', 'APPROVAL_PASS', '', '2019-06-12 22:20:20', '2019-06-12 22:20:20', 'PUB_SERV', null, null, '10000014', '银联', '银联系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1083', '252', '桐庐区', '', '6000001235591715', '0', 'APPROVAL_PASS', '', '2019-06-14 19:07:47', '2019-06-14 19:08:09', 'AREA', null, null, null, '桐庐区', '桐庐平台', '127', null, null);
INSERT INTO `app_info` VALUES ('1086', '253', '杭州西湖风景名胜区管理委员会', '', '6000001389976479', '0', 'APPROVAL_PASS', '', '2019-06-24 14:15:59', '2019-06-24 14:16:41', null, null, null, null, '杭州西湖风景名胜区管委会', '西湖景区', '127', null, null);
INSERT INTO `app_info` VALUES ('1088', '254', 'admin_test02', '', '6000000352868005', '0', 'APPROVAL_PASS', '', '2019-06-25 16:55:45', '2019-06-25 16:56:10', null, null, null, null, null, 'admin_test02', '127', null, null);
INSERT INTO `app_info` VALUES ('1089', '255', '展厅', '', '6000001319677198', '0', 'APPROVAL_PASS', '', '2019-07-01 11:57:24', '2019-07-01 11:57:53', null, null, null, null, null, '展厅', '127', null, null);
INSERT INTO `app_info` VALUES ('1102', '278', '拱墅云共治', null, null, '1', 'APPROVAL_PASS', null, '2019-08-02 17:08:37', '2019-08-02 17:08:37', 'OTHER', '330105000000', null, null, '云共治', '云共治', '127', null, null);
INSERT INTO `app_info` VALUES ('1263', '2266', '市委组织部', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:53', null, 'DEPT', null, null, null, '市委组织部', '市委组织部系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1264', '2267', '市委宣传部', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市委宣传部', '市委宣传部系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1265', '2268', '市委统战部(市侨办)', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市委统战部', '市委统战部系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1266', '2269', '杭州市投资促进局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市投资促进局', '市投资促进局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1267', '2270', '杭州市民政局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市民政局', '市民政局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1268', '2271', '杭州市审计管办', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市审计管办', '市审计管办系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1269', '2272', '杭州市人力资源和社会保障局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市人力社保局', '市人力社保局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1270', '2273', '杭州市交通运输局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市交通运输局', '市交通运输局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1271', '2274', '杭州市林业水利局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市林水局', '市林水局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1272', '2275', '杭州市城乡建设委员会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市建委', '市建委系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1273', '2276', '杭州市规划和自然资源局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市规划和自然资源局', '市规划和自然资源局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1274', '2277', '杭州市商务局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市商务局', '市商务局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1275', '2278', '杭州市教育局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市教育局', '市教育局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1276', '2279', '杭州市妇女联合会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市妇联', '市妇联系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1277', '2280', '杭州市科协', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市科协', '市科协系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1278', '2281', '杭州市地铁集团有限责任公司', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市地铁集团', '市地铁集团系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1279', '2282', '杭州市运河综合保护开发建设集团有限公司', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市运河集团', '市运河集团系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1280', '2283', '杭州市商贸旅游集团有限公司', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市商旅集团', '市商旅集团系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1281', '2284', '中共杭州市委杭州市人民政府信访局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市信访办', '市信访办系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1282', '2285', '市红十字会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市红十字会', '市红十字会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1283', '2286', '杭州市医疗保障局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:54', null, 'DEPT', null, null, null, '市医疗保障局', '市医疗保障局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1284', '2287', '市法院', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市法院', '市法院系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1285', '2288', '市检察院', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市检察院', '市检察院系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1286', '2289', '杭州市司法局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市司法局', '市司法局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1287', '2290', '市税务局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市税务局', '市税务局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1288', '2291', '市消防救援支队', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市消防救援支队', '市消防救援支队系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1289', '2292', '市气象局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市气象局', '市气象局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1290', '2293', '市总工会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市总工会', '市总工会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1291', '2294', '市团委', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市团委', '市团委系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1292', '2295', '市民族宗教局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市民族宗教局', '市民族宗教局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1293', '2296', '市委办公厅', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市委办公厅（市委政研室、市委改革办）', '市委办公厅（市委政研室、市委改革办）系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1294', '2297', '市人大常委会机关', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市人大常委会机关', '市人大常委会机关系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1295', '2298', '市政府办公厅', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市政府办公厅（市政府研究室、市数据资源局）', '市政府办公厅（市政府研究室、市数据资源局）系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1296', '2299', '市政协机关', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市政协机关', '市政协机关系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1297', '2300', '市纪委监委机关（市委巡察办）', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市纪委监委机关（市委巡察办）', '市纪委监委机关（市委巡察办）系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1298', '2301', '杭州市钱江新城建设管理委员会（指挥部）', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市钱江新城管委会', '市钱江新城管委会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1299', '2302', '市直机关工委', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市直机关工委', '市直机关工委系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1300', '2303', '中共杭州市委机构编制委员会办公室', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市委编办', '市委编办系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1301', '2304', '市委党史研究室', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市委党史研究室', '市委党史研究室系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1302', '2305', '市科技局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市科技局', '市科技局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1303', '2306', '市国资委', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市国资委', '市国资委系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1304', '2307', '市金融办', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:55', null, 'DEPT', null, null, null, '市金融办', '市金融办系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1305', '2308', '市外办', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市外办', '市外办系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1306', '2309', '市机关事务局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市机关事务局', '市机关事务局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1307', '2310', '市财政局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市财政局', '市财政局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1308', '2311', '杭州市对口支援和区域合作局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市对口支援和区域合作局', '市对口支援和区域合作局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1309', '2312', '杭州市供销社', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市供销社', '市供销社系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1310', '2313', '市农科院', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市农科院', '市农科院系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1311', '2314', '市体育局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市体育局', '市体育局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1312', '2315', '西泠印社社务委员会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '西泠印社社委会', '西泠印社社委会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1313', '2316', '市园文局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市园文局', '市园文局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1314', '2317', '市文联', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市文联', '市文联系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1315', '2318', '杭州市国安局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市国安局', '市国安局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1316', '2319', '市奥体指挥部', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市奥体指挥部', '市奥体指挥部系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1317', '2320', '市钱投集团', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市钱投集团', '市钱投集团系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1318', '2321', '市交投集团', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市交投集团', '市交投集团系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1319', '2322', '杭报集团（杭州日报社）', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '杭报集团', '杭报集团系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1320', '2323', '杭州文化广播电视集团（杭州文化广播电视集团有限公司）', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '杭州文广集团', '杭州文广集团系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1321', '2324', '市统计局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市统计局', '市统计局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1322', '2325', '市委军民融合办', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市委军民融合办', '市委军民融合办系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1323', '2326', '市委老干部局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市委老干部局', '市委老干部局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1324', '2327', '市委党校（行政学院、社会主义学院、市委讲师团）', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市委党校', '市委党校系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1325', '2328', '中国国际贸易促进委员会杭州市委员会（中国国际商会杭州商会）', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:56', null, 'DEPT', null, null, null, '市贸促会（市国际商会）', '市贸促会（市国际商会）系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1326', '2329', '市残联', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '市残联', '市残联系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1327', '2330', '杭州市退役军人事务局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '市退役军人事务局', '市退役军人事务局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1328', '2331', '杭州住房公积金管理中心', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '杭州公积金中心', '杭州公积金中心系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1329', '2332', '城西科创产业集聚区管委会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '城西科创产业集聚区管委会', '城西科创产业集聚区管委会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1330', '2333', '市政府驻北京办公室', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '市政府驻北京办公室', '市政府驻北京办公室系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1331', '2334', '市政府驻上海（深圳）办公室', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '市政府驻上海（深圳）办公室', '市政府驻上海（深圳）办公室系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1332', '2335', '杭州市审计局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '市审计局', '市审计局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1333', '2336', '市人防办（市民防局）', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '市人防办（市民防局）', '市人防办（市民防局）系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1334', '2337', '市社科联（市社科院）', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '市社科联（市社科院）', '市社科联（市社科院）系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1335', '2338', '杭州市台办', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '市委台办（市台办）', '市委台办（市台办）系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1336', '2339', '市侨联', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '市侨联', '市侨联系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1337', '2340', '市工商联', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '市工商联', '市工商联系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1338', '2341', '民革市委会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '民革市委会', '民革市委会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1339', '2342', '民盟市委会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '民盟市委会', '民盟市委会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1340', '2343', '民建市委会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '民建市委会', '民建市委会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1341', '2344', '民进市委会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '民进市委会', '民进市委会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1342', '2345', '农工党市委会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '农工党市委会', '农工党市委会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1343', '2346', '致公党市委会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '致公党市委会', '致公党市委会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1344', '2347', '九三学社市委会', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '九三学社市委会', '九三学社市委会系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1345', '2348', '国家统计局杭州调查队', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '国家统计局杭州调查队', '国家统计局杭州调查队系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1346', '2349', '杭州海关（在杭单位）', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:57', null, 'DEPT', null, null, null, '杭州海关（在杭单位）', '杭州海关（在杭单位）系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1347', '2350', '杭州铁路公安处', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:58', null, 'DEPT', null, null, null, '杭州铁路公安处', '杭州铁路公安处系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1348', '2351', '杭州出入境边防检查站', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:58', null, 'DEPT', null, null, null, '杭州出入境边防检查站', '杭州出入境边防检查站系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1349', '2352', '杭州市邮政管理局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:58', null, 'DEPT', null, null, null, '市邮政管理局', '市邮政管理局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1350', '2353', '杭州市烟草局', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:58', null, 'DEPT', null, null, null, '市烟草局', '市烟草局系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1351', '2354', '中国电信股份有限公司杭州分公司', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:58', null, 'DEPT', null, null, null, '杭州电信公司', '杭州电信公司系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1352', '2355', '中国移动杭州分公司', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:58', null, 'DEPT', null, null, null, '杭州移动公司', '杭州移动公司系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1353', '2356', '中国联通杭州分公司', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:58', null, 'DEPT', null, null, null, '杭州联通公司', '杭州联通公司系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1354', '2357', '杭州邮政公司', null, null, '1', 'APPROVAL_PASS', null, '2019-08-06 00:55:58', null, 'DEPT', null, null, null, '杭州邮政公司', '杭州邮政公司系统', '127', null, null);
INSERT INTO `app_info` VALUES ('1356', '2358', '市文明办', '', null, '1', 'APPROVAL_PASS', null, '2019-08-08 18:01:11', null, 'DEPT', null, null, null, '市文明办', '市文明办', '127', null, null);
INSERT INTO `app_info` VALUES ('1357', '2359', '市城投集团', '', null, '1', 'APPROVAL_PASS', null, '2019-08-08 18:03:49', null, 'DEPT', null, null, null, '市城投集团', '市城投集团', '127', null, null);
INSERT INTO `app_info` VALUES ('1358', '2360', '工程院专班', '', null, '1', 'APPROVAL_PASS', null, '2019-08-09 10:26:13', null, 'OTHER', null, null, null, '工程院专班', '工程院专班', '127', null, null);
