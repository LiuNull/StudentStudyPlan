/*
Navicat MySQL Data Transfer

Source Server         : Connection
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : studentmanagement

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-11-29 15:02:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `clazzid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`clazzid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('1', '计算机1401班');
INSERT INTO `clazz` VALUES ('2', '计算机1402班');
INSERT INTO `clazz` VALUES ('3', '计算机1403班');

-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail` (
  `detailid` int(11) NOT NULL AUTO_INCREMENT,
  `kecheng` int(11) DEFAULT NULL,
  `plan` int(11) DEFAULT NULL,
  PRIMARY KEY (`detailid`),
  KEY `IPLAN` (`plan`),
  KEY `FK_kecheng` (`kecheng`),
  CONSTRAINT `FK_kecheng` FOREIGN KEY (`kecheng`) REFERENCES `kecheng` (`kechengid`) ON UPDATE CASCADE,
  CONSTRAINT `FK_plan` FOREIGN KEY (`plan`) REFERENCES `plan` (`planid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detail
-- ----------------------------
INSERT INTO `detail` VALUES ('1', '1', '1');
INSERT INTO `detail` VALUES ('2', '2', '1');
INSERT INTO `detail` VALUES ('3', '3', '1');
INSERT INTO `detail` VALUES ('4', '4', '1');
INSERT INTO `detail` VALUES ('5', '5', '1');
INSERT INTO `detail` VALUES ('6', '6', '1');

-- ----------------------------
-- Table structure for kecheng
-- ----------------------------
DROP TABLE IF EXISTS `kecheng`;
CREATE TABLE `kecheng` (
  `kechengid` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `credit` float DEFAULT NULL,
  `totaltime` int(11) DEFAULT '0',
  `week` int(11) DEFAULT '0',
  `term` char(6) DEFAULT NULL,
  `subject` int(11) DEFAULT NULL,
  `iselective` int(11) DEFAULT NULL,
  PRIMARY KEY (`kechengid`),
  KEY `IELECTIVE` (`iselective`),
  KEY `ISUBJECT` (`subject`),
  CONSTRAINT `FK_subjectkecheng` FOREIGN KEY (`subject`) REFERENCES `subject` (`subjectid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kecheng
-- ----------------------------
INSERT INTO `kecheng` VALUES ('1', '数据库概论', '3', '64', '0', '201602', '1', '0');
INSERT INTO `kecheng` VALUES ('2', '编译原理', '4.5', '64', '0', '201701', '1', '0');
INSERT INTO `kecheng` VALUES ('3', '操作系统', '4.5', '63', '0', '201601', '1', '0');
INSERT INTO `kecheng` VALUES ('4', '电子商务', '2', '0', '12', '201602', '1', '1');
INSERT INTO `kecheng` VALUES ('5', 'MySQL数据库程序设计', '2', '0', '12', '201701', '1', '1');
INSERT INTO `kecheng` VALUES ('6', '数据库系统综合实验', '1', '20', '0', '201701', '1', '1');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `subject` int(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`managerid`),
  KEY `FK_manager_subject` (`subject`),
  CONSTRAINT `FK_manager_subject` FOREIGN KEY (`subject`) REFERENCES `subject` (`subjectid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '王红霞', '123', '1', '20', '0');
INSERT INTO `manager` VALUES ('2', '刘传文', '123', '2', '50', '1');
INSERT INTO `manager` VALUES ('3', '邓佳', '123', '1', '28', '1');

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `planid` int(11) NOT NULL,
  `subject` int(11) DEFAULT NULL,
  `term` char(6) DEFAULT NULL,
  PRIMARY KEY (`planid`),
  KEY `FK_plan_subjectid` (`subject`),
  CONSTRAINT `FK_plan_subjectid` FOREIGN KEY (`subject`) REFERENCES `subject` (`subjectid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES ('1', '1', '201602');
INSERT INTO `plan` VALUES ('2', '1', '201701');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) NOT NULL,
  `password` varchar(11) DEFAULT NULL,
  `subject` int(11) DEFAULT NULL,
  `clazz` int(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentid`),
  KEY `ISUBJECT` (`subject`),
  KEY `ICALZZ` (`clazz`),
  CONSTRAINT `FK_clazz` FOREIGN KEY (`clazz`) REFERENCES `clazz` (`clazzid`) ON UPDATE CASCADE,
  CONSTRAINT `FK_subjectstudent` FOREIGN KEY (`subject`) REFERENCES `subject` (`subjectid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '张泽晗', '123', '2', '3', '19', '1');
INSERT INTO `student` VALUES ('3', '李楚鸿', '111', '3', '3', '23', '1');
INSERT INTO `student` VALUES ('827', '柳军领', '111', '1', '3', '23', '1');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subjectid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`subjectid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', '计算机科学与技术');
INSERT INTO `subject` VALUES ('2', '物联网');
INSERT INTO `subject` VALUES ('3', '软件工程');

-- ----------------------------
-- View structure for compulsoryview
-- ----------------------------
DROP VIEW IF EXISTS `compulsoryview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `compulsoryview` AS select `kecheng`.`kechengid` AS `kechengid`,`kecheng`.`name` AS `name`,`kecheng`.`credit` AS `credit`,`kecheng`.`totaltime` AS `totaltime`,`kecheng`.`week` AS `week`,`kecheng`.`term` AS `term`,`kecheng`.`subject` AS `subject`,`kecheng`.`iselective` AS `iselective` from `kecheng` where (`kecheng`.`iselective` = 0) ;

-- ----------------------------
-- View structure for electiveview
-- ----------------------------
DROP VIEW IF EXISTS `electiveview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `electiveview` AS select `kecheng`.`kechengid` AS `kechengid`,`kecheng`.`name` AS `name`,`kecheng`.`credit` AS `credit`,`kecheng`.`totaltime` AS `totaltime`,`kecheng`.`week` AS `week`,`kecheng`.`term` AS `term`,`kecheng`.`subject` AS `subject`,`kecheng`.`iselective` AS `iselective` from `kecheng` where (`kecheng`.`iselective` = 1) ;

-- ----------------------------
-- View structure for kechengview
-- ----------------------------
DROP VIEW IF EXISTS `kechengview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `kechengview` AS select `kecheng`.`kechengid` AS `kechengid`,`kecheng`.`name` AS `name`,`kecheng`.`credit` AS `credit`,`kecheng`.`totaltime` AS `totaltime`,`kecheng`.`term` AS `term`,`kecheng`.`subject` AS `subject`,`kecheng`.`iselective` AS `iselective`,`kecheng`.`week` AS `week` from `kecheng` where (`kecheng`.`week` = 0) ;

-- ----------------------------
-- View structure for practiceview
-- ----------------------------
DROP VIEW IF EXISTS `practiceview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `practiceview` AS select `kecheng`.`kechengid` AS `kechengid`,`kecheng`.`name` AS `name`,`kecheng`.`credit` AS `credit`,`kecheng`.`week` AS `week`,`kecheng`.`term` AS `term`,`kecheng`.`subject` AS `subject`,`kecheng`.`iselective` AS `iselective`,`kecheng`.`totaltime` AS `totaltime` from `kecheng` where (`kecheng`.`totaltime` = 0) ;
