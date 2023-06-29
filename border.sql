SELECT * FROM test;

SELECT * FROM border;


SELECT * FROM comment;

CREATE VIEW reply as
SELECT bnum, COUNT(bnum) rp_cnt
FROM comment
GROUP BY bnum; 



CREATE VIEW border_rp as
SELECT b.bnum, b.title,b.writer ,b.content, r.rp_cnt
FROM border b
left JOIN reply r ON b.bnum = r.bnum;


SELECT * from border_rp;

DROP VIEW border_rp;


DROP TABLE border;

CREATE TABLE border(
	bnum INT PRIMARY KEY,
	id VARCHAR(50),
	title VARCHAR(200),
	writer VARCHAR(50),
	DATE DATE,
	modify_date DATE,
	content VARCHAR(1000)
);

CREATE TABLE MEMBER(
	id VARCHAR(50) PRIMARY key,
	NAME VARCHAR(100),
	pw VARCHAR(100),
	tel VARCHAR(100),
	addr VARCHAR(100)

);




DROP TABLE MEMBER;

CREATE TABLE comment(
	cnum INT PRIMARY KEY,
	id VARCHAR(50),
	content VARCHAR(500),
	writer VARCHAR(50),
	c_date DATE,
	c_modify_date DATE,
	bnum int

);
-- 기능 --

-- 전체 조회 --
SELECT * FROM border;
SELECT * FROM comment;
SELECT * FROM reply;

-- 1행 조회 --
SELECT * FROM border WHERE bnum = 1;
SELECT * FROM comment WHERE cnum = 1;


-- 추가 --
INSERT INTO border VALUES(1,'admin','안녕하새요.', '관리자','2023-06-29' ,'2023-06-29','첫글이요');

INSERT INTO MEMBER VALUES('관리자', 'admin','123','01011112222','부산 부전동');

INSERT INTO comment VALUES(1,'admin','안녕하세요.', '관리자','2023-06-29' ,'2023-06-29','1');

-- 수정 --
UPDATE border SET title = '첫글이요', content =  '안녕하세요', modify_date = '2023-06-30' WHERE bnum = 1; 

UPDATE comment SET  content =  '안녕하세요', c_modify_date = '2023-06-30' WHERE cnum = 1; 

-- 삭제 --
 DELETE FROM border WHERE bnum = 1;
 DELETE FROM comment WHERE cnum = 1;
 
-- create view --
CREATE VIEW rp_cnt as
SELECT bnum, COUNT(bnum) rp_cnt
FROM comment
GROUP BY bnum;

CREATE VIEW reply AS
SELECT b.bnum, b.id, b.title, b.writer, b.DATE, b.modify_date, b.content, c.rp_cnt
FROM border b
LEFT JOIN rp_cnt c
on b.bnum = c.bnum;


-- table 삭제 --
DROP TABLE border;
DROP TABLE comment;
DROP TABLE MEMBER;
DROP view reply;
DROP view rp_cnt;
