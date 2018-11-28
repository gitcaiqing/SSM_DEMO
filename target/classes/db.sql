CREATE DATABASE db_ssmdemo CHARACTER SET UTF8;

DROP TABLE IF EXISTS tb_basic_user;
CREATE TABLE tb_basic_user (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  userId varchar(32) DEFAULT NULL COMMENT '用户ID',
  utype int(1) DEFAULT 0 COMMENT '用户类型 0管理员1普通用户',
  username varchar(20) NOT NULL COMMENT '用户名',
  password varchar(100) NOT NULL COMMENT 'MD5加密密码',
  headimg varchar(200) DEFAULT NULL COMMENT '头像',
  realname varchar(20) DEFAULT NULL COMMENT '真实姓名',
  sex int(1) DEFAULT NULL COMMENT '性别',
  age int(2) DEFAULT NULL COMMENT '年龄',
  mobile varchar(20) DEFAULT NULL COMMENT '手机号',
  email varchar(50) DEFAULT NULL COMMENT '邮件地址',
  credate datetime DEFAULT NULL COMMENT '创建时间',
  upddate datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (id)
);
