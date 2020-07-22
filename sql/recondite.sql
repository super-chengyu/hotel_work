/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : hotel_work

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-07-22 20:58:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for recondite
-- ----------------------------
DROP TABLE IF EXISTS `recondite`;
CREATE TABLE `recondite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `home_id` int(11) DEFAULT NULL,
  `eat_status` int(11) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL COMMENT '离店日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recondite
-- ----------------------------
