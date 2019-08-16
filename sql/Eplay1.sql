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

 Date: 02/08/2019 05:32:02
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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gamelist
-- ----------------------------
INSERT INTO `gamelist` VALUES (1, '王者荣耀', 'game1.jpg');
INSERT INTO `gamelist` VALUES (2, '英雄联盟', 'game2.jpg');
INSERT INTO `gamelist` VALUES (3, 'CS', 'game3.jpg');
INSERT INTO `gamelist` VALUES (4, '地下城', 'geme4.jsp');
INSERT INTO `gamelist` VALUES (5, '绝地求生', 'game5.jsp');

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
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES (1, 1, '王者');
INSERT INTO `level` VALUES (2, 1, '钻石');
INSERT INTO `level` VALUES (3, 1, '黄金');
INSERT INTO `level` VALUES (4, 1, '青铜');
INSERT INTO `level` VALUES (5, 2, '大师');
INSERT INTO `level` VALUES (6, 2, '黄金');
INSERT INTO `level` VALUES (7, 2, '黄铜');
INSERT INTO `level` VALUES (8, 2, '白银');
INSERT INTO `level` VALUES (9, 3, '大师');
INSERT INTO `level` VALUES (10, 3, '白银');
INSERT INTO `level` VALUES (11, 3, '黄金新星');
INSERT INTO `level` VALUES (12, 3, '大师级守卫精英');
INSERT INTO `level` VALUES (13, 4, '大师');
INSERT INTO `level` VALUES (14, 4, '钻石一星');
INSERT INTO `level` VALUES (15, 4, '黄金');
INSERT INTO `level` VALUES (16, 4, '青铜');
INSERT INTO `level` VALUES (18, 5, '800分以下');
INSERT INTO `level` VALUES (21, 5, '800-1000分');
INSERT INTO `level` VALUES (22, 5, '1000-1400分');
INSERT INTO `level` VALUES (23, 5, '1400-1800分');
INSERT INTO `level` VALUES (24, 5, '2000分以上');

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lovegame
-- ----------------------------
INSERT INTO `lovegame` VALUES (1, 1, 1);
INSERT INTO `lovegame` VALUES (2, 11, 4);
INSERT INTO `lovegame` VALUES (3, 2, 3);
INSERT INTO `lovegame` VALUES (4, 3, 1);
INSERT INTO `lovegame` VALUES (5, 4, 2);
INSERT INTO `lovegame` VALUES (6, 5, 4);
INSERT INTO `lovegame` VALUES (7, 6, 2);
INSERT INTO `lovegame` VALUES (8, 7, 4);
INSERT INTO `lovegame` VALUES (9, 8, 3);
INSERT INTO `lovegame` VALUES (10, 9, 2);
INSERT INTO `lovegame` VALUES (11, 10, 1);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息列表id',
  `userID` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `status` int(255) NULL DEFAULT 0 COMMENT '消息状态：0未读，1已读',
  `type` int(255) NULL DEFAULT 0 COMMENT '消息类型：0系统消息，1',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '消息时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user`(`userID`) USING BTREE,
  CONSTRAINT `user` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 1, 'hello one', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (2, 2, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (3, 4, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (4, 3, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (5, 5, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (6, 6, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (7, 7, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (8, 8, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (9, 9, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (10, 10, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (11, 11, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (12, 1, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (13, 1, 'hello', 0, 0, '2019-01-07 00:00:00');
INSERT INTO `message` VALUES (14, 1, 'hello', 0, 0, '2019-01-07 00:00:00');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
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
  `status` int(255) NULL DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_ID2`(`gameID`) USING BTREE,
  INDEX `FK_ID3`(`userID`) USING BTREE,
  INDEX `FK_ID4`(`playerID`) USING BTREE,
  CONSTRAINT `FK_ID2` FOREIGN KEY (`gameID`) REFERENCES `gamelist` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ID3` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`playerID`) REFERENCES `player` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 3, 1, 1, '14592380123', '2018-09-10 12:00:00', '2018-09-10 13:00:00', 1, 60, 6, NULL, NULL, 1);
INSERT INTO `orders` VALUES (2, 3, 1, 1, '14592380123', '2018-10-10 12:00:00', '2018-10-10 13:00:00', 1, 60, 6, 'good', '干', 1);
INSERT INTO `orders` VALUES (3, 2, 1, 2, '14592380123', '2018-10-10 12:00:00', '2018-10-10 13:00:00', 1, 50, 6, 'good', '干', 1);
INSERT INTO `orders` VALUES (4, 3, 5, 1, '1301162912', '2018-06-10 13:00:00', '2018-06-10 13:00:00', 1, 60, 6, 'good', '干', 1);
INSERT INTO `orders` VALUES (5, 4, 4, 4, '14567100912', '2018-09-10 12:00:00', '2018-09-10 13:00:00', 1, 30, 6, 'good', '莽', 1);
INSERT INTO `orders` VALUES (6, 4, 8, 4, '1311162912', '2019-07-10 12:00:00', '2019-07-10 13:00:00', 1, 30, 6, 'good', '莽', 1);
INSERT INTO `orders` VALUES (7, 1, 7, 3, '1301162912', '2019-07-11 12:00:00', '2019-07-11 13:00:00', 1, 40, 6, 'good', '莽', 1);
INSERT INTO `orders` VALUES (8, 2, 5, 2, '1301100912', '2019-07-11 12:00:00', '2019-07-11 13:00:00', 1, 50, 6, 'good', '莽', 1);
INSERT INTO `orders` VALUES (9, 2, 4, 2, '14567100912', '2018-09-20 13:00:00', '2018-09-20 14:00:00', 1, 50, 6, 'good', '莽', 1);
INSERT INTO `orders` VALUES (10, 2, 4, 2, '14567100912', '2019-07-19 12:00:00', '2019-07-19 13:00:00', 1, 50, 6, 'good', '莽', 1);
INSERT INTO `orders` VALUES (11, 1, 1, 3, '14592380123', '2019-01-11 12:00:00', '2019-01-11 13:00:00', 1, 40, 6, 'good', '莽', 1);
INSERT INTO `orders` VALUES (12, 1, 7, 3, '1301162912', '2019-02-11 12:00:00', '2019-02-11 13:00:00', 1, 40, 6, 'good', '莽', 1);
INSERT INTO `orders` VALUES (13, 3, 8, 1, '1311162912', '2019-03-11 14:00:00', '2019-03-11 15:00:00', 1, 60, 6, 'good', '莽', 1);
INSERT INTO `orders` VALUES (14, 3, 4, 1, '14567100912', '2019-04-11 14:00:00', '2019-04-11 15:00:00', 1, 60, 6, 'good', '莽', 1);

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
  CONSTRAINT `player_ibfk_123` FOREIGN KEY (`playerID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `player_ibfk_2` FOREIGN KEY (`level`) REFERENCES `level` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `player_ibfk_3` FOREIGN KEY (`gameID`) REFERENCES `gamelist` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of player
-- ----------------------------
INSERT INTO `player` VALUES (1, 2, 3, 10, 'ia_10014.jpg*ia_10015.jpg*ia_10016.jpg*ia_10017.jpg*ia_10018.jpg', 5, 300.00, 'person', 0);
INSERT INTO `player` VALUES (2, 9, 2, 6, 'ia_10056.jpg*ia_10058.jpg*ia_10061.jpg*ia_10062.jpg*ia_10064.jpg', 4, 200.00, 'person', 0);
INSERT INTO `player` VALUES (3, 10, 3, 1, 'ia_10065.jpg*ia_10067.jpg*ia_10068.jpg*ia_10075.jpg*ia_10076.jpg', 3, 120.00, 'person', 0);
INSERT INTO `player` VALUES (4, 11, 4, 13, 'ia_10019.jpg*ia_10020.jpg*ia_10021.jpg*ia_10022.jpg*ia_10023.jpg', 2, 60.00, 'person', 0);
INSERT INTO `player` VALUES (5, 15, 4, 14, 'ia_10019.jpg*ia_10020.jpg*ia_10021.jpg*ia_10022.jpg*ia_10023.jpg', 6, 240.00, 'person', 0);
INSERT INTO `player` VALUES (6, 16, 1, 3, 'ia_10019.jpg*ia_10020.jpg*ia_10021.jpg*ia_10022.jpg*ia_10023.jpg', 5, 200.00, 'person', 0);
INSERT INTO `player` VALUES (7, 14, 5, 22, 'zly1.jpg*zly2.jpg*zly3.jpg*zly4.jpg', 68, 88.88, '救死扶伤,移动药箱,输出全靠吼*我就是个盒子 你们别打我*呜呜呜 再打就傻了 不能打头*带我在机场飙车好么 喵? 暴力摩托 突突突~~~', 0);
INSERT INTO `player` VALUES (8, 18, 4, 14, 'ia_10019.jpg*ia_10020.jpg*ia_10021.jpg*ia_10022.jpg*ia_10023.jpg', 1, 20.00, 'person', 0);
INSERT INTO `player` VALUES (9, 19, 2, 5, 'ia_10019.jpg*ia_10020.jpg*ia_10021.jpg*ia_10022.jpg*ia_10023.jpg', 2, 100.00, 'person', 0);
INSERT INTO `player` VALUES (10, 20, 2, 6, 'ia_10019.jpg*ia_10020.jpg*ia_10021.jpg*ia_10022.jpg*ia_10023.jpg', 2, 80.00, 'person', 0);
INSERT INTO `player` VALUES (11, 2, 1, 10, 'ia_10014.jpg*ia_10015.jpg*ia_10016.jpg*ia_10017.jpg*ia_10018.jpg', 5, 300.00, 'person', 0);
INSERT INTO `player` VALUES (12, 9, 3, 6, 'ia_10056.jpg*ia_10058.jpg*ia_10061.jpg*ia_10062.jpg*ia_10064.jpg', 4, 200.00, 'person', 0);
INSERT INTO `player` VALUES (13, 10, 1, 1, 'ia_10065.jpg*ia_10067.jpg*ia_10068.jpg*ia_10075.jpg*ia_10076.jpg', 3, 120.00, 'person', 0);
INSERT INTO `player` VALUES (14, 11, 4, 13, 'ia_10019.jpg*ia_10020.jpg*ia_10021.jpg*ia_10022.jpg*ia_10023.jpg', 2, 60.00, 'person', 0);
INSERT INTO `player` VALUES (15, 14, 1, 2, 'zly1.jpg*zly2.jpg*zly3.jpg*zly4.jpg', 103, 99.99, '可盐可甜？可奶可狼？输出全靠吼*提莫队长正在送命 杀人啦~~~~~*可话痨可沉默 O(∩_∩)O*可坑不可carry 嘻嘻嘻*可口可乐百事可乐加冰双倍快乐', 0);
INSERT INTO `player` VALUES (16, 17, 3, 10, 'ia_10019.jpg*ia_10020.jpg*ia_10021.jpg*ia_10022.jpg*ia_10023.jpg', 4, 200.00, 'person', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recharge
-- ----------------------------
INSERT INTO `recharge` VALUES (1, 1, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (2, 2, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (3, 3, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (4, 4, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (5, 5, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (6, 6, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (7, 7, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (8, 8, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (9, 9, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (10, 10, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (11, 11, 10.00, 0, '2019-07-02 00:00:00');
INSERT INTO `recharge` VALUES (12, 1, 10.00, 0, '2019-07-03 00:00:00');
INSERT INTO `recharge` VALUES (13, 1, 10.00, 0, '2019-07-04 00:00:00');
INSERT INTO `recharge` VALUES (14, 1, 10.00, 0, '2019-07-05 00:00:00');

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relationship
-- ----------------------------
INSERT INTO `relationship` VALUES (1, 1, 2, 0);
INSERT INTO `relationship` VALUES (3, 1, 1, 0);
INSERT INTO `relationship` VALUES (4, 1, 3, 0);
INSERT INTO `relationship` VALUES (5, 1, 4, 0);
INSERT INTO `relationship` VALUES (6, 4, 2, 1);
INSERT INTO `relationship` VALUES (7, 4, 1, 0);
INSERT INTO `relationship` VALUES (9, 4, 3, 0);
INSERT INTO `relationship` VALUES (10, 5, 4, 0);
INSERT INTO `relationship` VALUES (11, 7, 3, 1);
INSERT INTO `relationship` VALUES (12, 7, 2, 0);
INSERT INTO `relationship` VALUES (13, 8, 1, 1);
INSERT INTO `relationship` VALUES (14, 9, 2, 0);
INSERT INTO `relationship` VALUES (15, 8, 2, 0);

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
  `photoPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像路径',
  `price` double(11, 0) NULL DEFAULT NULL COMMENT '消费总额',
  `QQ` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'QQ号码',
  `registerTime` datetime(0) NOT NULL COMMENT '注册时间',
  `registerStatus` int(255) NOT NULL DEFAULT 0 COMMENT '注册状态：0未激活 1已激活',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `status` int(6) NOT NULL DEFAULT 1 COMMENT '用户状态（1用户，2待审核用户，3玩家，0管理员）',
  `money` double(11, 2) NULL DEFAULT 0.00 COMMENT '余额',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `staffNumber`(`staffNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '宋远桥', 'syq', NULL, '宋远桥', '1963-06-27 13:23:09', '男', '234593591@qq.com', '14592380123', 'ia_10027.jpg', 0, '234593591', '2013-06-27 12:00:00', 0, 'qwerqer', 1, 0.00);
INSERT INTO `user` VALUES (2, '赵敏', 'zm', NULL, '赵敏', '1993-06-27 00:00:00', '女', '287593591@qq.com', '14592380123', 'ia_10012.jpg', 0, '287593591', '2015-06-27 00:00:00', 1, NULL, 3, 0.00);
INSERT INTO `user` VALUES (3, '园真', 'yz', '2001001', '成昆', '1961-01-01 00:00:00', '男', '299999@qq.com', '15268026308', 'ia_10029.jpg', 0, '299999', '2001-01-01 00:00:00', 1, NULL, 0, 0.00);
INSERT INTO `user` VALUES (4, '殷素素', 'yss', NULL, '殷素素', '1984-06-27 00:00:00', '女', '28759359@qq.com', '14567100912', 'ia_10013.jpg', 0, '28759359', '2011-06-27 00:00:00', 1, NULL, 1, 0.00);
INSERT INTO `user` VALUES (5, '莫声谷', 'msg', NULL, '莫声谷', '1974-06-27 00:00:00', '男', '287593519@qq.com', '1301100912', 'ia_10043.jpg', 0, '287593519', '2011-07-27 00:00:00', 1, NULL, 2, 0.00);
INSERT INTO `user` VALUES (6, '张三丰', 'zsf', '2001002', '张三丰', '1921-01-01 00:00:00', '男', '2123499@qq.com', '15918026308', 'ia_10044.jpg', 0, '2123499', '2011-01-01 00:00:00', 1, NULL, 0, 0.00);
INSERT INTO `user` VALUES (7, '张松溪', 'zsx', NULL, '张松溪', '1978-06-27 00:00:00', '男', '287593511@qq.com', '1301162912', 'ia_10047.jpg', 0, '287593511', '2011-09-17 00:00:00', 1, NULL, 1, 0.00);
INSERT INTO `user` VALUES (8, '小昭', 'xz', NULL, '小昭', '1998-06-27 00:00:00', '女', '227593511@qq.com', '1311162912', 'ia_10014.jpg', 0, '227593511', '2011-01-17 00:00:00', 1, NULL, 1, 0.00);
INSERT INTO `user` VALUES (9, '张翠山', 'zcs', NULL, '张翠山', '1978-06-27 00:00:00', '男', '227593509@qq.com', '1311162919', 'ia_10347.jpg', 0, '227593509', '2015-01-17 00:00:00', 1, NULL, 3, 0.00);
INSERT INTO `user` VALUES (10, '张松溪', 'zsx', NULL, '张松溪', '1980-06-27 00:00:00', '男', '227593510@qq.com', '1337562910', 'ia_10058.jpg', 0, '227593510', '2015-08-17 00:00:00', 1, NULL, 3, 0.00);
INSERT INTO `user` VALUES (11, '杨不悔', 'ybh', NULL, '杨不悔', '1998-06-27 00:00:00', '女', '227593011@qq.com', '1393062919', 'ia_10016.jpg', 0, '227593011', '2015-09-17 00:00:00', 1, NULL, 3, 0.00);
INSERT INTO `user` VALUES (12, 'larimar', 'tyl123', '200500', 'larimar', NULL, '男', '565203943@qq.com', '13617004500', 'user.JPEG', 0, '56520345', '2019-08-01 23:08:49', 1, '123456', 1, 0.00);
INSERT INTO `user` VALUES (13, '八戒', 'baj', NULL, '八戒', '1001-01-01 00:00:00', '男', '111111112@qq.com', '13209239725', 'ia_10028.jpg', NULL, '111111112', '2016-03-01 00:00:00', 1, NULL, 1, 0.00);
INSERT INTO `user` VALUES (14, 'zly', 'zly', '200548', '咕咕乐ღ', NULL, '女', '2411566582@', '13617004548', 'zly1.jpg', 0, '56520345', '2019-08-01 23:19:33', 1, '123456', 1, 0.00);
INSERT INTO `user` VALUES (15, '唐僧', 'ta', NULL, '唐僧', '1003-01-01 00:00:00', '男', '111111114@qq.com', '13209239727', 'ia_10077.jpg', NULL, '111111114', '2013-03-01 00:00:00', 3, NULL, 1, 0.00);
INSERT INTO `user` VALUES (16, '牛魔王', 'nmw', NULL, '牛魔王', '1004-01-01 00:00:00', '男', '111111115@qq.com', '13209239728', 'ia_100000001442.jpg', NULL, '111111115', '2013-04-01 00:00:00', 3, NULL, 1, 0.00);
INSERT INTO `user` VALUES (17, '白骨精', 'bgj', NULL, '白骨精', '1005-01-01 00:00:00', '女', '111111116@qq.com', '13209239729', 'ia_10241.jpg', NULL, '111111116', '2014-04-01 00:00:00', 3, NULL, 1, 0.00);
INSERT INTO `user` VALUES (18, '铁扇公主', 'tsg', NULL, '铁扇公主', '1005-02-01 00:00:00', '女', '111111117@qq.com', '13209239730', 'ia_10233.jpg', NULL, '111111117', '2014-04-02 00:00:00', 3, NULL, 1, 0.00);
INSERT INTO `user` VALUES (19, '白龙马', 'blongma', NULL, '白龙马', '1005-02-08 00:00:00', '男', '111111118@qq.com', '13209239731', 'ia_10056.jpg', NULL, '111111118', '2014-04-03 00:00:00', 3, NULL, 1, 0.00);
INSERT INTO `user` VALUES (20, 'huang', 'huang', NULL, '黄', '1105-02-08 00:00:00', '男', '111111119@qq.com', '13209239732', 'ia_10057.jpg', NULL, '111111119', '2015-04-03 00:00:00', 3, NULL, 1, 0.00);
INSERT INTO `user` VALUES (21, '杨不悔', 'ybh', NULL, '杨不悔', '1998-06-27 00:00:00', '女', '227593011@qq.com', '1393062919', 'ia_10074.jpg', 0, '227593011', '2015-09-17 00:00:00', 1, NULL, 3, 0.00);
INSERT INTO `user` VALUES (22, '孙悟空', 'swk', NULL, '孙悟空', '1000-01-01 00:00:00', '男', '111111111@qq.com', '13209239724', 'ia_10076.jpg', NULL, '111111111', '0000-00-00 00:00:00', 1, NULL, 1, 0.00);
INSERT INTO `user` VALUES (23, '沙僧', 'ss', NULL, '沙僧', '1002-01-01 00:00:00', '男', '111111113@qq.com', '13209239726', 'ia_10075.jpg', NULL, '111111113', '2013-03-01 00:00:00', 1, NULL, 1, 0.00);

SET FOREIGN_KEY_CHECKS = 1;
