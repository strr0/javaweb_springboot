-- 如果存在message则删除 --
drop table if exists message;

-- 创建message表
create table message(
id int primary key auto_increment,
m_name varchar(20) not null,
m_data varchar(50) not null,
m_time datetime not null);