drop table tbl_message;

create table tbl_message(
	me_no number not null,	-- 메시지 번호
	me_sender varchar2(50) not null,	-- 보내는 사람 id
	me_receiver varchar2(50) not null, -- 받는 사람 id
	me_text varchar2(2000) not null, -- 내용
	me_senddate Date default sysdate not null, -- 보낸날짜
	me_readdate Date,
	me_isShow char(1) default 'Y' check(me_isShow in('Y', 'N')),
	constraint pk_meno primary key(me_no)	
);	

-- 메시지 일련번호 생성
select nvl(max(me_no),0)+1 from tbl_message;
-- 메시지 보내기(저장)
insert into TBL_MESSAGE (me_no, me_sender, me_receiver, me_text) values
((select nvl(max(me_no),0)+1 from tbl_message) , 'user00', 'user01', '내용');
-- 메시지 수
SELECT count(ME_NO) AS CNT FROM TBL_MESSAGE WHERE ME_RECEIVER = 'user00';
-- 메시지 리스트


