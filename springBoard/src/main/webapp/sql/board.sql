
-- 글 관리 table
create table board (
    seq number not null,                --글번호
    id varchar2(20) not null,           --아이디
    name varchar2(20) not null,         --이름
    subject varchar2(255) not null,     --제목
    content varchar2(4000) not null,    --내용    
    hit number default 0,               --조회수
    logtime date default sysdate        --작성일
);
drop table board purge;

select * from tab; --전체 테이블 확인
create sequence seq_board nocache nocycle; --시퀀스 객체 생성
drop sequence seq_board; -- 시퀀스 객체 삭제

insert into board values  
    (seq_board.nextval, 'num1', '홍길동', '내일은', '즐거운 토요일', 0, sysdate); --데이터 저장
select * from board; --데이터 전체 검색
select * from board where seq=1;

update board set subject='오늘은' where seq=1;
delete board where sql=1;

commit;