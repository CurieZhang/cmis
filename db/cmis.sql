-- �������ݿ�
create database cmis character set utf8;
-- �����û�
CREATE USER 'cmis'@'localhost' IDENTIFIED BY '13993106255';
-- ��Ȩ�û�
grant all privileges on cmis.* to 'cmis'@'localhost';
flush privileges;

-- ����users��
create table users
(
    USER_ID       varchar(32)  not null comment '�û�id'
        primary key,
    USER_NAME     varchar(50)  not null comment '�û���',
    USER_PASSWORD varchar(128) not null comment '�û�����',
    USER_PHONE    varchar(20)  null comment '�û��ֻ�'
);
