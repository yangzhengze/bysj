-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: bysj_database
-- ------------------------------------------------------
-- Server version	5.6.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (3);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_config` (
  `config_id` bigint(20) NOT NULL COMMENT '系统配置ID',
  `config_key` varchar(100) DEFAULT NULL COMMENT '系统配置关键字',
  `config_value` varchar(2000) DEFAULT NULL COMMENT '配置的值',
  `config_remark` varchar(500) DEFAULT NULL COMMENT '配置值的备注',
  PRIMARY KEY (`config_id`),
  UNIQUE KEY `AK_Key_2` (`config_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  `dparent_id` bigint(20) DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `dept_name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `order_num` bigint(20) DEFAULT NULL COMMENT '排序',
  `dept_create_time` datetime DEFAULT NULL COMMENT '部门创建时间',
  `del_flag` smallint(6) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (0,0,'测试',0,NULL,0);
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict` (
  `dict_id` bigint(20) NOT NULL COMMENT '数据字典ID',
  `dict_name` varchar(200) DEFAULT NULL COMMENT '数据字典名称',
  `dict_type` varchar(100) DEFAULT NULL COMMENT '数据字典类型',
  `dict_code` varchar(200) DEFAULT NULL COMMENT '数据字典码',
  `dict_value` varchar(1000) DEFAULT NULL COMMENT '数据字典值',
  `dict_filed_name` varchar(200) DEFAULT NULL COMMENT '字典字段名称',
  `dict_table_name` varchar(200) DEFAULT NULL COMMENT '字典表名',
  `dict_order` bigint(20) DEFAULT '0' COMMENT '数据字典排序',
  `dict_remark` varchar(500) DEFAULT NULL COMMENT '数据字典备注',
  `dict_del_flag` smallint(6) DEFAULT '0' COMMENT '删除标记  -1：已删除  0：正常',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `AK_Key_2` (`dict_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统数据字典管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `syslog_id` bigint(20) NOT NULL COMMENT '系统日志ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '系统用户ID',
  `operation` varchar(200) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(400) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(4000) DEFAULT NULL COMMENT '请求参数',
  `runtime` decimal(11,0) DEFAULT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(200) DEFAULT NULL COMMENT 'IP地址',
  `syslog_create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `syslog_location` varchar(100) DEFAULT NULL COMMENT '系统操作地点',
  PRIMARY KEY (`syslog_id`),
  KEY `FK_sys_user_log` (`user_id`),
  CONSTRAINT `FK_sys_user_log` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志管理\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `mparent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(500) DEFAULT NULL COMMENT '菜单URL',
  `menu_perms` varchar(1000) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `menu_type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `menu_icon` varchar(200) DEFAULT NULL COMMENT '菜单图标',
  `menu_order` int(11) DEFAULT NULL COMMENT '排序',
  `menu_create_time` datetime DEFAULT NULL COMMENT '菜单创建时间',
  `menu_modify_time` datetime DEFAULT NULL COMMENT '菜单修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL COMMENT '系统角色ID',
  `role_name` varchar(200) DEFAULT NULL COMMENT '角色名称',
  `role_remark` varchar(500) DEFAULT NULL COMMENT '角色说明',
  `role_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `role_modify_time` datetime DEFAULT NULL COMMENT '角色修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_dept`
--

DROP TABLE IF EXISTS `sys_role_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '系统角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  `sys_roledept_id` bigint(20) NOT NULL COMMENT '角色部门ID',
  PRIMARY KEY (`sys_roledept_id`),
  KEY `FK_sys_role_dept2` (`dept_id`),
  KEY `FK_sys_role_dept` (`role_id`),
  CONSTRAINT `FK_sys_role_dept` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FK_sys_role_dept2` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_dept`
--

LOCK TABLES `sys_role_dept` WRITE;
/*!40000 ALTER TABLE `sys_role_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `role_id` bigint(20) NOT NULL COMMENT '系统角色ID',
  `sys_rolemenu_id` bigint(20) NOT NULL COMMENT '角色菜单表ID',
  PRIMARY KEY (`sys_rolemenu_id`),
  KEY `FK_sys_role_menu2` (`role_id`),
  KEY `FK_sys_role_menu` (`menu_id`),
  CONSTRAINT `FK_sys_role_menu` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`menu_id`),
  CONSTRAINT `FK_sys_role_menu2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL COMMENT '系统用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐',
  `user_realname` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `user_sex` char(1) DEFAULT NULL COMMENT '用户性别：性别 0     男 1女',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` smallint(6) DEFAULT NULL COMMENT '状态：0：禁用   1：正常,',
  `user_create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `user_modify_time` datetime DEFAULT NULL COMMENT '用户修改时间',
  `user_lastlogin_time` datetime DEFAULT NULL COMMENT '用户最近登录时间',
  `user_theme` varchar(255) DEFAULT NULL COMMENT '用户主题',
  `user_photo_url` varchar(255) DEFAULT NULL COMMENT '用户头像url',
  `user_description` longtext COMMENT '用户自我简介',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `AK_Key_2` (`username`),
  KEY `FK_sysuser_sysdept` (`dept_id`),
  CONSTRAINT `FK_sysuser_sysdept` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (0,0,'tester','6ec0a6bfa5e58f32df2d8278f11786e4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-05-02 19:06:06','green','default.jpg',NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '系统用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '系统角色ID',
  `sys_userrole_id` bigint(20) NOT NULL COMMENT '用户角色表ID',
  PRIMARY KEY (`sys_userrole_id`),
  KEY `FK_sys_user_role2` (`role_id`),
  KEY `FK_sys_user_role` (`user_id`),
  CONSTRAINT `FK_sys_user_role` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FK_sys_user_role2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色对应的关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-02 20:06:19
