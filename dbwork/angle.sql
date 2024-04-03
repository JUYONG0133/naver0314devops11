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
drop sequence seq_test;
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


--불필요한 제약조건 제거
alter table student drop constraint ck_score;
alter table student drop constraint nn_name;
--새로운 제약조건 추가
alter table student add constraint uq_name unique(stuname);
--같은 이름 데이터를 추갛
insert into student (num,stuname) values (10,'강호동'); --위에 새로운 제약조건으로 unique를 걸었기 때문에 같은 이름은 들어가지 못한다


--연습이 끝난후 테이블과 시퀀스 삭제
drop sequence seq_test;
drop table student;
-----------------------------------------------------------------------------------------------
/*
 join 연습용 테이블 2개 생성하기
 테이블 #1:
    food -  foodnum 숫자 3
            foodname 문자열 20
            foodprice 숫자 7
            foodsize 문자열 20
    booking -   bnum pk 숫자 3
                bname 문자열 20 nn
                bhp 문자열 20 uq
                foodnum 숫자 3 - fk(food의 foodnum)
                bookingday date

 외부키로 연결된경우 booking 에 데이터가 추가된 이후 추가된 foodnum은 삭제할 수없다
 (예를 들어 게시판의 댓글같은 경우 외부키로 연결되어 있는데 이때도 댓글이 달린경우 해당글 삭제할수 없는 게시판들이 있다.
 - 그런데도 만약 food의 데이터를 삭제하면 그 메뉴를 추가한 고객의 데이터도 자동으로 삭제시키고자 할 경우 booking 에 외부키를 설정할때 on table cascade 를 주면된다)
 */
create table food(
                     foodnum number (3) constraint pk_foodnum primary key ,
                     foodname varchar2(20),
                     foodprice number(7),
                     foodsize varchar2(20)
);
--메뉴 등록
insert into food values (100,'짜장면',9000,'보통');
insert into food values (101,'짜장면',11000,'곱배기');
insert into food values (200,'탕수육',15000,'보통');
insert into food values (201,'탕수육',20000,'곱배기');
insert into food values (300,'칠리새우',15000,'소');
insert into food values (301,'칠리새우',30000,'대');
insert into food values (400,'해물짬뽕',11000,'보통');
commit;
select * from food;
--시퀀스 추가
create sequence seq_food nocache ;
--booking table 생성
create table booking(
                        bnum number(3) constraint pk_bnum primary key ,
                        bname varchar2(20) constraint nn_bname not null ,
                        bhp varchar2(20) constraint nq_bhp unique ,
                        foodnum number(3) ,
                        bookingday date,
                        constraint fk_foodnum foreign key(foodnum) references food(foodnum)
);

--예약 테이블에 데이터 추가
select * from booking;
insert into booking values (seq_food.nextval,'홍범이','010-2222-3433',100,sysdate);
insert into booking values (seq_food.nextval,'홍범자','010-2222-3333',101,sysdate);
insert into booking values (seq_food.nextval,'강호동','010-2222-3333',101,sysdate); --오류 발생 한드폰번호가 같으면 안됌
insert into booking values (seq_food.nextval,'이영자','010-3434-8899',301,sysdate+7);
insert into booking values (seq_food.nextval,'박지민','010-2222-4545',101,sysdate+3);
insert into booking values (seq_food.nextval,'손미나','010-1234-3332',201,sysdate+10);
insert into booking values (seq_food.nextval,'이효리','010-3451-5231',400,sysdate+1);
commit;

select bnum ,bname, bhp, booking.foodnum,foodname, foodprice,foodsize,to_char(bookingday,'yyyy-mm-dd') bookingday from food,booking where food.foodnum  =booking.foodnum;

--아무도 에약하지 않은 food 는 무엇이 있는지 찾기
select
    bnum , f.foodnum, foodname, foodprice, foodsize
from food f, booking b
where f.foodnum = b.foodnum(+) and bnum is null ;
--food 의 200번 메뉴는 삭제 가능?
delete from food where foodnum = 200;  -- 200번 메뉴를 주문한 고객이 없으므로 삭제 가능
--food 의 101qjs
delete from food where foodnum = 100;  --100번 메뉴를 주문한 고객이 있으므로 삭제할 수 없음
--부모 테이블인 food를 삭제해보자
drop table food; --오류발생, 자식테이블을 먼저 삭제후 부모 테이플을 삭제해야만한다.

--연습이 끝난 후 두 테이블 제거
drop table booking;
drop table food;
drop sequence seq_food;
---------------------------------------------------------------------------------------------------------------------------
--이번에는 부모테이블의 데이터 삭제시 서브테이블의 데이터도 자동으로 삭제되도록 외부키 설정
--시퀀스 생성
create sequence seq_shop;
--shop, cart
create table shop(
                     sang_no number(3) constraint shop_pk_no primary key ,
                     sang_name varchar2(30),
                     sang_price number(10)
);
create table cart(
                     cart_no number(3) constraint cart_pk_no primary key ,
                     sang_no number(3),
                     cnt number(3),
                     cartday date,
                     constraint cart_fk_no foreign key (sang_no) references shop(sang_no) on delete cascade
);
--외부키 설정시 on delete cascade를 붙이면 부모테이블 삭제시 자식테이블에 추가된 데이터도 같이 삭제됨

insert into shop values (SEQ_SHOP.nextval, '블라우스',12000);
insert into shop values (SEQ_SHOP.nextval, '조끼',19000);
insert into shop values (SEQ_SHOP.nextval, '청바지',25000);
insert into shop values (SEQ_SHOP.nextval, '체크코트',99000);
insert into shop values (SEQ_SHOP.nextval, '티셔츠',11000);
commit;
select * from shop;

--카트에 원하는 상품을 담아보자
insert into cart values (seq_shop.nextval,2,3,sysdate);
insert into cart values (seq_shop.nextval,1,2,sysdate);
insert into cart values (seq_shop.nextval,5,1,sysdate);
commit;
select * from cart;

--cart_no, sang_no, sang_name, sang_price,cnt,cartday(yyyy-mm-dd)
select
    cart_no,s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
from shop s,cart c
where s.sang_no = c.sang_no

--아무것도 담지 않은 상품
select
    cart_no,s.sang_no,sang_name,sang_price
from shop s,cart c
where s.sang_no = c.sang_no(+) and cart_no is null ;

--on delete cascade를 한경우 cart에 등록된 상품도 삭제 가능
--2번 조끼 상품 삭제
delete from shop where sang_no = 2;
--cart를 확인해보면 cart에 있던 상품도 사라진걸 볼수 있다.

--테이블 제거는 서브테이블부터
drop table cart;
drop table shop;
drop sequence seq_shop;