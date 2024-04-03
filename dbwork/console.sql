SELECT username FROM dba_users;

create user scott identified BY tiger;
grant connect, resource to scott;


alter user angel default tablespace users quota unlimited on users;
alter user scott default tablespace users quota unlimited on users;

