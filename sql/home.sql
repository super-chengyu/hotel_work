/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : hotel_work

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-07-22 20:58:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for home
-- ----------------------------
DROP TABLE IF EXISTS `home`;
CREATE TABLE `home` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `home_name` varchar(255) DEFAULT NULL COMMENT '房间名',
  `home_status` int(11) DEFAULT NULL COMMENT '房间状态（有无预约 0:无预约，1:已预约）',
  `is_vip` int(11) DEFAULT NULL COMMENT '是否为会员房间 0：是，1：不是',
  `is_del` int(11) DEFAULT NULL COMMENT '伪删除0：正常，1：删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of home
-- ----------------------------
