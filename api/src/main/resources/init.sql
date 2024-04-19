create database if not exists testdb;
use testdb;

-- 회원 테이블
create table testdb.company_member
(
    member_idx           int auto_increment                  primary key    comment '회원 고유 번호',
    member_birth_date    datetime(6)                         not null       comment '회원 생년월일',
    member_email         varchar(255)                        not null       comment '회원 이메일 주소',
    member_email_receive int                                 not null       comment '회원 이메일 수신 여부 (0: 비수신 1: 수신)',
    member_gender        varchar(255)                        not null       comment '회원 성별',
    member_id            varchar(255)                        not null       comment '회원 아이디',
    member_join_date     datetime(6)                         not null       comment '회원 가입일 (기본값: 현재 날짜)',
    member_name          varchar(255)                        not null       comment '회원 이름',
    member_pw            varchar(255)                        not null       comment '회원 비밀번호',
    member_pw_answer     varchar(255)                        not null       comment '회원 비밀번호 복구 질문 답변',
    member_pw_question   int                                 not null       comment '회원 비밀번호 복구 질문 선택 (0: 질문 미설정, 1: 질문 설정)',
    constraint UK_6kp3rcgdb5tblowq43ebky6co
        unique (member_email),
    constraint UK_cbgepx3lo4ef0b0dy74hvjop9
        unique (member_id)
) comment '회원 테이블';

desc company_member;

insert into testdb.company_member(
    member_birth_date, member_email, member_email_receive, member_gender, member_id, member_join_date, member_name, member_pw, member_pw_answer, member_pw_question
) values
      ('1990-01-01', 'example1@gmail.com', 1, '남자', 'user1', CURRENT_TIMESTAMP, '홍길동', '1234', '답변1', 1),
      ('1995-02-02', 'example2@gmail.com', 0, '여자', 'user2', CURRENT_TIMESTAMP, '김철수', '5678', '답변2', 1),
      ('1995-02-02', 'example3@gmail.com', 0, '여자', 'user3', CURRENT_TIMESTAMP, '김영희', '5678', '답변3', 1);

select * from company_member;

-- 관리자 테이블
drop table if exists company_member_admin;
create table testdb.company_member_admin
(
    member_idx       int auto_increment                  primary key    comment '관리자 고유 번호',
    member_email     varchar(255)                        not null       comment '관리자 이메일 주소',
    member_id        varchar(255)                        not null       comment '관리자 아이디',
    member_name      varchar(255)                        not null       comment '관리자 이름',
    member_pw        varchar(255)                        not null       comment '관리자 비밀번호',
    constraint UK_2huq255g70inepvgg7yq2g5eh
        unique (member_id),
    constraint UK_r5c5m7yd5biaym06dsrw85pk1
        unique (member_email)
) comment '관리자 테이블';


desc company_member_admin;

insert into testdb.company_member_admin (
    member_email,
    member_id,
    member_join_date,
    member_name,
    member_pw
) values
    ('admin@gmail.com', 'admin', CURRENT_TIMESTAMP, '관리자', '1234');

select * from company_member_admin;
select count(*) from company_member where member_id = 'admin' and member_pw = '1234';

commit;

-- 공지사항
drop table if exists company_notice;
create table testdb.company_notice
(
    notice_idx       int auto_increment                     primary key comment '공지사항 고유 번호',
    notice_content   varchar(2000)                          not null    comment '공지사항 내용',
    notice_date      timestamp default CURRENT_TIMESTAMP    not null    comment '공지사항 작성일 (기본값: 현재 날짜)',
    notice_member_id varchar(255)                           not null    comment '공지사항 작성자 아이디',
    notice_title     varchar(255)                           not null    comment '공지사항 제목'
) comment '공지사항 테이블';

desc company_notice;

insert into testdb.company_notice (
    notice_content, notice_date, notice_member_id, notice_title
) values
      ('내용입니다.1', CURRENT_TIMESTAMP, 'admin', '타이틀1'),
      ('내용입니다.2', CURRENT_TIMESTAMP, 'admin', '타이틀2'),
      ('내용입니다.3', CURRENT_TIMESTAMP, 'admin', '타이틀3');

select * from company_notice;
commit;

-- 1:1문의
drop table if exists company_one2one;
create table testdb.company_one2one
(
    one2one_idx     int auto_increment                  primary key     comment '1:1문의 고유 번호',
    one2one_address varchar(255)                        not null        comment '1:1문의 주소',
    one2one_content varchar(2000)                       not null        comment '1:1문의 내용',
    one2one_date    timestamp default CURRENT_TIMESTAMP not null        comment '1:1문의 작성일 (기본값: 현재 날짜)',
    one2one_email   varchar(255)                        not null        comment '1:1문의 이메일 주소',
    one2one_name    varchar(255)                        not null        comment '1:1문의 작성자 이름',
    one2one_phone   varchar(255)                        not null        comment '1:1문의 전화번호',
    one2one_title   varchar(255)                        not null        comment '1:1문의 제목'
) comment '1:1문의 테이블';

desc company_one2one;

insert into testdb.company_one2one (
    one2one_address, one2one_content, one2one_date, one2one_email, one2one_name, one2one_phone, one2one_title
) values
      ('주소1', '내용1', CURRENT_TIMESTAMP, 'example1@gmail.com', '홍길동', '010-1234-5678', '제목1'),
      ('주소2', '내용2', CURRENT_TIMESTAMP, 'example2@gmail.com', '김철수', '010-2345-6789', '제목2');

select * from company_one2one;
commit;

-- 묻고답하기
drop table if exists company_qna;
create table testdb.company_qna
(
    qna_idx     int auto_increment                  primary key     comment 'QNA 고유 번호',
    qna_content varchar(2000)                       not null        comment 'QNA 내용',
    qna_date    timestamp default CURRENT_TIMESTAMP not null        comment 'QNA 작성일 (기본값: 현재 날짜)',
    qna_name    varchar(255)                        not null        comment 'QNA 작성자 이름',
    qna_pw      varchar(255)                        not null        comment 'QNA 비밀번호',
    qna_title   varchar(255)                        not null        comment 'QNA 제목'
) comment 'QNA 테이블';

desc company_qna;

insert into testdb.company_qna (
    qna_content, qna_date, qna_name, qna_pw, qna_title
) values
      ('QNA내용1', CURRENT_TIMESTAMP, '홍길동', '1234', 'QNA제목1'),
      ('QNA내용2', CURRENT_TIMESTAMP, '김철수', '5678', 'QNA제목2');

select * from company_qna;
commit;

-- 제품목록
drop table if exists company_product;
create table testdb.company_product
(
    product_idx      int auto_increment                     primary key   comment '제품 고유 번호',
    product_content  varchar(2000)                          not null      comment '제품 설명',
    product_date     timestamp default CURRENT_TIMESTAMP    not null      comment '제품 등록일 (기본값: 현재 날짜)',
    product_img      varchar(255)                           not null      comment '제품 이미지 경로',
    product_name     varchar(255)                           not null      comment '제품 이름',
    product_reg_name varchar(255)                           not null      comment '제품 등록자 아이디'
) comment '제품 테이블';

desc company_product;

insert into testdb.company_product (
    product_content, product_date, product_img, product_name, product_reg_name
) values
      ('제품설명1', CURRENT_TIMESTAMP, 'img1.jpg', '제품1', 'admin'),
      ('제품설명2', CURRENT_TIMESTAMP, 'img2.jpg', '제품2', 'admin'),
      ('제품설명3', CURRENT_TIMESTAMP, 'img3.jpg', '제품3', 'admin');

select * from company_product;
commit
