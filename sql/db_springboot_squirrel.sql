/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : db_springboot_squirrel

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-10-13 10:10:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_shop_catelog
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_catelog`;
CREATE TABLE `t_shop_catelog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分类名',
  `number` int(11) DEFAULT '0' COMMENT '该分类下的商品数量',
  `status` tinyint(10) DEFAULT '0' COMMENT '分类状态，0正常，1暂用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shop_catelog
-- ----------------------------
INSERT INTO `t_shop_catelog` VALUES ('0', '全部', '0', '1');
INSERT INTO `t_shop_catelog` VALUES ('1', '闲置数码', '14', '1');
INSERT INTO `t_shop_catelog` VALUES ('2', '校园代步', '6', '1');
INSERT INTO `t_shop_catelog` VALUES ('3', '电器日用', '6', '1');
INSERT INTO `t_shop_catelog` VALUES ('4', '图书教材', '8', '1');
INSERT INTO `t_shop_catelog` VALUES ('5', '美妆衣物', '6', '1');
INSERT INTO `t_shop_catelog` VALUES ('6', '运动棋牌', '2', '1');
INSERT INTO `t_shop_catelog` VALUES ('7', '票券小物', '2', '1');

-- ----------------------------
-- Table structure for t_shop_comments
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_comments`;
CREATE TABLE `t_shop_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户，外键',
  `atuser_id` int(11) DEFAULT NULL COMMENT '回复用户',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品，外键',
  `content` text COMMENT '评论内容',
  `create_at` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_shop_comments
-- ----------------------------
INSERT INTO `t_shop_comments` VALUES ('1', '1', '0', '1', '不错', '2018-02-26 22:02:44');
INSERT INTO `t_shop_comments` VALUES ('2', '4', '1', '1', '是啊', '2018-02-26 22:02:44');
INSERT INTO `t_shop_comments` VALUES ('3', '1', '4', '1', '哈哈', '2018-02-27 09:23:13');
INSERT INTO `t_shop_comments` VALUES ('5', '1', '4', '1', 'haha', '2018-03-05 10:13:37');

-- ----------------------------
-- Table structure for t_shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_goods`;
CREATE TABLE `t_shop_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品主键',
  `catelog_id` int(11) DEFAULT NULL COMMENT '商品分类，外键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户外键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `price` float(11,2) DEFAULT NULL COMMENT '出售价格',
  `real_price` float(11,2) DEFAULT NULL COMMENT '真实价格',
  `start_time` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布时间',
  `polish_time` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '擦亮时间，按该时间进行查询，精确到时分秒',
  `end_time` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '下架时间',
  `describle` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '详细信息',
  `commet_num` int(11) DEFAULT NULL COMMENT '评论回复数量',
  `state` int(8) DEFAULT '0' COMMENT '0表示进行中,1表示已下架,2表示审核中',
  PRIMARY KEY (`id`),
  KEY `catelog_id` (`catelog_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shop_goods
-- ----------------------------
INSERT INTO `t_shop_goods` VALUES ('1', '1', '1', '精美吉他', '130.00', '160.00', '2017-05-13', '2018-01-06', '2017-05-23', '自用二手吉他，9成新，低价出售，有意者联系!!!。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('2', '2', '1', '山地车', '520.00', '890.00', '2017-05-13', '2017-05-13', '2017-05-23', '8成新山地车，无损坏，喜欢Call我。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('3', '3', '1', '无线鼠标', '23.00', '48.00', '2017-05-13', '2017-05-13', '2017-05-23', '罗技无线鼠标，自用一个月，9成新，手感好，反应灵敏。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('6', '1', '2', '笔记本电脑', '690.00', '2300.00', '2017-05-14', '2017-05-14', '2017-05-24', '7成新14寸笔记本电脑，商务本，适合办公，2G内存。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('7', '3', '2', '收纳盒', '15.00', '36.00', '2017-05-14', '2017-05-14', '2017-05-24', '3层塑料物品收纳盒，毕业了，低价出售。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('8', '3', '1', '台灯', '32.00', '58.00', '2017-05-14', '2017-05-14', '2017-05-24', '考研时购买的台灯，可插USB接口。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('9', '5', '2', '女鞋', '35.00', '86.00', '2017-05-14', '2017-05-14', '2017-05-24', '学生女鞋', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('11', '1', '3', '无线传呼机', '230.00', '370.00', '2017-05-14', '2017-05-14', '2017-05-24', '一对无线传呼机，带有充电器，可以传呼2公里。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('12', '5', '3', '手提女包', '36.00', '89.00', '2017-05-14', '2017-05-14', '2017-05-24', '手提女包，自用一个月。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('13', '5', '1', '手提包', '15.00', '23.00', '2017-05-14', '2017-05-14', '2017-05-24', '自用手提包，8成新，便宜出。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('16', '6', '2', '耐克运动书包', '56.00', '198.00', '2017-05-14', '2017-05-14', '2017-05-24', '去年年底购买的耐克书包，8成新，无损坏，可以装电脑，很漂亮，有意者联系。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('18', '4', '2', '公务员考试资料', '35.00', '79.00', '2017-05-14', '2017-05-14', '2017-05-24', '刚刚考完公务员的复习资料。淘宝购买，低价出售。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('20', '1', '4', 'Thinkpad笔记本', '1600.00', '2300.00', '2017-05-14', '2017-05-14', '2017-05-24', '京东购买的Thinkpad笔记本电脑，九成新。限鲁大学生。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('21', '7', '4', '水晶挂件', '20.00', '60.00', '2017-05-14', '2017-05-14', '2017-05-24', '水晶挂件。一套，全部出。很精美很漂亮。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('22', '4', '3', '《Python编程实践》', '32.00', '69.00', '2017-05-14', '2017-05-14', '2017-05-24', '亚马逊购买', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('23', '4', '3', '《未来简史》', '40.00', '69.00', '2017-05-14', '2017-05-14', '2017-05-24', '9.5成新书籍，《未来简史》，已读完，推荐。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('24', '7', '3', '玉挂', '260.00', '450.00', '2017-05-14', '2017-05-14', '2017-05-24', '纯玉，购买于食品店，有发票。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('26', '2', '3', '概念代步车', '1300.00', '3500.00', '2017-05-14', '2017-05-14', '2017-05-24', '9成新概念代步车，上市3个月。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('27', '2', '3', '爱玛电动车', '800.00', '1500.00', '2017-05-14', '2017-05-14', '2017-05-24', '爱玛电动车，爱就马上行动吧。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('28', '3', '3', '公牛插排', '15.00', '36.00', '2017-05-14', '2017-05-14', '2017-05-24', '京东购买的插排，9成新。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('29', '5', '1', '李宁音速', '90.00', '100.00', '2017-05-14', '2017-05-14', '2017-05-24', '李宁旗舰店购买的李宁音速，9成新，41号，有意者联系。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('32', '4', '1', '《形势与政策》', '35.00', '65.00', '2017-05-15', '2017-05-15', '2017-05-25', '一个月前购买的书籍，现在已看完，还不错，收获很多。现转卖。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('34', '4', '2', '《世界汉学》', '18.00', '36.00', '2017-05-15', '2017-05-15', '2017-05-25', '一本记载了汉代发展的书籍。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('35', '1', '2', '欧达数码相机', '890.00', '1300.00', '2017-05-15', '2017-05-15', '2017-05-25', '9成新欧达数码相机，刚入手一个索尼，打算出掉，可议价。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('36', '3', '2', '手机充电器', '15.00', '38.00', '2017-05-15', '2017-05-15', '2017-05-25', '华为手机充电器，手机已毁，现转让充电器。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('37', '1', '2', '摄像头', '360.00', '480.00', '2017-05-15', '2017-05-15', '2017-05-25', '可旋转摄像头', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('38', '3', '2', '漫步者耳机', '380.00', '690.00', '2017-05-15', '2017-05-15', '2017-05-25', '漫步者耳机，音质好，9.5成新。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('39', '1', '2', '小米笔记本', '3200.00', '5800.00', '2017-05-15', '2017-05-15', '2017-05-25', '去年年底京东购买的笔记本，未过保，无损坏。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('40', '2', '2', '死飞自行车', '350.00', '680.00', '2017-05-15', '2017-05-15', '2017-05-25', '黄色死飞自行车，骑行一年。9成新。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('41', '2', '2', '自行车', '360.00', '480.00', '2017-05-15', '2017-05-15', '2017-05-25', '银色自行车。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('44', '5', '2', 't恤套装', '40.00', '90.00', '2017-05-15', '2017-05-15', '2017-05-25', '上身+下身，全套出。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('45', '5', '2', 't恤', '13.00', '36.00', '2017-05-15', '2017-05-15', '2017-05-25', '淘宝购买，低价出。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('46', '4', '1', 'Spring3.x--企业开发实战', '95.00', '112.00', '2017-05-15', '2017-05-15', '2017-05-25', '作为Spring3.x的升级版，书内容还是相当不错，讲解非常细致，分析非常到位，真正做到理论结合实际，对目前大环境下质量普遍不好的情况下，该书还真是值得购买和通读的。', '0', '0');
INSERT INTO `t_shop_goods` VALUES ('47', '4', '1', 'spring实战', '60.00', '80.00', '2017-05-16', '2017-05-16', '2017-05-26', '非常畅销的Spring图书', '0', '0');

-- ----------------------------
-- Table structure for t_shop_image
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_image`;
CREATE TABLE `t_shop_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片主键',
  `goods_id` int(11) NOT NULL COMMENT '商品外键',
  `img_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片链接',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shop_image
-- ----------------------------
INSERT INTO `t_shop_image` VALUES ('1', '1', 'ae2bdee2-0abb-428d-961f-eadf9905bf4c.jpg');
INSERT INTO `t_shop_image` VALUES ('2', '2', 'f4ccf238-e458-4dda-9ed8-88bca2d42309.jpg');
INSERT INTO `t_shop_image` VALUES ('3', '3', 'f34e49f8-bbef-4e1d-8138-e57aa97e408a.jpg');
INSERT INTO `t_shop_image` VALUES ('4', '4', 'f91335d4-784b-443a-bb68-34645ec164f8.jpg');
INSERT INTO `t_shop_image` VALUES ('5', '5', '24e34c65-1ff9-4eba-b97a-7cd8d8b4ecb1.jpg');
INSERT INTO `t_shop_image` VALUES ('6', '6', 'bec28d84-7d5e-4d50-8bb2-91409de00859.jpg');
INSERT INTO `t_shop_image` VALUES ('7', '7', '4859432c-5955-411b-bdaa-d65275a9a61a.jpg');
INSERT INTO `t_shop_image` VALUES ('8', '8', '3c95fa0d-d5e3-40f7-826f-cafe6e6af740.jpg');
INSERT INTO `t_shop_image` VALUES ('9', '9', 'd8ca0740-bdf3-416b-8557-8384e7299924.jpg');
INSERT INTO `t_shop_image` VALUES ('11', '11', '68bac661-f69f-4ec5-8f21-f92ec1970547.jpg');
INSERT INTO `t_shop_image` VALUES ('12', '12', '83e6a0be-cf28-4d74-8db6-ed1e3bafdec0.jpg');
INSERT INTO `t_shop_image` VALUES ('13', '13', 'e26183d0-244c-4da4-86dd-387d0ef8dfeb.jpg');
INSERT INTO `t_shop_image` VALUES ('16', '16', 'f845fd90-db8a-4701-aa22-0968b2694fb0.jpg');
INSERT INTO `t_shop_image` VALUES ('17', '17', 'c378a8bb-0561-42bb-b77e-c89ed375efca.jpg');
INSERT INTO `t_shop_image` VALUES ('18', '18', '8222a2f2-6287-4530-a399-da7696b73fdf.jpg');
INSERT INTO `t_shop_image` VALUES ('20', '20', '5aceed48-21f6-4aa8-9cfa-6bb831694c3a.jpg');
INSERT INTO `t_shop_image` VALUES ('21', '21', 'd01acfd0-3b87-4983-b46d-d2864e722437.jpg');
INSERT INTO `t_shop_image` VALUES ('22', '22', 'dee36400-df6a-46ac-96df-d71a7c42f328.jpg');
INSERT INTO `t_shop_image` VALUES ('23', '23', '0a281a3b-f4e1-445b-b7a0-3f7a829849bc.jpg');
INSERT INTO `t_shop_image` VALUES ('24', '24', 'f2857094-1642-4d22-88b8-d06c290944fe.jpg');
INSERT INTO `t_shop_image` VALUES ('26', '26', '27c63995-9ff9-453d-b24f-d9aa95dcc138.jpg');
INSERT INTO `t_shop_image` VALUES ('27', '27', 'e80e60a1-859c-4277-9a6a-c6bfe95dcf7a.jpg');
INSERT INTO `t_shop_image` VALUES ('28', '28', '786c6d89-b27a-4a41-8f96-352aed2a9e6c.jpg');
INSERT INTO `t_shop_image` VALUES ('29', '29', '4ff2f2e2-5b3e-4ce6-9161-fb09cffea277.jpg');
INSERT INTO `t_shop_image` VALUES ('32', '32', '75599f16-ef35-4013-8c71-9f8c1682ad64.jpg');
INSERT INTO `t_shop_image` VALUES ('34', '34', '370298f4-e81c-46b6-9dbd-83118922bb22.jpg');
INSERT INTO `t_shop_image` VALUES ('35', '35', 'a90f891e-9b74-4f92-a800-03ef83c0a69c.jpg');
INSERT INTO `t_shop_image` VALUES ('36', '36', '6c8a2d88-ab90-488e-a468-d379c730bd46.jpg');
INSERT INTO `t_shop_image` VALUES ('37', '37', '85d132d0-bb61-4519-a08e-ec29937e4426.jpg');
INSERT INTO `t_shop_image` VALUES ('38', '38', '2f3fc053-090d-49de-a184-39e78cb4fc7e.jpg');
INSERT INTO `t_shop_image` VALUES ('39', '39', '9d0782df-277f-45e6-b3b4-c424d688e312.jpg');
INSERT INTO `t_shop_image` VALUES ('40', '40', '4b85e359-6fc8-4c12-93b9-edec64320f67.jpg');
INSERT INTO `t_shop_image` VALUES ('41', '41', '26c2c89b-9312-4759-88a0-7f73f86c549d.jpg');
INSERT INTO `t_shop_image` VALUES ('44', '44', '01974fb4-da95-4191-8c80-e89db4a4e7a3.jpg');
INSERT INTO `t_shop_image` VALUES ('45', '45', '75131adc-b3a8-495b-94a5-c7b144c41a0e.jpg');
INSERT INTO `t_shop_image` VALUES ('46', '46', 'f80708c6-e242-465d-9f0e-18f79f0d0b00.jpg');
INSERT INTO `t_shop_image` VALUES ('47', '47', '816c281c-3c37-4e93-beb9-074276838bb5.jpg');
INSERT INTO `t_shop_image` VALUES ('53', '53', '612b5f9a-1017-49e3-ab39-878199a8b63c.jpg');

-- ----------------------------
-- Table structure for t_shop_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_notice`;
CREATE TABLE `t_shop_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统信息主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户，外键',
  `context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '信息内容',
  `create_at` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推送信息时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态，0未读，1已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shop_notice
-- ----------------------------

-- ----------------------------
-- Table structure for t_shop_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_reply`;
CREATE TABLE `t_shop_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论回复主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户，外键',
  `atuser_id` int(11) DEFAULT NULL,
  `commet_id` int(11) DEFAULT NULL COMMENT '评论，外键',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `create_at` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shop_reply
-- ----------------------------

-- ----------------------------
-- Table structure for t_shop_user
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_user`;
CREATE TABLE `t_shop_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录使用的手机号',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `QQ` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '即时通讯',
  `create_at` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `goods_num` int(11) DEFAULT '0' COMMENT '发布过的物品数量',
  `power` tinyint(10) DEFAULT '10' COMMENT '权限值，普通用户默认为10',
  `last_login` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最近一次登陆时间',
  `status` tinyint(4) DEFAULT '0' COMMENT '账号是否冻结，默认0未冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_shop_user
-- ----------------------------
INSERT INTO `t_shop_user` VALUES ('1', '17862821585', 'ggee', 'E10ADC3949BA59ABBE56E057F20F883E', '8621867221', '2017-05-10 00:00:00', '17', '90', null, '0');
INSERT INTO `t_shop_user` VALUES ('2', '17862826440', 'llwwlql', 'E10ADC3949BA59ABBE56E057F20F883E', '462821493', '2017-05-14 00:00:00', '17', '10', null, '0');
INSERT INTO `t_shop_user` VALUES ('3', '17862821997', 'lduldj', 'E10ADC3949BA59ABBE56E057F20F883E', '421330323', '2017-05-14 00:00:00', '8', '10', null, '0');
INSERT INTO `t_shop_user` VALUES ('4', '15552201622', '策马奔腾hly', 'E10ADC3949BA59ABBE56E057F20F883E', '782697347', '2017-05-15 12:29:00', '2', '10', null, '0');
INSERT INTO `t_shop_user` VALUES ('5', '17862821996', 'adimin', 'E10ADC3949BA59ABBE56E057F20F883E', '1256972301', '2017-05-01 00:00:00', '0', '90', null, '0');
INSERT INTO `t_shop_user` VALUES ('8', '15622110487', '测试人员1号', 'E10ADC3949BA59ABBE56E057F20F883E', '1394176783', '2018-02-25 09:48:45', '0', '10', null, '0');
INSERT INTO `t_shop_user` VALUES ('9', '1', '测试人员2号', 'E10ADC3949BA59ABBE56E057F20F883E', '1394176783', '2018-02-25 13:07:32', '0', '90', null, '0');
