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














