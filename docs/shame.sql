create database spring_boot;
show databases;
use spring_boot;

create table t_example(
  id BIGINT primary key,
  name VARCHAR(50) not null,
  password varchar(50) not null,
  create_time timestamp not null
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE =utf8_general_ci;

show tables;
select * from t_example;
alter table t_example add (create_time timestamp not null);

select `id`,`name`,`password`,`create_time` from t_example where id = 1000;
