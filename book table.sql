

--장르 와 책번호(위치) 테이블
--책번호(위치)는 "장르별번호" - "입력된 순서"
--예) 코믹에 2번째로 등록된 책 
--     책번호   10-2 
--     위치     C-2
--     위치(위 예의 C) 는 이클립스에서 구현 

create table book(            
bgenreno number(10),
bgenre varchar(10),
primary key (bgenreno)
);


--리뷰 테이블 
--리뷰 작성자(rname) 및 리뷰 내용 (review)
--책 번호로 접근가능
create table review(         
bgenreno number(10),
bnumber number (20),
rname varchar(20),
review varchar (4000),
foreign key (bgenreno) references book (bgenreno),
foreign key (bnumber) references action (bnumber),
foreign key (bnumber) references comic (bnumber),
foreign key (bnumber) references fantasy (bnumber),
foreign key (bnumber) references sport (bnumber),
foreign key (bnumber) references love (bnumber)
);

--별점 테이블
-- 별점은 소수점 1자리까지 구현 
-- 평균 구하는식은 이클립스에서 구현
-- 책 번호로 접근가능

create table star(
bgenreno number(10),
bnumber number (20),
starno number (3,1),
foreign key (bgenreno) references book (bgenreno),
foreign key (bnumber) references action (bnumber),
foreign key (bnumber) references comic (bnumber),
foreign key (bnumber) references fantasy (bnumber),
foreign key (bnumber) references sport (bnumber),
foreign key (bnumber) references love (bnumber)
);

-- 각 장르별 테이블
-- 장르별로 나눈 이유는 책번호 "장르별번호" - "입력된 순서"
-- 에서 입력된 순서를 장르별로 나누기 위함.

create table action (
bgenreno number(10),       --장르번호
bnumber number(20) primary key,      --책번호 (1번부터 순서대로)
bname varchar(50),        --책이름
bwriter varchar(50),      --글쓴이 
brental varchar(20),       --대여상태
brentalday date,
foreign key (bgenreno) references book (bgenreno)
);
create table comic (
bgenreno number(10),       --장르번호
bnumber number(20) primary key,      --책번호 (1번부터 순서대로)
bname varchar(50),        --책이름
bwriter varchar(50),      --글쓴이 
brental varchar(20),       --대여상태
brentalday date,
foreign key (bgenreno) references book (bgenreno)
);

create table fantasy (
bgenreno number(10),       --장르번호
bnumber number(20) primary key,      --책번호 (1번부터 순서대로)
bname varchar(50),        --책이름
bwriter varchar(50),      --글쓴이 
brental varchar(20),       --대여상태
brentalday date,
foreign key (bgenreno) references book (bgenreno)
);
create table sport (
bgenreno number(10),       --장르번호
bnumber number(20) primary key,      --책번호 (1번부터 순서대로)
bname varchar(50),        --책이름
bwriter varchar(50),      --글쓴이 
brental varchar(20),       --대여상태
brentalday date,
foreign key (bgenreno) references book (bgenreno)
);
create table love (
bgenreno number(10),       --장르번호
bnumber number(20) primary key,      --책번호 (1번부터 순서대로)
bname varchar(50),        --책이름
bwriter varchar(50),      --글쓴이 
brental varchar(20),       --대여상태
brentalday date,
foreign key (bgenreno) references book (bgenreno)
);

-- 각 장르별 책번호 부여 
create sequence action_seq
start with 1
increment by 1;
create sequence comic_seq
start with 1
increment by 1;
create sequence love_seq
start with 1
increment by 1;
create sequence fantasy_seq
start with 1
increment by 1;
create sequence sport_seq
start with 1
increment by 1;

-- 장르번호 및 장르 입력
insert into book 
values (10,'코믹');
insert into book 
values (20,'액션');
insert into book 
values (30,'순정');
insert into book 
values (40,'판타지');
insert into book 
values (50,'스포츠');

-- 예시로 장르별로 책 한권씩 등록
insert into action
values (20,action_seq.nextval,'나루토','키시모토 마사시','미대여',null);
insert into comic
values (10,comic_seq.nextval,'이말년시리즈','이말년','미대여',null);
insert into love
values (30,love_seq.nextval,'궁','박소희','대여중',sysdate);
insert into fantasy
values (40,fantasy_seq.nextval,'전지적 독자 시점','UMI/슬리피-C','미대여',null);
insert into sport
values (50,sport_seq.nextval,'더 파이팅','모리카와 조지','미대여',null);


