-- 게시판 테이블 생성
create table tbl_board (
	b_no number primary key,
	b_title varchar2(200) not null,
	b_content clob not null,
	b_writer varchar2(100) not null,
	b_regdate date not null,
	b_viewcnt number not null
)

-- 게시판 댓글 테이블 생성
create table tbl_reply( 
    r_no number not null,
    b_no number not null,
    r_replytext varchar2(2000) not null,
    r_replyer varchar2(1000) not null,
    r_regdate Date not null,
    r_updatedate Date not null,
    CONSTRAINT PK_rno PRIMARY KEY(r_no),
    constraint fk_bno foreign key(b_no) references tbl_board(b_no)
    )
    

-- 게시글 등록
insert into tbl_board values (
(select nvl(max(b_no), 0) + 1 from TBL_BOARD), '제목', '내용', '작성자', sysdate, 0);

select count(*) from tbl_board;

select * from tbl_board order By b_no desc;


-- 게시글 리스트 - 게시글 번호에 따른 댓글 개수 목록
select * from(
                select rownum as rno, t.* from
                    (select b_no, b_title , nvl(r.cnt, 0) as rcnt from TBL_BOARD , 
                        (select b_no as bno , count(*) as cnt from tbl_reply group by b_no) r 
                            where b_no = r.bno(+) order by b_no desc
                    )t
             ) where rno between 1 and 10


             
-- 게시글 상세보기 
select b_title as btitle, b_content as bcontent, b_writer as bwriter,
 b_regdate as bregdate, b_viewcnt as bviewcnt from TBL_board where b_no = 1

             
             
-- 게시글 번호에 따른 댓글 상세보기
select * from tbl_reply where b_no = 2 order by r_no desc

-- 게시글 번호에 따른 댓글 쓰기
insert into tbl_reply values( (select nvl(max(r_no),0)+1 from tbl_reply), 2, '내용', '작성자1', sysdate, sysdate);                
