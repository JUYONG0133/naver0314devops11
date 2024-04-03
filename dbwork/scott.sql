--------------------------------------------------------
--  ������ ������ - �ݿ���-3��-22-2019
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BONUS
--------------------------------------------------------

CREATE TABLE "BONUS"
(	"ENAME" VARCHAR2(10 BYTE),
     "JOB" VARCHAR2(9 BYTE),
     "SAL" NUMBER,
     "COMM" NUMBER
) SEGMENT CREATION DEFERRED
    PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
    TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DEPT
--------------------------------------------------------

CREATE TABLE "DEPT"
(	"DEPTNO" NUMBER(2,0),
     "DNAME" VARCHAR2(14 BYTE),
     "LOC" VARCHAR2(13 BYTE)
) SEGMENT CREATION IMMEDIATE
    PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
            PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
    TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EMP
--------------------------------------------------------

CREATE TABLE "EMP"
(	"EMPNO" NUMBER(4,0),
     "ENAME" VARCHAR2(10 BYTE),
     "JOB" VARCHAR2(9 BYTE),
     "MGR" NUMBER(4,0),
     "HIREDATE" DATE,
     "SAL" NUMBER(7,2),
     "COMM" NUMBER(7,2),
     "DEPTNO" NUMBER(2,0)
) SEGMENT CREATION IMMEDIATE
    PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
            PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
    TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SALGRADE
--------------------------------------------------------

CREATE TABLE "SALGRADE"
(	"GRADE" NUMBER,
     "LOSAL" NUMBER,
     "HISAL" NUMBER
) SEGMENT CREATION IMMEDIATE
    PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
            PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
    TABLESPACE "USERS" ;
--REM INSERTING into BONUS
SET DEFINE OFF;
--REM INSERTING into DEPT
SET DEFINE OFF;
Insert into DEPT (DEPTNO,DNAME,LOC) values (10,'ACCOUNTING','NEW YORK');
Insert into DEPT (DEPTNO,DNAME,LOC) values (20,'RESEARCH','DALLAS');
Insert into DEPT (DEPTNO,DNAME,LOC) values (30,'SALES','CHICAGO');
Insert into DEPT (DEPTNO,DNAME,LOC) values (40,'OPERATIONS','BOSTON');
--REM INSERTING into EMP
SET DEFINE OFF;
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7369,'SMITH','CLERK',7902,to_date('80/12/17','RR/MM/DD'),800,null,20);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7499,'ALLEN','SALESMAN',7698,to_date('81/02/20','RR/MM/DD'),1600,300,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7521,'WARD','SALESMAN',7698,to_date('81/02/22','RR/MM/DD'),1250,500,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7566,'JONES','MANAGER',7839,to_date('81/04/02','RR/MM/DD'),2975,null,20);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7654,'MARTIN','SALESMAN',7698,to_date('81/09/28','RR/MM/DD'),1250,1400,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7698,'BLAKE','MANAGER',7839,to_date('81/05/01','RR/MM/DD'),2850,null,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7782,'CLARK','MANAGER',7839,to_date('81/06/09','RR/MM/DD'),2450,null,10);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7788,'SCOTT','ANALYST',7566,to_date('87/04/19','RR/MM/DD'),3000,null,20);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7839,'KING','PRESIDENT',null,to_date('81/11/17','RR/MM/DD'),5000,null,10);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7844,'TURNER','SALESMAN',7698,to_date('81/09/08','RR/MM/DD'),1500,0,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7876,'ADAMS','CLERK',7788,to_date('87/05/23','RR/MM/DD'),1100,null,20);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7900,'JAMES','CLERK',7698,to_date('81/12/03','RR/MM/DD'),950,null,30);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7902,'FORD','ANALYST',7566,to_date('81/12/03','RR/MM/DD'),3000,null,20);
Insert into EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7934,'MILLER','CLERK',7782,to_date('82/01/23','RR/MM/DD'),1300,null,10);
--REM INSERTING into SALGRADE
SET DEFINE OFF;
Insert into SALGRADE (GRADE,LOSAL,HISAL) values (1,700,1200);
Insert into SALGRADE (GRADE,LOSAL,HISAL) values (2,1201,1400);
Insert into SALGRADE (GRADE,LOSAL,HISAL) values (3,1401,2000);
Insert into SALGRADE (GRADE,LOSAL,HISAL) values (4,2001,3000);
Insert into SALGRADE (GRADE,LOSAL,HISAL) values (5,3001,9999);
--------------------------------------------------------
--  DDL for Index PK_DEPT
--------------------------------------------------------

CREATE UNIQUE INDEX "PK_DEPT" ON "DEPT" ("DEPTNO")
    PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
    PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
    TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_EMP
--------------------------------------------------------

CREATE UNIQUE INDEX "PK_EMP" ON "EMP" ("EMPNO")
    PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
    PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
    TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DEPT
--------------------------------------------------------

ALTER TABLE "DEPT" ADD CONSTRAINT "PK_DEPT" PRIMARY KEY ("DEPTNO")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EMP
--------------------------------------------------------

ALTER TABLE "EMP" ADD CONSTRAINT "PK_EMP" PRIMARY KEY ("EMPNO")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
        STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
        PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
        TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EMP
--------------------------------------------------------

ALTER TABLE "EMP" ADD CONSTRAINT "FK_DEPTNO" FOREIGN KEY ("DEPTNO")
    REFERENCES "DEPT" ("DEPTNO") ENABLE;

select * from  tab ;
select * from  EMP;
commit ;

--ename 이 'A'나 'S'로 시작하는 사람의 ENAME,SAL,COMM 조회
select ENAME, SAL,COMM from EMP where ENAME like 'A%' or ENAME like 'S%';
--COMM 이 NULL이 아닌 사람마다 조회
select * from EMP where COMM is not null;
--MGR이 7698.7566,7782 인 사람 조회 (in사용)
select * from EMP where MGR in (7698,7566,7782);
--SAL이 2500부터 3000까지 조회 (and연산)
select * from EMP where  SAL>=2500 and SAL<=3000;
--SAL이 2500부터 3000까지 조회 (BETWEEN) 사용
select * from EMP where SAL between 2500 and 3000;
--job을 중복러리해서 한번씩만 처리하세요
select distinct JOB from EMP;


--서브쿼리
--ALLEN의 직업과 같은 직업을 가진 사람들을 조회하세요
select * from EMP where JOB like  (select JOB from EMP where ENAME like 'ALLEN');
--SCOTT의 MGR과 같은 값을 가진 사람의 정보를 조회하시오.
select * from emp where MGR = (select MGR from EMP where ENAME like 'SCOTT');

--
--숫자함수, 문자함수 연습
select abs(-5),abs(5)from DUAL;  --abs : 절대값
select ceil(3.1),ceil(3.9) from DUAL; --ceil : 소수점 아래 무조건 올림
select floor(3.0),floor(3.1),floor(3.9) from DUAL; --floor : 소수점 아래 무조건 내림
select mod(7,3),mod(9,5) from DUAL; --MOD  : 나머지 값
select power(2,3),power(3,4) from DUAL; --POWER : 지수승
select ROUND(23.456,2) ,round(8923,-1) from DUAL; --ROUND : 반올림

--문자함수
select concat('HAPPY','DAY') from DUAL; --concat : 문자열합치기
select 'HAPPY'||'DAY' from DUAL; -- 위와 결과가 같다
select initcap('HAPPY'),INITCAP('hello') from DUAL ; -- initcap : 첫글자만 무조건 대문자로
select lower('hellOdAy'),upper('hellOdAy') from DUAL;--lower : 무조건 소문자로 , upper: 무조건 대문자로
select lower(ENAME) , initcap(ENAME) from emp;
select lpad(sal,10,'*')from emp;  --왼쪽으로 * 채우기
select RPAD(sal,10,'*')from emp;  --오른쪽으로 * 채우기
select substr('happy day',2,3) from DUAL; --2번 인덱스부터 3글자(첫글자 인덱스는 1)
select substr('happy day',-5,3) from DUAL; --뒤에서 5번째부터 3글자
select ENAME , length(ENAME) 글자수 from emp; --length : 길이, 글자수
select replace('GOOD DAY','O','*') from DUAL;  --relpace : 변경 (good day 에서 o를 *로 변경)
select instr('happy','a') from DUAL; --instr : 위치 찾기 (happy 에서 a 찾기)
select instr('happy','x')from DUAL; -- 찾는 값이 없을경우 0
select instr('have a nice day','nice') from DUAL; --문자하나가 아니라 단어 자체를 찾을수 있음
select trim('      hello         ') from DUAL; --TRIM : 앞뒤공백제거

--기타함수
--NVL은 널일경우 대체값으로 출력
select nvl(comm,1000) from emp; -- comm이 null 일 경우 1000으로 출력
select ENAME 사원명 ,DEPTNO 부서코드, decode(DEPTNO,10,'홍보부',20,'교육부',30,'인사부') 부서명 from emp; --decode : 값에 따라 다른값을 출력 할때

--join : ppt 43page
--inner jopin(내부조인),equi,join
-- 방법 1
select EMP.EMPNO, EMP.ENAME, EMP.JOB, DEPT.DNAME, DEPT.LOC from emp,dept where emp.DEPTNO = dept.DEPTNO;
-- 방법 2 , 두 테이블에 공통적으로 있는 컬럼일경우에만 앞에 테이블명을 붙이고 나머지는 생략가능
select EMPNO , ENAME, JOB, DNAME, LOC from emp,DEPT where emp.DEPTNO  = dept.DEPTNO;
--방법 3 , 테이블 명이 너무 길 경우 별칭을 사용할 수있다,
select EMPNO , ENAME, JOB, DNAME, LOC from emp e,DEPT d where e.DEPTNO  = d.DEPTNO;

commit;












