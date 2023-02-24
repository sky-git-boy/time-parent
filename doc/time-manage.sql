/*
 Navicat Premium Data Transfer

 Source Server         : 华为云
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 116.205.247.83:3307
 Source Schema         : time-manage

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 24/02/2023 10:42:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log_oper_info
-- ----------------------------
DROP TABLE IF EXISTS `log_oper_info`;
CREATE TABLE `log_oper_info`  (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '业务类型（0其它 1新增 2删除 3修改 4登录）',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2前台用户）',
  `oper_by` bigint(20) NULL DEFAULT NULL COMMENT '操作人员',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '返回参数',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 219 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_oper_info
-- ----------------------------
INSERT INTO `log_oper_info` VALUES (6, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-14 14:57:12');
INSERT INTO `log_oper_info` VALUES (7, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', '[400] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=110&password=1234562&login_type=admin_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"invalid_grant\",\"error_description\":\"用户名或密码错误\"}]', '2021-12-14 14:58:38');
INSERT INTO `log_oper_info` VALUES (8, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-14 15:47:06');
INSERT INTO `log_oper_info` VALUES (9, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-15 11:31:38');
INSERT INTO `log_oper_info` VALUES (10, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-15 11:37:31');
INSERT INTO `log_oper_info` VALUES (11, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作失败\",\"code\":400}', '1', '[400] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=1234&password=11111&login_type=member_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"invalid_grant\",\"error_description\":\"用户名或密码错误\"}]', '2021-12-15 11:56:51');
INSERT INTO `log_oper_info` VALUES (12, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-15 11:59:06');
INSERT INTO `log_oper_info` VALUES (13, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', '[400] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=110&password=1234562&login_type=admin_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"invalid_grant\",\"error_description\":\"用户名或密码错误\"}]', '2021-12-15 12:02:16');
INSERT INTO `log_oper_info` VALUES (14, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-15 14:04:37');
INSERT INTO `log_oper_info` VALUES (15, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 123456', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', '[401] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=123456&password=123&login_type=admin_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"unauthorized\",\"error_description\":\"UserDetailsService returned null, which is an interface contract violation\"}]', '2021-12-15 15:06:20');
INSERT INTO `log_oper_info` VALUES (16, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 123456', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', '[401] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=123456&password=110&login_type=admin_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"unauthorized\",\"error_description\":\"UserDetailsService returned null, which is an interface contract violation\"}]', '2021-12-15 15:06:38');
INSERT INTO `log_oper_info` VALUES (17, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-15 15:07:00');
INSERT INTO `log_oper_info` VALUES (18, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-15 15:08:58');
INSERT INTO `log_oper_info` VALUES (19, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 123', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-15 15:15:57');
INSERT INTO `log_oper_info` VALUES (20, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-15 15:20:14');
INSERT INTO `log_oper_info` VALUES (21, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', '[400] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=110&password=1234562&login_type=admin_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"invalid_grant\",\"error_description\":\"用户名或密码错误\"}]', '2021-12-15 16:56:37');
INSERT INTO `log_oper_info` VALUES (22, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-15 16:56:45');
INSERT INTO `log_oper_info` VALUES (23, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-15 17:01:12');
INSERT INTO `log_oper_info` VALUES (24, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-16 10:41:34');
INSERT INTO `log_oper_info` VALUES (25, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-16 10:50:50');
INSERT INTO `log_oper_info` VALUES (26, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-16 10:51:58');
INSERT INTO `log_oper_info` VALUES (27, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-16 11:13:56');
INSERT INTO `log_oper_info` VALUES (28, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-16 11:14:52');
INSERT INTO `log_oper_info` VALUES (29, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-16 11:15:52');
INSERT INTO `log_oper_info` VALUES (30, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作失败\",\"code\":400}', '1', 'Read timed out executing POST http://authorization-server/oauth/token?grant_type=password&username=1234&password=123456&login_type=member_type', '2021-12-17 09:56:20');
INSERT INTO `log_oper_info` VALUES (31, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-17 09:57:09');
INSERT INTO `log_oper_info` VALUES (32, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-17 11:20:05');
INSERT INTO `log_oper_info` VALUES (34, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-19 12:49:07');
INSERT INTO `log_oper_info` VALUES (35, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作失败\",\"code\":400}', '1', 'Read timed out executing POST http://authorization-server/oauth/token?grant_type=password&username=1234&password=123456&login_type=member_type', '2021-12-20 12:59:19');
INSERT INTO `log_oper_info` VALUES (36, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 12:59:31');
INSERT INTO `log_oper_info` VALUES (37, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 14:53:40');
INSERT INTO `log_oper_info` VALUES (38, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 14:56:48');
INSERT INTO `log_oper_info` VALUES (39, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 15:53:46');
INSERT INTO `log_oper_info` VALUES (40, '添加个人任务', '1', 'com.sky.controller.TaskController.add()', 'POST', '2', 3, '/task/add', '127.0.0.1', '内网IP', '{\"important\":\"0\",\"simpleUser\":{\"userId\":3},\"description\":\"testtotest\",\"pageSize\":10,\"title\":\"testtotest\",\"pageNum\":1,\"tags\":\"0\"}', 'null', '1', '', '2021-12-20 17:09:02');
INSERT INTO `log_oper_info` VALUES (41, '添加个人任务', '1', 'com.sky.controller.TaskController.add()', 'POST', '2', 3, '/task/add', '127.0.0.1', '内网IP', '{\"important\":\"0\",\"simpleUser\":{\"userId\":3},\"description\":\"aaatest\",\"pageSize\":10,\"title\":\"aaatest\",\"pageNum\":1,\"tags\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 17:10:45');
INSERT INTO `log_oper_info` VALUES (42, '添加个人任务', '1', 'com.sky.controller.TaskController.add()', 'POST', '2', 3, '/task/add', '127.0.0.1', '内网IP', '{\"important\":\"0\",\"simpleUser\":{\"userId\":3},\"description\":\"1341\",\"pageSize\":10,\"title\":\"341\",\"pageNum\":1,\"status\":\"1\",\"tags\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 17:12:50');
INSERT INTO `log_oper_info` VALUES (43, '修改任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '1', 3, '/task/update', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"taskId\":1472856988923854848,\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 17:16:59');
INSERT INTO `log_oper_info` VALUES (44, '添加任务', '1', 'com.sky.controller.TaskController.add()', 'POST', '2', 3, '/task/add', '127.0.0.1', '内网IP', '{\"important\":\"0\",\"simpleUser\":{\"userId\":3},\"description\":\"adsfasfd\",\"pageSize\":10,\"title\":\"afdaf\",\"pageNum\":1,\"tags\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 17:22:04');
INSERT INTO `log_oper_info` VALUES (45, '添加任务', '1', 'com.sky.controller.TaskController.add()', 'POST', '2', 3, '/task/add', '127.0.0.1', '内网IP', '{\"important\":\"0\",\"simpleUser\":{\"userId\":3},\"description\":\"adfafd\",\"pageSize\":10,\"title\":\"fafdafd\",\"pageNum\":1,\"status\":\"1\",\"tags\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 17:24:08');
INSERT INTO `log_oper_info` VALUES (46, '修改任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"taskId\":1472859837305061376,\"status\":\"2\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 17:27:29');
INSERT INTO `log_oper_info` VALUES (47, '添加任务', '1', 'com.sky.controller.TaskController.add()', 'POST', '2', 3, '/task/add', '127.0.0.1', '内网IP', '{\"important\":\"0\",\"simpleUser\":{\"userId\":3},\"description\":\"afadsfsasfd\",\"pageSize\":10,\"title\":\"afafdasdfa\",\"pageNum\":1,\"status\":\"2\",\"tags\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 17:41:07');
INSERT INTO `log_oper_info` VALUES (48, '添加任务', '1', 'com.sky.controller.TaskController.add()', 'POST', '2', 3, '/task/add', '127.0.0.1', '内网IP', '{\"important\":\"0\",\"simpleUser\":{\"userId\":3},\"description\":\"afdafa\",\"pageSize\":10,\"title\":\"fadsfa\",\"pageNum\":1,\"status\":\"2\",\"tags\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 17:43:00');
INSERT INTO `log_oper_info` VALUES (49, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 21:41:49');
INSERT INTO `log_oper_info` VALUES (50, '添加任务', '2', 'com.sky.controller.TaskController.delete()', 'DELETE', '2', 3, '/task/delete/1472864825221709824', '127.0.0.1', '内网IP', '{id=1472864825221709824}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 21:45:45');
INSERT INTO `log_oper_info` VALUES (51, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 22:35:02');
INSERT INTO `log_oper_info` VALUES (52, '删除轮播图', '2', 'com.sky.controller.TimSlideController.deleteNoticeByIds()', 'DELETE', '1', 1, '/slide/deleteSlideByIds/9', '127.0.0.1', '内网IP', '{slideIds=9}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 23:17:16');
INSERT INTO `log_oper_info` VALUES (53, '修改轮播图', '3', 'com.sky.controller.TimSlideController.updateNotice()', 'PUT', '1', 1, '/slide/updateSlide', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/not-authorized.png\",\"simpleUser\":{\"userId\":1},\"slideId\":11,\"pageSize\":10,\"slideSort\":10,\"pageNum\":1,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 23:17:24');
INSERT INTO `log_oper_info` VALUES (54, '修改轮播图', '3', 'com.sky.controller.TimSlideController.updateNotice()', 'PUT', '1', 1, '/slide/updateSlide', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/forgot-password.png\",\"simpleUser\":{\"userId\":1},\"slideId\":1,\"pageSize\":10,\"slideSort\":1,\"pageNum\":1,\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 23:17:48');
INSERT INTO `log_oper_info` VALUES (55, '删除轮播图', '2', 'com.sky.controller.TimSlideController.deleteNoticeByIds()', 'DELETE', '1', 1, '/slide/deleteSlideByIds/1', '127.0.0.1', '内网IP', '{slideIds=1}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-20 23:17:53');
INSERT INTO `log_oper_info` VALUES (56, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 09:02:32');
INSERT INTO `log_oper_info` VALUES (57, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 09:11:39');
INSERT INTO `log_oper_info` VALUES (58, '添加轮播图', '1', 'com.sky.controller.TimSlideController.addNotice()', 'POST', '1', 1, '/slide/addSlide', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":1},\"pageSize\":10,\"slideSort\":0,\"pageNum\":1,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 09:13:52');
INSERT INTO `log_oper_info` VALUES (59, '修改轮播图', '3', 'com.sky.controller.TimSlideController.updateNotice()', 'PUT', '1', 1, '/slide/updateSlide', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/forgot-password.png\",\"simpleUser\":{\"userId\":1},\"slideId\":15,\"pageSize\":10,\"slideSort\":0,\"pageNum\":1,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 09:16:14');
INSERT INTO `log_oper_info` VALUES (60, '修改轮播图', '3', 'com.sky.controller.TimSlideController.updateNotice()', 'PUT', '1', 1, '/slide/updateSlide', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/forgot-password.png\",\"simpleUser\":{\"userId\":1},\"slideId\":15,\"pageSize\":10,\"slideSort\":0,\"pageNum\":1,\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 09:39:52');
INSERT INTO `log_oper_info` VALUES (61, '修改轮播图', '3', 'com.sky.controller.TimSlideController.updateNotice()', 'PUT', '1', 1, '/slide/updateSlide', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/graphic-1.png\",\"simpleUser\":{\"userId\":1},\"slideId\":2,\"pageSize\":10,\"slideSort\":2,\"pageNum\":1,\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 09:39:56');
INSERT INTO `log_oper_info` VALUES (62, '修改轮播图', '3', 'com.sky.controller.TimSlideController.updateNotice()', 'PUT', '1', 1, '/slide/updateSlide', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/graphic-2.png\",\"simpleUser\":{\"userId\":1},\"slideId\":3,\"pageSize\":10,\"slideSort\":3,\"pageNum\":1,\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 09:39:59');
INSERT INTO `log_oper_info` VALUES (63, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 1234', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 10:03:43');
INSERT INTO `log_oper_info` VALUES (64, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 11:53:18');
INSERT INTO `log_oper_info` VALUES (65, '添加轮播图', '1', 'com.sky.controller.TimeMusicController.addNotice()', 'POST', '1', 1, '/music/addMusic', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/66226434466.jpg\",\"simpleUser\":{\"userId\":1},\"musicUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/test.mp4\",\"pageSize\":10,\"pageNum\":1,\"musicName\":\"test\",\"status\":\"0\"}', 'null', '1', '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'music_id\' cannot be null\r\n### The error may exist in com/sky/mapper/TimeMusicMapper.java (best guess)\r\n### The error may involve com.sky.mapper.TimeMusicMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO time_music  ( music_id, music_name, music_url, pic_url, create_by, create_time,   status )  VALUES  ( ?, ?, ?, ?, ?, ?,   ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'music_id\' cannot be null\n; Column \'music_id\' cannot be null; nested exception is java.sql.SQLIntegrityConstraintViolationException: Column \'music_id\' cannot be null', '2021-12-21 14:24:44');
INSERT INTO `log_oper_info` VALUES (66, '添加轮播图', '1', 'com.sky.controller.TimeMusicController.addNotice()', 'POST', '1', 1, '/music/addMusic', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/66226434466.jpg\",\"simpleUser\":{\"userId\":1},\"musicUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/test.mp4\",\"pageSize\":10,\"pageNum\":1,\"musicName\":\"test\",\"status\":\"0\"}', 'null', '1', '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'music_id\' cannot be null\r\n### The error may exist in com/sky/mapper/TimeMusicMapper.java (best guess)\r\n### The error may involve com.sky.mapper.TimeMusicMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO time_music  ( music_id, music_name, music_url, pic_url, create_by, create_time,   status )  VALUES  ( ?, ?, ?, ?, ?, ?,   ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'music_id\' cannot be null\n; Column \'music_id\' cannot be null; nested exception is java.sql.SQLIntegrityConstraintViolationException: Column \'music_id\' cannot be null', '2021-12-21 14:24:55');
INSERT INTO `log_oper_info` VALUES (67, '添加轮播图', '1', 'com.sky.controller.TimeMusicController.addNotice()', 'POST', '1', 1, '/music/addMusic', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/66226434466.jpg\",\"simpleUser\":{\"userId\":1},\"musicUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/test.mp4\",\"pageSize\":10,\"pageNum\":1,\"musicName\":\"test\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:26:42');
INSERT INTO `log_oper_info` VALUES (68, '修改轮播图', '3', 'com.sky.controller.TimeMusicController.updateNotice()', 'PUT', '1', 1, '/music/updateMusic', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/66226434466.jpg\",\"simpleUser\":{\"userId\":1},\"musicId\":7,\"musicUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/raindrop.mp3\",\"pageSize\":10,\"pageNum\":1,\"musicName\":\"test\",\"status\":\"0\"}', 'null', '1', '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'7\' for key \'PRIMARY\'\r\n### The error may exist in com/sky/mapper/TimeMusicMapper.java (best guess)\r\n### The error may involve com.sky.mapper.TimeMusicMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO time_music  ( music_id, music_name, music_url, pic_url,   update_by, update_time, status )  VALUES  ( ?, ?, ?, ?,   ?, ?, ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'7\' for key \'PRIMARY\'\n; Duplicate entry \'7\' for key \'PRIMARY\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'7\' for key \'PRIMARY\'', '2021-12-21 14:38:10');
INSERT INTO `log_oper_info` VALUES (69, '修改轮播图', '3', 'com.sky.controller.TimeMusicController.updateNotice()', 'PUT', '1', 1, '/music/updateMusic', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/66226434466.jpg\",\"simpleUser\":{\"userId\":1},\"musicId\":7,\"musicUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/raindrop.mp3\",\"pageSize\":10,\"pageNum\":1,\"musicName\":\"test\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:39:37');
INSERT INTO `log_oper_info` VALUES (70, '修改轮播图', '3', 'com.sky.controller.TimeMusicController.updateNotice()', 'PUT', '1', 1, '/music/updateMusic', '127.0.0.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/66226434466.jpg\",\"simpleUser\":{\"userId\":1},\"musicId\":7,\"musicUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/thunder.mp3\",\"pageSize\":10,\"pageNum\":1,\"musicName\":\"test\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:41:32');
INSERT INTO `log_oper_info` VALUES (71, '删除轮播图', '2', 'com.sky.controller.TimeMusicController.deleteNoticeByIds()', 'DELETE', '1', 1, '/music/deleteMusicByIds/7', '127.0.0.1', '内网IP', '{musicIds=7}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:41:50');
INSERT INTO `log_oper_info` VALUES (72, '删除字典类型数据', '2', 'com.sky.controller.SysDictTypeController.deleteDictTypeByIds()', 'DELETE', '1', 1, '/dict/type/deleteDictTypeByIds/11', '127.0.0.1', '内网IP', '{dictIds=11}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:45:12');
INSERT INTO `log_oper_info` VALUES (73, '新增字典类型数据', '1', 'com.sky.controller.SysDictTypeController.addDictType()', 'POST', '1', 1, '/dict/type/addDictType', '127.0.0.1', '内网IP', '{\"pageSize\":10,\"remark\":\"任务类型\",\"pageNum\":1,\"dictType\":\"time_task_type\",\"simpleUser\":{\"userId\":1},\"dictName\":\"任务类型\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:46:16');
INSERT INTO `log_oper_info` VALUES (74, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '127.0.0.1', '内网IP', '{\"dictValue\":\"0\",\"dictSort\":0,\"pageSize\":10,\"remark\":\"无\",\"pageNum\":1,\"dictType\":\"time_task_type\",\"dictLabel\":\"none\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:46:43');
INSERT INTO `log_oper_info` VALUES (75, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '127.0.0.1', '内网IP', '{\"dictValue\":\"1\",\"dictSort\":0,\"pageSize\":10,\"remark\":\"工作\",\"pageNum\":1,\"dictType\":\"time_task_type\",\"dictLabel\":\"work\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:47:02');
INSERT INTO `log_oper_info` VALUES (76, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '127.0.0.1', '内网IP', '{\"dictValue\":\"2\",\"dictSort\":0,\"pageSize\":10,\"remark\":\"业务\",\"pageNum\":1,\"dictType\":\"time_task_type\",\"dictLabel\":\"business\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:47:18');
INSERT INTO `log_oper_info` VALUES (77, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '127.0.0.1', '内网IP', '{\"dictValue\":\"3\",\"dictSort\":0,\"pageSize\":10,\"remark\":\"个人\",\"pageNum\":1,\"dictType\":\"time_task_type\",\"dictLabel\":\"personal\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:47:40');
INSERT INTO `log_oper_info` VALUES (78, '新增字典类型数据', '1', 'com.sky.controller.SysDictTypeController.addDictType()', 'POST', '1', 1, '/dict/type/addDictType', '127.0.0.1', '内网IP', '{\"pageSize\":10,\"remark\":\"是否重要\",\"pageNum\":1,\"dictType\":\"time_is_important\",\"simpleUser\":{\"userId\":1},\"dictName\":\"是否重要\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:48:29');
INSERT INTO `log_oper_info` VALUES (79, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '127.0.0.1', '内网IP', '{\"dictValue\":\"0\",\"dictSort\":0,\"pageSize\":10,\"remark\":\"否\",\"pageNum\":1,\"dictType\":\"time_is_important\",\"dictLabel\":\"否\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:48:45');
INSERT INTO `log_oper_info` VALUES (80, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '127.0.0.1', '内网IP', '{\"dictValue\":\"1\",\"dictSort\":0,\"pageSize\":10,\"remark\":\"是\",\"pageNum\":1,\"dictType\":\"time_is_important\",\"dictLabel\":\"是\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:48:53');
INSERT INTO `log_oper_info` VALUES (81, '新增字典类型数据', '1', 'com.sky.controller.SysDictTypeController.addDictType()', 'POST', '1', 1, '/dict/type/addDictType', '127.0.0.1', '内网IP', '{\"pageSize\":10,\"remark\":\"任务状态\",\"pageNum\":1,\"dictType\":\"time_task_status\",\"simpleUser\":{\"userId\":1},\"dictName\":\"任务状态\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:49:18');
INSERT INTO `log_oper_info` VALUES (82, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '127.0.0.1', '内网IP', '{\"dictValue\":\"0\",\"dictSort\":0,\"pageSize\":10,\"remark\":\"待办\",\"pageNum\":1,\"dictType\":\"time_task_status\",\"dictLabel\":\"待办\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:49:32');
INSERT INTO `log_oper_info` VALUES (83, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '127.0.0.1', '内网IP', '{\"dictValue\":\"1\",\"dictSort\":0,\"pageSize\":10,\"remark\":\"进行中\",\"pageNum\":1,\"dictType\":\"time_task_status\",\"dictLabel\":\"进行中\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:49:43');
INSERT INTO `log_oper_info` VALUES (84, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '127.0.0.1', '内网IP', '{\"dictValue\":\"2\",\"dictSort\":0,\"pageSize\":10,\"remark\":\"完成\",\"pageNum\":1,\"dictType\":\"time_task_status\",\"dictLabel\":\"完成\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:49:53');
INSERT INTO `log_oper_info` VALUES (85, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '127.0.0.1', '内网IP', '{\"dictValue\":\"3\",\"dictSort\":0,\"pageSize\":10,\"remark\":\"过期\",\"pageNum\":1,\"dictType\":\"time_task_status\",\"dictLabel\":\"过期\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 14:50:08');
INSERT INTO `log_oper_info` VALUES (86, '添加个人事件', '1', 'com.sky.controller.EventController.add()', 'POST', '2', 3, '/event/add', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"endDate\":1640725980000,\"classes\":\"event-primary\",\"pageSize\":10,\"title\":\"adfaf\",\"pageNum\":1,\"startDate\":1640639580000,\"tags\":\"0\"}', 'null', '1', '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'user_id\' doesn\'t have a default value\r\n### The error may exist in com/sky/mapper/TimeEventMapper.java (best guess)\r\n### The error may involve com.sky.mapper.TimeEventMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO time_event  ( title, start_date, end_date,  tags, classes )  VALUES  ( ?, ?, ?,  ?, ? )\r\n### Cause: java.sql.SQLException: Field \'user_id\' doesn\'t have a default value\n; Field \'user_id\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'user_id\' doesn\'t have a default value', '2021-12-21 17:13:20');
INSERT INTO `log_oper_info` VALUES (87, '添加个人事件', '1', 'com.sky.controller.EventController.add()', 'POST', '2', 3, '/event/add', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"endDate\":1640813940000,\"classes\":\"event-primary\",\"pageSize\":10,\"title\":\"asdfa\",\"pageNum\":1,\"startDate\":1640641140000,\"tags\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 17:39:30');
INSERT INTO `log_oper_info` VALUES (88, '添加个人事件', '1', 'com.sky.controller.EventController.add()', 'POST', '2', 3, '/event/add', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"endDate\":1640554860000,\"classes\":\"event-primary\",\"pageSize\":10,\"title\":\"daaaa\",\"pageNum\":1,\"startDate\":1640468460000,\"tags\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 17:41:45');
INSERT INTO `log_oper_info` VALUES (89, '删除个人事件', '2', 'com.sky.controller.EventController.delete()', 'DELETE', '2', 3, '/event/delete/6', '127.0.0.1', '内网IP', '{id=6}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 17:44:58');
INSERT INTO `log_oper_info` VALUES (90, '添加个人事件', '1', 'com.sky.controller.EventController.add()', 'POST', '2', 3, '/event/add', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"endDate\":1640555100000,\"classes\":\"event-warning\",\"pageSize\":10,\"title\":\"sda\",\"pageNum\":1,\"startDate\":1640468700000,\"tags\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 17:45:18');
INSERT INTO `log_oper_info` VALUES (91, '删除个人事件', '2', 'com.sky.controller.EventController.delete()', 'DELETE', '2', 3, '/event/delete/7', '127.0.0.1', '内网IP', '{id=7}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 17:45:21');
INSERT INTO `log_oper_info` VALUES (92, '修改个人事件', '3', 'com.sky.controller.EventController.update()', 'PUT', '2', 3, '/event/update', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"endDate\":1640554740000,\"classes\":\"event-danger\",\"pageSize\":10,\"id\":5,\"title\":\"asdfassss\",\"pageNum\":1,\"startDate\":1640468340000,\"tags\":\"3\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 17:52:14');
INSERT INTO `log_oper_info` VALUES (93, '添加个人事件', '1', 'com.sky.controller.EventController.add()', 'POST', '2', 3, '/event/add', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"endDate\":1639433280000,\"classes\":\"event-warning\",\"pageSize\":10,\"title\":\"test\",\"pageNum\":1,\"startDate\":1639346880000,\"tags\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 18:08:33');
INSERT INTO `log_oper_info` VALUES (94, '修改个人事件', '3', 'com.sky.controller.EventController.update()', 'PUT', '2', 3, '/event/update', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"endDate\":1638914880000,\"classes\":\"event-warning\",\"pageSize\":10,\"id\":8,\"title\":\"test\",\"pageNum\":1,\"startDate\":1638742080000,\"tags\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 18:08:41');
INSERT INTO `log_oper_info` VALUES (95, '删除个人事件', '2', 'com.sky.controller.EventController.delete()', 'DELETE', '2', 3, '/event/delete/8', '127.0.0.1', '内网IP', '{id=8}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 18:08:44');
INSERT INTO `log_oper_info` VALUES (96, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 20:45:31');
INSERT INTO `log_oper_info` VALUES (97, '删除个人任务', '2', 'com.sky.controller.TaskController.delete()', 'DELETE', '2', 3, '/task/delete/1472863114348331008', '127.0.0.1', '内网IP', '{id=1472863114348331008}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 20:45:41');
INSERT INTO `log_oper_info` VALUES (98, '删除个人任务', '2', 'com.sky.controller.TaskController.delete()', 'DELETE', '2', 3, '/task/delete/1472859837305061376', '127.0.0.1', '内网IP', '{id=1472859837305061376}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 20:45:43');
INSERT INTO `log_oper_info` VALUES (99, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"taskId\":9,\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 20:46:20');
INSERT INTO `log_oper_info` VALUES (100, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"taskId\":1472856988923854848,\"status\":\"2\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-21 20:46:36');
INSERT INTO `log_oper_info` VALUES (101, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', 'Read timed out executing POST http://authorization-server/oauth/token?grant_type=password&username=110&password=123456&login_type=admin_type', '2021-12-22 14:01:00');
INSERT INTO `log_oper_info` VALUES (102, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-22 14:02:18');
INSERT INTO `log_oper_info` VALUES (103, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-22 14:40:25');
INSERT INTO `log_oper_info` VALUES (104, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-22 20:29:58');
INSERT INTO `log_oper_info` VALUES (105, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 15205976807', '{\"msg\":\"操作失败\",\"code\":400}', '1', '[401] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=15205976807&password=123456&login_type=member_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"unauthorized\",\"error_description\":\"用户【15205976807】无权限\"}]', '2021-12-22 20:51:45');
INSERT INTO `log_oper_info` VALUES (106, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 15205976807', '{\"msg\":\"操作失败\",\"code\":400}', '1', '[401] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=15205976807&password=123456&login_type=member_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"unauthorized\",\"error_description\":\"用户【15205976807】无权限\"}]', '2021-12-22 20:51:50');
INSERT INTO `log_oper_info` VALUES (107, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 15205976807', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-22 20:54:25');
INSERT INTO `log_oper_info` VALUES (108, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 15205976807', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-22 21:12:13');
INSERT INTO `log_oper_info` VALUES (109, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 15205976807', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-22 22:27:59');
INSERT INTO `log_oper_info` VALUES (110, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 15205976807', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-22 22:29:29');
INSERT INTO `log_oper_info` VALUES (111, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 19859217185', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-22 22:56:22');
INSERT INTO `log_oper_info` VALUES (112, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 09:24:13');
INSERT INTO `log_oper_info` VALUES (113, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 09:26:31');
INSERT INTO `log_oper_info` VALUES (114, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 09:27:20');
INSERT INTO `log_oper_info` VALUES (115, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 09:31:38');
INSERT INTO `log_oper_info` VALUES (116, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 09:33:38');
INSERT INTO `log_oper_info` VALUES (117, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 123', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 09:36:12');
INSERT INTO `log_oper_info` VALUES (118, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 09:37:06');
INSERT INTO `log_oper_info` VALUES (119, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 10:11:02');
INSERT INTO `log_oper_info` VALUES (120, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 11:03:10');
INSERT INTO `log_oper_info` VALUES (121, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', 'Read timed out executing POST http://authorization-server/oauth/token?grant_type=password&username=110&password=123456&login_type=admin_type', '2021-12-23 13:01:03');
INSERT INTO `log_oper_info` VALUES (122, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 13:01:21');
INSERT INTO `log_oper_info` VALUES (123, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 14:06:59');
INSERT INTO `log_oper_info` VALUES (124, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作失败\",\"code\":400}', '1', 'Read timed out executing POST http://authorization-server/oauth/token?grant_type=password&username=13645912977&password=123456&login_type=member_type', '2021-12-23 14:41:16');
INSERT INTO `log_oper_info` VALUES (125, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-23 14:41:28');
INSERT INTO `log_oper_info` VALUES (126, '登录', '4', '', '', '2', NULL, '', '112.47.163.135', '内网IP', '账号: 13645912977', '{\"msg\":\"操作失败\",\"code\":400}', '1', 'Connection refused (Connection refused) executing POST http://authorization-server/oauth/token?grant_type=password&username=13645912977&password=123456&login_type=member_type', '2021-12-23 23:10:50');
INSERT INTO `log_oper_info` VALUES (127, '登录', '4', '', '', '1', NULL, '', '59.61.216.124', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', 'Connection refused (Connection refused) executing POST http://authorization-server/oauth/token?grant_type=password&username=110&password=123456&login_type=admin_type', '2021-12-24 09:23:23');
INSERT INTO `log_oper_info` VALUES (128, '登录', '4', '', '', '1', NULL, '', '59.61.216.124', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', 'Connection refused (Connection refused) executing POST http://authorization-server/oauth/token?grant_type=password&username=110&password=123456&login_type=admin_type', '2021-12-24 09:23:31');
INSERT INTO `log_oper_info` VALUES (129, '登录', '4', '', '', '1', NULL, '', '59.61.216.124', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', 'Connection refused (Connection refused) executing POST http://authorization-server/oauth/token?grant_type=password&username=110&password=123456&login_type=admin_type', '2021-12-24 09:24:10');
INSERT INTO `log_oper_info` VALUES (130, '登录', '4', '', '', '1', NULL, '', '59.61.216.124', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', 'Connection refused (Connection refused) executing POST http://authorization-server/oauth/token?grant_type=password&username=110&password=123456&login_type=admin_type', '2021-12-24 09:25:54');
INSERT INTO `log_oper_info` VALUES (131, '登录', '4', '', '', '1', NULL, '', '59.61.216.124', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', 'Connection refused (Connection refused) executing POST http://authorization-server/oauth/token?grant_type=password&username=110&password=123456&login_type=admin_type', '2021-12-24 09:26:17');
INSERT INTO `log_oper_info` VALUES (132, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作失败\",\"code\":400}', '1', 'Read timed out executing POST http://authorization-server/oauth/token?grant_type=password&username=13645912977&password=123456&login_type=member_type', '2021-12-24 14:41:46');
INSERT INTO `log_oper_info` VALUES (133, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作失败\",\"code\":400}', '1', 'Read timed out executing POST http://authorization-server/oauth/token?grant_type=password&username=13645912977&password=123456&login_type=member_type', '2021-12-24 14:41:22');
INSERT INTO `log_oper_info` VALUES (134, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 14:42:04');
INSERT INTO `log_oper_info` VALUES (135, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 14:43:11');
INSERT INTO `log_oper_info` VALUES (136, '登录', '4', '', '', '1', NULL, '', '192.168.36.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 14:42:20');
INSERT INTO `log_oper_info` VALUES (137, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '192.168.36.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"taskId\":9,\"status\":\"2\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 14:44:40');
INSERT INTO `log_oper_info` VALUES (138, '登录', '4', '', '', '1', NULL, '', '192.168.36.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:30:10');
INSERT INTO `log_oper_info` VALUES (139, '新增字典类型数据', '1', 'com.sky.controller.SysDictTypeController.addDictType()', 'POST', '1', 1, '/dict/type/addDictType', '192.168.36.1', '内网IP', '{\"pageSize\":10,\"remark\":\"test\",\"pageNum\":1,\"dictType\":\"test\",\"simpleUser\":{\"userId\":1},\"dictName\":\"test\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:30:38');
INSERT INTO `log_oper_info` VALUES (140, '更新字典类型数据', '3', 'com.sky.controller.SysDictTypeController.updateDictType()', 'PUT', '1', 1, '/dict/type/updateDictType', '192.168.36.1', '内网IP', '{\"pageSize\":10,\"remark\":\"tests\",\"updateTime\":1640305837000,\"dictId\":15,\"pageNum\":1,\"dictType\":\"tests\",\"simpleUser\":{\"userId\":1},\"createBy\":\"1\",\"createTime\":1640334637000,\"dictName\":\"tests\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:33:07');
INSERT INTO `log_oper_info` VALUES (141, '删除字典类型数据', '2', 'com.sky.controller.SysDictTypeController.deleteDictTypeByIds()', 'DELETE', '1', 1, '/dict/type/deleteDictTypeByIds/15', '192.168.36.1', '内网IP', '{dictIds=15}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:33:10');
INSERT INTO `log_oper_info` VALUES (142, '新增字典类型数据', '1', 'com.sky.controller.SysDictTypeController.addDictType()', 'POST', '1', 1, '/dict/type/addDictType', '192.168.36.1', '内网IP', '{\"pageSize\":10,\"remark\":\"系统状态\",\"pageNum\":1,\"dictType\":\"sys_common_status\",\"simpleUser\":{\"userId\":1},\"dictName\":\"系统状态\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:42:17');
INSERT INTO `log_oper_info` VALUES (143, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '192.168.36.1', '内网IP', '{\"dictValue\":\"0\",\"dictSort\":0,\"pageSize\":10,\"pageNum\":1,\"dictType\":\"sys_common_status\",\"dictLabel\":\"正常\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:43:14');
INSERT INTO `log_oper_info` VALUES (144, '新增字典数据', '1', 'com.sky.controller.SysDictDataController.addDictData()', 'POST', '1', 1, '/dict/data/addDictData', '192.168.36.1', '内网IP', '{\"dictValue\":\"1\",\"dictSort\":0,\"pageSize\":10,\"pageNum\":1,\"dictType\":\"sys_common_status\",\"dictLabel\":\"异常\",\"simpleUser\":{\"userId\":1},\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:43:22');
INSERT INTO `log_oper_info` VALUES (145, '修改轮播图', '3', 'com.sky.controller.TimSlideController.updateNotice()', 'PUT', '1', 1, '/slide/updateSlide', '192.168.36.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/register.jpg\",\"simpleUser\":{\"userId\":1},\"slideId\":13,\"pageSize\":10,\"slideSort\":12,\"pageNum\":1,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:44:17');
INSERT INTO `log_oper_info` VALUES (146, '修改轮播图', '3', 'com.sky.controller.TimSlideController.updateNotice()', 'PUT', '1', 1, '/slide/updateSlide', '192.168.36.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/graphic-1.png\",\"simpleUser\":{\"userId\":1},\"slideId\":2,\"pageSize\":10,\"slideSort\":2,\"pageNum\":1,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:44:26');
INSERT INTO `log_oper_info` VALUES (147, '修改轮播图', '3', 'com.sky.controller.TimSlideController.updateNotice()', 'PUT', '1', 1, '/slide/updateSlide', '192.168.36.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/graphic-1.png\",\"simpleUser\":{\"userId\":1},\"slideId\":2,\"pageSize\":10,\"slideSort\":2,\"pageNum\":1,\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:45:11');
INSERT INTO `log_oper_info` VALUES (148, '修改轮播图', '3', 'com.sky.controller.TimSlideController.updateNotice()', 'PUT', '1', 1, '/slide/updateSlide', '192.168.36.1', '内网IP', '{\"picUrl\":\"https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/forgot-password.png\",\"simpleUser\":{\"userId\":1},\"slideId\":15,\"pageSize\":10,\"slideSort\":0,\"pageNum\":1,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 16:45:21');
INSERT INTO `log_oper_info` VALUES (149, '登录', '4', '', '', '1', NULL, '', '192.168.36.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 17:45:41');
INSERT INTO `log_oper_info` VALUES (150, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-24 18:29:24');
INSERT INTO `log_oper_info` VALUES (151, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-25 16:06:09');
INSERT INTO `log_oper_info` VALUES (152, '登录', '4', '', '', '1', NULL, '', '192.168.36.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-25 16:06:36');
INSERT INTO `log_oper_info` VALUES (153, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-25 16:55:13');
INSERT INTO `log_oper_info` VALUES (154, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-25 16:59:57');
INSERT INTO `log_oper_info` VALUES (155, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '192.168.36.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"status\":\"0\"}', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2021-12-25 17:00:51');
INSERT INTO `log_oper_info` VALUES (156, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '192.168.36.1', '内网IP', '{\"important\":\"0\",\"simpleUser\":{\"userId\":3},\"description\":\"Dragée gummi bears tiramisu brownie cookie. Jelly beans pudding marzipan fruitcake muffin. Wafer gummi bears lollipop pudding lollipop biscuit.\",\"pageSize\":10,\"endTime\":1639729800000,\"title\":\"Send PPT 🎁\",\"pageNum\":1,\"taskId\":3,\"status\":\"2\",\"tags\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-25 17:16:38');
INSERT INTO `log_oper_info` VALUES (157, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '192.168.36.1', '内网IP', '{\"important\":\"0\",\"simpleUser\":{\"userId\":3},\"description\":\"Dragée gummi bears tiramisu brownie cookie. Jelly beans pudding marzipan fruitcake muffin. Wafer gummi bears lollipop pudding lollipop biscuit.\",\"pageSize\":10,\"endTime\":1639729800000,\"title\":\"Send PPT 🎁\",\"pageNum\":1,\"taskId\":3,\"status\":\"0\",\"tags\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-25 17:16:39');
INSERT INTO `log_oper_info` VALUES (158, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-26 15:00:51');
INSERT INTO `log_oper_info` VALUES (159, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-26 15:12:55');
INSERT INTO `log_oper_info` VALUES (160, '登录', '4', '', '', '2', NULL, '', '192.168.36.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-26 15:19:15');
INSERT INTO `log_oper_info` VALUES (161, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '192.168.36.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"taskId\":6,\"status\":\"2\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-26 15:41:44');
INSERT INTO `log_oper_info` VALUES (162, '添加个人任务', '1', 'com.sky.controller.TaskController.add()', 'POST', '2', 3, '/task/add', '127.0.0.1', '内网IP', '{\"important\":\"1\",\"simpleUser\":{\"userId\":3},\"description\":\"ffff\",\"pageSize\":10,\"endTime\":1640664000000,\"title\":\"tttt\",\"pageNum\":1,\"status\":\"1\",\"tags\":\"2\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2021-12-26 18:09:19');
INSERT INTO `log_oper_info` VALUES (163, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', '[401] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=13645912977&password=123456&login_type=admin_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"unauthorized\",\"error_description\":\"UserDetailsService returned null, which is an interface contract violation\"}]', '2023-02-20 17:46:38');
INSERT INTO `log_oper_info` VALUES (164, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', '[400] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=110&password=admin&login_type=admin_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"invalid_grant\",\"error_description\":\"用户名或密码错误\"}]', '2023-02-20 17:48:07');
INSERT INTO `log_oper_info` VALUES (165, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', '[400] during [POST] to [http://authorization-server/oauth/token?grant_type=password&username=110&password=110&login_type=admin_type] [OAuth2FeignClient#getToken(String,String,String,String,String)]: [{\"error\":\"invalid_grant\",\"error_description\":\"用户名或密码错误\"}]', '2023-02-20 17:49:46');
INSERT INTO `log_oper_info` VALUES (166, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 17:49:51');
INSERT INTO `log_oper_info` VALUES (167, '登录', '4', '', '', '1', NULL, '', '127.0.0.1', '内网IP', '账号: 110', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 17:56:25');
INSERT INTO `log_oper_info` VALUES (168, '保存角色和菜单权限关系', '1', 'com.sky.controller.SysRoleController.saveRoleMenu()', 'POST', '1', 1, '/role/saveRoleMenu/3/21,15,16,17,18,19,20', '127.0.0.1', '内网IP', '3 [21,15,16,17,18,19,20]', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 18:31:17');
INSERT INTO `log_oper_info` VALUES (169, '删除轮播图', '2', 'com.sky.controller.TimSlideController.deleteNoticeByIds()', 'DELETE', '1', 1, '/slide/deleteSlideByIds/3', '127.0.0.1', '内网IP', '{slideIds=3}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 18:34:39');
INSERT INTO `log_oper_info` VALUES (170, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 19:26:56');
INSERT INTO `log_oper_info` VALUES (171, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"status\":\"1\"}', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:27:31');
INSERT INTO `log_oper_info` VALUES (172, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"status\":\"3\"}', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:32:24');
INSERT INTO `log_oper_info` VALUES (173, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"status\":\"3\"}', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:32:25');
INSERT INTO `log_oper_info` VALUES (174, '修改个人任务', '3', 'com.sky.controller.TaskController.update()', 'PUT', '2', 3, '/task/update', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"pageSize\":10,\"pageNum\":1,\"status\":\"3\"}', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:32:27');
INSERT INTO `log_oper_info` VALUES (175, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:49:10');
INSERT INTO `log_oper_info` VALUES (176, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:49:11');
INSERT INTO `log_oper_info` VALUES (177, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:49:14');
INSERT INTO `log_oper_info` VALUES (178, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:49:18');
INSERT INTO `log_oper_info` VALUES (179, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:49:22');
INSERT INTO `log_oper_info` VALUES (180, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:49:30');
INSERT INTO `log_oper_info` VALUES (181, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:49:31');
INSERT INTO `log_oper_info` VALUES (182, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:49:31');
INSERT INTO `log_oper_info` VALUES (183, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:49:38');
INSERT INTO `log_oper_info` VALUES (184, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:49:45');
INSERT INTO `log_oper_info` VALUES (185, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:50:14');
INSERT INTO `log_oper_info` VALUES (186, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:50:39');
INSERT INTO `log_oper_info` VALUES (187, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:51:07');
INSERT INTO `log_oper_info` VALUES (188, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:51:18');
INSERT INTO `log_oper_info` VALUES (189, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:52:53');
INSERT INTO `log_oper_info` VALUES (190, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:53:35');
INSERT INTO `log_oper_info` VALUES (191, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:53:41');
INSERT INTO `log_oper_info` VALUES (192, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:53:47');
INSERT INTO `log_oper_info` VALUES (193, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:57:26');
INSERT INTO `log_oper_info` VALUES (194, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 19:57:56');
INSERT INTO `log_oper_info` VALUES (195, '保存角色和菜单权限关系', '1', 'com.sky.controller.SysRoleController.saveRoleMenu()', 'POST', '1', 1, '/role/saveRoleMenu/3/21,15,16,17,18,19,20', '127.0.0.1', '内网IP', '3 [21,15,16,17,18,19,20]', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 19:58:32');
INSERT INTO `log_oper_info` VALUES (196, '添加菜单', '1', 'com.sky.controller.SysMenuController.addMenu()', 'POST', '1', 1, '/menu/addMenu', '127.0.0.1', '内网IP', '{\"percode\":\"stats\",\"pageSize\":10,\"menuName\":\"数据统计\",\"remark\":\"数据统计\",\"pageNum\":1,\"parentId\":21,\"path\":\"/stats\",\"simpleUser\":{\"userId\":1},\"menuType\":\"1\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 20:02:16');
INSERT INTO `log_oper_info` VALUES (197, '添加菜单', '1', 'com.sky.controller.SysMenuController.addMenu()', 'POST', '1', 1, '/menu/addMenu', '127.0.0.1', '内网IP', '{\"percode\":\"reward\",\"pageSize\":10,\"menuName\":\"奖惩规则\",\"remark\":\"奖惩规则\",\"pageNum\":1,\"parentId\":21,\"path\":\"/reward\",\"simpleUser\":{\"userId\":1},\"menuType\":\"1\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 20:04:34');
INSERT INTO `log_oper_info` VALUES (198, '添加菜单', '1', 'com.sky.controller.SysMenuController.addMenu()', 'POST', '1', 1, '/menu/addMenu', '127.0.0.1', '内网IP', '{\"percode\":\"profile\",\"pageSize\":10,\"menuName\":\"个人主页\",\"remark\":\"个人主页\",\"pageNum\":1,\"parentId\":21,\"path\":\"/profile\",\"simpleUser\":{\"userId\":1},\"menuType\":\"1\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 20:05:44');
INSERT INTO `log_oper_info` VALUES (199, '保存角色和菜单权限关系', '1', 'com.sky.controller.SysRoleController.saveRoleMenu()', 'POST', '1', 1, '/role/saveRoleMenu/3/21,15,16,17,18,19,20,23,24,25', '127.0.0.1', '内网IP', '3 [21,15,16,17,18,19,20,23,24,25]', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 20:07:36');
INSERT INTO `log_oper_info` VALUES (200, '保存角色和菜单权限关系', '1', 'com.sky.controller.SysRoleController.saveRoleMenu()', 'POST', '1', 1, '/role/saveRoleMenu/2/21,15,16,17,19,25', '127.0.0.1', '内网IP', '2 [21,15,16,17,19,25]', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 20:08:04');
INSERT INTO `log_oper_info` VALUES (201, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 20:08:24');
INSERT INTO `log_oper_info` VALUES (202, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/2', '127.0.0.1', '内网IP', '3 [2]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 20:08:46');
INSERT INTO `log_oper_info` VALUES (203, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 20:13:27');
INSERT INTO `log_oper_info` VALUES (204, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/1', '127.0.0.1', '内网IP', '3 [1]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 20:14:53');
INSERT INTO `log_oper_info` VALUES (205, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/11/3', '127.0.0.1', '内网IP', '11 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 20:17:30');
INSERT INTO `log_oper_info` VALUES (206, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/11/3', '127.0.0.1', '内网IP', '11 [3]', '{\"msg\":\"操作失败\",\"code\":400}', '0', '', '2023-02-20 20:21:10');
INSERT INTO `log_oper_info` VALUES (207, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/11/3', '127.0.0.1', '内网IP', '11 [3]', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 21:29:22');
INSERT INTO `log_oper_info` VALUES (208, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 21:29:32');
INSERT INTO `log_oper_info` VALUES (209, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 21:31:33');
INSERT INTO `log_oper_info` VALUES (210, '保存角色和用户之间的关系', '1', 'com.sky.controller.SysRoleController.saveRoleUser()', 'POST', '1', 1, '/role/saveRoleUser/3/3', '127.0.0.1', '内网IP', '3 [3]', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 21:32:15');
INSERT INTO `log_oper_info` VALUES (211, '登录', '4', '', '', '2', NULL, '', '127.0.0.1', '内网IP', '账号: 13645912977', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 21:34:31');
INSERT INTO `log_oper_info` VALUES (212, '添加个人事件', '1', 'com.sky.controller.EventController.add()', 'POST', '2', 3, '/event/add', '127.0.0.1', '内网IP', '{\"simpleUser\":{\"userId\":3},\"endDate\":1676390400000,\"classes\":\"event-warning\",\"pageSize\":10,\"title\":\"自我提升\",\"pageNum\":1,\"startDate\":1676217600000,\"tags\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-20 21:35:22');
INSERT INTO `log_oper_info` VALUES (213, '登录', '4', '', '', '1', NULL, '', '112.47.217.56', '内网IP', '账号: 13505960017', '{\"msg\":\"用户名或密码不正确\",\"code\":500}', '1', 'Read timed out executing POST http://authorization-server/oauth/token?grant_type=password&username=13505960017&password=123456&login_type=admin_type', '2023-02-20 23:35:37');
INSERT INTO `log_oper_info` VALUES (214, '登录', '4', '', '', '1', NULL, '', '220.162.6.246', '内网IP', '账号: 13505960017', '{\"msg\":\"操作成功\",\"code\":200}', '0', '', '2023-02-21 08:33:02');
INSERT INTO `log_oper_info` VALUES (215, '登录', '4', '', '', '2', NULL, '', '220.162.6.246', '内网IP', '账号: 13645912977', '{\"msg\":\"操作失败\",\"code\":400}', '1', 'com.netflix.client.ClientException: Load balancer does not have available server for client: authorization-server', '2023-02-21 08:44:17');
INSERT INTO `log_oper_info` VALUES (216, '登录', '4', '', '', '2', NULL, '', '220.162.6.246', '内网IP', '账号: 13645912977', '{\"msg\":\"操作失败\",\"code\":400}', '1', 'com.netflix.client.ClientException: Load balancer does not have available server for client: authorization-server', '2023-02-21 08:44:46');
INSERT INTO `log_oper_info` VALUES (217, '登录', '4', '', '', '2', NULL, '', '220.162.6.246', '内网IP', '账号: 13645912977', '{\"msg\":\"操作失败\",\"code\":400}', '1', 'com.netflix.client.ClientException: Load balancer does not have available server for client: authorization-server', '2023-02-21 08:45:46');
INSERT INTO `log_oper_info` VALUES (218, '登录', '4', '', '', '2', NULL, '', '220.162.6.246', '内网IP', '账号: 13645912977', '{\"msg\":\"操作失败\",\"code\":400}', '1', 'com.netflix.client.ClientException: Load balancer does not have available server for client: authorization-server', '2023-02-21 09:26:27');

-- ----------------------------
-- Table structure for log_sms_info
-- ----------------------------
DROP TABLE IF EXISTS `log_sms_info`;
CREATE TABLE `log_sms_info`  (
  `id` bigint(22) NOT NULL COMMENT '表id',
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '验证码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '0发送成功 1发送失败',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '0注册验证码 1修改密码',
  `error_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发送失败的错误信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '短息发送记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_sms_info
-- ----------------------------
INSERT INTO `log_sms_info` VALUES (1, '12345678911', '2021-11-30 10:46:19', '1234', '1', '1', 'test');
INSERT INTO `log_sms_info` VALUES (2, '32141257282', '2021-11-18 10:46:19', '6594', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473558431955812352, '{\r\n    \"phone\": \"13645912977\"\r\n}', '2021-12-22 15:38:02', '7436', '1', '1', 'error');
INSERT INTO `log_sms_info` VALUES (1473560746343399424, '13645912977', '2021-12-22 15:47:14', '0957', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473590887740211200, '13645912977', '2021-12-22 17:47:00', '6053', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473594648634195968, '13645912977', '2021-12-22 18:01:57', '6600', '1', '1', 'error');
INSERT INTO `log_sms_info` VALUES (1473595387574091776, '13645912977', '2021-12-22 18:04:53', '3589', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473595977171599360, '15205976807', '2021-12-22 18:07:14', '0171', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473618821423169536, '15205976807', '2021-12-22 19:38:00', '1952', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473626057612591104, '13645912977', '2021-12-22 20:06:45', '6895', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473628238734557184, '13645912977', '2021-12-22 20:15:25', '0655', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473629930809065472, '13645912977', '2021-12-22 20:22:09', '8596', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473630593236467712, '13645912977', '2021-12-22 20:24:47', '2699', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473631765821259776, '13645912977', '2021-12-22 20:29:26', '6295', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473633636153688064, '15205976807', '2021-12-22 20:36:52', '8732', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473634844444590080, '15205976807', '2021-12-22 20:41:40', '0464', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473635420049899520, '15205976807', '2021-12-22 20:43:58', '0411', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473637253443092480, '15205976807', '2021-12-22 20:51:15', '5491', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473640543773917184, '15205976807', '2021-12-22 21:04:19', '8364', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473641556249542656, '15205976807', '2021-12-22 21:08:21', '9708', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473652313817219072, '13645912977', '2021-12-22 21:51:05', '7921', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473655864505270272, '13645912977', '2021-12-22 22:05:12', '8965', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473657139829538816, '13645912977', '2021-12-22 22:10:16', '4453', '1', '1', 'error');
INSERT INTO `log_sms_info` VALUES (1473660190732713984, '13645912977', '2021-12-22 22:22:23', '7558', '1', '1', 'error');
INSERT INTO `log_sms_info` VALUES (1473660716136398848, '15205976807', '2021-12-22 22:24:29', '9410', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473661830374227968, '15205976807', '2021-12-22 22:28:54', '0488', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1473665529716801536, '15205976807', '2021-12-22 22:43:36', '6416', '1', '0', 'error');
INSERT INTO `log_sms_info` VALUES (1473666431261474816, '15205976807', '2021-12-22 22:47:11', '0919', '1', '0', 'error');
INSERT INTO `log_sms_info` VALUES (1473666950176571392, '19859217185', '2021-12-22 22:49:15', '6367', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473667828665155584, '19859217185', '2021-12-22 22:52:44', '8533', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1473668542867046400, '19859217185', '2021-12-22 22:55:35', '3168', '0', '0', NULL);
INSERT INTO `log_sms_info` VALUES (1474269292831834112, '13645912977', '2021-12-24 14:42:45', '2044', '0', '1', NULL);
INSERT INTO `log_sms_info` VALUES (1627662045526753280, '15205976807', '2023-02-20 21:30:47', '6239', '1', '0', 'error');
INSERT INTO `log_sms_info` VALUES (1627662045673553920, '15205976807', '2023-02-20 21:30:47', '1233', '0', '0', NULL);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '0', '性别男', 1, '2021-11-27 09:23:25', 1, '2021-11-27 09:23:25');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '0', '性别女', 1, '2021-11-27 09:23:25', 1, '2021-11-27 09:23:25');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '0', '性别未知', 1, '2021-11-27 09:23:25', 1, '2021-11-27 09:23:25');
INSERT INTO `sys_dict_data` VALUES (4, 1, '正常', '0', 'sys_normal_disable', '0', '正常状态', 1, '2021-11-27 09:23:25', 1, '2021-11-27 09:23:25');
INSERT INTO `sys_dict_data` VALUES (5, 2, '停用', '1', 'sys_normal_disable', '0', '停用状态', 1, '2021-11-27 09:23:25', 1, '2021-11-27 09:23:25');
INSERT INTO `sys_dict_data` VALUES (8, 0, '后台用户', '0', 'sys_user_type', '0', '后台用户', 1, '2021-11-28 17:23:16', NULL, '2021-11-28 09:23:14');
INSERT INTO `sys_dict_data` VALUES (9, 1, '前台用户', '1', 'sys_user_type', '0', '前台用户', 1, '2021-11-28 17:23:42', 1, '2021-11-28 17:23:47');
INSERT INTO `sys_dict_data` VALUES (10, 0, '通知', '1', 'sys_notice_type', '0', '通知', 1, '2021-11-30 16:03:41', NULL, '2021-11-30 08:03:40');
INSERT INTO `sys_dict_data` VALUES (11, 0, '公告', '2', 'sys_notice_type', '0', '公告', 1, '2021-11-30 16:04:03', NULL, '2021-11-30 08:04:02');
INSERT INTO `sys_dict_data` VALUES (12, 0, '其它', '0', 'sys_oper_type', '0', NULL, 1, '2021-11-30 16:29:43', NULL, '2021-11-30 08:29:42');
INSERT INTO `sys_dict_data` VALUES (13, 0, '新增', '1', 'sys_oper_type', '0', NULL, 1, '2021-11-30 16:30:10', NULL, '2021-11-30 08:30:09');
INSERT INTO `sys_dict_data` VALUES (14, 0, '修改', '2', 'sys_oper_type', '0', NULL, 1, '2021-11-30 16:30:18', NULL, '2021-11-30 08:30:17');
INSERT INTO `sys_dict_data` VALUES (15, 0, '删除', '3', 'sys_oper_type', '0', NULL, 1, '2021-11-30 16:30:24', NULL, '2021-11-30 08:30:23');
INSERT INTO `sys_dict_data` VALUES (16, 0, '登录', '4', 'sys_oper_type', '0', NULL, 1, '2021-11-30 16:30:31', NULL, '2021-11-30 08:30:30');
INSERT INTO `sys_dict_data` VALUES (17, 0, '发送成功', '0', 'sys_sms_status', '0', NULL, 1, '2021-11-30 16:38:07', NULL, '2021-11-30 08:38:06');
INSERT INTO `sys_dict_data` VALUES (18, 1, '发送失败', '1', 'sys_sms_status', '0', NULL, 1, '2021-11-30 16:38:16', NULL, '2021-11-30 08:38:14');
INSERT INTO `sys_dict_data` VALUES (19, 0, '一个月', '0', 'time_order_item', '0', '一个月的大会员', 1, '2021-12-01 11:56:01', NULL, '2021-12-01 03:56:00');
INSERT INTO `sys_dict_data` VALUES (20, 1, '三个月', '1', 'time_order_item', '0', '三个月的大会员', 1, '2021-12-01 11:56:26', 1, '2021-12-01 11:58:54');
INSERT INTO `sys_dict_data` VALUES (21, 2, '半年', '2', 'time_order_item', '0', '半年的大会员', 1, '2021-12-01 11:57:01', 1, '2021-12-01 11:59:00');
INSERT INTO `sys_dict_data` VALUES (22, 3, '一年', '3', 'time_order_item', '0', '一年的大会员', 1, '2021-12-01 11:58:25', 1, '2021-12-01 11:59:06');
INSERT INTO `sys_dict_data` VALUES (23, 4, '永久', '4', 'time_order_item', '0', '永久的大会员', 1, '2021-12-01 11:58:45', 1, '2021-12-01 11:59:09');
INSERT INTO `sys_dict_data` VALUES (24, 0, 'none', '0', 'time_task_type', '0', '无', 1, '2021-12-21 14:46:42', NULL, '2021-12-21 06:46:41');
INSERT INTO `sys_dict_data` VALUES (25, 0, 'work', '1', 'time_task_type', '0', '工作', 1, '2021-12-21 14:47:01', NULL, '2021-12-21 06:47:00');
INSERT INTO `sys_dict_data` VALUES (26, 0, 'business', '2', 'time_task_type', '0', '业务', 1, '2021-12-21 14:47:18', NULL, '2021-12-21 06:47:16');
INSERT INTO `sys_dict_data` VALUES (27, 0, 'personal', '3', 'time_task_type', '0', '个人', 1, '2021-12-21 14:47:40', NULL, '2021-12-21 06:47:39');
INSERT INTO `sys_dict_data` VALUES (28, 0, '否', '0', 'time_is_important', '0', '否', 1, '2021-12-21 14:48:45', NULL, '2021-12-21 06:48:43');
INSERT INTO `sys_dict_data` VALUES (29, 0, '是', '1', 'time_is_important', '0', '是', 1, '2021-12-21 14:48:53', NULL, '2021-12-21 06:48:52');
INSERT INTO `sys_dict_data` VALUES (30, 0, '待办', '0', 'time_task_status', '0', '待办', 1, '2021-12-21 14:49:31', NULL, '2021-12-21 06:49:30');
INSERT INTO `sys_dict_data` VALUES (31, 0, '进行中', '1', 'time_task_status', '0', '进行中', 1, '2021-12-21 14:49:43', NULL, '2021-12-21 06:49:42');
INSERT INTO `sys_dict_data` VALUES (32, 0, '完成', '2', 'time_task_status', '0', '完成', 1, '2021-12-21 14:49:53', NULL, '2021-12-21 06:49:51');
INSERT INTO `sys_dict_data` VALUES (33, 0, '过期', '3', 'time_task_status', '0', '过期', 1, '2021-12-21 14:50:08', NULL, '2021-12-21 06:50:06');
INSERT INTO `sys_dict_data` VALUES (34, 0, '正常', '0', 'sys_common_status', '0', NULL, 1, '2021-12-24 16:43:14', NULL, '2021-12-24 08:43:13');
INSERT INTO `sys_dict_data` VALUES (35, 0, '异常', '1', 'sys_common_status', '0', NULL, 1, '2021-12-24 16:43:22', NULL, '2021-12-24 08:43:21');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', '用户性别列表', 1, '2021-11-27 17:20:27', 1, '2021-11-27 17:20:27');
INSERT INTO `sys_dict_type` VALUES (2, '系统开关', 'sys_normal_disable', '0', '系统状态列表', 1, '2021-11-27 17:20:27', 1, '2021-11-27 17:20:27');
INSERT INTO `sys_dict_type` VALUES (7, '用户类型', 'sys_user_type', '0', '用户类型列表', 1, '2021-11-28 17:22:36', 1, '2021-11-28 17:22:47');
INSERT INTO `sys_dict_type` VALUES (8, '公告类型', 'sys_notice_type', '0', '公告类型', 1, '2021-11-30 16:02:49', NULL, '2021-11-30 08:02:48');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', '操作类型', 1, '2021-11-30 16:29:16', NULL, '2021-11-30 08:29:15');
INSERT INTO `sys_dict_type` VALUES (10, '短信发送状态', 'sys_sms_status', '0', '短信发送状态', 1, '2021-11-30 16:37:49', NULL, '2021-11-30 08:37:48');
INSERT INTO `sys_dict_type` VALUES (12, '任务类型', 'time_task_type', '0', '任务类型', 1, '2021-12-21 14:46:16', NULL, '2021-12-21 06:46:15');
INSERT INTO `sys_dict_type` VALUES (13, '是否重要', 'time_is_important', '0', '是否重要', 1, '2021-12-21 14:48:29', NULL, '2021-12-21 06:48:28');
INSERT INTO `sys_dict_type` VALUES (14, '任务状态', 'time_task_status', '0', '任务状态', 1, '2021-12-21 14:49:18', NULL, '2021-12-21 06:49:16');
INSERT INTO `sys_dict_type` VALUES (16, '系统状态', 'sys_common_status', '0', '系统状态', 1, '2021-12-24 16:42:17', NULL, '2021-12-24 08:42:17');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父节点ID',
  `parent_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '父节点ID集合',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名称',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '类型 1-目录 2-菜单 3-前台',
  `percode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限标识',
  `path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路由地址',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标识（0正常 1删除）',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, NULL, '系统管理', '1', 'system', '/system', '系统管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (2, 0, NULL, '日志管理', '1', 'log', '/log', '日志管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (3, 0, NULL, '订单中心', '1', 'order', '/order', '订单管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (4, 0, NULL, '前台管理', '1', 'portal', '/portal', '前台管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (5, 1, '1', '用户管理', '2', 'system_user', '/system/user', '用户管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (6, 1, '1', '角色管理', '2', 'system_role', '/system/role', '角色管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (7, 1, '1', '菜单管理', '2', 'system_menu', '/system/menu', '菜单管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (8, 1, '1', '字典管理', '2', 'system_dict', '/system/dict', '字典管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (9, 2, '2', '操作日志管理', '2', 'oper-log', '/log/oper-log', '操作日志管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (10, 2, '2', '短信日志管理', '2', 'sms-log', '/log/sms-log', '短信日志管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (11, 3, '3', '订单统计', '2', 'order_stat', '/order/stat', '订单统计', '0', 1, '2021-12-20 20:55:54', 1, '2023-02-20 19:19:45', '0');
INSERT INTO `sys_menu` VALUES (13, 4, '4', '白噪音管理', '2', 'portal_music', '/portal/music', '白噪音管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (14, 4, '4', '通知公告管理', '2', 'portal_notice', '/portal/notice', '通知公告管理', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (15, 21, NULL, '待办看板', '3', 'todo_kanban', '/todo-kanban', '待办看板', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (16, 21, NULL, '待办', '3', 'todo', '/todo', '待办', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (17, 21, NULL, '每日自省', '3', 'diary', '/diary', '每日自省', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (18, 21, NULL, '个人目标', '3', 'goal', '/goal', '个人目标', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (19, 21, NULL, '白噪音', '3', 'music', '/music', '白噪音', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (20, 21, NULL, '日历', '3', 'calendar', '/calendar', '日历', '0', 1, '2021-12-20 20:55:54', 1, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (21, 0, NULL, '前台目录', '3', 'portal', '/portal', '前台目录', '0', 1, '2021-12-20 20:55:54', NULL, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (22, 4, '4', '轮播图管理', '2', 'portal_slide', '/portal/slide', '轮播图管理', '0', 1, '2021-12-20 20:55:54', NULL, '2021-12-24 08:40:46', '0');
INSERT INTO `sys_menu` VALUES (23, 21, NULL, '数据统计', '3', 'statistic', '/stats', '数据统计', '0', 1, '2023-02-20 20:02:16', 1, '2023-02-20 21:34:06', '0');
INSERT INTO `sys_menu` VALUES (24, 21, NULL, '奖惩规则', '3', 'reward', '/reward', '奖惩规则', '0', 1, '2023-02-20 20:04:34', 1, '2023-02-20 20:04:40', '0');
INSERT INTO `sys_menu` VALUES (25, 21, NULL, '个人主页', '3', 'profile', '/profile', '个人主页', '0', 1, '2023-02-20 20:05:44', 1, '2023-02-20 20:05:55', '0');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'MessageSquareIcon' COMMENT '备注',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '系统初步搭建', '2', '毕设系统后端初步搭建', '0', 'MessageSquareIcon', 1, '2021-12-13 15:59:07', 1, '2021-12-20 08:55:33');
INSERT INTO `sys_notice` VALUES (2, '系统模块实现', '1', '毕设系统模块实现', '0', 'PackageIcon', 1, '2021-12-14 15:59:07', 1, '2021-12-20 08:56:55');
INSERT INTO `sys_notice` VALUES (3, '日志模块实现', '2', '毕设日志模块实现', '0', 'AlertOctagonIcon', 1, '2021-12-15 15:59:07', 1, '2021-12-20 08:56:55');
INSERT INTO `sys_notice` VALUES (4, '前台管理模块实现', '1', '毕设前台管理模块实现', '0', 'MailIcon', 1, '2021-12-16 15:59:07', 1, '2021-12-20 08:56:55');
INSERT INTO `sys_notice` VALUES (5, '前台实现', '2', '毕设前台实现', '0', 'CalendarIcon', 1, '2021-12-17 15:59:07', 1, '2021-12-20 08:56:55');
INSERT INTO `sys_notice` VALUES (6, '前台公告通知实现', '2', '毕设前台公告通知实现', '0', 'MessageSquareIcon', 1, '2021-12-20 15:59:07', 1, '2021-12-20 08:56:55');
INSERT INTO `sys_notice` VALUES (7, '前台个人信息页实现', '1', '毕设前台个人信息页实现', '0', 'PackageIcon', 1, '2021-12-20 15:59:07', 1, '2021-12-23 12:26:52');
INSERT INTO `sys_notice` VALUES (8, '前后台白噪音实现', '2', '毕设前后台白噪音实现', '0', 'MailIcon', 1, '2021-12-21 15:59:07', 1, '2021-12-23 12:29:28');
INSERT INTO `sys_notice` VALUES (9, '前后台日历看板实现', '1', '毕设前后台日历看板实现', '0', 'MailIcon', 1, '2021-12-21 15:59:07', 1, '2021-12-23 12:29:29');
INSERT INTO `sys_notice` VALUES (10, '前后台目标脑图实现', '2', '毕设前后台目标脑图实现', '0', 'MessageSquareIcon', 1, '2021-12-22 15:59:07', 1, '2021-12-23 12:29:29');
INSERT INTO `sys_notice` VALUES (11, '用户注册及重置密码实现', '2', '毕设用户注册及重置密码实现', '0', 'AlertOctagonIcon', 1, '2021-12-22 15:59:07', 1, '2021-12-23 12:29:55');
INSERT INTO `sys_notice` VALUES (12, '数据统计模块实现', '1', '毕设数据统计模块实现', '0', 'PackageIcon', 1, '2021-12-23 15:59:07', 1, '2021-12-23 12:31:11');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `role_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色权限编码',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '角色状态（0正常 1停用）',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'ROLE_ADMIN', 1, '超级管理员', '0', 1, '2021-12-16 10:04:28', 1, '2021-12-24 08:39:44', '0');
INSERT INTO `sys_role` VALUES (2, '普通用户', 'ROLE_USER', 3, '普通用户', '0', 1, '2021-12-16 10:04:28', 1, '2021-12-24 08:39:47', '0');
INSERT INTO `sys_role` VALUES (3, '会员', 'ROLE_SUPER_USER', 2, '高级用户', '0', 1, '2021-12-16 10:04:28', 1, '2021-12-25 12:46:00', '0');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1, 1, '2021-11-20 20:06:56', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (28, 3, 21, 1, '2023-02-20 20:07:35', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (29, 3, 15, 1, '2023-02-20 20:07:35', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (30, 3, 16, 1, '2023-02-20 20:07:35', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (31, 3, 17, 1, '2023-02-20 20:07:35', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (32, 3, 18, 1, '2023-02-20 20:07:35', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (33, 3, 19, 1, '2023-02-20 20:07:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (34, 3, 20, 1, '2023-02-20 20:07:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (35, 3, 23, 1, '2023-02-20 20:07:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (36, 3, 24, 1, '2023-02-20 20:07:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (37, 3, 25, 1, '2023-02-20 20:07:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (38, 2, 21, 1, '2023-02-20 20:08:04', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (39, 2, 15, 1, '2023-02-20 20:08:04', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (40, 2, 16, 1, '2023-02-20 20:08:04', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (41, 2, 17, 1, '2023-02-20 20:08:04', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (42, 2, 19, 1, '2023-02-20 20:08:04', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (43, 2, 25, 1, '2023-02-20 20:08:04', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户姓名',
  `user_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '1' COMMENT '用户类型（0后台用户 1前台用户）',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `open_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户授权登录openid 扩展第三方登陆使用',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0正常 1删除）',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '0', '13505960017', '799116474@qq.com', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/pic/Saved%20Pictures/20220416232840.jpg', '$2a$10$vyIU7EVrnkA6xGmiBZtBUOX5hw6kysOBtVDVwEGSv.TZj1MwHqsPa', '0', NULL, 1, '2022-12-16 10:03:33', 1, '2023-02-20 15:01:23', '0');
INSERT INTO `sys_user` VALUES (2, 'test', '1', '123', 'test@qq.com', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/pic/Saved%20Pictures/20220416232829.jpg', '$2a$10$PTzBWVnV15baGIwTyUgOLOCw3kMUNE6cy80eskgZzDXccVqVOHyfG', '0', NULL, 1, '2022-12-16 10:03:33', 1, '2023-02-20 10:28:09', '0');
INSERT INTO `sys_user` VALUES (3, 'sukeyu', '1', '13645912977', 'user@user.com', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/pic/Saved%20Pictures/20220416233004.jpg', '$2a$10$2AqXwFMOMO6B3lgwCPieku9QA87JywE1GgheOJYdftvD/.f/9z0JS', '0', NULL, 1, '2022-12-16 10:03:33', 1, '2023-02-20 10:28:09', '0');
INSERT INTO `sys_user` VALUES (11, 'sssk', '1', '19859217185', '7777777777@qq.com', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/pic/Saved%20Pictures/20220416233720.jpg', '$2a$10$8EA0C859722izP8Yxl75/eN57bOdBTm77zjAmHVV.UkyaX5xgUZKG', '0', NULL, 1, '2022-12-16 10:03:33', 1, '2023-02-20 10:28:09', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `expire_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1, 1, '2023-02-02 19:53:11', NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (2, 2, 2, 1, '2023-02-02 19:53:17', NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (4, 11, 3, 1, '2023-02-20 21:29:22', NULL, NULL, NULL);
INSERT INTO `sys_user_role` VALUES (6, 3, 3, 1, '2023-02-20 21:32:15', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for time_event
-- ----------------------------
DROP TABLE IF EXISTS `time_event`;
CREATE TABLE `time_event`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '事件主键',
  `title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '事件标题',
  `start_date` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_date` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `tags` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '标签（0无 1工作 2业务 3个人）',
  `classes` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '样式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '事件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_event
-- ----------------------------
INSERT INTO `time_event` VALUES (1, 'My Event', '2021-12-18 15:55:55', '2021-12-20 15:55:44', 3, '2', 'event-success');
INSERT INTO `time_event` VALUES (2, 'Event2', '2021-12-22 15:57:13', '2021-12-25 15:57:18', 3, '0', 'event-primary');
INSERT INTO `time_event` VALUES (3, 'Event3', '2021-12-16 15:58:13', '2021-12-16 15:58:17', 3, '1', 'event-warning');
INSERT INTO `time_event` VALUES (4, 'Event4', '2021-11-17 15:58:41', '2021-11-20 15:58:54', 3, '3', 'event-danger');
INSERT INTO `time_event` VALUES (5, 'asdfassss', '2021-12-26 05:39:00', '2021-12-27 05:39:00', 3, '3', 'event-danger');
INSERT INTO `time_event` VALUES (6, '自我提升', '2023-02-13 00:00:00', '2023-02-15 00:00:00', 3, '1', 'event-warning');

-- ----------------------------
-- Table structure for time_gold
-- ----------------------------
DROP TABLE IF EXISTS `time_gold`;
CREATE TABLE `time_gold`  (
  `gold_id` bigint(20) NOT NULL COMMENT '目标ID',
  `data_json` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '目标的json格式',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`gold_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '个人目标表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_gold
-- ----------------------------
INSERT INTO `time_gold` VALUES (1, '{\"name\":\"2022年计划\",\"left\":false,\"children\":[{\"name\":\"学习Java\",\"left\":false,\"children\":[{\"name\":\"Java基础\",\"left\":false},{\"name\":\"集合框架\",\"left\":false}]},{\"name\":\"学习Spring\",\"left\":false,\"children\":[{\"name\":\"IOC\",\"left\":false},{\"name\":\"AOP\",\"left\":false}]},{\"name\":\"学习SpringBoot\",\"left\":true},{\"name\":\"学习微服务\",\"left\":true,\"children\":[{\"name\":\"test\",\"left\":true}]}]}', 3, '2021-12-15 15:11:38');

-- ----------------------------
-- Table structure for time_journal
-- ----------------------------
DROP TABLE IF EXISTS `time_journal`;
CREATE TABLE `time_journal`  (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ' 记录ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `description` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '个人日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_journal
-- ----------------------------
INSERT INTO `time_journal` VALUES (1, '垃圾分类小程序', '小程序端使用SpringBoot+uniapp技术；后台管理系统使用vue-element-admin搭建页面，SpringBoot+Dubbo搭建后端服务。', 3, '2021-12-15 15:27:13', '2021-12-20 01:35:30');
INSERT INTO `time_journal` VALUES (2, '医疗管理系统', '本项目是以完整的基层医疗机构-信息化解决方案为出发点，打造连接诊所、医生、患者、一站式互联网医疗服务系统，深度挖掘基层医疗机构需求，解决其真正的痛点；全面提升医疗管理质量和可执行落地的综合性解决方案。', 3, '2021-12-16 11:51:58', '2021-12-20 01:35:48');
INSERT INTO `time_journal` VALUES (3, '小型药品进销存系统', '本系统研究设计的意义是为了使医院运作过程中的信息维护、采购、入库等操作的电子化，加快现代的医院从原来传统的人工管理模式向现代化的信息化的管理模式的转变。', 3, '2021-12-16 11:53:31', '2021-12-20 01:36:02');
INSERT INTO `time_journal` VALUES (4, '个人时间管理系统', '《把时间当作朋友》这本书，里面有个管理时间的观点个人觉得很有用，就是养成记录自己每天的时间消耗的一个习惯，这样有助于更有效地管理自己的时间。', 3, '2021-12-16 14:12:00', '2021-12-20 01:38:52');
INSERT INTO `time_journal` VALUES (5, 'asdafasdfa', 'fadfafsdfa', 3, '2021-12-16 14:12:34', '2021-12-16 17:00:51');
INSERT INTO `time_journal` VALUES (6, 'wqerq', 'qrwerq', 3, '2021-12-16 14:12:51', NULL);
INSERT INTO `time_journal` VALUES (7, 'rqerqer', 'qwerq', 3, '2021-12-16 14:14:59', NULL);
INSERT INTO `time_journal` VALUES (8, 'sssdfafdsaf', 'ssfsfafas', 3, '2021-12-16 16:49:10', '2021-12-16 17:00:39');
INSERT INTO `time_journal` VALUES (9, 'rewr', 'rewrq', 3, '2021-12-16 17:52:01', '2021-12-16 09:57:51');

-- ----------------------------
-- Table structure for time_music
-- ----------------------------
DROP TABLE IF EXISTS `time_music`;
CREATE TABLE `time_music`  (
  `music_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '白噪音Id',
  `music_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `music_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '音频url',
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '背景url',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '修改者',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '状态（0正常 1禁用）',
  PRIMARY KEY (`music_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '白噪音' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_music
-- ----------------------------
INSERT INTO `time_music` VALUES (1, '大海', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/noice/bigsurf.mp3', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/img/bigsurf.jpg', 1, '2021-12-21 11:41:26', 1, '2021-12-21 04:58:59', '0');
INSERT INTO `time_music` VALUES (2, '山野', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/noice/birds.mp3', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/img/birds.jpg', 1, '2021-12-21 11:41:26', 1, '2021-12-21 04:59:00', '0');
INSERT INTO `time_music` VALUES (3, '咖啡', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/noice/coffee.mp3', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/img/coffee.jpg', 1, '2021-12-21 11:41:26', 1, '2021-12-21 04:59:00', '0');
INSERT INTO `time_music` VALUES (4, '暴雨', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/noice/rainbest.mp3', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/img/rainbest.jpg', 1, '2021-12-21 11:41:26', 1, '2021-12-21 04:59:00', '0');
INSERT INTO `time_music` VALUES (5, '雪', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/noice/snow.mp3', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/img/snow.png', 1, '2021-12-21 11:41:26', 1, '2021-12-21 04:59:00', '0');
INSERT INTO `time_music` VALUES (6, '雷雨', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/noice/thunder.mp3', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/img/thunder.jpg', 1, '2021-12-21 11:41:26', 1, '2021-12-21 04:59:00', '0');

-- ----------------------------
-- Table structure for time_order
-- ----------------------------
DROP TABLE IF EXISTS `time_order`;
CREATE TABLE `time_order`  (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_amount` decimal(20, 0) NULL DEFAULT NULL,
  `order_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `order_item` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `pay_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1627673575626506241 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_order
-- ----------------------------
INSERT INTO `time_order` VALUES (1627673575626506240, 30, '0', '0', 3, '2023-02-20 22:16:36', NULL);

-- ----------------------------
-- Table structure for time_reward_info
-- ----------------------------
DROP TABLE IF EXISTS `time_reward_info`;
CREATE TABLE `time_reward_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1627671211318312961 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_reward_info
-- ----------------------------
INSERT INTO `time_reward_info` VALUES (1627663296649887744, 'yyyy', '0', 3, '2023-02-20 21:35:45');
INSERT INTO `time_reward_info` VALUES (1627671211318312960, '4564', '0', 3, '2023-02-20 22:07:12');

-- ----------------------------
-- Table structure for time_rules
-- ----------------------------
DROP TABLE IF EXISTS `time_rules`;
CREATE TABLE `time_rules`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `need_count` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `reward_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `punishment_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dead_line` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_rules
-- ----------------------------
INSERT INTO `time_rules` VALUES (1, 3, '2', 'yyyy', 'rrrr', '2023-02-25 12:00:00', '2023-02-20 21:35:44', '1');
INSERT INTO `time_rules` VALUES (2, 3, '2', '4564', '1231', '2023-02-22 12:00:00', '2023-02-20 22:07:11', '1');

-- ----------------------------
-- Table structure for time_slide
-- ----------------------------
DROP TABLE IF EXISTS `time_slide`;
CREATE TABLE `time_slide`  (
  `slide_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `slide_sort` int(4) NULL DEFAULT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态（0启用 1禁用）',
  `pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`slide_id`) USING BTREE,
  UNIQUE INDEX `slide_show_slide_uindex`(`slide_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '轮播图表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_slide
-- ----------------------------
INSERT INTO `time_slide` VALUES (2, 2, '1', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/graphic-1.png', 1, '2021-12-21 09:13:52', 1, '2021-12-24 16:45:11');
INSERT INTO `time_slide` VALUES (11, 10, '0', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/not-authorized.png', 1, '2021-12-21 09:13:52', 1, '2021-12-20 23:17:24');
INSERT INTO `time_slide` VALUES (13, 12, '0', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/register.jpg', 1, '2021-12-21 09:13:52', 1, '2021-12-24 16:44:17');
INSERT INTO `time_slide` VALUES (14, 13, '0', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/reset-password.png', 1, '2021-12-21 09:13:52', NULL, NULL);
INSERT INTO `time_slide` VALUES (15, 0, '0', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/2021/12/21/forgot-password.png', 1, '2021-12-21 09:13:52', 1, '2021-12-24 16:45:21');
INSERT INTO `time_slide` VALUES (16, 14, '1', 'https://personal-time.oss-cn-shenzhen.aliyuncs.com/graphic-2.png', 1, '2021-12-21 09:13:52', 1, '2021-12-21 09:39:59');

-- ----------------------------
-- Table structure for time_task
-- ----------------------------
DROP TABLE IF EXISTS `time_task`;
CREATE TABLE `time_task`  (
  `task_id` bigint(20) NOT NULL COMMENT '任务ID',
  `title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '状态（0待办 1进行中 2完成 3已过期）',
  `important` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '优先级（0否 1是）',
  `tags` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标签（0无 1工作 2业务 3个人）',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `done_time` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '完成时间（yyyy-MM-dd）',
  PRIMARY KEY (`task_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time_task
-- ----------------------------
INSERT INTO `time_task` VALUES (1, 'Fix Responsiveness 💻', 'Jelly topping toffee bear claw. Sesame snaps lollipop macaroon croissant cheesecake pastry cupcake.', '2', '1', '0', 3, '2023-02-15 15:30:00', '2023-12-16');
INSERT INTO `time_task` VALUES (2, 'Pick up Natasha 😁', 'Sweet roll toffee dragée cotton candy jelly beans halvah gingerbread jelly-o. Ice cream bear claw sugar plum powder.', '3', '1', '1', 3, '2023-02-16 15:30:08', NULL);
INSERT INTO `time_task` VALUES (3, 'Send PPT 🎁', 'Dragée gummi bears tiramisu brownie cookie. Jelly beans pudding marzipan fruitcake muffin. Wafer gummi bears lollipop pudding lollipop biscuit.', '3', '0', '0', 3, '2023-02-17 16:30:00', '');
INSERT INTO `time_task` VALUES (4, 'Submit Report', 'Donut tart toffee cake cookie gingerbread. Sesame snaps brownie sugar plum candy canes muffin cotton candy.', '3', '1', '3', 3, '2023-02-18 15:30:08', NULL);
INSERT INTO `time_task` VALUES (6, 'Refactor Code', 'Pie liquorice wafer cotton candy danish. Icing topping jelly-o halvah pastry lollipop.', '2', '0', '0', 3, '2023-02-13 15:30:08', '2023-2-20');
INSERT INTO `time_task` VALUES (7, 'Meet Jane ❤️', 'test99', '2', '1', '2', 3, '2023-02-19 15:30:00', '2023-2-19');
INSERT INTO `time_task` VALUES (9, 'fotrat', 'fotrat', '2', '0', '0', 3, '2023-02-19 15:30:08', '2023-2-20');
INSERT INTO `time_task` VALUES (10, 'testjob', 'testjob', '0', '0', '0', 3, '2023-02-25 15:30:08', NULL);
INSERT INTO `time_task` VALUES (1472856988923854848, 'aaatest', 'aaatest', '2', '0', '0', 3, '2023-01-19 15:30:08', '2023-1-21');
INSERT INTO `time_task` VALUES (1472857512565932032, '341', '1341', '2', '0', '2', 3, '2023-02-19 12:30:08', '2023-02-19');
INSERT INTO `time_task` VALUES (1472860352843743232, 'fafdafd', 'adfafd', '3', '0', '0', 3, '2023-01-19 15:30:08', NULL);
INSERT INTO `time_task` VALUES (1475046052129275904, 'tttt', 'ffff', '1', '1', '2', 3, '2023-02-28 12:00:00', NULL);

SET FOREIGN_KEY_CHECKS = 1;
