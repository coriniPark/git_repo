create table member (
    name varchar2(30) not null,
    id varchar2(30) primary key, -- primary key => not null, unique
    pwd varchar2(30) not null,
    gender varchar2(3),
    email1 varchar2(20),
    email2 varchar2(10),
    tel1 varchar2(10),
    tel2 varchar2(10),
    tel3 varchar2(10),
    addr varchar2(100),
    logtime date
);

desc member; -- table 구조 확인

drop table member purge; -- table 삭제

select * from tab; -- table 확인

insert into member values 
('홍길동', 'hong', '1234', '남', 'hong','naver.com', '010','1234','5678',
'경기도 수원시', sysdate);  -- 데이터 추가 

select * from member;  -- 데이터 검색(전체 검색)

select * from member where id = 'hong'; -- 부분 검색

select * from member where id='park' and pwd='1234';

update member set tel2 = '2345' where id = 'hong'  ;-- 전화번호 변경

delete member where id = 'kim';  -- 데이터 삭제

select * from member where id = 'park';

commit;  -- DB 저장