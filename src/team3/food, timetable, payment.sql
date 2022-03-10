-- 식사메뉴 
create table food(
    fno number(10) primary key,
    fname varchar2(50) not null,
    price number(10) not null,
    mealtype varchar2(10) not null
);

create sequence fno_seq
start with 1
increment by 1;

insert into food values(fno_seq.nextval, '라면', '3500', '스낵');
insert into food values(fno_seq.nextval, '떡볶이', '4500', '스낵');
insert into food values(fno_seq.nextval, '라볶이', '5000', '스낵');
insert into food values(fno_seq.nextval, '스팸계란 볶음밥', '5900', '식사');
insert into food values(fno_seq.nextval, '치킨가라아게 덮밥', '5900', '식사');
insert into food values(fno_seq.nextval, '김치베이컨 볶음밥', '5900', '식사');
insert into food values(fno_seq.nextval, '아메리카노', '3000', '음료');
insert into food values(fno_seq.nextval, '카페 라떼', '3800', '음료');
insert into food values(fno_seq.nextval, '카라멜 마끼아또', '4300', '음료');


-- 시간 요금제 
create table timetable(
    hours number(5) primary key,
    tname varchar2(30) not null,
    tprice number(10) not null,
    type varchar2(30) not null
);


insert into timetable values('1', '1시간 추가', '1000', 'HOURS');
insert into timetable values('2', '2시간 추가', '2000', 'HOURS');
insert into timetable values('3', '3시간 추가', '3000', 'HOURS');
insert into timetable values('6', '6시간 추가', '5000', 'HOURS');
insert into timetable values('12', '12시간 추가', '8000', 'HALF-DAY');
insert into timetable values('24', '24시간 추가', '12000', 'ALL-DAY');



-- 결제 완료 후 주문건 테이블
create table payment(
    oderno number primary key,
    pname varchar2(50) not null,
    amount number(10),
    total number(10) not null,
    sort varchar2(10) not null,
    cashtype varchar2(10) not null,
    regdate date
);
commit;
















