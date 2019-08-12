/*
Navicat MySQL Data Transfer

Source Server         : 172.18.109.89_prod
Source Server Version : 50634
Source Host           : 172.18.109.89:3306
Source Database       : citybrain_service

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2019-08-12 10:00:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `operation_customer_user`
-- ----------------------------
DROP TABLE IF EXISTS `operation_customer_user`;
CREATE TABLE `operation_customer_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `passwd` varchar(128) NOT NULL,
  `is_login` int(10) DEFAULT NULL COMMENT '激活状态 0首次登录修改密码 1非首次登录',
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话',
  `state` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `create_by` bigint(20) unsigned DEFAULT NULL COMMENT '创建人',
  `modify_by` bigint(20) unsigned DEFAULT '0' COMMENT '更新信息人',
  `update_passwd_time` datetime DEFAULT NULL COMMENT '上次修改密码时间',
  `app_info_id` bigint(20) DEFAULT NULL COMMENT '所属接入方id',
  `access_type` varchar(50) DEFAULT NULL,
  `main_user` int(10) DEFAULT NULL COMMENT '是否为该app_info_id下的主账号 即管理人',
  `approval_status` varchar(20) DEFAULT NULL COMMENT '账号审核状态 PASS ING REJECT',
  `approve_time` datetime DEFAULT NULL COMMENT '审核通过或拒绝时间',
  `approve_by` bigint(20) DEFAULT NULL COMMENT '审核用户ID',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `index_login_name` (`login_name`) USING BTREE COMMENT '登录账号不能重复',
  UNIQUE KEY `index_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=629 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operation_customer_user
-- ----------------------------
INSERT INTO `operation_customer_user` VALUES ('309', 'test01', 'tester01', 'fced774ff3bfd2b1a51ddbb727d02e91', '1', '13511112222', '123@123.com', null, '1', '2019-08-02 14:09:01', '2019-08-02 14:09:32', '63', '309', '2019-08-02 14:09:32', '275', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('310', 'test11', 'test11', '0aabc918103a9c56fa50639b93fff117', '1', '18293093876', '111@qq.com', null, '0', '2019-08-02 14:30:46', '2019-08-02 14:32:16', '63', '310', '2019-08-02 14:32:16', '276', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('311', 'wanglongtest', 'wanglong', '2ba029d7f15cf60ce1726facaa7f5fe1', '1', '18299992345', '8882345@qq.com', null, '1', '2019-08-02 14:50:05', '2019-08-02 15:46:56', '63', '311', '2019-08-02 15:46:56', '277', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('312', 'gsygz', '张智', '1cc78c906fdded5fc303bf5a18ff7882', '1', '18505811240', '18505811240@163.com', null, '0', '2019-08-02 17:08:37', '2019-08-02 17:09:38', '63', '312', '2019-08-02 17:09:38', '278', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('313', 'test02', 'fuxiao', '876a6de5f6864c7b0453f4192009675e', '1', '13511112222', '123@123.com', null, '1', '2019-08-02 18:51:06', '2019-08-02 18:52:16', '63', '313', '2019-08-02 18:52:16', '281', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('314', 'test03', 'fuxiao', '49ea00608acd74dee0bd16e23c2b6c25', '1', '13511112223', '123@123.com', null, '1', '2019-08-02 19:54:09', '2019-08-02 19:54:51', '63', '314', '2019-08-02 19:54:51', '282', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('469', 'swzzb', '张华兵', '76db4b97e7f310e88dfdcbb98ca6c419', '1', '18857198288', null, '0571-85253221', '1', '2019-08-06 00:55:53', '2019-08-07 20:40:05', null, '469', '2019-08-07 15:18:29', '2266', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('470', 'ssxcb', '赵雷', 'b104fdc5e63ce06bade7fafd10e061bd', '1', '15958167576', null, null, '1', '2019-08-06 00:55:54', '2019-08-07 15:30:42', null, '470', '2019-08-07 15:16:22', '2267', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('471', 'swtzb', '尹化宏', 'c78f2ccf8d609ee850fa0c5fd476dd90', '1', '15257183203', null, '', '1', '2019-08-06 00:55:54', '2019-08-07 15:32:59', null, '471', '2019-08-07 10:16:54', '2268', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('472', 'stzcjj', '杨砚', '10533d027c4e77de5214692a66541968', '1', '13858037998', null, null, '1', '2019-08-06 00:55:54', '2019-08-08 18:06:22', null, '472', '2019-08-08 11:27:51', '2269', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('473', 'smzj', '曹淑伟', '214349a5856b54e38deac71a72ff317f', '1', '13556638125', null, null, '1', '2019-08-06 00:55:54', '2019-08-08 21:19:54', null, '473', '2019-08-08 21:17:41', '2270', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('474', 'ssjgb', '王元杰', '21712e65590e79b09322677a1e1444cf', '1', '13456826383', null, '', '1', '2019-08-06 00:55:54', '2019-08-09 10:38:57', null, '474', '2019-08-09 09:23:25', '2271', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('475', 'srlsbj', '黄燕堂', 'ff0be545110bbee4bc6cddce362ee204', '1', '15888831608', null, null, '1', '2019-08-06 00:55:54', '2019-08-07 17:04:16', null, '475', '2019-08-07 17:02:30', '2272', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('476', 'sjtysj', '孙海娟', 'cfb4130727a7d7bf5b1bb3717392fddc', '1', '18071610756', null, null, '1', '2019-08-06 00:55:54', '2019-08-07 14:12:55', null, '476', '2019-08-07 11:32:51', '2273', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('477', 'slsj', '徐志刚', 'd2ad45a491069ba62c78174eb3bea769', '1', '13588722517', null, '0571-88370438', '1', '2019-08-06 00:55:54', '2019-08-07 16:48:27', null, '477', '2019-08-07 16:25:50', '2274', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('478', 'sjw', '吴安定', 'd4dc4dcf13fcae5ea56738869c189560', '1', '13958179897', null, null, '1', '2019-08-06 00:55:54', '2019-08-07 12:52:40', null, '478', '2019-08-07 10:54:22', '2275', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('479', 'sghhzrzyj', '曾志勇', '6c1c8f9c3c7d4d996195961cacb33837', '1', '13819491053', null, '0571-88227533', '1', '2019-08-06 00:55:54', '2019-08-09 16:31:15', null, '479', '2019-08-09 16:21:22', '2276', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('480', 'sswj1', '方东波', 'c6cceefd1c5d21487f000f5f6f96aea2', '1', '13105719470', null, null, '1', '2019-08-06 00:55:54', '2019-08-07 17:45:17', null, '480', '2019-08-07 16:23:56', '2277', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('481', 'sjyj', '金源 杭州市教育局计财处处长', '2813237453fb06e2149ec4fae6e06850', '1', '13757186777', null, null, '1', '2019-08-06 00:55:54', '2019-08-09 17:49:40', null, '481', '2019-08-09 10:23:17', '2278', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('482', 'sfl', '朱伊娜', 'ffd3ea780fb7a058e3455058569dadbb', '1', '13819107577', null, '0571-88892521', '1', '2019-08-06 00:55:54', '2019-08-09 09:44:59', null, '482', '2019-08-08 16:22:07', '2279', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('483', 'skx', null, '301e701eff2f348bf843c952b8c8b704', '0', null, null, null, '1', '2019-08-06 00:55:54', null, null, null, null, '2280', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('484', 'sdtjt', '李加丁', '08a37f7323c1fb0a91da9bdc59b95b58', '1', '18258222982', null, '0571-86000012', '1', '2019-08-06 00:55:54', '2019-08-09 09:16:16', null, '484', '2019-08-09 09:07:58', '2281', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('485', 'syhjt', '朱炜', '546d5c12e82b3425b64d3204a3373445', '1', '13634115316', null, '0571-85112989', '1', '2019-08-06 00:55:54', '2019-08-08 15:10:55', null, '485', '2019-08-08 15:09:00', '2282', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('486', 'ssljt', null, '30b8735c936732da7edcd30a83c0e3d2', '0', null, null, null, '1', '2019-08-06 00:55:54', null, null, null, null, '2283', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('487', 'sxfb', '朱华龙', 'd10c721217f508bcbfd6bbdaa365ed99', '1', '13777491226', null, null, '1', '2019-08-06 00:55:54', '2019-08-08 10:08:18', null, '487', '2019-08-08 09:55:35', '2284', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('488', 'shszh', null, 'c94fa951a8c7b97e98921cd5ff90fbdf', '0', null, null, null, '1', '2019-08-06 00:55:54', null, null, null, null, '2285', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('489', 'sylbzj', null, 'd0e9c3752b0788024622e5ce08c0fc58', '0', null, null, null, '1', '2019-08-06 00:55:54', null, null, null, null, '2286', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('490', 'sfy', null, '622c328b3ed3dab2e576b8fcd0619a14', '0', null, null, null, '1', '2019-08-06 00:55:55', null, null, null, null, '2287', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('491', 'sjcj', null, '15d22f890e1af681d4d2fed5451f2ee0', '0', null, null, null, '1', '2019-08-06 00:55:55', null, null, null, null, '2288', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('492', 'ssfj', null, '47e9d52af8bdab03a711b57d4a14f925', '1', null, null, null, '1', '2019-08-06 00:55:55', '2019-08-09 16:58:04', null, '492', '2019-08-09 16:58:04', '2289', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('493', 'sswj2', '唐丽敏', 'b10ea5b584b23da597f35d5bfbcdea71', '1', '13858065783', null, '0571-87160603', '1', '2019-08-06 00:55:55', '2019-08-08 09:40:41', null, '493', '2019-08-08 09:36:20', '2290', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('494', 'sxfjyzd', '刘平', '5f02ae87c72d46111f46e5233f92e0d5', '1', '13819185455', null, null, '1', '2019-08-06 00:55:55', '2019-08-07 16:42:02', null, '494', '2019-08-07 10:29:21', '2291', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('495', 'sqxj', '王小良', 'e8d5eeecc146d9eb0722ce8c54cf6cc8', '1', '18057194121', null, '', '1', '2019-08-06 00:55:55', '2019-08-07 12:54:01', null, '495', '2019-08-07 12:43:48', '2292', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('496', 'szgh', '程志民', 'c6b31cf224fbeda53f1a9d186164db2d', '1', '13805792660', null, '0571-87161069', '1', '2019-08-06 00:55:55', '2019-08-09 14:47:04', null, '496', '2019-08-07 15:00:10', '2293', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('497', 'stw', null, 'd80691efe1ec094611febdb59dcda7fa', '0', null, null, null, '1', '2019-08-06 00:55:55', null, null, null, null, '2294', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('498', 'smzzjj', '陶胜', '3198158b612c905fa5e50c8fd06f6119', '1', '13958096592', null, null, '1', '2019-08-06 00:55:55', '2019-08-08 09:56:30', null, '498', '2019-08-07 17:56:06', '2295', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('499', 'swbgt', null, 'cf54a11cd72b1bda30cc107dda41bc3e', '0', null, null, null, '1', '2019-08-06 00:55:55', null, null, null, null, '2296', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('500', 'srdcwhjg', '王暨平', '373bf49b06b0e00384a9953c984e7cbd', '1', '15905716633', null, null, '1', '2019-08-06 00:55:55', '2019-08-07 15:32:15', null, '500', '2019-08-07 15:03:25', '2297', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('501', 'szfbgt', null, '660b01d99fe641066126c089896fe355', '0', null, null, null, '1', '2019-08-06 00:55:55', null, null, null, null, '2298', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('502', 'szxjg', null, '0aa7d5470eab155672c23887862a27a3', '0', null, null, null, '1', '2019-08-06 00:55:55', null, null, null, null, '2299', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('503', 'sjwjwjg', '张道远', 'fe088488f5c61e6648ccf88b7a4c021a', '1', '13567135071', null, '0571-85251415', '1', '2019-08-06 00:55:55', '2019-08-08 09:38:37', null, '503', '2019-08-08 09:12:50', '2300', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('504', 'sqjxcgwh', null, 'b39f8f47a14b8ee3e46e321e2eb2193a', '0', null, null, null, '1', '2019-08-06 00:55:55', null, null, null, null, '2301', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('505', 'szjggw', null, '6613f53151b9a601af872bb0ac863a00', '0', null, null, null, '1', '2019-08-06 00:55:55', null, null, null, null, '2302', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('506', 'swbb', '鲍剑光', 'aa170d862ba7e26073c89d65d65c5541', '1', '13750888383', null, '0571-85250173', '1', '2019-08-06 00:55:55', '2019-08-09 15:17:31', null, '506', '2019-08-09 15:12:22', '2303', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('507', 'swdsyjs', '骆小峰', 'fd508286ef05403571f679b36e60b6fd', '1', '13362182260', null, '0571-85253288', '1', '2019-08-06 00:55:55', '2019-08-08 16:12:33', null, '507', '2019-08-08 16:01:09', '2304', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('508', 'skjj', '曾维启', 'f11f88939b33ce1a3e2f1d374e82b62c', '1', '13362892899', null, '0571-87023807', '1', '2019-08-06 00:55:55', '2019-08-08 11:47:18', null, '508', '2019-08-08 11:12:39', '2305', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('509', 'sgzw', null, 'ef983438337663b99279f6a8eb322ff6', '0', null, null, null, '1', '2019-08-06 00:55:55', null, null, null, null, '2306', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('510', 'sjrb', null, '19e86a4719c21a805f1c367129ed489e', '0', null, null, null, '1', '2019-08-06 00:55:55', null, null, null, null, '2307', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('511', 'swb', '傅荣昌', 'f11d77e5c8a840a829625069f99c0c01', '1', '13588775811', null, '0571-85252896', '1', '2019-08-06 00:55:56', '2019-08-12 09:17:09', null, '511', '2019-08-12 09:08:48', '2308', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('512', 'sjgswj', '李阳', 'bd2be9eb713855f8b8d99eef9cf5b0d2', '1', '13296713660', null, null, '1', '2019-08-06 00:55:56', '2019-08-09 16:19:53', null, '512', '2019-08-09 16:18:32', '2309', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('513', 'sczj', '许国平', 'e8d77a298d685b18154fb446cb3c1729', '1', '13867163615', null, '', '1', '2019-08-06 00:55:56', '2019-08-07 15:25:17', null, '513', '2019-08-07 14:50:38', '2310', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('514', 'sdkzyhqyhzj', '金中伟', 'c286dfdff3be62b8a77da4e6c604d4c1', '1', '13588716358', null, null, '1', '2019-08-06 00:55:56', '2019-08-08 10:40:43', null, '514', '2019-08-07 11:55:00', '2311', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('515', 'sgxs', '李和丰', 'c48c8e55371636df66d545d2e80052a3', '1', '13867108685', null, null, '1', '2019-08-06 00:55:56', '2019-08-09 10:22:46', null, '515', '2019-08-09 10:22:04', '2312', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('516', 'snky', '周毅飞', '38bfa0fdcf74f9a734d3546ca9438d04', '1', '13588041399', null, null, '1', '2019-08-06 00:55:56', '2019-08-09 18:20:19', null, null, '2019-08-09 15:36:45', '2313', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('517', 'styj', '周留存', '00c377c9484f49427d720c73a08cd12f', '1', '13666689685', null, '0571-87979873', '1', '2019-08-06 00:55:56', '2019-08-07 15:40:47', null, '517', '2019-08-07 15:38:07', '2314', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('518', 'xlysswh', '李佶', '344c18089169a7f78971f15dfa889d92', '1', '13858038607', null, '', '1', '2019-08-06 00:55:56', '2019-08-08 16:45:04', null, '518', '2019-08-08 16:43:00', '2315', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('519', 'sywj', '沈莺', '283117e616c7057239583fb878958669', '1', '13606519527', null, '0571-87988966', '1', '2019-08-06 00:55:56', '2019-08-07 16:34:06', null, '519', '2019-08-07 16:11:14', '2316', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('520', 'swl', null, '9f8503d8783e406ffbc5c94798b7f7e9', '0', null, null, null, '1', '2019-08-06 00:55:56', null, null, null, null, '2317', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('521', 'sgaj', null, '378084a53ed91cc74060e00b8ed34a71', '0', null, null, null, '1', '2019-08-06 00:55:56', null, null, null, null, '2318', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('522', 'satzhb', '高秀芹', '5b559dc57a0367709ed585cc7ab13290', '1', '13819188697', null, '0571-28888057', '1', '2019-08-06 00:55:56', '2019-08-09 16:21:00', null, '522', '2019-08-09 16:18:16', '2319', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('523', 'sqtjt', '来盾矛', '5e1cb9f65325089c1f00d6ef9ee2cb45', '1', '13606700548', null, null, '1', '2019-08-06 00:55:56', '2019-08-07 18:15:20', null, '523', '2019-08-07 18:11:48', '2320', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('524', 'sjtjt', '董朔', 'dd4303c6f6a9e11b92ca9a31c9e044c9', '1', '13858143271', null, null, '1', '2019-08-06 00:55:56', '2019-08-07 10:15:15', null, '524', '2019-08-07 10:11:19', '2321', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('525', 'hbjt', null, '0b6fbdbfa8064c797158d1f9c978043f', '0', null, null, null, '1', '2019-08-06 00:55:56', null, null, null, null, '2322', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('526', 'hzwgjt', '徐东波', 'a0dbc028448a593723f2126bb29d1869', '1', '18658865690', null, null, '1', '2019-08-06 00:55:56', '2019-08-07 16:06:30', null, '526', '2019-08-07 15:24:33', '2323', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('527', 'stjj', '席端芳', 'b51adb1657c7971637e50a46d9ae0072', '1', '13750888502', null, '0571-85257329', '1', '2019-08-06 00:55:56', '2019-08-07 10:56:15', null, '527', '2019-08-07 10:54:07', '2324', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('528', 'swjmrhb', '章伟锋', '7abeca0d0034b6cbb41b6cc726fa1e10', '1', '13388610707', null, '0571-85253027', '1', '2019-08-06 00:55:56', '2019-08-09 16:22:23', null, '528', '2019-08-09 16:20:01', '2325', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('529', 'swlgbj', '李辉', '6dff9d596866a0f4aef90f319da7b7bd', '1', '13605801969', null, null, '1', '2019-08-06 00:55:56', '2019-08-08 10:55:07', null, '529', '2019-08-08 10:49:51', '2326', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('530', 'swdx', null, 'ff4e5808a3e85347fe384c5605ef023b', '0', null, null, null, '1', '2019-08-06 00:55:56', null, null, null, null, '2327', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('531', 'swch', '胡玉梅', '34c161a675adc7a31d36d766f97ec7f5', '1', '13957117727', null, null, '1', '2019-08-06 00:55:56', '2019-08-09 17:31:16', null, '531', '2019-08-09 17:29:24', '2328', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('532', 'scl', null, '4e68a048b3715a428ed86c7d9df67a0d', '1', null, null, null, '1', '2019-08-06 00:55:57', '2019-08-07 09:52:21', null, '532', '2019-08-07 09:52:21', '2329', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('533', 'styjrswj', '庄健', 'a15d4d95137413ca7d82b00b42860fda', '1', '13858115700', null, '0571-85153148', '1', '2019-08-06 00:55:57', '2019-08-08 10:28:42', null, '533', '2019-08-08 10:21:18', '2330', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('534', 'hagjjzx', '李娜', '6e8e2d12bda673982ff3ae3d41c729e2', '1', '13958171680', null, '0571-87566310', '1', '2019-08-06 00:55:57', '2019-08-07 17:36:48', null, '534', '2019-08-07 14:45:29', '2331', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('535', 'cxkccyjjqgwh', null, '53475087bafeec8c82cda4247a26a239', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2332', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('536', 'szfzbjbgs', null, '86770d29d674171edae5bd10b057b7d1', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2333', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('537', 'szfzshbgs', null, 'e58877e46a6e825f28554a01354a8f38', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2334', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('538', 'ssjj', '吴淑志', 'fc976a65404c6abe35a7e4dbda81e6c2', '1', '13858188088', null, null, '1', '2019-08-06 00:55:57', '2019-08-07 13:37:11', null, '538', '2019-08-07 13:22:16', '2335', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('539', 'srfj', null, '0bed89519a764ae3de7d22e70c80a8cd', '1', null, null, null, '1', '2019-08-06 00:55:57', '2019-08-12 09:47:58', null, '539', '2019-08-12 09:47:58', '2336', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('540', 'sskl', '叶晓', '3996a579dfb76498f96fa3d30e9aa021', '1', '13588111886', null, '0571-85811575', '1', '2019-08-06 00:55:57', '2019-08-09 16:27:44', null, '540', '2019-08-09 16:21:19', '2337', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('541', 'swtb', '黄洁颖', 'c2f0577758aaa8d8de6bfe0d5253730d', '1', '13868134096', null, null, '1', '2019-08-06 00:55:57', '2019-08-08 15:25:33', null, '541', '2019-08-08 11:34:39', '2338', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('542', 'sql', null, '5dbbe701ec803f90fa94b50d3fa30628', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2339', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('543', 'sgsl', '张科', '85dd7474925ad7af3520fe40f568034b', '1', '13750866888', null, null, '1', '2019-08-06 00:55:57', '2019-08-08 10:58:38', null, '543', '2019-08-07 16:43:58', '2340', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('544', 'mgswh', null, 'c89f74bc43eb6bac43a07a3fa66adc02', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2341', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('545', 'mlswh', null, '84e44fa55fd8fdaa5ac383e3b4d9a29f', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2342', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('546', 'mjswh1', null, 'dda5885492bdcd30df0ef5763633546d', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2343', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('547', 'mjswh2', null, 'b754797545365e6aa3f11ca321f9aa3d', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2344', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('548', 'mgtswh', null, 'bd90877e766a4c249eae2fc26fcc8926', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2345', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('549', 'zgdswh', null, '308ec732dde37c0b9ab6b25e4e808fc2', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2346', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('550', 'jsxsswh', null, '37de290ffc754bf604fb176cf431cf8c', '0', null, null, null, '1', '2019-08-06 00:55:57', null, null, null, null, '2347', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('551', 'gjtjjhztcd', '何艳秋', '461bbc23fb2f6f9f2f9afced512effd3', '1', '13958100525', null, '0571-85257416', '1', '2019-08-06 00:55:57', '2019-08-12 09:05:04', null, '551', '2019-08-09 18:02:10', '2348', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('552', 'hzhg', '梁萌', 'cd4c4448493cf065feb8e07eec4432c1', '1', '13666686257', null, null, '1', '2019-08-06 00:55:58', '2019-08-09 17:37:03', null, '552', '2019-08-09 17:32:04', '2349', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('553', 'hztlgac', null, '6e33d2234f147eb41bdacd9b5788ff13', '0', null, null, null, '1', '2019-08-06 00:55:58', null, null, null, null, '2350', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('554', 'hzcrjbfjcz', null, 'f1403469aaa138d23ed00ab43a89e209', '0', null, null, null, '1', '2019-08-06 00:55:58', null, null, null, null, '2351', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('555', 'syzglj', null, '60ec7095ef4baafbffe8d06c54d95d26', '0', null, null, null, '1', '2019-08-06 00:55:58', null, null, null, null, '2352', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('556', 'sycj', null, '48da97c696399aec3b2f5370fa035056', '0', null, null, null, '1', '2019-08-06 00:55:58', null, null, null, null, '2353', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('557', 'hzdxgs', null, 'db1d6091897976e5a78462a447619f46', '0', null, null, null, '1', '2019-08-06 00:55:58', null, null, null, null, '2354', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('558', 'hzydgs', null, 'bddad0bc6088a4ff1fd944310c578665', '0', null, null, null, '1', '2019-08-06 00:55:58', null, null, null, null, '2355', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('559', 'hzltgs', null, '1def2986ae102c8660debaec6fc6bcf4', '0', null, null, null, '1', '2019-08-06 00:55:58', null, null, null, null, '2356', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('560', 'hzyzgs', null, '4a7a704219b89c72fd2cae2224e88d9d', '0', null, null, null, '1', '2019-08-06 00:55:58', null, null, null, null, '2357', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('591', 'snyncj', '冯莉', '1d9860d007745b366a742c58efbbb2c6', '1', '18958087186', null, null, '1', '2019-08-06 01:33:30', '2019-08-07 12:09:39', null, '591', '2019-08-07 10:43:02', '145', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('592', 'sjxj', null, '82b160606ed198502baf952981cb0564', '0', null, null, null, '1', '2019-08-06 01:33:30', '2019-08-06 01:33:30', null, null, null, '122', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('593', 'syjglj', '吴俊', 'd92c9c3892e49f9b35774bd2ac488d55', '1', '13819127877', null, '0571-85259649', '1', '2019-08-06 01:33:30', '2019-08-07 17:41:59', null, '593', '2019-08-07 17:36:49', '150', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('594', 'ssthjj', '邵煜琦', '417c06221325957d7fd44f958604e953', '1', '13957122896', null, null, '1', '2019-08-06 01:33:30', '2019-08-07 17:50:33', null, '594', '2019-08-07 11:42:23', '95', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('595', 'sscjgj', '范立', '1d5ff665a16e7870bac0b2c59a140c18', '1', '18067978865', null, null, '1', '2019-08-06 01:33:30', '2019-08-08 14:27:42', null, '595', '2019-08-08 13:22:30', '138', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('596', 'scgj', '戴旭', '61fcd4d697fb67e9c4695756d3ec833e', '1', '13336048848', null, '', '1', '2019-08-06 01:33:30', '2019-08-07 16:15:57', null, '596', '2019-08-07 12:44:20', '64', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('597', 'swhgdlyj', '李伟平', 'cf8f1e7e8911790ab90978776d63d200', '1', '15221581056', null, null, '1', '2019-08-06 01:33:30', '2019-08-07 19:40:48', null, '597', '2019-08-07 17:41:18', '67', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('598', 'swsjkw', '何炜', '11de5cb295a8644bf36a615ed74c7bd8', '0', '13858137303', null, null, '1', '2019-08-06 01:33:30', '2019-08-09 13:01:30', null, null, null, '136', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('599', 'szbfgj', '毛珍珍', 'bdb65f7647cc7a74843cd9dcd54aec59', '1', '18072969495', null, null, '1', '2019-08-06 01:33:30', '2019-08-07 10:37:53', null, '599', '2019-08-07 10:28:02', '140', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('600', 'scq', '孟慧君', '0495d2a05263c1c3caad3c17f81b65f7', '1', '19975251880', null, '0571-87823516', '1', '2019-08-06 01:33:30', '2019-08-07 09:43:11', null, '600', '2019-08-07 09:37:07', '147', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('601', 'xsq', '章建平', 'c75f2fad796353a834def11a2b50ff81', '1', '13967114110', null, '0571-83897207', '1', '2019-08-06 01:33:30', '2019-08-09 09:14:56', null, '601', '2019-08-09 09:11:30', '71', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('602', 'fyq', '于绩洋', '14836da7fc3e9b9f96b824d8a1fe1216', '1', '13968167928', null, null, '1', '2019-08-06 01:33:30', '2019-08-09 08:33:04', null, '602', '2019-08-09 08:31:49', '70', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('603', 'jdq', '万里', '7efa5ee408a83f9741d484db8bc70daf', '1', '13819161616', null, '0571-64705550', '1', '2019-08-06 01:33:30', '2019-08-07 15:55:32', null, '603', '2019-08-07 12:20:02', '143', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('604', 'gsq', '施建伟', '2bfa83cf9dbfb8f3f9a07f936d51cc32', '1', '18906526668', null, '0571-58125668', '1', '2019-08-06 01:33:30', '2019-08-07 13:01:46', null, '604', '2019-08-07 12:45:38', '101', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('605', 'yhq', '王炜', '9e77efd54f3aece3d00611a4edf8a3d6', '1', '18810992722', null, '', '1', '2019-08-06 01:33:30', '2019-08-07 13:42:03', null, '605', '2019-08-07 13:39:15', '137', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('606', 'xcq', '雷卿', 'b25ff5e39d8e35f3f43cb41f9b4bac14', '1', '15700196682', null, null, '1', '2019-08-06 01:33:30', '2019-08-07 12:33:23', null, '606', '2019-08-07 12:30:00', '131', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('607', 'bjq', '郑威', '27ca0b1a59760607682180a53b140221', '1', '13396819083', null, '', '1', '2019-08-06 01:33:30', '2019-08-08 15:40:21', null, '607', '2019-08-08 14:52:38', '153', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('608', 'laq', '贾炜琦', '9b077d515e40affca7f01a511326d65a', '1', '13666634393', null, null, '1', '2019-08-06 01:33:30', '2019-08-07 13:57:07', null, '608', '2019-08-07 13:49:28', '146', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('609', 'hzxhfjmsqgwh', '方国兴', '0ec70be5a31c347c7da2106f54972a3b', '1', '13958195228', null, '', '1', '2019-08-06 01:33:30', '2019-08-08 11:33:12', null, '609', '2019-08-08 09:02:57', '253', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('610', 'caq', '吴坚平', '7b312003151606e4a40f4eec843345a8', '1', '13777817379', null, null, '1', '2019-08-06 01:33:30', '2019-08-07 17:40:06', null, '610', '2019-08-07 17:37:15', '129', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('611', 'xhq', '孙慧洁', 'f2561fc2b072be861fc9390b9f14b73e', '1', '13588716383', null, null, '1', '2019-08-06 01:33:30', '2019-08-07 16:27:38', null, '611', '2019-08-07 16:23:15', '141', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('612', 'jgq', '罗荣军', 'e5b9a8114411b4201abc2788d1c38606', '1', '13858063511', null, '0571-86974716', '1', '2019-08-06 01:33:30', '2019-08-07 15:05:29', null, '612', '2019-08-07 14:57:18', '135', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('613', 'tlq', '縢雪飞', 'a4f1150065f9b2a2c30ef46d6d086111', '1', '13588236866', null, null, '1', '2019-08-06 01:33:30', '2019-08-07 14:32:17', null, '613', '2019-08-07 12:58:10', '252', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('614', 'qtxq', '赵贤富', 'ab717a8f0f4894feabb631de6c4cc55c', '1', '13777388388', null, '0571-82981096', '1', '2019-08-06 01:33:30', '2019-08-07 11:56:26', null, '614', '2019-08-07 11:54:39', '152', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('615', 'gwhzgdgs', null, 'debee98b74c86066b8f9d969a2729eee', '0', null, null, null, '1', '2019-08-06 01:33:30', '2019-08-06 01:33:30', null, null, null, '139', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('616', 'swzfw', '汝虎', '0084bf97384fc89cb5780a3c0a87d0c8', '1', '13588812080', null, '0571-85253041', '1', '2019-08-06 01:33:30', '2019-08-07 11:04:15', null, '616', '2019-08-07 10:45:48', '149', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('617', 'sfgw', '孙向光', 'ca801bd1a1b883ec96bbb8b71a0e1a6e', '1', '13033613818', null, null, '1', '2019-08-06 01:33:30', '2019-08-07 14:53:05', null, '617', '2019-08-07 11:13:40', '68', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('622', 'sgaj1', '王秋', '33aea03e89f9d80c18093689061a55a9', '1', '15968831999', null, null, '1', '2019-08-06 02:00:46', '2019-08-07 17:10:23', null, '622', '2019-08-07 17:04:33', '66', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('623', 'sjtjcj', '周为钢', '2fb29daea195557c4956ca728f969dc4', '1', '13858080987', null, '0571-87282332', '1', '2019-08-07 16:50:43', '2019-08-08 10:22:34', null, '623', '2019-08-07 16:56:51', '63', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('624', 'hbjd', '郑欣', 'bd90d06d7f312f57a13ad8108f9c1530', '1', '13615817546', null, null, '1', '2019-08-08 17:09:53', '2019-08-09 13:39:49', null, '624', '2019-08-09 11:35:11', '121', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('625', 'swmb', null, '79b55293f02f197736529b867814de02', '0', null, null, null, '1', '2019-08-08 18:02:52', null, null, null, null, '2358', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('626', 'sctjt', '陈琦涛', 'c36105911ac343d217a47bcc1271736a', '1', '13757142088', null, null, '1', '2019-08-08 18:08:30', '2019-08-09 09:31:17', null, '626', '2019-08-09 09:24:06', '2359', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('627', 'gcy_test', null, '72c84c33da6c2583ea6aa7a087f30b38', '1', null, null, null, '1', '2019-08-09 10:26:27', '2019-08-09 16:10:57', null, '627', '2019-08-09 16:10:57', '2360', null, '1', 'PASS', null, null);
INSERT INTO `operation_customer_user` VALUES ('628', 'top_ever', '郑燕江  开发公司 项目负责', '7a6c192c051f8bbb48362682caa0b4a8', '0', '18667163031', '9844730@qq.com', null, '0', '2019-08-09 14:47:47', null, '481', '0', '2019-08-09 14:47:47', '2278', null, '0', 'PASS', null, null);
