-- 2024-04-04 mysql 공부
-- 현재 날짜를 구하는 함수들
select now() from dual;
select sysdate() from dual;
select current_timestamp() from dual;

-- 날짜 함수들
select year(now()) from dual; -- 년도
select month(now()) from dual; -- 월 (숫자)
select monthname(now()) from dual; -- 월(문자)
select day(now()) from dual; -- 일 (숫자)
select dayofmonth(now()) from dual; -- 위와같다
select dayname((now())) from dual; -- 일(문자)
select date_format((now()),'%Y-%m-%d') from dual; -- 년월일 원하는 형대로 출력
select date_format((now()),'%Y-%m-%d %H:%i') from dual; -- 년월일시분 출력
select str_to_date(20240404,'%Y%m%d')from dual; -- 숫자형태를 날짜 타입으로 변환

-- 테스트 생성 test01
create table test01 (num tinyint auto_increment primary key,
                     name varchar(20), age smallint,
                     height decimal(5,1),birthday datetime, ipsaday date);

-- insert : 일부만 추가할 경우 컬럼명 기재, 전체 다 줄경우 컬럼명 생략
insert into test01 (name,age, height) values ('lee',23,178.9);
insert into test01 (name,birthday, ipsaday) values ('LeeMJ','2021-12-25 12:30','2018-05-10');

-- 컬럼 생략시 num도 값을 넣어야하는데 num은 auto 이므로 그냥 null로 넣으면됨
insert into test01 values (null,'kim',29,156.9,now(),now());
insert into test01 values (null,'son',31,167.988,now(),now());
insert into test01 values (null,'sonaaa',26,145.9,now(),now());
insert into test01 values (null,'kimbbb',45,186.9,now(),now());
insert into test01 values (null,'ParkNamJung',14,136.9,now(),now());



select * from test01;
select * from test01 where name = 'son';
select * from test01 where name like 's%';  -- s 로 시작하는사람
select * from test01 where name like '_i%'; -- 두번째 글짜가 i인 사람
select upper(name),height from test01;  -- 이름을 대문자로
select ucase(name),height from test01;  -- 이름을 대문자로

select lower(name),height from test01;  -- 이름을 소문자로
select lcase(name),height from test01;  -- 이름을 소문자로

-- 오라클의 NVL이 MYSQL에서는 ifnull:null 일때 대체값 지정
select name,ifnull(age,10),ifnull(height,150.5) from test01;
-- 컬럼명을 변경
select name "이름" ,ifnull(age,10) "나이",ifnull(height,150.5)"키" from test01;
-- 컬럼명을 변경하는데 "" 없이 사용가능(공백이없을때) 컬럼명으로도 지정가능
select name  ,ifnull(age,10) age,ifnull(height,150.5)height from test01;

-- 테이블 구조 수정
-- 컬럼 추가
alter table test01 add hp varchar(20);
-- 컬럼을 추가하는데 기본값 지정
alter table test01 add blood varchar(4) default 'b';
-- 컬럼 타입 변경
desc test01; -- 구조 확인
    -- name 의 길이를 20 에서 30으로 변경
alter  table test01 modify name varchar(30);
-- age 컬럼 제거
alter table test01 drop column age;
-- 컬럼명 변경(mysql5 는 change, mysql8은 rename column (오라클과 같다)
-- hp -> phone 변경
alter table test01 rename column hp to phone;
-- 삭제
delete from test01 where num = 5;
-- 수정
update test01 set birthday = '1990-12-12' , ipsaday=now(), phone = '010-2222-3333' where num =1;

-- 조회
select * from test01 order by num;
select * from test01 order by 1; -- 컬럼 번호 첫 컬럼이 1번
-- 부분조회
select * from test01 limit 0,3; -- 첫 데이터가 0번: 0번부터 3개 조회;
select * from test01 limit 3,2; -- 첫 데이터가 0번: 3번부터 2개 조회;


create table sawon (
                       num smallint auto_increment,
                       name varchar(20),
                       score smallint,
                       gender varchar(10),
                       buseo varchar(10),
                       constraint pk_sawon_num primary key(num),
                       constraint ck_sawon_score check (score between 0 and 100),
                       constraint ck_sawon_gender check (gender in ('여자','남자')));

-- 제약조건 확인
select * from information_schema.table_constraints where table_name='sawon';
select * from sawon;
-- check 에 안맞는 값을 insert 할경우 오류메세지 확인
insert into sawon values (null,'이민정',110,'여자','홍보부'); -- 에러발생
-- check 에 맞게 데이터를 추가
insert into sawon values (null,'이민정',90,'여자','홍보부');
insert into sawon values (null,'홀길동',87,'남','교육부'); -- 에러발생
insert into sawon values (null,'홀길동',87,'남자','교육부');
insert into sawon values (null,'이진',56,'여자','인사부');
insert into sawon values (null,'유재석',95,'남자','홍보부');
insert into sawon values (null,'김재동',87,'남자','인사부');
insert into sawon values (null,'박재정',57,'남자','홍보부');
insert into sawon values (null,'이영자',78,'여자','인사부');
insert into sawon values (null,'손흥민',57,'남자','홍보부');
insert into sawon values (null,'이강인',95,'남자','인사부');
insert into sawon values (null,'이기제',17,'남자','교육부');

-- group 함수
select count(*) from sawon; -- 총 인원수
select sum(score),avg(score) from sawon; -- 총점, 평균
select sum(score),round(avg(score),1) from sawon; -- 총점, 평균.1

-- 성별 : 인원수 최고점수 최저점수 평균점수를 구해보자
select
    gender 성별 ,count(*) 인원수 ,max(score) 최고점수 ,min(score) 최저점수 ,round(avg(score),1) 평균점수
from sawon
group by gender;

-- 부서별 인원수와 최고점수
select
    buseo 부서,count(*) 인원수, max(score) 최고점수
from sawon
group by buseo;

-- 오라클의 decode와 비슷한 if문
select name,score,if(score>=90,'통과','재시험') 평가 from sawon;

-- test01은 연습용이므로 삭제

drop table test01;
-- ----------------------------------------------------------------------------
-- mysql 함수부분
select concat('happy','day') from dual; /*문자열더함*/
select concat('apple','kiwi','mango') from dual;
select replace('have a nice day','a','*') from dual;
select instr('happy','a') from dual;
select instr('happy','x') from dual;
select left('have a nice day',4) from dual;
select right('have a nice day',5) from dual;
select mid('have a nice day',8,4) from dual;
select substring('have a nice day',8,4) from dual;
select left('가나다라마바사',3) from dual; /*한글도3글자 나옴*/
select substring('가나다라마바사',4,2) from dual;
select concat(ltrim('   abc    '),'*') from dual;
select concat(rtrim('   abc    '),'*') from dual;
select concat(trim('   abc    '),'*') from dual;
select lcase('Happy'),lower('Happy') from dual;
select ucase('Happy'),upper('Happy') from dual;
select reverse('Happy') from dual;
select abs(-10) from dual;/*무조건 양수값 반환*/
select ceiling(2.1) from dual; /*무조건올림  3 */
select floor(2.9) from dual; /*무조건내림  2 */
select truncate(2.345,2) from dual; /*소숫점2자리까지 출력되고 3자리에서 내림*/
select mod(5,3) from dual;/*5를 3으로 나눈나머지=2*/
select greatest(12,23,34,11,4) from dual;/*가장 큰숫자*/
select least(12,23,34,11,4) from dual;/*가장 작은숫자*/
-- ----------------------------------------------------------------------------------

create table bitclass (
                          idx smallint primary key,
                          class varchar(30),
                          price int,
                          gigan smallint);
create table stu (
                     num smallint auto_increment primary key,
                     name varchar(20),
                     idx smallint,
                     sugangday date,
                     constraint stu_fk_idx foreign key(idx) references bitclass(idx));
-- bitclass 에 데이타 추가
insert into bitclass values (100,'Java',110000,10);
insert into bitclass values (200,'HTML5',90000,8);
insert into bitclass values (300,'jQuery',130000,12);
insert into bitclass values (400,'Oracle',180000,20);
-- stu 에 데이타 추가
insert into stu (name,idx,sugangday) values ('kim',200,now());
insert into stu (name,idx,sugangday) values ('lee',100,now());
insert into stu (name,idx,sugangday) values ('son',300,now());
insert into stu (name,idx,sugangday) values ('min',400,now());
-- join
-- join 1
select * from bitclass bc,stu where bc.idx=stu.idx;
-- join 2
select name,class,price,gigan,sugangday from bitclass bc,stu
where bc.idx=stu.idx;
-- join 3
select name,class,price,gigan,sugangday from bitclass bc
                                                 inner join stu on bc.idx=stu.idx;

-- join 연습용 테이블 삭제
drop table stu;
drop table bitclass;
show tables;

-- ------------------------------------------------------------------------------
-- join 연습용 테이블 2개 생성  : on delete cacade
create table shop(
    shopnum smallint auto_increment primary key ,
    sangpum varchar(30),
    price int,
    color varchar(20) default 'black'
);
create table cart(
    cartnum smallint auto_increment primary key ,
    username varchar(20),
    shopnum smallint,
    guipday datetime,
    constraint fk_shopnum foreign key (shopnum) references shop(shopnum) on delete cascade
);

-- shop 에 5개의 상품을 등록해보자
insert into shop(sangpum,price) values ('블라우스',12000);
insert into shop values (null,'청바지',29000,'blue');
insert into shop values (null,'레이스조끼',31000,'yellow');
insert into shop values (null,'주름스커트',43000,'green');
insert into shop values (null,'체크남방',32000,'pink');
select * from shop;

-- cart 에도 데이터 추가
select * from cart;
insert into cart values (null,'이진',3,now());
insert into cart values (null,'강철수',1,now());
insert into cart values (null,'유재석',4,now());
insert into cart values (null,'한예슬',5,now());
insert into cart values (null,'강호동',1,now());

-- join 1
select * from shop, cart where shop.shopnum = cart.shopnum;
-- join 2
select
    username, sangpum, price, color ,guipday
from shop s, cart c where s.shopnum = c.shopnum;
-- join 3
select
    username,sangpum,price,color,guipday
from shop inner join cart on shop.shopnum = cart.shopnum;

-- shop 에서 1번 블라우스를 삭제해보자
delete from shop where shopnum =1;
-- 다시 join
select
    username,sangpum,price,color,guipday
from shop inner join cart on shop.shopnum = cart.shopnum;









