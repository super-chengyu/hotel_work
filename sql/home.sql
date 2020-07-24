/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : hotel_work

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-07-24 14:51:31
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of home
-- ----------------------------
INSERT INTO `home` VALUES ('1', '大厅一号', '1', '1', '0');
INSERT INTO `home` VALUES ('2', '大厅二号', '0', '1', '0');
INSERT INTO `home` VALUES ('3', '大厅三号', '0', '1', '0');
INSERT INTO `home` VALUES ('4', '大厅四号', '0', '1', '0');
INSERT INTO `home` VALUES ('5', '大厅五号', '0', '1', '0');
INSERT INTO `home` VALUES ('6', '大厅六号', '0', '1', '0');
INSERT INTO `home` VALUES ('7', '大厅七号', '0', '1', '0');
INSERT INTO `home` VALUES ('8', '大厅八号', '0', '1', '0');
INSERT INTO `home` VALUES ('9', '大厅九号', '0', '1', '0');
INSERT INTO `home` VALUES ('10', '天字一号', '0', '0', '0');
INSERT INTO `home` VALUES ('11', '天字二号', '0', '0', '0');
INSERT INTO `home` VALUES ('12', '天字三号', '0', '0', '0');
INSERT INTO `home` VALUES ('13', '天字四号', '0', '0', '0');
INSERT INTO `home` VALUES ('14', '地字一号', '0', '0', '0');
INSERT INTO `home` VALUES ('15', '地字二号', '0', '0', '0');
INSERT INTO `home` VALUES ('16', '地字三号', '0', '0', '0');
INSERT INTO `home` VALUES ('17', '地子四号', '0', '0', '0');
INSERT INTO `home` VALUES ('18', '龙门镖局', '0', '0', '0');
INSERT INTO `home` VALUES ('19', '纪盛昌', '0', '0', '0');
