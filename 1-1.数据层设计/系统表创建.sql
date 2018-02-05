--user
create tablespace hrsys datafile 'DT_HRSYS_01.dbf' size 500M autoextend on;
create user c##hrmgr identified by hrmgr default tablespace hrsys temporary tablespace temp;
grant connect,resource to c##hrmgr;
/*grant dba to c##hrmgr;*/
--tables
create table PRIV_USERS 
(
user_id number(9) primary key,
uname varchar(20) not null,
upwd varchar(100) not null
);
CREATE SEQUENCE PRIV_USERS_ID_SEQ MINVALUE 1 NOMAXVALUE INCREMENT BY 1 START WITH 100000000 NOCACHE;
CREATE OR REPLACE TRIGGER PRIV_USERS_INS_TRG BEFORE INSERT ON PRIV_USERS FOR EACH ROW WHEN(NEW.user_id IS NULL)
BEGIN
SELECT PRIV_USERS_ID_SEQ.NEXTVAL INTO :NEW.user_id FROM DUAL;
END;
--insert into PRIV_USERS (uname,upwd) values ('SYSTEM','SYSTEM');
