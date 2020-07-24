/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : hotel_work

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-07-22 20:58:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) DEFAULT NULL COMMENT '菜名',
  `menu_price` decimal(10,2) DEFAULT NULL,
  `menu_note` varchar(255) DEFAULT NULL COMMENT '菜品介绍',
  `menu_status` varchar(255) DEFAULT NULL COMMENT '菜名状态',
  `is_del` int(11) DEFAULT NULL COMMENT '伪删除，0：正常，1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
ALTER TABLE `menu`
MODIFY COLUMN `menu_status`  int(11) NULL DEFAULT NULL COMMENT '菜名状态' AFTER `menu_note`;