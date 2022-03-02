

--장르 테이블

create table blocation(    
blocation varchar (10),
primary key (blocation)
);


-- 장르번호 및 장르 입력
insert into blocation
values ('A');
insert into blocation
values ('B');
insert into blocation
values ('C');
insert into blocation
values ('D');
insert into blocation
values ('E');


--리뷰 및 별점테이블 
--리뷰 작성자(rname) 및 리뷰 내용 (review)
--책 번호로 접근가능
create table review(    
bnumber number (20),
rname varchar(20),
review varchar (4000),
starsum number (20),          --별점
foreign key (bnumber) references books (bnumber)
);

-- 도서 테이블

create table books (
blocation varchar(10),       --책 위치
bnumber number(20)primary key,  -- 책 고유 번호 (장르 무관)
bname varchar(50)unique ,        --책이름
bwriter varchar(50),      --글쓴이
foreign key (blocation) references blocation (blocation)
);


--책 고유번호

create sequence booknum_seq
start with 1
increment by 1;

alter sequence booknum_seq nocache;



-- 예시로 장르별로 책 한권씩 등록
insert into books
values ('A',booknum_seq.nextval,'나루토','키시모토 마사시');
insert into books
values ('B',booknum_seq.nextval,'이말년시리즈','이말년');
insert into books
values ('C',booknum_seq.nextval,'궁','박소희');
insert into books
values ('D',booknum_seq.nextval,'전지적 독자 시점','UMI/슬리피-C');
insert into books
values ('E',booknum_seq.nextval,'더 파이팅','모리카와 조지');

insert into review 
values (1,'오경종','액션신이 너무 좋았다',5);