--시퀀스 생성
--기본 1부터 1씩 증가하는 시퀀스는 생략하고 기본 명령어만 주면됨
create sequence seq1;
--전체 시퀀스 조회
select * from seq;
--다음 시퀀스값 발생 : nextval
select seq1.nextval from dual; --1씩 증가된 값이 발생한다.

--10 부터 5씩 증가하는 시퀀스를 생성해보자. 캐쉬가 기본20인데 없애보자
create sequence seq2 start with 10 increment by 5 nocache ;
--seq2 값으로 발생시켜보자
select seq2.nextval from DUAL;

--1부터 3씩증가, 캐쉬 0 , 맥스 100
create sequence seq3 start with 1 increment by 3 nocache maxvalue 100;
select seq3.nextval from DUAL;

--시퀀스 제거
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

--최종 테이블에서 사용할 시퀀스 생성(1부터 1씩 증가 생략가능)
create sequence seq_test nocache ;
--연습용 테이블 생성
create table hello(
    idx number(3) primary key ,
    irum varchar2(20),
    age number(3)
);
--테이블 구조 수정 : alter table
--irum 의 길이를 20에서 30으로 수정해보자
alter table hello modify irum varchar2(30);

-- addr 이라는 컬럼을 추가해보자 (문자열 길이는 100)
alter table hello add addr varchar2(100);

--age 라는 컬럼을 제거해보자
alter table hello drop column age;
alter table hello drop column blood;

--컬럼명 변경(addr -> address)
alter table hello rename column addr to address;

--컬럼 하나를 추가해보자
alter table hello add blood varchar2(3);
alter table hello add age number(3);

--데이터를 추가해보자
insert into hello (irum) values ('lee');  -- 에러발생, idx는 pk이므로 반드시 값을 넣어야한다.
insert into hello (idx,irum) values (seq_test.nextval, 'lee');
insert into hello (idx,blood,address) values (seq_test.nextval,'ab','서울 역삼');
--컬럼명 생략시 테이블의 컬럼 순서대로 모든값을 줘야한다.
insert into hello values (seq_test.nextval, '이진','제주도 애월읍','O',23);

--수정
--이름이 '이진' 인 사람의 혈액형을 b형으로 변경해보자
update hello set blood = 'b' where irum ='이진';
--idx가 2인 사람의 irum,age 를 수정해보자
update hello set irum = '강호동',age = 35 where idx = 5;
--idx가 1인 사람의 address,blood,age의 값을 수정하세요
update hello set address = '부산', blood = 'A', age = 1 where idx = 1;

--삭제
--idx 가 1인 사람 삭제
delete from hello where idx = 1;
--age가 30이상인 데이터는 모두삭제
delete from hello where age >= 30;
--테이블을 제거
drop table hello;

select * from HELLO;
------------------------------------------------------------------
--새로운 테이블 생성, 이번에는 각종 제약조건을 추가해서 생성해보자

create table student(
    num number(3) constraint pk_num primary key ,
    stuname varchar2(20) constraint nn_name not null ,
    score number(3) constraint ck_score check(score >=1 and score<=100),
    birthday date
);

--insert 로 데이터 추가 하는데 각종 에러를 발생시켜보자
insert into student (num,stuname) values (1,'aaa');
insert into student (stuname,score) values ('aaa',45); --오류발생  --num은 pk

--score 의 범위는 1~100 이어야 한다.
insert into STUDENT (num,STUNAME,SCORE) values (2,'bbb',110);
--오류없는 정상 데이터 추가
insert into student values (3,'이미자',89,sysdate);
insert into student values (4,'김민종',100,'2010-12-20');
commit; --commit 를 하면 rollback이 안된다
insert into student values (5,'곤미나',56,'2019-05-10');
insert into student values (6,'강수지',98,sysdate);
insert into student values (7,'김진우',67,'2015-09-12');
insert into student values (8,'강호동',66,'2019-05-03');
commit;
rollback;  -- 마지막 commit 한 이후의 dml 작업에 대한 롤백

update student set stuname='손미라',score=80 where num = 5;
update student set SCORE = 85 where to_char(birthday,'mm')=5;
select * from student;
commit;

--num이 7인 데이터 삭제
--롤백후 데이터 확인하기
--다시 삭제문 실행
--커밋하기
--다시 롤백후 데이터 확인하기
delete from student where num = 7;
select * from student;
rollback;
select  * from student;
delete from student where num = 7;
commit ;
rollback;
select * from student;















