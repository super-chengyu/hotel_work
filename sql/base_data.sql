/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : hotel_work

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-07-22 20:58:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_data
-- ----------------------------
DROP TABLE IF EXISTS `base_data`;
CREATE TABLE `base_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `base_name` varchar(255) DEFAULT NULL COMMENT '基础名字',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `is_del` int(11) DEFAULT NULL COMMENT '0:正常，1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_data
-- ----------------------------
INSERT INTO `base_data` VALUES ('1', '用户身份', '0', '0');
INSERT INTO `base_data` VALUES ('2', '普通用户', '1', '0');
INSERT INTO `base_data` VALUES ('3', '会员用户', '1', '0');
INSERT INTO `base_data` VALUES ('4', '大堂经理', '1', '0');
INSERT INTO `base_data` VALUES ('5', '厨师', '1', '0');
INSERT INTO `base_data` VALUES ('6', '用餐状态', '0', '0');
INSERT INTO `base_data` VALUES ('7', '已到店', '6', '0');
INSERT INTO `base_data` VALUES ('8', '已点餐', '6', '0');
INSERT INTO `base_data` VALUES ('9', '餐已好', '6', '0');
INSERT INTO `base_data` VALUES ('10', '已离店', '6', '0');
