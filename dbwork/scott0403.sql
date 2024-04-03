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
commit;

desc emp;

select ENAME,JOB from emp;

select ENAME,JOB from emp order by ENAME asc ; --오름차순정렬
select ENAME,JOB from EMP order by ENAME desc ; --내림차순정렬
--job 조회
select JOB from emp;
select distinct job from emp order by JOB asc ;
select distinct job from emp order by 1; --컬럼번호는 1번부터 , 위와같다

--ename아 SMITH인 사람 조회
select * from EMP where ename = 'SMITH';
select * from EMP where ename = 'ward'; --sqi 명령어는 대소문자 상관없지만 데이터는 정확히 써야한다

--ename이 SMITH이거나 WARD인 사람조회 (OR)
select * from EMP where ename = 'SMITH' or ENAME = 'WARD';

--ename, sal을 조회
select ENAME , sal from emp;

--컬럼 제목으 변경

select ename "사 원 명", sal "급여" from Emp;  --제목변경시 공백이 포함되어 잇을경우 반드시 "" 로 묶어준다

select ename 사원명, sal 급여 from Emp;  --제목변경시 공백이 없을경우 "" 생략가능

--여러컬럼을 합해서 하나의 컬럼으로 출력할경우 ,
select '내 이름은 '||ENAME||'이고 직업은 '||JOB||'입니다.' from EMP;
select '내 이름은 '||ENAME||'이고 직업은 '||JOB||'입니다.' "사원" from EMP;

select ''||ENAME||'님의 연봉은 '||sal||'만원 입니다.' "연봉" from emp;

--sal 연봉이 2000~3000 사이 조회(조회할 컬럼은 enmae, sal)
select ENAME, SAL from EMP where SAL >=2000 and sal<=3000;
--between을 이용해서 조회할수도있다,
select ENAME, SAL from EMP where SAL between 1000 and 2000;

--직업이 salesmen 이거나 manager, CLERK 조회
select ENAME,JOB from EMP where JOB = 'SALESMAN' or job= 'MANAGER' or JOB = 'CLERK';
select ENAME,JOB from EMP where JOB in ('SALESMAN','MANAGER','CLERK');

--MGR이 7902,7839,7788 인 사람 조회(컬럼, ename,job,mgr) in 사용
select ENAME,JOB,MGR from EMP where MGR in (7902,7839,7788);

--mgr이 null인 경우
select * from EMP where MGR is null ;
--CoMM이 null인경우
select  * from  EMP where COMM is null ;
--comm이 null이 아닌경우
select * from  EMP where COMM  is not null;
--문자 조회시 % , _ 를 이용해서 조회
--ENAME이 A로 시작하는 사람 조회
select ENAME,SAL from EMP where ENAME like 'A%';
--ename 이 N으로 끝나는사람
select ENAME,SAL from EMP where ENAME like '%N';
--이름의 두번째 글자가 A인사람 조회 _;
select ENAME,SAL from EMP where ENAME like '_A%';
--이름의 세번째 글자가 A인사람 조회 _;
select ENAME,SAL from EMP where ENAME like '__A%';

--이름이 s 나 m 으로 시작하는 사람
select ENAME,SAL from EMP where ENAME  like 'S%' or ENAME like 'M%';
--이름이 S로 시작하는 사람중에 연봉이 2000이상인사ㅏㄹㅁ
select ENAME,SAL from EMP where ENAME like 'S%' and SAL>=2000;
--MGR이 7902,7788,7566 이 아닌사람;
select ENAME,MGR from emp where MGR not in(7902,7788,7566);
--COMM, COMM+1000 의 결과 출력
select COMM, COMM+1000 from EMP; --null인 경우는 더해도 결과는 null
--함수중에 NVL(컬럼명, null일 경우 초기값), MYSQL은 ifnull이다.
select nvl(COMM,0), nvl(COMM,0)+1000 from EMP;
--위의 SQL문을 컬럼제목을 추가하여 완성하기
select nvl(COMM,0) "COMM", nvl(COMM,0)+1000 "COMM2"   from EMP;

--sal 이 2000~3000 이 아닌경우 조회
select ENAME,SAL from emp where sal<2000 or sal>3000;
select ENAME,SAL from EMP where SAL not between 2000 and 3000;

--GROUP 함수 (COUNT,MAX,MIN,AVG,SUM)
select COUNT(*) from EMP; --전체 인원수
select max(SAL) from  EMP; --최고 연봉
select min(SAL) from EMP; --최소 연봉
select sum(sal) from EMP; --sal의 합계
select avg(SAL) from emp; --sal의 평균
--avg는 소숫점 이하가 많이 나오는 경우가 많아서 ROUND,CELL,FLOOR 등과 같이 많이 사용
select round(avg(SAL),2) from emp; --ROUND() 소수점 반올림
select CEIL(avg(SAL)) from emp;  --무조건 올림
select FLOOR(avg(SAL)) from emp; --무조건 내림

--job을 그룹으로 각 인원수를 구해보자
select JOB 직업, count(*) 인원수 from EMP group by JOB;

--위에 결과에 직업의 오름차순으로 출력
select JOB 직업, count(*) 인원수 from EMP group by JOB order by 직업; --컬럼명으로 순서정하기
select JOB 직업, count(*) 인원수 from EMP group by JOB order by 1; --컬럼번호로 순서 정ㅇ하기

select JOB 직업, count(*) 인원수 from EMP group by job order by 인원수;
select JOB 직업, count(*) 인원수 from EMP group by JOB order by 2;
select JOB 직업, count(*) 인원수 from EMP group by JOB order by count(*) asc;

--직업별 인원수와 최고연봉, 최저연봉, 평균연봉(무조건올림)
select JOB 직업,count(*) 인원수,MAX(SAL) 최고연봉, min(sal) 최저연봉, ceIl(avg(sal)) 평균연봉 from EMP group by JOB order by 2;

--HAVING 은 GROUO 절에서 그룹함수를 이용해서 조건을 나타낼경우
--직업별 인원수와 최고연봉을 구하는데 직업별 인원수가 3명 이상인 경우만 조회하시오
select JOB,count(*),max(SAL) from EMP group by JOB having count(job) >=3;

--오라클에서 현재 날짜를 구할때 SYSDATE,MYSQL 은 NOW()
select sysdate from dual; --현재 콘솔에 현재 날짜 출력
--3일뒤
select sysdate+3 from DUAL;
--30일 뒤
select sysdate+30 from dual;

--날짜타입을 문자열로 변환 to_char : 기호 Y,M,D,HH,HH24,MI,SS,AM/PM
select to_char(sysdate,'YYYY') from DUAL;
select to_char(sysdate,'MM') from DUAL;

--기호를 많이 쓰는데 다양한 기호로 날짜를 출력
select to_char(sysdate,'YYYY-MM-DD HH24:MI')from DUAL;

--emp에서 HIREDATE(낼짜타입) 이용해서 출력해보자
select ENAME, TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE from EMP;

--고용년이 1987 인 사람 출력
select * from EMP where to_char(HIREDATE, 'YYYY')='1987';
--고용월이 5월인 사람 출력
select * from EMP where to_char(HIREDATE,'MM') = '05';

--SUBQUERY (SELECT 문 안에 SELECT 문이 있는경우)
-- SMITH 의 연봉과 같은 연봉을 가진 사람으 ㄹ구하시오.
select * from EMP where SAL = (select SAL from EMP where ENAME like 'SCOTT' ) ;
--평균연봉보다 많은 사람으ㅢ 정보를 구하시오
select * from EMP where SAL >( select ceil(avg(SAL)) from EMP);


















