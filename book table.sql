

--장르 테이블

create table genre(            
bgenreno number(10),
bgenre varchar(10),
primary key (bgenreno)
);


-- 장르번호 및 장르 입력
insert into genre 
values (10,'코믹');
insert into genre
values (20,'액션');
insert into genre
values (30,'순정');
insert into genre
values (40,'판타지');
insert into genre
values (50,'스포츠');


--리뷰 및 별점테이블 
--리뷰 작성자(rname) 및 리뷰 내용 (review)
--책 번호로 접근가능
create table review(         
bgenreno number(10),
bnumber number (20),
rname varchar(20),
review varchar (4000),
starsum number (20),          --별점
foreign key (bgenreno) references genre (bgenreno),
foreign key (bnumber) references books (bnumber)
);

-- 도서 테이블

create table books (
bgenreno number(10),       --장르번호
bposition number(20),      --책 위치 (장르별 1번부터 차례로)
bnumber number(20)primary key,  -- 책 고유 번호 (장르 무관)
bname varchar(50)unique ,        --책이름
bwriter varchar(50),      --글쓴이 
brental varchar(20),       --대여상태
brentalday date,           --대여날짜
foreign key (bgenreno) references genre (bgenreno)
);


--책 별로 고유번호 (장르별 중복 안되게 따로 설정)
create sequence comic_seq
start with 1
increment by 1;
create sequence action_seq
start with 1
increment by 1;
create sequence sport_seq
start with 1
increment by 1;
create sequence love_seq
start with 1
increment by 1;
create sequence fantasy_seq
start with 1
increment by 1;
create sequence booknum_seq
start with 1
increment by 1;

alter sequence comic_seq nocache;
alter sequence action_seq nocache;
alter sequence sport_seq nocache;
alter sequence love_seq nocache;
alter sequence fantasy_seq nocache;
alter sequence booknum_seq nocache;



-- 예시로 장르별로 책 한권씩 등록
insert into books
values (20,action_seq.nextval,booknum_seq.nextval,'나루토','키시모토 마사시','미대여',null);
insert into books
values (10,comic_seq.nextval,booknum_seq.nextval,'이말년시리즈','이말년','미대여',null);
insert into books
values (30,love_seq.nextval,booknum_seq.nextval,'궁','박소희','대여중',sysdate);
insert into books
values (40,fantasy_seq.nextval,booknum_seq.nextval,'전지적 독자 시점','UMI/슬리피-C','미대여',null);
insert into books
values (50,sport_seq.nextval,booknum_seq.nextval,'더 파이팅','모리카와 조지','미대여',null);

insert into review 
values (20,1,'오경종','액션신이 너무 좋았다',5);