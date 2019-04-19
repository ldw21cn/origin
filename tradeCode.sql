/*
 Navicat Premium Data Transfer

 Source Server         : 172.16.70.136
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : 172.16.70.136:3306
 Source Schema         : studb

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 19/04/2019 14:19:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tradeCode
-- ----------------------------
DROP TABLE IF EXISTS `tradeCode`;
CREATE TABLE `tradeCode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `callNo` int(25) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updatedAt` date DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tradeCode
-- ----------------------------
BEGIN;
INSERT INTO `tradeCode` VALUES (71, '测试10', '一个任务名称1', 'owner', '测试任务', 1460000, '1', NULL, NULL);
INSERT INTO `tradeCode` VALUES (72, '测试20', '一个任务名称2', 'owner', '测试任务', 1460000, '1', NULL, NULL);
INSERT INTO `tradeCode` VALUES (73, '测试30', '一个任务名称3', 'owner', '测试任务', 1460000, '1', NULL, NULL);
INSERT INTO `tradeCode` VALUES (74, '测试40', '一个任务名称4', 'owner', '测试任务', 1460000, '1', NULL, NULL);
INSERT INTO `tradeCode` VALUES (75, '测试50', '一个任务名称5', 'owner', '测试任务', 1460000, '1', NULL, NULL);
INSERT INTO `tradeCode` VALUES (76, '测试60', '一个任务名称6', 'owner', '测试任务', 1460000, '1', NULL, NULL);
INSERT INTO `tradeCode` VALUES (77, '测试70', '一个任务名称7', 'owner', '测试任务', 1460000, '1', NULL, NULL);
INSERT INTO `tradeCode` VALUES (78, '测试80', '一个任务名称8', 'owner', '测试任务', 1460000, '1', NULL, NULL);
INSERT INTO `tradeCode` VALUES (80, '测试10', '一个任务名称1', 'owner', '测试任务', 1460000, '1', NULL, NULL);
INSERT INTO `tradeCode` VALUES (81, '测试20', '一个任务名称2', 'owner', '测试任务', 1460000, '2', NULL, NULL);
INSERT INTO `tradeCode` VALUES (82, '测试30', '一个任务名称3', 'owner', '测试任务', 1460000, '2', NULL, NULL);
INSERT INTO `tradeCode` VALUES (83, '测试40', '一个任务名称4', 'owner', '测试任务', 1460000, '2', NULL, NULL);
INSERT INTO `tradeCode` VALUES (84, '测试50', '一个任务名称5', 'owner', '测试任务', 1460000, '2', NULL, NULL);
INSERT INTO `tradeCode` VALUES (85, '测试60', '一个任务名称6', 'owner', '测试任务', 1460000, '2', NULL, NULL);
INSERT INTO `tradeCode` VALUES (86, '测试70', '一个任务名称7', 'owner', '测试任务', 1460000, '2', NULL, NULL);
INSERT INTO `tradeCode` VALUES (90, '测试 xxx', '这是一个任务描述', '曲贡', '111111', 1460000, '0', '2019-04-07', '2019-04-07 11:53:13');
INSERT INTO `tradeCode` VALUES (91, '测试 xxx', '这是一个任务描述', '曲贡', '111111', 1460000, '0', '2019-04-07', '2019-04-07 12:03:40');
INSERT INTO `tradeCode` VALUES (93, '北京云杉餐饮管理系统', '这是一个任务描述', '曲贡', '111111', 1460000, '2', '2019-04-08', '2019-04-08 11:31:16');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
