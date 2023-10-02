/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : onlineshop

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 05/06/2020 22:30:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_p_filename` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cart_p_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cart_p_price` float(10, 0) NULL DEFAULT NULL,
  `cart_quantity` int(11) NULL DEFAULT NULL,
  `cart_p_stock` int(11) NULL DEFAULT NULL,
  `cart_p_id` int(11) NULL DEFAULT NULL,
  `cart_u_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cart_status` decimal(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (11, 'u=3778513161,2671931925&fm=26&gp=0.jpg', '多特蒙德卫衣', 299, 1, 2001, 1, 'dylan', 2);
INSERT INTO `cart` VALUES (12, '91b2cadfd1c63dbb.jpg', '多特蒙德球衣', 314, 3, 90, 3, 'dylan', 2);
INSERT INTO `cart` VALUES (14, 'e0b2b64661244458.jpg', '多特蒙德外套', 599, 3, 1000, 5, 'admin', 2);
INSERT INTO `cart` VALUES (15, 'u=3778513161,2671931925&fm=26&gp=0.jpg', '多特蒙德卫衣', 299, 1, 2001, 1, 'admin', 2);
INSERT INTO `cart` VALUES (16, 'c7f917ae4e64448c.jfif', '多特蒙德运动裤', 219, 4, 210, 2, 'admin', 2);
INSERT INTO `cart` VALUES (17, '91b2cadfd1c63dbb.jpg', '多特蒙德球衣', 314, 4, 90, 3, 'admin', 2);
INSERT INTO `cart` VALUES (18, 'th.jfif', '多特蒙德围巾', 50, 4, 60, 11, 'admin', 2);
INSERT INTO `cart` VALUES (19, '91b2cadfd1c63dbb.jpg', '多特蒙德球衣', 314, 3, 90, 3, 'dylan', 2);
INSERT INTO `cart` VALUES (20, '91b2cadfd1c63dbb.jpg', '多特蒙德球衣', 314, 3, 90, 3, 'dylan', 2);
INSERT INTO `cart` VALUES (21, 'c7f917ae4e64448c.jfif', '多特蒙德运动裤', 219, 3, 210, 2, 'dylan', 2);
INSERT INTO `cart` VALUES (22, '91b2cadfd1c63dbb.jpg', '多特蒙德球衣', 314, 3, 87, 3, 'dylan', 2);
INSERT INTO `cart` VALUES (23, '', '耐克足球鞋', 999, 3, 50, 9, 'dylan', 2);
INSERT INTO `cart` VALUES (24, 'u=3778513161,2671931925&fm=26&gp=0.jpg', '多特蒙德卫衣', 299, 3, 2000, 1, 'dylan', 2);
INSERT INTO `cart` VALUES (25, 'u=3778513161,2671931925&fm=26&gp=0.jpg', '多特蒙德卫衣', 299, 3, 1997, 1, 'dylan', 1);
INSERT INTO `cart` VALUES (26, '91b2cadfd1c63dbb.jpg', '多特蒙德球衣', 315, 5, 86, 3, 'dylan', 1);
INSERT INTO `cart` VALUES (27, '91b2cadfd1c63dbb.jpg', '多特蒙德球衣', 315, 1, 86, 3, 'admin', 2);
INSERT INTO `cart` VALUES (28, 'th.jfif', '多特蒙德围巾', 50, 3, 56, 11, 'admin', 2);
INSERT INTO `cart` VALUES (29, 'e0b2b64661244458.jpg', '多特蒙德外套', 599, 3, 997, 5, 'admin', 2);
INSERT INTO `cart` VALUES (30, 'th.jfif', '多特蒙德围巾', 50, 3, 56, 11, 'swulearner', 2);
INSERT INTO `cart` VALUES (31, '91b2cadfd1c63dbb.jpg', '多特蒙德球衣', 315, 3, 86, 3, 'swulearner', 2);
INSERT INTO `cart` VALUES (32, '91b2cadfd1c63dbb.jpg', '多特蒙德球衣', 315, 3, 85, 3, 'admin', 2);
INSERT INTO `cart` VALUES (33, '0dbe86a2aee04c5c.jpg', '多特蒙德运动裤', 219, 4, 206, 2, 'admin', 2);
INSERT INTO `cart` VALUES (34, '35c5f3d9c6bae137.jpg', '耐克足球鞋', 999, 4, 47, 9, 'admin', 2);
INSERT INTO `cart` VALUES (35, '5b6f10d30151dc11.png', '多特蒙德袜子', 20, 3, 87, 12, 'admin', 2);
INSERT INTO `cart` VALUES (36, '35c5f3d9c6bae137.jpg', '耐克足球鞋', 999, 3, 47, 9, 'dylan', 1);
INSERT INTO `cart` VALUES (37, 'ee7bfca2786de53d.jpg', '猎鹰足球鞋', 1099, 2, 599, 10, 'admin', 2);
INSERT INTO `cart` VALUES (38, 'u=3778513161,2671931925&fm=26&gp=0.jpg', '多特蒙德卫衣', 299, 5, 3, 1, 'admin', 2);
INSERT INTO `cart` VALUES (39, 'u=3778513161,2671931925&fm=26&gp=0.jpg', '多特蒙德卫衣', 299, 1, -2, 1, 'admin', 2);
INSERT INTO `cart` VALUES (40, 'u=3778513161,2671931925&fm=26&gp=0.jpg', '多特蒙德卫衣', 299, 2, 3, 1, 'admin', 2);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `CATE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CATE_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CATE_PARENT_NAME` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`CATE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '上装', 0);
INSERT INTO `category` VALUES (2, '下装', 0);
INSERT INTO `category` VALUES (3, '鞋类', 0);
INSERT INTO `category` VALUES (4, '配饰', 0);
INSERT INTO `category` VALUES (5, '卫衣', 1);
INSERT INTO `category` VALUES (6, '短裤', 2);
INSERT INTO `category` VALUES (7, '运动鞋', 3);
INSERT INTO `category` VALUES (8, '帽子', 4);
INSERT INTO `category` VALUES (9, '围巾', 4);
INSERT INTO `category` VALUES (10, '袜子', 4);
INSERT INTO `category` VALUES (11, '短袖', 1);
INSERT INTO `category` VALUES (12, '足球鞋', 3);
INSERT INTO `category` VALUES (13, '休闲鞋', 3);
INSERT INTO `category` VALUES (15, '长裤', 2);
INSERT INTO `category` VALUES (16, '外套', 1);

-- ----------------------------
-- Table structure for order_list
-- ----------------------------
DROP TABLE IF EXISTS `order_list`;
CREATE TABLE `order_list`  (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` int(10) NOT NULL,
  `BUYER_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PUACHER_TIME` datetime(0) NOT NULL,
  `PRODUCT_AMOUNT` int(10) NOT NULL,
  `PRODUCT_STATUS` int(10) NOT NULL,
  `ORDER_DELIVERY` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ORDER_DELIVERY_NUM` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_list
-- ----------------------------
INSERT INTO `order_list` VALUES (19, 3, 'dylan', '2020-04-07 11:15:49', 3, 1, '百世汇通', NULL);
INSERT INTO `order_list` VALUES (20, 2, 'dylan', '2020-04-07 11:15:49', 3, 2, '百世汇通', '5646546');
INSERT INTO `order_list` VALUES (21, 11, 'admin', '2020-04-07 11:30:47', 4, 2, '顺丰快递', '34534534543');
INSERT INTO `order_list` VALUES (22, 3, 'admin', '2020-04-07 11:30:47', 4, 1, '顺丰快递', NULL);
INSERT INTO `order_list` VALUES (23, 2, 'admin', '2020-04-07 11:30:47', 4, 1, '顺丰快递', NULL);
INSERT INTO `order_list` VALUES (24, 1, 'admin', '2020-04-07 11:30:48', 1, 3, '顺丰快递', '231516');
INSERT INTO `order_list` VALUES (25, 5, 'admin', '2020-04-07 11:30:48', 3, 3, '顺丰快递', '23132');
INSERT INTO `order_list` VALUES (26, 1, 'dylan', '2020-04-08 23:04:01', 3, 1, '百世汇通', NULL);
INSERT INTO `order_list` VALUES (27, 9, 'dylan', '2020-04-08 23:04:02', 3, 3, '百世汇通', '56465465');
INSERT INTO `order_list` VALUES (28, 3, 'swulearner', '2020-04-10 16:05:27', 3, 1, '百世汇通', NULL);
INSERT INTO `order_list` VALUES (29, 11, 'swulearner', '2020-04-10 16:05:27', 3, 3, '百世汇通', '789456');
INSERT INTO `order_list` VALUES (30, 5, 'admin', '2020-04-10 16:16:03', 3, 1, '百世汇通', NULL);
INSERT INTO `order_list` VALUES (31, 11, 'admin', '2020-04-10 16:16:04', 3, 1, '百世汇通', NULL);
INSERT INTO `order_list` VALUES (32, 3, 'admin', '2020-04-10 16:16:04', 1, 1, '百世汇通', NULL);
INSERT INTO `order_list` VALUES (33, 10, 'admin', '2020-04-23 21:10:20', 2, 1, '圆通快递', NULL);
INSERT INTO `order_list` VALUES (34, 2, 'admin', '2020-04-23 21:11:44', 4, 1, '中通快递', NULL);
INSERT INTO `order_list` VALUES (35, 1, 'admin', '2020-06-05 17:51:33', 5, 1, '', NULL);
INSERT INTO `order_list` VALUES (36, 1, 'admin', '2020-06-05 17:52:18', 1, 1, '', NULL);
INSERT INTO `order_list` VALUES (37, 1, 'admin', '2020-06-05 21:53:02', 2, 1, '', NULL);
INSERT INTO `order_list` VALUES (38, 12, 'admin', '2020-06-05 21:53:02', 3, 1, '', NULL);
INSERT INTO `order_list` VALUES (39, 9, 'admin', '2020-06-05 21:53:02', 4, 1, '', NULL);
INSERT INTO `order_list` VALUES (40, 3, 'admin', '2020-06-05 21:53:03', 3, 1, '', NULL);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `PRODUCT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PRODUCT_DESCRIPTION` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PRODUCT_PRICE` decimal(10, 2) NOT NULL,
  `PRODUCT_STOCK` decimal(10, 2) NULL DEFAULT NULL,
  `PRODUCT_FID` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_CID` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_PICTURE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '多特蒙德卫衣', '黄色卫衣', 299.00, 1.00, 1, 5, 'u=3778513161,2671931925&fm=26&gp=0.jpg');
INSERT INTO `product` VALUES (2, '多特蒙德运动裤', '足球短裤', 219.50, 202.00, 2, 15, '0dbe86a2aee04c5c.jpg');
INSERT INTO `product` VALUES (3, '多特蒙德球衣', '多特蒙德主场上装', 315.50, 82.00, 1, 11, '91b2cadfd1c63dbb.jpg');
INSERT INTO `product` VALUES (5, '多特蒙德外套', '外套', 599.00, 994.00, 1, 16, 'e0b2b64661244458.jpg');
INSERT INTO `product` VALUES (9, '耐克足球鞋', '足球鞋', 999.00, 43.00, 3, 12, '35c5f3d9c6bae137.jpg');
INSERT INTO `product` VALUES (10, '猎鹰足球鞋', '阿迪达斯足球鞋', 1099.00, 597.00, 3, 12, 'ee7bfca2786de53d.jpg');
INSERT INTO `product` VALUES (11, '多特蒙德围巾', '保暖围巾', 50.00, 53.00, 4, 10, 'th.jfif');
INSERT INTO `product` VALUES (12, '多特蒙德袜子', '保暖长袜', 20.00, 84.00, 4, 10, '5b6f10d30151dc11.png');
INSERT INTO `product` VALUES (13, '足球鞋', '足球鞋', 499.50, 1000.00, 3, 12, 'a24b91ef11f1599a.jpg');
INSERT INTO `product` VALUES (14, '耐克短袖', '耐克短袖', 199.00, 100.00, 1, 11, 'OIP.jpg');
INSERT INTO `product` VALUES (15, 'adidas短袖', 'adidas短袖', 209.00, 200.00, 1, 11, 'OIP (1).jpg');

-- ----------------------------
-- Table structure for user_list
-- ----------------------------
DROP TABLE IF EXISTS `user_list`;
CREATE TABLE `user_list`  (
  `USER_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_SEX` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_BIRTHDAY` datetime(0) NULL DEFAULT NULL,
  `USER_IDENITY_CODE` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_EMAIL` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_MOBILE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_STATUS` decimal(6, 0) NOT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_list
-- ----------------------------
INSERT INTO `user_list` VALUES ('admin', 'admin', '123456', 'T', '2020-01-02 00:00:00', NULL, '865014147@qq.com', '22336558899', 'hefei', 2);
INSERT INTO `user_list` VALUES ('admin111', 'aaa', '123456', 'F', '2020-03-08 00:00:00', NULL, '13216812@163.com', '12344558877', 'chongqin', 1);
INSERT INTO `user_list` VALUES ('dylan', 'qwer', '0000', 'T', '2019-08-09 00:00:00', NULL, '777476565675@163.com', '12344558877', 'hefei', 1);
INSERT INTO `user_list` VALUES ('swulearner', '童实语', '123456', 'T', '2019-08-09 00:00:00', NULL, '777476565675@163.com', '15999887788', '西南大学', 1);

SET FOREIGN_KEY_CHECKS = 1;
