conn /as sysdba
create user juyoung identified by juyoung;
GRANT resource, connect TO juyoung;

-- 테이블 생성
create table tbl_board (
	b_no number primary key,
	b_title varchar2(200) not null,
	b_content clob not null,
	b_writer varchar2(100) not null,
	b_regdate date not null,
	b_viewcnt number not null
)

-- 게시글 등록
insert into tbl_board values (
(select nvl(max(b_no), 0) + 1 from TBL_BOARD), '제목', '내용', '작성자', sysdate, 0);

select count(*) from tbl_board;

select * from tbl_board order By b_no desc;


-- 상세보기 뷰
select b_title as btitle, b_content as bcontent, b_writer as bwriter,
 b_regdate as bregdate, b_viewcnt as bviewcnt from TBL_board where b_no = 1