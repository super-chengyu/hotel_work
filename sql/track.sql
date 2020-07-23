/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : hotel_work

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-07-22 20:58:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for track
-- ----------------------------
DROP TABLE IF EXISTS `track`;
CREATE TABLE `track` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reco_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `menu_num` int(11) DEFAULT NULL,
  `menu_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of track
-- ----------------------------
ALTER TABLE `track`
ADD COLUMN `menu_confirm`  varchar(255) NULL COMMENT '备注' AFTER `menu_price`;
