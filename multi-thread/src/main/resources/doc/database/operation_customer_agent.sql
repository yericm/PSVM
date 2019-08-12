/*
Navicat MySQL Data Transfer

Source Server         : 172.18.109.89_prod
Source Server Version : 50634
Source Host           : 172.18.109.89:3306
Source Database       : citybrain_service

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2019-08-12 10:01:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `operation_customer_agent`
-- ----------------------------
DROP TABLE IF EXISTS `operation_customer_agent`;
CREATE TABLE `operation_customer_agent` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `app_info_id` bigint(11) DEFAULT NULL COMMENT '对应接入方的app_info_id',
  `agent_ip` varchar(20) DEFAULT NULL COMMENT 'agent所在的主机地址',
  `agent_port` varchar(60) DEFAULT NULL COMMENT 'agent所在服务器登录端口',
  `agent_path` varchar(126) DEFAULT NULL COMMENT '在中枢服务器上路径',
  `agent_login_name` varchar(126) DEFAULT NULL COMMENT 'agent所在主机登录名',
  `agent_passwd` varchar(126) DEFAULT NULL COMMENT 'agent所在主机初始密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_app_info_id` (`app_info_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=385 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of operation_customer_agent
-- ----------------------------
INSERT INTO `operation_customer_agent` VALUES ('255', '64', '172.18.110.8', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('256', '66', '172.18.110.242', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('257', '67', '172.18.110.16', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('258', '68', '172.18.110.33', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('259', '70', '172.18.110.45', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('260', '71', '172.18.110.41', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('261', '95', '172.18.110.10', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('262', '101', '172.18.110.49', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('263', '122', '172.18.110.37', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('264', '129', '172.18.110.183', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('265', '131', '172.18.110.50', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('266', '135', '172.18.110.48', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('267', '136', '172.18.110.3', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('268', '137', '172.18.110.44', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('269', '139', '172.18.110.228', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('270', '140', '172.18.110.4', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('271', '141', '172.18.110.42', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('272', '138', '172.18.110.12', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('273', '143', '172.18.110.40', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('274', '145', '172.18.110.28', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('275', '146', '172.18.110.46', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('276', '147', '172.18.110.47', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('277', '149', '172.18.110.31', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('278', '150', '172.18.110.27', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('279', '152', '172.18.110.32', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('280', '153', '172.18.110.43', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('281', '252', '172.18.110.39', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('282', '253', '172.18.110.237', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('283', '2266', '172.18.110.34', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('284', '2267', '172.18.110.36', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('285', '2268', '172.18.110.30', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('286', '2269', '172.18.110.20', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('287', '2270', '172.18.110.23', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('288', '2271', '172.18.110.24', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('289', '2272', '172.18.110.25', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('290', '2273', '172.18.110.26', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('291', '2274', '172.18.110.21', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('292', '2275', '172.18.110.22', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('293', '2276', '172.18.110.5', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('294', '2277', '172.18.110.14', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('295', '2278', '172.18.110.17', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('296', '2279', '172.18.110.6', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('297', '2280', '172.18.110.7', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('298', '2281', '172.18.110.9', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('299', '2282', '172.18.110.11', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('300', '2283', '172.18.110.182', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('301', '2284', '172.18.110.13', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('302', '2285', '172.18.110.18', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('303', '2286', '172.18.110.15', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('304', '2287', '172.18.110.19', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('305', '2288', '172.18.110.241', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('306', '2289', '172.18.110.245', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('307', '2290', '172.18.110.248', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('308', '2291', '172.18.110.249', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('309', '2292', '172.18.110.240', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('310', '2293', '172.18.110.243', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('311', '2294', '172.18.110.247', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('312', '2295', '172.18.110.251', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('313', '2296', '172.18.110.239', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('314', '2297', '172.18.110.229', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('315', '2298', '172.18.110.231', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('316', '2299', '172.18.110.215', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('317', '2300', '172.18.110.250', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('318', '2301', '172.18.110.216', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('319', '2302', '172.18.110.218', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('320', '2303', '172.18.110.220', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('321', '2304', '172.18.110.223', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('322', '2305', '172.18.110.230', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('323', '2306', '172.18.110.225', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('324', '2307', '172.18.110.252', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('325', '2308', '172.18.110.226', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('326', '2309', '172.18.110.232', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('327', '2310', '172.18.110.234', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('328', '2311', '172.18.110.214', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('329', '2312', '172.18.110.217', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('330', '2313', '172.18.110.219', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('331', '2314', '172.18.110.238', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('332', '2315', '172.18.110.221', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('333', '2316', '172.18.110.222', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('334', '2317', '172.18.110.224', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('335', '2318', '172.18.110.208', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('336', '2319', '172.18.110.211', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('337', '2320', '172.18.110.213', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('338', '2321', '172.18.110.205', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('339', '2322', '172.18.110.206', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('340', '2323', '172.18.110.207', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('341', '2324', '172.18.110.227', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('342', '2325', '172.18.110.35', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('343', '2326', '172.18.110.209', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('344', '2327', '172.18.110.210', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('345', '2328', '172.18.110.212', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('346', '2329', '172.18.110.198', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('347', '2330', '172.18.110.201', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('348', '2331', '172.18.110.233', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('349', '2332', '172.18.110.204', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('350', '2333', '172.18.110.199', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('351', '2334', '172.18.110.200', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('352', '2335', '172.18.110.235', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('353', '2336', '172.18.110.236', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('354', '2337', '172.18.110.202', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('355', '2338', '172.18.110.203', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('356', '2339', '172.18.110.194', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('357', '2340', '172.18.110.192', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('358', '2341', '172.18.110.186', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('359', '2342', '172.18.110.181', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('360', '2343', '172.18.110.29', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('361', '2344', '172.18.110.38', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('362', '2345', '172.18.110.244', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('363', '2346', '172.18.110.246', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('364', '2347', '172.18.110.185', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('365', '2348', '172.18.110.193', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('366', '2349', '172.18.110.195', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('367', '2350', '172.18.110.196', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('368', '2351', '172.18.110.197', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('369', '2352', '172.18.110.188', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('370', '2353', '172.18.110.190', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('371', '2354', '172.18.110.187', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('372', '2355', '172.18.110.189', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('373', '2356', '172.18.110.191', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('374', '2357', '172.18.110.184', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('375', '63', '172.18.109.117', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('382', '121', '172.18.110.66', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('383', '2358', '172.18.110.65', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
INSERT INTO `operation_customer_agent` VALUES ('384', '2359', '172.18.110.67', '22', '/root/agent4', 'root', 'm1jqCxFOlW');
