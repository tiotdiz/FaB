/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : car_rent

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-09-27 16:01:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', '小A');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL DEFAULT '0',
  `order_price` decimal(18,2) NOT NULL DEFAULT '0.00',
  `order_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1', '1000.00', '2018-08-21 09:20:52');
INSERT INTO `t_order` VALUES ('2', '1', '1000.00', '2018-08-21 09:33:21');
INSERT INTO `t_order` VALUES ('3', '1', '1000.00', '2018-08-21 09:36:03');
INSERT INTO `t_order` VALUES ('4', '1', '1000.00', '2018-08-21 09:37:51');

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL DEFAULT '0',
  `vehicle_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
INSERT INTO `t_order_detail` VALUES ('1', '1', '1');
INSERT INTO `t_order_detail` VALUES ('2', '1', '2');
INSERT INTO `t_order_detail` VALUES ('3', '3', '1');
INSERT INTO `t_order_detail` VALUES ('4', '4', '1');

-- ----------------------------
-- Table structure for t_vehicle
-- ----------------------------
DROP TABLE IF EXISTS `t_vehicle`;
CREATE TABLE `t_vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `price` decimal(18,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vehicle
-- ----------------------------
INSERT INTO `t_vehicle` VALUES ('1', '宝马', '1000.00');
INSERT INTO `t_vehicle` VALUES ('2', 'Audi', '100.00');
INSERT INTO `t_vehicle` VALUES ('3', '奔驰', '0.00');
INSERT INTO `t_vehicle` VALUES ('4', 'VOLVO', '1.00');
INSERT INTO `t_vehicle` VALUES ('5', '大众', '234.00');
INSERT INTO `t_vehicle` VALUES ('6', '皇冠', '23.00');
INSERT INTO `t_vehicle` VALUES ('7', '法拉利', '0.00');
INSERT INTO `t_vehicle` VALUES ('8', '华晨宝马', '8.00');
