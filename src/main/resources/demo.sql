/*
 Navicat MySQL Data Transfer

 Source Server         : 本机数据库
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 127.0.0.1:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 27/07/2020 18:00:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `createTime` bigint(13) NOT NULL COMMENT '创建时间',
  `modifyTime` bigint(13) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '删除状态 1有效 2已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '账号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, 'test02', '123', 11111111111, 1595776918165, 1);
INSERT INTO `user` VALUES (7, 'test01', 'string', 1595776944555, 1595776944555, 1);
INSERT INTO `user` VALUES (8, 'wjh', '123', 1595843541523, 1595843541523, 1);

SET FOREIGN_KEY_CHECKS = 1;
