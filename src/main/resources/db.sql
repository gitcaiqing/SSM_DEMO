CREATE DATABASE db_ssmdemo CHARACTER SET UTF8;

CREATE TABLE `tb_basic_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '��������',
  `userId` varchar(32) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `headimg` varchar(200) DEFAULT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `memo` varchar(50) DEFAULT NULL,
  `credate` datetime DEFAULT NULL,
  `upddate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);