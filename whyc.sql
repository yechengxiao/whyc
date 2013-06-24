/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50531
Source Host           : localhost:3306
Source Database       : whyc

Target Server Type    : MYSQL
Target Server Version : 50531
File Encoding         : 65001

Date: 2013-06-11 20:38:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for indi_warn
-- ----------------------------
DROP TABLE IF EXISTS `indi_warn`;
CREATE TABLE `indi_warn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `indiId` int(11) NOT NULL,
  `warnId` int(11) NOT NULL,
  `workMatch` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `inid` (`indiId`),
  KEY `warncontent` (`warnId`),
  KEY `id` (`id`),
  KEY `workMatch` (`workMatch`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='保存监测指标和预警指标之间的关系。';

-- ----------------------------
-- Records of indi_warn
-- ----------------------------
INSERT INTO `indi_warn` VALUES ('21', '18', '1', '12');
INSERT INTO `indi_warn` VALUES ('22', '18', '1', '13');
INSERT INTO `indi_warn` VALUES ('23', '18', '1', '14');
INSERT INTO `indi_warn` VALUES ('24', '18', '1', '15');
INSERT INTO `indi_warn` VALUES ('25', '17', '1', '16');
INSERT INTO `indi_warn` VALUES ('26', '17', '4', '16');
INSERT INTO `indi_warn` VALUES ('27', '18', '1', '17');
INSERT INTO `indi_warn` VALUES ('28', '18', '4', '17');
INSERT INTO `indi_warn` VALUES ('29', '23', '1', '18');
INSERT INTO `indi_warn` VALUES ('30', '23', '4', '18');
INSERT INTO `indi_warn` VALUES ('31', '24', '1', '19');
INSERT INTO `indi_warn` VALUES ('32', '24', '4', '19');
INSERT INTO `indi_warn` VALUES ('33', '24', '6', '19');
INSERT INTO `indi_warn` VALUES ('34', '25', '1', '20');
INSERT INTO `indi_warn` VALUES ('35', '25', '4', '20');
INSERT INTO `indi_warn` VALUES ('36', '22', '1', '21');
INSERT INTO `indi_warn` VALUES ('37', '25', '7', '22');

-- ----------------------------
-- Table structure for indicator
-- ----------------------------
DROP TABLE IF EXISTS `indicator`;
CREATE TABLE `indicator` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) NOT NULL COMMENT '监测名称',
  `method` varchar(255) NOT NULL COMMENT '监测方式',
  `kindId` int(11) NOT NULL COMMENT '监测类别',
  `addTime` date NOT NULL COMMENT '监测周期，开始日期',
  `endTime` date NOT NULL COMMENT '监测周期，结束日期',
  `content` text NOT NULL COMMENT '监测内容',
  `note` text COMMENT '备注',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '1表示存在。-1表示删除',
  PRIMARY KEY (`id`),
  KEY `kindid` (`kindId`),
  CONSTRAINT `kindid` FOREIGN KEY (`kindId`) REFERENCES `kind` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='监测指标。\r\n包括名称、方法、监测周期、监测类别、监测内容、备注、预警信息';

-- ----------------------------
-- Records of indicator
-- ----------------------------
INSERT INTO `indicator` VALUES ('17', 'ts', 'method', '1', '2013-06-07', '2013-06-08', 'content', 'note', '1');
INSERT INTO `indicator` VALUES ('18', 'ts', 'method', '1', '2013-06-07', '2013-06-08', 'content', 'note', '1');
INSERT INTO `indicator` VALUES ('22', 'ghjghj', 'sdf', '1', '2013-06-09', '2013-06-10', 'sadf', 'sdf', '1');
INSERT INTO `indicator` VALUES ('23', '0610', '0610', '1', '2013-06-10', '2013-06-11', 'test', 'test', '1');
INSERT INTO `indicator` VALUES ('24', 'test0610', 'test', '1', '2013-06-10', '2013-06-11', 'test', 'test', '1');
INSERT INTO `indicator` VALUES ('25', '06101', 'asdf', '1', '2013-06-10', '2013-06-11', 'asf', 'af', '1');

-- ----------------------------
-- Table structure for kind
-- ----------------------------
DROP TABLE IF EXISTS `kind`;
CREATE TABLE `kind` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(45) NOT NULL COMMENT '监测类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='监测类别。\r\nvalue代表具体的类别。\r\n比如植物或者建筑。';

-- ----------------------------
-- Records of kind
-- ----------------------------
INSERT INTO `kind` VALUES ('1', '建筑');
INSERT INTO `kind` VALUES ('2', '植物');

-- ----------------------------
-- Table structure for match
-- ----------------------------
DROP TABLE IF EXISTS `match`;
CREATE TABLE `match` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workMatch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='workMatch这个值是必须被加上去的。但服务器重启后，程序中的中国·workMatch被重置了。';

-- ----------------------------
-- Records of match
-- ----------------------------
INSERT INTO `match` VALUES ('1', '23');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `userpass` varchar(30) NOT NULL,
  `level` int(11) NOT NULL DEFAULT '1' COMMENT '专家/管理员/员工',
  `email` varchar(100) DEFAULT 'yechengxiao@gmail.com' COMMENT 'email',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='userLevel中1代表管理员，2代表专家，3代表普通员工。';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1', 'admin@qq.com');
INSERT INTO `user` VALUES ('2', 'test', 'test', '1', 'qw@aa.com');

-- ----------------------------
-- Table structure for warncontent
-- ----------------------------
DROP TABLE IF EXISTS `warncontent`;
CREATE TABLE `warncontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预警内容',
  `content` text NOT NULL,
  `levelId` int(11) NOT NULL DEFAULT '4' COMMENT '预警等级id',
  PRIMARY KEY (`id`),
  KEY `levelid` (`levelId`),
  CONSTRAINT `levelid` FOREIGN KEY (`levelId`) REFERENCES `warnlevel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warncontent
-- ----------------------------
INSERT INTO `warncontent` VALUES ('1', '预警内容:	', '1');
INSERT INTO `warncontent` VALUES ('4', 'test', '1');
INSERT INTO `warncontent` VALUES ('6', 'test', '1');
INSERT INTO `warncontent` VALUES ('7', 'test2', '2');

-- ----------------------------
-- Table structure for warnlevel
-- ----------------------------
DROP TABLE IF EXISTS `warnlevel`;
CREATE TABLE `warnlevel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(30) NOT NULL COMMENT '预警等级',
  `count` int(11) DEFAULT '0' COMMENT '预警计数',
  PRIMARY KEY (`id`),
  KEY `warnLevel` (`level`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='预警等级设置。固定不开放。\r\n一级最高。';

-- ----------------------------
-- Records of warnlevel
-- ----------------------------
INSERT INTO `warnlevel` VALUES ('1', '一级预警', '7');
INSERT INTO `warnlevel` VALUES ('2', '二级预警', '1');
INSERT INTO `warnlevel` VALUES ('3', '三级预警', '0');
INSERT INTO `warnlevel` VALUES ('4', '正常', '0');

-- ----------------------------
-- Table structure for warnstodo
-- ----------------------------
DROP TABLE IF EXISTS `warnstodo`;
CREATE TABLE `warnstodo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warntodoId` int(11) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT '指标名称',
  `content` text NOT NULL COMMENT '监测内容',
  PRIMARY KEY (`id`),
  KEY `warntodoId` (`warntodoId`),
  CONSTRAINT `warntodoId` FOREIGN KEY (`warntodoId`) REFERENCES `warntodo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件处理。多条预警合并而来。\r\n合并后预警会被当成已处理。';

-- ----------------------------
-- Records of warnstodo
-- ----------------------------

-- ----------------------------
-- Table structure for warntodo
-- ----------------------------
DROP TABLE IF EXISTS `warntodo`;
CREATE TABLE `warntodo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) NOT NULL,
  `name` varchar(200) NOT NULL COMMENT '指标名称',
  `kind` varchar(200) NOT NULL,
  `content` text,
  `warn` text NOT NULL,
  `state` int(11) NOT NULL COMMENT '1为没有处理掉的预警。-1为处理掉的预警。',
  PRIMARY KEY (`id`),
  KEY `workId` (`workId`),
  CONSTRAINT `workId` FOREIGN KEY (`workId`) REFERENCES `work` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='预警处理。从任务处理复制数据。\r\n';

-- ----------------------------
-- Records of warntodo
-- ----------------------------
INSERT INTO `warntodo` VALUES ('2', '14', 'ts', '建筑', null, '预警内容:	', '1');
INSERT INTO `warntodo` VALUES ('3', '16', 'ts', '建筑', null, '预警内容:	\ntest', '1');
INSERT INTO `warntodo` VALUES ('4', '18', '0610', '建筑', null, '预警内容:	', '1');
INSERT INTO `warntodo` VALUES ('5', '20', '06101', '建筑', 'tedt', 'test', '-1');
INSERT INTO `warntodo` VALUES ('6', '21', 'ghjghj', '建筑', null, '预警内容:	', '1');
INSERT INTO `warntodo` VALUES ('7', '22', '06101', '建筑', null, 'test2', '1');

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL COMMENT '任务名称',
  `method` varchar(255) NOT NULL COMMENT '任务监测方法',
  `kind` varchar(200) NOT NULL COMMENT '任务对象种类，如植物',
  `content` text NOT NULL COMMENT '任务内容',
  `note` text NOT NULL COMMENT '备注',
  `state` int(11) NOT NULL COMMENT '表示状态。1表示没完成。0表示完成，但未来按频率出现。-1表示完成。',
  `doDate` date NOT NULL COMMENT '执行时间',
  `frequency` int(11) NOT NULL COMMENT '执行任务的频率',
  `workMatch` int(11) NOT NULL COMMENT '监测指标的id。',
  PRIMARY KEY (`id`),
  KEY `periodKey` (`kind`),
  KEY `match` (`workMatch`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='任务处理。从监测指标复制数据。提醒时间需要计算。\r\n';

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES ('12', 'ts', 'method', '建筑', 'content', 'note', '-1', '2013-06-08', '1', '12');
INSERT INTO `work` VALUES ('13', 'ts', 'method', '建筑', 'content', 'note', '-1', '2013-06-08', '1', '13');
INSERT INTO `work` VALUES ('14', 'ts', 'method', '建筑', 'content', 'note', '-1', '2013-06-08', '1', '14');
INSERT INTO `work` VALUES ('15', 'ts', 'method', '建筑', 'content', 'note', '-1', '2013-06-08', '1', '15');
INSERT INTO `work` VALUES ('16', 'ts', 'method', '建筑', 'content', 'note', '-1', '2013-06-08', '1', '16');
INSERT INTO `work` VALUES ('17', 'ts', 'method', '建筑', 'content', 'note', '-1', '2013-06-08', '1', '17');
INSERT INTO `work` VALUES ('18', '0610', '0610', '建筑', 'test', 'test', '1', '2013-06-11', '1', '18');
INSERT INTO `work` VALUES ('19', 'test0610', 'test', '建筑', 'test', 'test', '1', '2013-06-10', '1', '19');
INSERT INTO `work` VALUES ('20', '06101', 'asdf', '建筑', 'asf', 'af', '1', '2013-06-11', '1', '20');
INSERT INTO `work` VALUES ('21', 'ghjghj', 'sdf', '建筑', 'sadf', 'sdf', '-1', '2013-06-10', '1', '21');
INSERT INTO `work` VALUES ('22', '06101', 'asdf', '建筑', 'asf', 'af', '-1', '2013-06-11', '1', '22');

-- ----------------------------
-- Procedure structure for test_insert
-- ----------------------------
DROP PROCEDURE IF EXISTS `test_insert`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_insert`()
BEGIN

DECLARE i INT DEFAULT 16;

WHILE i<20
DO
INSERT INTO indicator
(
id,name,method,kindId,addTime,endTime,content,note,state
)
VALUES
(
i,'ts','method','1','2013-06-07','2013-06-08','content','note','1'
);

SET i=i+1;
END WHILE ;

END
;;
DELIMITER ;
