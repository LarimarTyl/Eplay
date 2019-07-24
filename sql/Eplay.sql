/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0.16
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : eplay

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 24/07/2019 18:04:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gamelist
-- ----------------------------
DROP TABLE IF EXISTS `gamelist`;
CREATE TABLE `gamelist`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '游戏id',
  `gameName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '游戏名',
  `gameLogo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏logo路径',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  INDEX `id_2`(`id`) USING BTREE,
  INDEX `id_3`(`id`) USING BTREE,
  INDEX `id_4`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gamelist
-- ----------------------------
INSERT INTO `gamelist` VALUES (1, '王者荣耀', NULL);
INSERT INTO `gamelist` VALUES (2, '英雄联盟', NULL);
INSERT INTO `gamelist` VALUES (3, '绝地求生', NULL);
INSERT INTO `gamelist` VALUES (4, '守望先锋', NULL);
INSERT INTO `gamelist` VALUES (5, 'DOTA2自走棋', NULL);

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '段位表id',
  `gameID` int(11) NULL DEFAULT NULL COMMENT '游戏id',
  `gameLeve` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏段位',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK-GAME`(`gameID`) USING BTREE,
  CONSTRAINT `FK-GAME` FOREIGN KEY (`gameID`) REFERENCES `gamelist` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES (1, 1, '黄金以下');
INSERT INTO `level` VALUES (2, 1, '铂金');
INSERT INTO `level` VALUES (3, 1, '钻石');
INSERT INTO `level` VALUES (4, 1, '星耀');
INSERT INTO `level` VALUES (5, 1, '王者');
INSERT INTO `level` VALUES (6, 2, '黄金以下');
INSERT INTO `level` VALUES (7, 2, '黄金');
INSERT INTO `level` VALUES (8, 2, '铂金');
INSERT INTO `level` VALUES (9, 2, '钻石');
INSERT INTO `level` VALUES (10, 2, '超凡大师');
INSERT INTO `level` VALUES (11, 2, '最强王者');
INSERT INTO `level` VALUES (12, 3, '500分以下');
INSERT INTO `level` VALUES (13, 3, '500-800分');
INSERT INTO `level` VALUES (14, 3, '800-1200分');
INSERT INTO `level` VALUES (15, 3, '1200-1500分');
INSERT INTO `level` VALUES (16, 3, '1500-1800分');
INSERT INTO `level` VALUES (17, 3, '1800分以上');

-- ----------------------------
-- Table structure for lovegame
-- ----------------------------
DROP TABLE IF EXISTS `lovegame`;
CREATE TABLE `lovegame`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '爱好表id',
  `userID` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `gameID` int(11) NULL DEFAULT NULL COMMENT '游戏id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK-Love`(`userID`) USING BTREE,
  INDEX `FK-lovegame`(`gameID`) USING BTREE,
  CONSTRAINT `FK-Love` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK-lovegame` FOREIGN KEY (`gameID`) REFERENCES `gamelist` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lovegame
-- ----------------------------
INSERT INTO `lovegame` VALUES (1, 1, 1);
INSERT INTO `lovegame` VALUES (2, 2, 1);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息列表id',
  `userID` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `statu` int(255) NULL DEFAULT 0 COMMENT '消息状态：0未读，1已读',
  `type` int(255) NULL DEFAULT 0 COMMENT '消息类型：0系统消息，1',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '消息时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user`(`userID`) USING BTREE,
  CONSTRAINT `user` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 1, '您有新的约3玩，请注意查收', 0, 0, '2019-07-24 13:49:28');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `gameID` int(11) NOT NULL COMMENT '游戏id',
  `userID` int(11) NOT NULL COMMENT '用户id',
  `playerID` int(11) NULL DEFAULT NULL COMMENT '玩家id',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `starttime` datetime(0) NOT NULL COMMENT '开始时间',
  `endtime` datetime(0) NOT NULL COMMENT '结束时间',
  `payway` smallint(6) NOT NULL DEFAULT 1 COMMENT '付款方式（1直接付款，2余额付款）',
  `price` double(11, 0) NOT NULL COMMENT '订单总价',
  `poitns` smallint(6) NOT NULL DEFAULT 6 COMMENT '订单评分',
  `appraise` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户评价',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_ID2`(`gameID`) USING BTREE,
  INDEX `FK_ID3`(`userID`) USING BTREE,
  INDEX `FK_ID4`(`playerID`) USING BTREE,
  CONSTRAINT `FK_ID2` FOREIGN KEY (`gameID`) REFERENCES `gamelist` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ID3` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`playerID`) REFERENCES `player` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 1, 1, 1, '565203943', '2019-07-24 13:50:52', '2019-07-24 16:50:55', 1, 80, 6, '还行', 'QQ');
INSERT INTO `order` VALUES (3, 1, 3, 1, '46545457', '2019-07-24 13:52:17', '2019-07-24 20:52:20', 1, 45, 6, '一般', 'QQ');

-- ----------------------------
-- Table structure for player
-- ----------------------------
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '玩家表编号',
  `playerID` int(11) NULL DEFAULT NULL COMMENT '玩家id',
  `gameID` int(11) NOT NULL COMMENT '游戏id',
  `level` int(11) NULL DEFAULT NULL COMMENT '游戏段位',
  `picPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏介绍图片',
  `orderNum` int(11) NULL DEFAULT NULL COMMENT '订单量',
  `money` double(11, 2) NULL DEFAULT NULL COMMENT '总收益',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人介绍',
  `status` int(6) NOT NULL DEFAULT 0 COMMENT '玩家状态（0可接单，1待接单，2已接单）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `level`(`level`) USING BTREE,
  INDEX `gameID`(`gameID`) USING BTREE,
  INDEX `playerID`(`playerID`) USING BTREE,
  CONSTRAINT `player_ibfk_2` FOREIGN KEY (`level`) REFERENCES `level` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `player_ibfk_3` FOREIGN KEY (`gameID`) REFERENCES `gamelist` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `player_ibfk_4` FOREIGN KEY (`playerID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES (1, 2, 1, 3, NULL, 12, 30.00, '30/小时', 0);

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '充值表id',
  `userID` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `money` double(11, 2) NULL DEFAULT NULL COMMENT '充值金额',
  `type` int(6) NULL DEFAULT 0 COMMENT '充值方式 1：支付宝 2：微信',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '充值时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rk`(`userID`) USING BTREE,
  CONSTRAINT `rk` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recharge
-- ----------------------------
INSERT INTO `recharge` VALUES (1, 1, 50.00, 0, '2019-07-24 13:53:28');

-- ----------------------------
-- Table structure for relationship
-- ----------------------------
DROP TABLE IF EXISTS `relationship`;
CREATE TABLE `relationship`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系表id',
  `userID` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `playerID` int(11) NULL DEFAULT NULL COMMENT '玩家id',
  `status` int(6) NULL DEFAULT 0 COMMENT '关系状态 0关注1黑名单',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userId`(`userID`) USING BTREE,
  INDEX `playerID`(`playerID`) USING BTREE,
  CONSTRAINT `relationship_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `relationship_ibfk_2` FOREIGN KEY (`playerID`) REFERENCES `player` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relationship
-- ----------------------------
INSERT INTO `relationship` VALUES (1, 1, 1, 0);
INSERT INTO `relationship` VALUES (2, 2, 1, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `loginName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录名',
  `loginPwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `staffNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号（唯一约束）',
  `staffName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `telephone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `picturePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像路径',
  `price` double(11, 0) NULL DEFAULT NULL COMMENT '消费总额',
  `QQ` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'QQ号码',
  `registerTime` datetime(0) NOT NULL COMMENT '注册时间',
  `registerStatus` int(255) NOT NULL DEFAULT 0 COMMENT '注册状态：0未激活 1已激活',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `status` int(6) NOT NULL DEFAULT 1 COMMENT '用户状态（1用户，2待审核用户，3玩家，0管理员）',
  `money` double(11, 2) NULL DEFAULT 0.00 COMMENT '余额',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `staffNumber`(`staffNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'test', 'test', '100190724156', 'Larimar', '1998-05-06 00:00:00', '男', '565203943@qq.com', '13617004500', 'img/user/photo/test', 150, '2411699692', '2019-07-24 13:14:53', 0, 'test', 1, 136.00);
INSERT INTO `user` VALUES (2, 'player', 'player', '200190724157', 'LeLe', '1996-06-21 00:00:00', '女', '2411699692@qq.com', '18732965874', 'img/user/photo/player', 135, '565203943', '2019-07-24 13:16:31', 1, 'player', 2, 50.00);
INSERT INTO `user` VALUES (3, 'admin', 'admin', '000190724159', 'Admin', '1999-09-09 00:00:00', '男', 'larimar@gmail.com', '15279128456', 'img/user/photo/admin', 0, '565203943', '2019-07-24 13:18:21', 1, 'admin', 0, 0.00);

SET FOREIGN_KEY_CHECKS = 1;
