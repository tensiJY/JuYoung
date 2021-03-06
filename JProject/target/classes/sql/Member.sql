drop table tbl_user;

create table tbl_user(
	u_no number not null,
	u_id varchar2(50) unique,
	u_pw varchar2(50) not null,
	u_name varchar2(100) not null,
	u_point number default 0,
	u_session varchar2(50) default 'none',
	u_sessionlimit Date default sysdate,
	constraint pk_uno primary key (u_no) 
);

insert into tbl_user(u_no, u_id, u_pw, u_name) values( (select nvl(max(u_no),0)+1 from tbl_user), 'user00', 'user00', 'iron man');
insert into tbl_user(u_no, u_id, u_pw, u_name) values( (select nvl(max(u_no),0)+1 from tbl_user), 'user01', 'user01', 'iron');
insert into tbl_user(u_no, u_id, u_pw, u_name) values( (select nvl(max(u_no),0)+1 from tbl_user), 'user02', 'user02', 'man');
insert into tbl_user(u_no, u_id, u_pw, u_name) values( (select nvl(max(u_no),0)+1 from tbl_user), 'user03', 'user03', 'na');
insert into tbl_user(u_no, u_id, u_pw, u_name) values( (select nvl(max(u_no),0)+1 from tbl_user), 'user04', 'user04', 'on man');
insert into tbl_user(u_no, u_id, u_pw, u_name) values( (select nvl(max(u_no),0)+1 from tbl_user), 'user05', 'user05', 'on man1');


select * from tbl_user

commit;
-- 포인트 증가
 		UPDATE TBL_USER SET 
 			U_POINT = U_POINT + 100 
 		WHERE
 			U_ID = 'user00';
