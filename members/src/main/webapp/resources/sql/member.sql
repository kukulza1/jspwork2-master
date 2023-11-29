--jweb member 테이블 생성
create table member(
    mno    int, 
    memid  varchar2(20) not null unique,
    pw      varchar2(20) not null,
    name    varchar2(30) not null,
    email   varchar2(40),
    gender  varchar2(8),
    joindate Timestamp default systimestamp,
    primary key(mno)
);

create sequence seq_mno nocache;

insert into member(mno,memid,pw,name,email,gender)
values(seq_mno.nextVal,'khit','m1234567','KSB','www.naver.com','남');

select*from member;

commit;

drop table member;
drop sequence seq_mno;