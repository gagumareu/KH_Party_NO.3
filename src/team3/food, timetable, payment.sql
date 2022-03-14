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


create sequence orderNO_sqe
start with 1
increment by 1;

-- 결제 완료 후 주문건 테이블
create table payment(
    oderno number primary key,
    pname varchar2(50) not null,
    amount number(10),
    total number(10) not null,
    sort varchar2(10) not null,
    cashtype varchar2(50) not null,
    regdate date
);
commit;




delete from payment;

insert into payment values('1','라면','1','3500','스낵','카드','2022/03/14');
insert into payment values('2','떡볶이','1','4500','스낵','카드','2022/03/14');
insert into payment values('3','라면','2','7000','스낵','현금','2022/03/14');
insert into payment values('4','라볶이','2','10000','스낵','카드','2022/03/14');
insert into payment values('5','라면','1','3500','스낵','카드','2022/03/14');
insert into payment values('6','스팸계란 볶음밥','1','5900','식사','카드','2022/03/14');
insert into payment values('7','치킨가라아게 덮밥','2','11800','식사','현금','2022/03/14');
insert into payment values('8','김치베이컨 볶음밥','2','11800','식사','카드','2022/03/14');
insert into payment values('9','치킨가라아게 덮밥','1','5900','식사','카드','2022/03/14');
insert into payment values('10','스팸계란 볶음밥','1','5900','식사','현금','2022/03/14');
insert into payment values('11','김치베이컨 볶음밥','2','11800','식사','카드','2022/03/14');
insert into payment values('12','아메리카노','2','6000','음료','카드','2022/03/14');
insert into payment values('13','카라멜 마끼아또','1','4300','음료','현금','2022/03/14');
insert into payment values('14','카페 라떼','2','7600','음료','카드','2022/03/14');
insert into payment values('15','아메리카노','2','6000','음료','카드','2022/03/14');
insert into payment values('16','카페 라떼','2','7600','음료','현금','2022/03/14');
insert into payment values('17','카페 라떼','2','7600','음료','카드','2022/03/14');

insert into payment values('18','1시간 추가','1','1000','HOURS','카드','2022/03/14');
insert into payment values('19','1시간 추가','1','1000','HOURS','현금','2022/03/14');
insert into payment values('20','2시간 추가','1','2000','HOURS','카드','2022/03/14');
insert into payment values('21','6시간 추가','1','5000','HOURS','현금','2022/03/14');
insert into payment values('22','1시간 추가','1','1000','HOURS','카드','2022/03/14');
insert into payment values('23','12시간 추가','1','8000','HALF-DAY','카드','2022/03/14');
insert into payment values('24','3시간 추가','1','3000','HOURS','카드','2022/03/14');
insert into payment values('25','1시간 추가','1','1000','HOURS','카드','2022/03/14');
insert into payment values('26','24시간 추가','1','12000','ALL-DAY','카드','2022/03/14');
insert into payment values('27','2시간 추가','1','2000','HOURS','현금','2022/03/14');
insert into payment values('28','1시간 추가','1','1000','HOURS','카드','2022/03/14');

insert into payment values('29','카페 라떼','2','7600','음료','카드','2022/03/14');

insert into payment values('30','라면','2','7000','스낵','현금','2022/03/15');
insert into payment values('31','라볶이','2','10000','스낵','카드','2022/03/15');
insert into payment values('32','김치베이컨 볶음밥','2','11800','식사','카드','2022/03/15');
insert into payment values('33','치킨가라아게 덮밥','1','5900','식사','카드','2022/03/15');
insert into payment values('34','스팸계란 볶음밥','1','5900','식사','현금','2022/03/15');
insert into payment values('35','김치베이컨 볶음밥','2','11800','식사','카드','2022/03/15');
insert into payment values('36','아메리카노','2','6000','음료','카드','2022/03/15');
insert into payment values('37','카라멜 마끼아또','1','4300','음료','현금','2022/03/15');

insert into payment values('38','1시간 추가','1','1000','HOURS','카드','2022/03/15');
insert into payment values('39','12시간 추가','1','8000','HALF-DAY','카드','2022/03/15');
insert into payment values('40','3시간 추가','1','3000','HOURS','카드','2022/03/15');
insert into payment values('41','1시간 추가','1','1000','HOURS','카드','2022/03/15');
insert into payment values('42','24시간 추가','1','12000','ALL-DAY','카드','2022/03/15');

commit;





