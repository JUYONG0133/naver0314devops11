create table myshop(
    shopidx smallint auto_increment primary key,
    sname varchar(30),
    sprice int,
    scount int,
    scolor varchar(20),
    sphoto varchar(100),
    writeday datetime
);

select * from myshop;

create table mysawon(
    num smallint auto_increment primary key,
    name varchar(20),
    buseo varchar(20),
    age smallint,
    addr varchar(100),
    photo varchar(100),
    gender varchar(10),
    birthday varchar(20)
);
select * from mysawon;

drop table mysawon;


select gender,count(*) count,round(avg(age),1) age from mysawon group by gender;

select buseo,count(*) count,round(avg(age),1) age from mysawon group by buseo;



create table mystudent(
    num smallint auto_increment primary key ,
    name varchar(20),
    blood varchar(3),
    license char(1),
    java smallint,
    spring smallint,
    html smallint,
    writeday datetime
);
update mystudent set name='강호동', blood='A', license='n', java='100', spring=100, html=100,writeday=now() where num=2;

create table mymemo(
    num smallint auto_increment primary key ,
    uploadphoto varchar(30),
    title varchar(100),
    content varchar(1000),
    writeday datetime
);


    create table user(
        userid varchar(20) primary key ,
        userpassword varchar(20),
        username varchar(20),
        usergender varchar(20)

    );
    create table caroption(
        num smallint auto_increment primary key ,
        userid varchar(20),
        carname varchar(20),
        wheel varchar(100),
        nav varchar(100),
        carkey varchar(100),
        caroption varchar(1000),
        etc varchar(100),
        writeday datetime,
        foreign key (userid) references user(userid)

    );




select * from caroption where num=5;
drop table caroption;
drop table user;



create table guest(
    num smallint auto_increment primary key ,
    nickname varchar(20),
    avata varchar(50),
    content varchar(1000),
    writeday datetime
);


create table simpleboard(
    num smallint auto_increment primary key ,
    writer varchar(20),
    avata varchar(20),
    subject varchar(200),
    content varchar(3000),
    readcount smallint default 0,
    chu smallint default 0,
    writeday datetime
);


