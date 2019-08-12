/*
Navicat MySQL Data Transfer

Source Server         : 172.18.109.89_prod
Source Server Version : 50634
Source Host           : 172.18.109.89:3306
Source Database       : citybrain_service

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2019-08-12 10:00:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `operation_user`
-- ----------------------------
DROP TABLE IF EXISTS `operation_user`;
CREATE TABLE `operation_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `login_name` varchar(50) NOT NULL COMMENT '用户名 登陆使用',
  `user_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `passwd` varchar(128) NOT NULL COMMENT '密码',
  `is_login` int(10) DEFAULT NULL COMMENT '激活状态 0首次登录修改密码 1非首次登录',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话',
  `state` int(10) DEFAULT NULL COMMENT '用户状态  0停用 1启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `modify_by` bigint(20) unsigned DEFAULT '0' COMMENT '更新信息人',
  `update_passwd_time` datetime DEFAULT NULL COMMENT '上次修改密码时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `login_name` (`login_name`) USING BTREE COMMENT '登录账号不能重复',
  UNIQUE KEY `index_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operation_user
-- ----------------------------
INSERT INTO `operation_user` VALUES ('63', 'root', '超级管理员', '4e3ff5301559c1c64d801d4861c07bb3', '1', '13812341234', '123@gmail.com', '0571-87654321', '1', '2019-07-30 19:51:50', '2019-07-30 19:52:35', '0', '63', '2019-07-30 19:52:35');
INSERT INTO `operation_user` VALUES ('64', 'yjm245', 'yjm', '6b39ab9c82ba3c7e057224349c58a546', '1', '13563893426', 'nucerw@dingtalk.com', '0571-34956644', '1', '2019-07-30 19:54:38', '2019-07-30 19:55:30', '63', '64', '2019-07-30 19:55:30');
INSERT INTO `operation_user` VALUES ('67', 'sxb', '宋小波', 'b68e0d55f41045668f422b86f2807766', '1', null, null, null, '1', '2019-08-07 16:24:01', '2019-08-08 09:10:28', null, '67', '2019-08-08 09:10:28');
INSERT INTO `operation_user` VALUES ('68', 'lxh', '陆晓红', '111ef4675aa69bba55b12df87d0fb56b', '1', null, null, null, '1', '2019-08-07 16:24:06', '2019-08-09 15:57:38', null, '68', '2019-08-09 15:57:38');
