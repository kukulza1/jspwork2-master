create table addrbook(
      bnum number primary key,
      username varchar2(20) not null,
      tel      varchar2(20), 
      email    varchar2(30) unique, --이메일중복체크(유니크)
      gender   varchar2(6),
      regdate  Timestamp default Systimestamp
);
create sequence seq_bnum Nocache;

drop sequence seq_bnum;

insert into addrbook(bnum,username,tel,email,gender)
values(seq_bnum.NextVal,'ksb','000-1111-2222','www.@naver.com','남');

insert into addrbook(bnum,username,tel,email,gender)
values(seq_bnum.NextVal,'gsb','000-1111-2222','www.@naver.com','여');

select*from addrbook;
--이메일이 khit@kh.kr인 이메일찾기
select email from addrbook
where email='khit@kh.kr';
