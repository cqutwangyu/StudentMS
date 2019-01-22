/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : db-studentms

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-01-05 14:07:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `sno` char(11) NOT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `sdatebirth` date DEFAULT NULL,
  `ssex` varchar(255) DEFAULT NULL,
  `snativeplace` varchar(255) DEFAULT NULL,
  `shouseaddress` varchar(255) DEFAULT NULL,
  `snation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('100001', '王浩', '2019-01-01', '', '', '', '');
INSERT INTO `students` VALUES ('100002', '张三', '2019-01-02', '', '', '', '');
INSERT INTO `students` VALUES ('100003', '王三', '2019-01-03', '', '', '', '');
INSERT INTO `students` VALUES ('100004', '小李', '2019-01-11', '', '', '', '');
INSERT INTO `students` VALUES ('100005', '李四', '2018-11-15', '', '', '', '');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
