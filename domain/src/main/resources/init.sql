CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;

-- 회원 테이블
DROP TABLE IF EXISTS company_member;
CREATE TABLE company_member(
        member_idx INT PRIMARY KEY AUTO_INCREMENT COMMENT '회원 고유 번호',
        member_id VARCHAR(20) UNIQUE NOT NULL COMMENT '회원 아이디',
        member_pw VARCHAR(20) NOT NULL COMMENT '회원 비밀번호',
        member_name VARCHAR(20) NOT NULL COMMENT '회원 이름',
        member_email VARCHAR(100) UNIQUE NOT NULL COMMENT '회원 이메일 주소',
        member_email_receive INT NOT NULL COMMENT '회원 이메일 수신 여부 (0: 비수신 1: 수신)',
        member_pw_question INT NOT NULL COMMENT '회원 비밀번호 복구 질문 선택 (0: 질문 미설정, 1: 질문 설정)',
        member_pw_answer VARCHAR(100) NOT NULL COMMENT '회원 비밀번호 복구 질문 답변',
        member_gender VARCHAR(10) NOT NULL COMMENT '회원 성별',
        member_birth_date DATE NOT NULL COMMENT '회원 생년월일',
        member_join_date DATE NOT NULL DEFAULT (CURRENT_DATE) COMMENT '회원 가입일 (기본값: 현재 날짜)'
) COMMENT '회원 테이블';

DESC company_member;

INSERT INTO company_member(member_idx, member_id, member_pw, member_name, member_email, member_email_receive, member_pw_question, member_pw_answer, member_gender, member_birth_date, member_join_date)
VALUES
    (0, 'hong', '1234', '홍길동', 'test@gmail.com', 0,0,0,'male','2000/01/01', now());

SELECT * FROM company_member;

-- 관리자 테이블
DROP TABLE IF EXISTS company_member_admin;
CREATE TABLE company_member_admin(
        member_idx INT PRIMARY KEY AUTO_INCREMENT COMMENT '관리자 고유 번호',
        member_id VARCHAR(20) UNIQUE NOT NULL COMMENT '관리자 아이디',
        member_pw VARCHAR(20) NOT NULL COMMENT '관리자 비밀번호',
        member_name VARCHAR(20) NOT NULL COMMENT '관리자 이름',
        member_email VARCHAR(100) UNIQUE NOT NULL COMMENT '관리자 이메일 주소',
        member_join_date DATE NOT NULL DEFAULT (CURRENT_DATE) COMMENT '관리자 가입일 (기본값: 현재 날짜)'
) COMMENT '관리자 테이블';

DESC company_member_admin;

INSERT INTO company_member_admin(member_idx, member_id, member_pw, member_name, member_email, member_join_date)
VALUES
    (0, 'admin', '1234', '관리자', 'admin@gmail.com', now());

SELECT * FROM company_member_admin;

SELECT COUNT(*) FROM company_member_admin WHERE member_id = 'admin' AND member_pw = '1234';
commit;

-- 공지사항
DROP TABLE IF EXISTS company_notice;
CREATE TABLE company_notice(
        notice_idx INT PRIMARY KEY AUTO_INCREMENT COMMENT '공지사항 고유 번호',
        notice_title VARCHAR(100) NOT NULL COMMENT '공지사항 제목',
        notice_content VARCHAR(2000) NOT NULL COMMENT '공지사항 내용',
        notice_member_id VARCHAR(20) NOT NULL COMMENT '공지사항 작성자 아이디',
        notice_date DATE NOT NULL DEFAULT (CURRENT_DATE) COMMENT '공지사항 작성일 (기본값: 현재 날짜)'
) COMMENT '공지사항 테이블';

DESC company_notice;

INSERT INTO company_notice(notice_idx, notice_title, notice_content, notice_member_id, notice_date)
VALUES
    (0, '타이틀1', '내용입니다.1', 'admin', now()),
    (0, '타이틀2', '내용입니다.2', 'admin', now()),
    (0, '타이틀3', '내용입니다.3', 'admin', now());

SELECT * FROM company_notice;
COMMIT;

-- FAQ
DROP TABLE IF EXISTS company_faq;
CREATE TABLE company_faq(
        faq_idx INT PRIMARY KEY AUTO_INCREMENT COMMENT 'FAQ 고유 번호',
        faq_title varchar(100) NOT NULL COMMENT 'FAQ 제목',
        faq_content varchar(2000) NOT NULL COMMENT 'FAQ 내용'
) COMMENT 'FAQ 테이블';

DESC company_faq;

INSERT INTO company_faq(faq_idx, faq_title, faq_content)
VALUES
    (0, '제목1', '내용1');

SELECT * FROM company_faq;
COMMIT;

-- 1:1문의
DROP TABLE IF EXISTS company_one2one;
CREATE TABLE company_one2one(
        one2one_idx INT PRIMARY KEY AUTO_INCREMENT COMMENT '1:1문의 고유 번호',
        one2one_name VARCHAR(20) NOT NULL COMMENT '1:1문의 작성자 이름',
        one2one_phone VARCHAR(20) NOT NULL COMMENT '1:1문의 작성자 전화번호',
        one2one_email VARCHAR(100) NOT NULL COMMENT '1:1문의 작성자 이메일 주소',
        one2one_address VARCHAR(100) NOT NULL COMMENT '1:1문의 작성자 주소',
        one2one_title VARCHAR(100) NOT NULL COMMENT '1:1문의 제목',
        one2one_content VARCHAR(2000) NOT NULL COMMENT '1:1문의 내용',
        one2one_date DATE NOT NULL DEFAULT (CURRENT_DATE) COMMENT '1:1문의 작성일 (기본값: 현재 날짜)'
) COMMENT '1:1문의 테이블';

DESC company_one2one;

INSERT INTO company_one2one(one2one_idx, one2one_name, one2one_phone, one2one_email, one2one_address, one2one_title, one2one_content, one2one_date)
VALUES
    (0,'홍길동','010-1111-2222','hong@gmail.com','한양','제목1','내용1', now());

SELECT * FROM company_one2one;
COMMIT;

-- 1:1문의 답글
DROP TABLE IF EXISTS company_one2one_reply;
CREATE TABLE company_one2one_reply(
        one2one_reply_idx INT PRIMARY KEY AUTO_INCREMENT COMMENT '1:1문의 답글 고유 번호',
        one2one_reply_content VARCHAR(2000) NOT NULL COMMENT '1:1문의 답글 내용',
        one2one_reply_name VARCHAR(20) NOT NULL COMMENT '1:1문의 답글 작성자 이름',
        one2one_reply_date DATE NOT NULL DEFAULT (CURRENT_DATE) COMMENT '1:1문의 답글 작성일 (기본값: 현재 날짜)',
        one2one_reply_one2one_idx INT NOT NULL COMMENT '1:1문의 답글 1:1문의 인덱스'
) COMMENT '1:1문의 답글 테이블';

DESC company_one2one_reply;

INSERT INTO company_one2one_reply(one2one_reply_idx, one2one_reply_content, one2one_reply_name, one2one_reply_date, one2one_reply_one2one_idx)
VALUES
    (0,'1:1문의답글내용','admin', now(), 1);

SELECT * FROM company_one2one_reply;
COMMIT;

-- 묻고답하기
DROP TABLE IF EXISTS company_qna;
CREATE TABLE company_qna(
        qna_idx INT PRIMARY KEY AUTO_INCREMENT COMMENT 'QNA 고유 번호',
        qna_name VARCHAR(20) NOT NULL COMMENT 'QNA 작성자 이름',
        qna_pw VARCHAR(20) NOT NULL COMMENT 'QNA 비밀번호',
        qna_title VARCHAR(100) NOT NULL COMMENT 'QNA 제목',
        qna_content VARCHAR(2000) NOT NULL COMMENT 'QNA 내용',
        qna_date DATE NOT NULL DEFAULT (CURRENT_DATE) COMMENT 'QNA 작성일 (기본값: 현재 날짜)'
) COMMENT 'QNA 테이블';

DESC company_qna;

INSERT INTO company_qna(qna_idx, qna_name, qna_pw, qna_title, qna_content, qna_date)
VALUES
    (0,'홍길동','1234','제목1','내용1', now());

SELECT * FROM company_qna;
COMMIT;

-- 묻고답하기 답글
DROP TABLE IF EXISTS company_qna_reply;
CREATE TABLE company_qna_reply(
        qna_reply_idx INT PRIMARY KEY AUTO_INCREMENT COMMENT 'QNA 답글 고유 번호',
        qna_reply_content VARCHAR(2000) NOT NULL COMMENT 'QNA 답글 내용',
        qna_reply_name VARCHAR(20) NOT NULL COMMENT 'QNA 답글 작성자 이름',
        qna_reply_date DATE NOT NULL DEFAULT (CURRENT_DATE) COMMENT 'QNA 답글 작성일 (기본값: 현재 날짜)',
        qna_reply_qna_idx INT NOT NULL COMMENT 'QNA 답글 QNA 인덱스'
);

DESC company_qna_reply;

INSERT INTO company_qna_reply(qna_reply_idx, qna_reply_content, qna_reply_name, qna_reply_date, qna_reply_qna_idx)
VALUES
    (0,'QNA문의 답글내용','admin', now(), 1);

SELECT * FROM company_qna_reply;
COMMIT;

-- 제품목록
DROP TABLE IF EXISTS company_product;
CREATE TABLE company_product(
        product_idx INT PRIMARY KEY AUTO_INCREMENT COMMENT '제품 고유 번호',
        product_name VARCHAR(100) NOT NULL COMMENT '제품 이름',
        product_content VARCHAR(2000) NOT NULL COMMENT '제품 설명',
        product_img VARCHAR(100) NOT NULL COMMENT '제품 이미지 경로',
        product_reg_name VARCHAR(20) NOT NULL COMMENT '제품 등록자 아이디',
        product_date DATE NOT NULL DEFAULT (CURRENT_DATE) COMMENT '제품 등록일 (기본값: 현재 날짜)'
);

DESC company_product;

INSERT INTO company_product(product_idx, product_name, product_content, product_img, product_reg_name, product_date)
VALUES
    (0,'제품이름1','제품설명1','/img/product/1.jpg','admin',now());

SELECT * FROM company_product;
COMMIT;
