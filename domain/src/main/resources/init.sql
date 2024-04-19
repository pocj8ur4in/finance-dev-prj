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

INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (1, 1, 1, '1990-01-01 00:00:00.021371', '1990-01-01', 'example1@example.com', 'Male', 'user01', 'John Doe', 'password123', 'answer1');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (1, 2, 1, '1995-05-15 00:00:00.699790', '1995-05-15', 'example2@example.com', 'Female', 'user02', 'Jane Smith', 'password456', 'answer2');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (0, 3, 0, '1988-09-30 00:00:00.699790', '1988-09-30', 'example3@example.com', 'Male', 'user03', 'Mark Johnson', 'password789', 'answer3');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (1, 4, 1, '1982-03-20 00:00:00.699790', '1982-03-20', 'example4@example.com', 'Female', 'user04', 'Emily Wilson', 'passwordabc', 'answer4');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (0, 5, 0, '1998-11-10 00:00:00.699790', '1998-11-10', 'example5@example.com', 'Male', 'user05', 'Michael Brown', 'passworddef', 'answer5');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (1, 6, 1, '1993-07-25 00:00:00.699790', '1993-07-25', 'example6@example.com', 'Female', 'user06', 'Sophia Martinez', 'passwordghi', 'answer6');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (0, 7, 0, '1975-12-05 00:00:00.021371', '1975-12-05', 'example7@example.com', 'Male', 'user07', 'Christopher Taylor', 'passwordjkl', 'answer7');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (1, 8, 1, '1986-04-15 00:00:00.699790', '1986-04-15', 'example8@example.com', 'Female', 'user08', 'Jessica Anderson', 'passwordmno', 'answer8');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (1, 9, 1, '1991-08-20 00:00:00.021371', '1991-08-20', 'example9@example.com', 'Male', 'user09', 'David Thomas', 'passwordpqr', 'answer9');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (0, 10, 0, '1979-06-30 00:00:00.699790', '1979-06-30', 'example10@example.com', 'Female', 'user10', 'Jennifer Wilson', 'passwordstu', 'answer10');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (0, 11, 0, '2024-04-22 02:53:03.699790', '2023-03-22', 'string@email.com', 'string', 'string', 'string', 'string123!', 'string');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (1, 12, 1, '2024-04-22 03:06:24.021371', '2023-03-22', 'test@test.com', 'male', 'test1234', 'test', 'test1234!', 'test');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (1, 13, 1, '2024-04-22 05:31:11.099728', '2024-04-16', 'user12@example.com', 'male', 'user12', 'user12', 'testuser12', '서울');
INSERT INTO testdb.company_member (member_email_receive, member_idx, member_pw_question, member_join_date, member_birth_date, member_email, member_gender, member_id, member_name, member_pw, member_pw_answer) VALUES (1, 14, 1, '2024-04-22 05:53:54.020464', '2024-04-22', 'user13@example.com', 'male', 'user13', 'user13', 'user13user13!', '서울');

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

INSERT INTO testdb.company_member_admin (member_idx, member_email, member_id, member_name, member_pw, member_join_date) VALUES (1, 'admin@gmail.com', 'admin', '관리자0', '1234', '2024-04-21');
INSERT INTO testdb.company_member_admin (member_idx, member_email, member_id, member_name, member_pw, member_join_date) VALUES (2, 'admin1@gmail.com', 'admin1', '관리자1', '1234', '1995-05-15');
INSERT INTO testdb.company_member_admin (member_idx, member_email, member_id, member_name, member_pw, member_join_date) VALUES (3, 'admin2@gmail.com', 'admin2', '관리자2', '1234', '1995-06-15');
INSERT INTO testdb.company_member_admin (member_idx, member_email, member_id, member_name, member_pw, member_join_date) VALUES (4, 'admin3@gmail.com', 'admin3', '관리자3', '1234', '1985-05-15');
INSERT INTO testdb.company_member_admin (member_idx, member_email, member_id, member_name, member_pw, member_join_date) VALUES (5, 'admin4@gmail.com', 'admin4', '관리자4', '1234', '2024-01-21');
INSERT INTO testdb.company_member_admin (member_idx, member_email, member_id, member_name, member_pw, member_join_date) VALUES (6, 'admin5@gmail.com', 'admin5', '관리자5', '1234', '2024-04-10');
INSERT INTO testdb.company_member_admin (member_idx, member_email, member_id, member_name, member_pw, member_join_date) VALUES (7, 'admin6@gmail.com', 'admin6', '관리자6', '1234', '2023-04-21');
INSERT INTO testdb.company_member_admin (member_idx, member_email, member_id, member_name, member_pw, member_join_date) VALUES (8, 'admin7@gmail.com', 'admin7', '관리자7', '1234', '2011-11-11');
INSERT INTO testdb.company_member_admin (member_idx, member_email, member_id, member_name, member_pw, member_join_date) VALUES (9, 'admin8@gmail.com', 'admin8', '관리자8', '1234', '2001-01-01');

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

INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (1, '2024-04-19 07:48:15', '내용입니다.1', 'admin', '타이틀1');
INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (2, '2024-04-19 07:48:15', '내용입니다.2', 'admin', '타이틀2');
INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (3, '2024-04-19 07:48:15', '내용입니다.3 (수정)', 'admin', '타이틀3 (수정)');
INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (4, '2024-04-21 23:38:03.365193', '공지사항 테스트입니다.', 'admin', '공지사항 테스트');
INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (5, '2024-04-22 06:10:32.774490', '공지1', 'admin', '공지');
INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (6, '2024-04-22 09:06:55.688690', '공지입니다!', 'admin', '공지');
INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (7, '2024-04-22 09:18:48.791766', '공지2예요.', 'admin', '공지2');
INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (8, '2024-04-22 09:29:33.068202', '공지예시', 'admin', '공지예시');
INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (9, '2024-04-22 09:29:55.555532', '공지템플릿1', 'admin', '공지템플릿1');
INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (10, '2024-04-22 09:30:11.611651', '공지111', 'admin', '공지11');
INSERT INTO testdb.company_notice (notice_idx, notice_date, notice_content, notice_member_id, notice_title) VALUES (11, '2024-04-22 09:30:58.336968', '타이틀4', 'admin', '타이틀4');

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

INSERT INTO testdb.company_one2one (one2one_idx, one2one_content, one2one_address, one2one_date, one2one_email, one2one_name, one2one_phone, one2one_title) VALUES (1, '내용1', '주소1', '2024-04-19 07:48:17', 'example1@gmail.com', '홍길동', '010-1234-5678', '제목1');
INSERT INTO testdb.company_one2one (one2one_idx, one2one_content, one2one_address, one2one_date, one2one_email, one2one_name, one2one_phone, one2one_title) VALUES (2, '내용2', '주소2', '2024-04-19 07:48:17', 'example2@gmail.com', '김철수', '010-2345-6789', '제목2');
INSERT INTO testdb.company_one2one (one2one_idx, one2one_content, one2one_address, one2one_date, one2one_email, one2one_name, one2one_phone, one2one_title) VALUES (3, '내용3', '주소3', '2024-04-19 07:48:17', 'test@gmail.com', '김철수', '010-1234-5678', '제목3');
INSERT INTO testdb.company_one2one (one2one_idx, one2one_content, one2one_address, one2one_date, one2one_email, one2one_name, one2one_phone, one2one_title) VALUES (4, '내용4', '주소4', '2024-04-19 07:48:17', 'test@gmail.com', '홍길동', '010-1234-5678', '제목4');
INSERT INTO testdb.company_one2one (one2one_idx, one2one_content, one2one_address, one2one_date, one2one_email, one2one_name, one2one_phone, one2one_title) VALUES (5, '내용', '주소', '2024-04-19 07:48:17', 'test@gmail.com', '홍길동', '010-2345-6789', '제목');

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

INSERT INTO testdb.company_qna (qna_idx, qna_date, qna_content, qna_name, qna_pw, qna_title) VALUES (1, '2024-04-19 07:48:18', 'QNA내용1', '홍길동', '1234', 'QNA제목1');
INSERT INTO testdb.company_qna (qna_idx, qna_date, qna_content, qna_name, qna_pw, qna_title) VALUES (2, '2024-04-19 07:48:18', 'QNA내용2', '김철수', '5678', 'QNA제목2');
INSERT INTO testdb.company_qna (qna_idx, qna_date, qna_content, qna_name, qna_pw, qna_title) VALUES (3, '2024-04-19 07:48:18', 'QNA내용2', '김철수', '5678', 'QNA제목3');
INSERT INTO testdb.company_qna (qna_idx, qna_date, qna_content, qna_name, qna_pw, qna_title) VALUES (4, '2024-04-19 07:48:18', 'QNA내용2', '김철수', '5678', 'QNA제목4');
INSERT INTO testdb.company_qna (qna_idx, qna_date, qna_content, qna_name, qna_pw, qna_title) VALUES (5, '2024-04-19 07:48:18', 'QNA내용1', '홍길동', '1234', 'QNA제목5');

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
