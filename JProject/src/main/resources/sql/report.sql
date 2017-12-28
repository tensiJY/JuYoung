-- drop table tbl_report;

create table tbl_report(
	r_no number not null,	-- 일련번호
    r_title varchar2(100) not null, -- 보고서명
	r_dname varchar2(100) not null, -- 부서명
	r_djob varchar2(100) not null, -- 직급
	r_date Date not null, --작성일
	r_name varchar2(100) not null, -- 작성자
	r_time1 varchar2(500) not null, -- 금일진행사항  업무시간1
	r_time2 varchar2(500) not null, -- 업무시간2
	r_time3 varchar2(500) not null, -- 업무시간3
	r_time4 varchar2(500) not null, -- 업무시간4
	r_time5 varchar2(500) not null, -- 업무시간5
	r_time6 varchar2(500) not null, -- 업무시간6
	r_educ varchar2(3000) not null, -- 차일 진행예정사항 교육및 학습
	r_prog varchar2(3000) not null, -- 업무보고서 프로그램
	r_summ varchar2(4000) not null, -- 금일 업무 결과 요약
	r_trou varchar2(4000) not null,
	r_isShow char(1) default 'Y' check (r_isShow in ('Y', 'N')),
	constraint pk_rno primary key(r_no)
);
select * from tbl_report where r_isShow = 'Y' order by r_no desc;

SELECT NVL(MAX(R_NO),0)+1 FROM TBL_REPORT;

-- 토탈 카운트
select count(r_no) from tbl_report where r_isshow='Y';