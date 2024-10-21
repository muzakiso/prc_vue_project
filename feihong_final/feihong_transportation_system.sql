/*
 Navicat MySQL Dump SQL

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80039 (8.0.39)
 Source Host           : localhost:3306
 Source Schema         : feihong_transportation_system

 Target Server Type    : MySQL
 Target Server Version : 80039 (8.0.39)
 File Encoding         : 65001

 Date: 23/08/2024 08:37:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `account` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '账号，由公司分配',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码，由员工自行设置',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '姓名',
  `phone` int NOT NULL COMMENT '手机号',
  `sex` varchar(4) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `mailbox` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '邮箱',
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('admin', '123456', 'lc', 150348, '男', '1254875');

-- ----------------------------
-- Table structure for cargo
-- ----------------------------
DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo`  (
  `cargo_id` int NOT NULL COMMENT '货物捆包号',
  `cargo_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '货物名',
  `weight` double NOT NULL COMMENT '货物重量',
  `status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '货物状态',
  `orders_id` int NOT NULL COMMENT '订单编号',
  `notes` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`cargo_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cargo
-- ----------------------------
INSERT INTO `cargo` VALUES (5000, '钢卷', 11, '运输中', 8000, '注意安全');
INSERT INTO `cargo` VALUES (5001, '钢管', 60, '运输中', 9000, '无');
INSERT INTO `cargo` VALUES (5002, '铁矿', 50, '未发货', 10000, '无');
INSERT INTO `cargo` VALUES (5003, '煤矿', 30, '未发货', 5000, '无');
INSERT INTO `cargo` VALUES (5004, '铜矿', 30, '运输中', 5000, '无');
INSERT INTO `cargo` VALUES (5005, '锡矿', 20, '未发货', 3000, '无');
INSERT INTO `cargo` VALUES (5006, '铁板', 10, '运输中', 5000, '无');
INSERT INTO `cargo` VALUES (5007, 'lc', 180, '未发货', 10011, '无');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orders_id` int NOT NULL COMMENT '订单编号',
  `status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '订单状态',
  `start_date` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建日期',
  `end_date` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '结束日期',
  `partya` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '甲方',
  `aaddress` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '甲方地址',
  `acontacter` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '甲方联系人',
  `acontacter_tel` int NOT NULL COMMENT '甲方联系人电话',
  `partyb` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '乙方',
  `baddress` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '乙方地址',
  `bcontacter` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '乙方联系人',
  `bcontacter_tel` int NOT NULL COMMENT '乙方联系人电话',
  `head` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '负责人',
  `head_tel` int NOT NULL COMMENT '负责人电话',
  `transport_id` int NOT NULL COMMENT '运单编号',
  `amount` int NULL DEFAULT NULL COMMENT '结算金额',
  `notes` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`orders_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (8000, '进行中', '8月10日', '8月20日', '甲方1', '武汉', '甲1', 123654, '乙方1', '新疆', '乙1', 125478, 'lc', 254136, 1000, 10000, '无');
INSERT INTO `orders` VALUES (8001, NULL, '8月16日', '8月20日', 'lc有限公司', '湖北', 'lc', 12548, 'cy有限公司', '湖南', 'cy', 23654, 'sr', 96587, 10011, 20000, '无');
INSERT INTO `orders` VALUES (8002, '未开始', '8月10日', '8月20日', 'lc有限公司', '湖北', 'lc', 12548, 'cy有限公司', '湖南', 'cy', 23654, 'sr', 96587, 10011, 20000, '无');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `salary_id` int NOT NULL COMMENT '账单编号',
  `transport_id` int NOT NULL COMMENT '运单编号',
  `driver_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '司机姓名',
  `driver_tel` int NOT NULL COMMENT '司机电话',
  `license_plate` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '车牌号码',
  `amount` int NOT NULL COMMENT '工资金额',
  `notes` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`salary_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (1000, 1100, 'lc', 150367, '鄂A:35H67', 10000, '无');
INSERT INTO `salary` VALUES (1001, 1101, 'cy', 185476, '鄂E:12345', 10000, '无');
INSERT INTO `salary` VALUES (1003, 1102, '范德萨', 125478, '鄂E:12354', 30000, '无');
INSERT INTO `salary` VALUES (1004, 1103, '范德萨', 125478, '鄂E:12354', 30000, '无');

-- ----------------------------
-- Table structure for transport
-- ----------------------------
DROP TABLE IF EXISTS `transport`;
CREATE TABLE `transport`  (
  `transport_id` int NOT NULL COMMENT '运单编号',
  `cargo_id` int NOT NULL COMMENT '货物捆包号',
  `license_plate` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '车牌号码',
  `driver_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '司机名称',
  `driver_tel` int NOT NULL COMMENT '司机电话',
  `send_address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '发货地址',
  `receive_address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '收货地址',
  `amount` int NOT NULL COMMENT '运费',
  `date` datetime NOT NULL COMMENT '开票日期',
  `notes` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`transport_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transport
-- ----------------------------
INSERT INTO `transport` VALUES (1000, 5000, '鄂E:S6587', 'lc', 321458, '武汉', '新疆', 10000, '2024-08-10 16:33:06', '无');

SET FOREIGN_KEY_CHECKS = 1;
