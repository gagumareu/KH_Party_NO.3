

-- 도서 테이블

create table books (
blocation varchar(10),          --책 위치
bgenre varchar (10),            --책 장르
bnumber number(20)primary key,  -- 책 고유 번호 (장르 무관)
bname varchar(50) unique ,        --책이름
bwriter varchar(50),            --글쓴이
bstarage number(10),
breviewsum number (10)
);


--리뷰 및 별점테이블
--리뷰 작성자(rname) 및 리뷰 내용 (review)
--책 번호로 접근가능
create table review(
bnumber number (20),
rname varchar(20),
review varchar (4000),
starsum number (20),          --별점
regdate date ,
foreign key (bnumber) references books (bnumber)
);

drop table review purge;


--책 고유번호
create sequence booknum_seq
start with 1
increment by 1
nocache;


-- 예시로 장르별로 책 한권씩 등록
insert into books
values ('A','엑션',booknum_seq.nextval,'나루토','키시모토 마사시',null,null);
insert into books
values ('A','엑션',booknum_seq.nextval,'원피스','에이치로 오다',null,null);
insert into books
values ('B','코미디',booknum_seq.nextval,'이말년시리즈','이말년',null,null);
insert into books
values ('C','순정',booknum_seq.nextval,'궁','박소희',null,null);
insert into books
values ('D','판타지',booknum_seq.nextval,'전지적 독자 시점','UMI/슬리피-C',null,null);
insert into books
values ('E','스포츠',booknum_seq.nextval,'더 파이팅','모리카와 조지',null,null);

insert into review
values (1,'오경종','액션신이 너무 좋았다',5,sysdate);
insert into review
values (1,'오경종','액션신이 너무 좋았다',4,sysdate);

select * from books;



