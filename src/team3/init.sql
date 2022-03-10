create table member(
    mem_id varchar(32) unique not null,
    mem_password varchar(100) not null,
    mem_num number(10) primary key,
    mem_name varchar(20) not null,
    mem_contact varchar(20),
    mem_addr varchar(100),
    mem_findpwd_ans varchar(20) not null,
    mem_mileage number(10)
);

create sequence mem_seq
start with 1
increment by 1;

create view mem_info
as
select mem_num, mem_name, mem_contact, mem_addr, mem_mileage
from member;