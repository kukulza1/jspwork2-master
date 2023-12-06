create table board(
    bno            number primary key,
    title          varchar2(100) not null,
    content        clob not null,
    createdate     timestamp default Systimestamp,
    modifydate     timestamp,
    hit            number default 0,
    filename       varchar2(50),
    memid          varchar2(20) not null,
    foreign key(memid) references member(memid) on delete cascade

);

create sequence seq_bno nocache;

insert into board(bno, title, content, memid)
values(seq_bno.nextval,'글제목','글내용입니다','kkk');
commit;
select *from board;

delete from board where bno=3;


update board set title='1234', content='222' where bno=5;


update board set hit= hit+1 where bno=10;



drop sequence seq_bno;
drop table board;