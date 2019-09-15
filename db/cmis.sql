-- 创建数据库
create database cmis character set utf8;
-- 创建用户
CREATE USER 'cmis'@'localhost' IDENTIFIED BY '13993106255';
-- 授权用户
grant all privileges on cmis.* to 'cmis'@'localhost';
flush privileges;

-- 创建users表
create table users
(
    USER_ID       varchar(32)  not null comment '用户id'
        primary key,
    USER_NAME     varchar(50)  not null comment '用户名',
    USER_PASSWORD varchar(128) not null comment '用户密码',
    USER_PHONE    varchar(20)  null comment '用户手机'
);
