/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : db-studentms

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-01-04 10:03:08
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
INSERT INTO `students` VALUES ('2131241', '阿斯顿覅as', '1999-05-15', '男', '四川', '遂宁', '汉族');
INSERT INTO `students` VALUES ('21412', 'asdgf', '1999-05-07', '男', '北京', '北京', '汉族');
INSERT INTO `students` VALUES ('436463', '阿斯蒂芬', '1998-05-07', '女', '四川', '成都', '汉族');
INSERT INTO `students` VALUES ('56464465', '王渔', '1997-05-13', '男', '重庆', '北碚', '汉族');

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
INSERT INTO `users` VALUES ('', '');
INSERT INTO `users` VALUES ('123', '123');
INSERT INTO `users` VALUES ('12312312', '213123');
INSERT INTO `users` VALUES ('123456', '123456');
INSERT INTO `users` VALUES ('234', '234');
INSERT INTO `users` VALUES ('324234', '234124');
INSERT INTO `users` VALUES ('432', '432');
INSERT INTO `users` VALUES ('adfasf', 'asfdasdf');
INSERT INTO `users` VALUES ('agd', 'gdasg');
INSERT INTO `users` VALUES ('qer', 'qwer');
INSERT INTO `users` VALUES ('qwe', 'qwe');
INSERT INTO `users` VALUES ('qwshenger', 'qwer');
