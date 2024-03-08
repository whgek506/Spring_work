use mydb;

create table usertable(
name varchar(30) not null,
id varchar(30) primary key, -- 기본키, unique, not null, 무결성 제약 조건 pwd varchar2(30) not null,
pwd varchar(30) not null
);

select * from usertable;
