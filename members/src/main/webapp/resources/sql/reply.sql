create table reply(
   rno number primary key,                  --댓글번호
   rcontent varchar2(2000) not null,        --댓글내용
   replyer  varchar2(20) not null,          --작성자
   rdate    Timestamp default systimestamp,  --작성일
   rupdate    Timestamp,                    --수정일
   bno number not null,                    --게시글번호
    foreign key(bno) references board(bno) on delete cascade
);
create sequence seq_ss nocache;

select*from board where bno = 5;
select*from reply;
insert into reply(rno, rcontent, replyer, bno) 
    				 values(seq_ss.nextVal , 'ss' , '33' , 5);

--5번게시글에 댓글달기
insert into reply(rno,rcontent,replyer,bno)
values(seq_ss.nextVal,'dfg3','hh2',5);

insert into reply(rno,rcontent,replyer,bno)
values(seq_ss.nextVal,'두번째댓글','kkk',5);

--댓글1번삭제
delete from reply where rno=1;

commit;

drop table reply;
drop sequence seq_ss;