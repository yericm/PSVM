/*
Navicat MySQL Data Transfer

Source Server         : 172.18.109.89_prod
Source Server Version : 50634
Source Host           : 172.18.109.89:3306
Source Database       : citybrain_service

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2019-08-12 10:01:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `operation_contact`
-- ----------------------------
DROP TABLE IF EXISTS `operation_contact`;
CREATE TABLE `operation_contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '联系人姓名',
  `mobile` varchar(64) DEFAULT NULL COMMENT '联系人手机',
  `telephone` varchar(64) DEFAULT NULL COMMENT '联系人固话',
  `email` varchar(64) DEFAULT NULL COMMENT '联系人邮箱',
  `company` varchar(20) DEFAULT NULL COMMENT '归属 大脑公司/云栖工程院（CITYOS/YUNQI）',
  `role` varchar(20) DEFAULT NULL COMMENT '角色 业务联系人/技术联系人 （BUSINESS/TECH）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of operation_contact
-- ----------------------------
INSERT INTO `operation_contact` VALUES ('69', '陈传焱', '18602763081', null, null, 'YUNQI', null);
INSERT INTO `operation_contact` VALUES ('70', '张智', '18505811240', null, null, 'YUNQI', null);
INSERT INTO `operation_contact` VALUES ('71', '李上武', '18252035105', null, null, 'YUNQI', null);
INSERT INTO `operation_contact` VALUES ('72', '扶晓', '15968153838', null, null, 'YUNQI', null);
INSERT INTO `operation_contact` VALUES ('73', '刘文强', '13037174601', null, null, 'YUNQI', null);
INSERT INTO `operation_contact` VALUES ('74', '王珑', '18295809202', null, null, 'YUNQI', null);
INSERT INTO `operation_contact` VALUES ('75', '雷云霓', '13754250711', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('76', '沈周昕', '15824108269', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('77', '郜亚楠', '17852870686', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('78', '叶晓华', '17767094926', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('79', '胡林林', '17745132750', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('80', '魏勇江', '13306819001', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('81', '俞练', '13567178605', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('82', '丁树成', '15325815885', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('83', '陈立超', '13588749367', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('84', '司稳稳', '13296575643', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('85', '叶智应', '18555092113', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('86', '朱铭', '13355786656', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('87', '金颖磊', '13758215989', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('88', '方谊诚', '15906650622', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('89', '韩诗琳', '15869105533', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('90', '汪宇翔', '18268030269', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('91', '赵鹏炜', '13732223129', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('92', '王燕', '15138939625', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('93', '樊磊', '13569617248', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('94', '隋文娟', '17853502300', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('95', '俞金萍', '17826618061', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('96', '朱晓冰', '13237088293', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('97', '陈一旸', '13105751643', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('98', '陈吉俊', '17621772125', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('99', '罗佳敏', '18062669275', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('100', '吴晶', '15868191692', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('101', '李洪峰', '13575748782', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('102', '李德玉', '18772247265', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('103', '李洪峰', '18268030269', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('104', '李洪峰', '13575748782', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('105', '樊磊', '13569617248', null, null, 'CITYOS', 'BUSSINESS');
INSERT INTO `operation_contact` VALUES ('106', '雷云霓', '13754250711', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('107', '沈周昕', '15824108269', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('108', '郜亚楠', '17852870686', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('109', '叶晓华', '17767094926', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('110', '胡林林', '17745132750', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('111', '魏勇江', '13306819001', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('112', '俞练', '13567178605', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('113', '丁树成', '15325815885', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('114', '陈立超', '13588749367', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('115', '司稳稳', '13296575643', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('116', '叶智应', '18555092113', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('117', '朱铭', '13355786656', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('118', '金颖磊', '13758215989', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('119', '方谊诚', '15906650622', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('120', '韩诗琳', '15869105533', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('121', '汪宇翔', '18268030269', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('122', '赵鹏炜', '13732223129', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('123', '王燕', '15138939625', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('124', '樊磊', '13569617248', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('125', '隋文娟', '17853502300', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('126', '俞金萍', '17826618061', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('127', '朱晓冰', '13237088293', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('128', '陈一旸', '13105751643', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('129', '陈吉俊', '17621772125', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('130', '罗佳敏', '18062669275', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('131', '吴晶', '15868191692', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('132', '李洪峰', '13575748782', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('133', '李德玉', '18772247265', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('134', '李洪峰', '18268030269', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('135', '李洪峰', '13575748782', null, null, 'CITYOS', 'TECH');
INSERT INTO `operation_contact` VALUES ('136', '樊磊', '13569617248', null, null, 'CITYOS', 'TECH');
