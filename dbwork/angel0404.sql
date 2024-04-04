-- 자바 연습용 시퀀스 및 테이블 생성
create sequence seq_test nocache ;

create table person(
    pnum number(3) constraint pk_pnum primary key ,
    pname varchar2(20),
    pblood varchar2(5) default 'B',
    page number(3),
    ipsaday date
);

--5개 정도 데이터 추가
insert into PERSON values (SEQ_TEST.nextval,'이상순','A',34,'2010-12-20');
insert into PERSON values (SEQ_TEST.nextval,'강호동','O',21,'2008-03-20');
insert into PERSON values (SEQ_TEST.nextval,'유재석','A',29,sysdate);
insert into PERSON values (SEQ_TEST.nextval,'손미나','A',39,'2015-09-13');
insert into PERSON values (SEQ_TEST.nextval,'손지영','o',28,sysdate);
commit;
select * from PERSON;

select pnum,pname,upper(pblood) pblood,page,to_char(IPSADAY,'YYYY-mm-dd') ipsaday from PERSON;








