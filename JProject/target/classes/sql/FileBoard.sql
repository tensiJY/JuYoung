	1)		기본 게시물 정보를 기억할 테이블
			
			CREATE TABLE UploadBoard
			(
				ub_NO		NUMBER(5),
				ub_Title	VARCHAR2(100),
				ub_Writer	VARCHAR2(100),
				ub_Body	VARCHAR2(2000),
				ub_Date	Date,
				ub_Hit		NUMBER(5),
				ub_Pw		VARCHAR2(100),
				ub_IsShow	CHAR(1)
			);

	2)		게시물에 업로드된 파일의 정보를 기억할 테이블
			(만약 한 게시물에 한개의 파일만 업로드하는 규칙이라면
			굳이 따로 테이블을 만들 필요는 없다.)

			CREATE TABLE UploadFile
			(
				uf_NO				NUMBER(5),
				uf_OriNo			NUMBER(5),
				uf_OriName		VARCHAR2(100),
				uf_SaveName		VARCHAR2(100),		--	필수
				uf_Length			NUMBER(10),
				uf_Path			VARCHAR2(100),
				uf_Download		NUMBER(5),
				uf_Date			Date					--	이 파일이 업로드된 날짜
			);
			
	<!--	라이브러리 빈 선언	-->
    <beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<!--	파일 업로드 환경 설정	-->
        <beans:property name="maxUploadSize" value="1000000000" />
        <beans:property name="maxInMemorySize" value="1000000000" />
		<beans:property name="defaultEncoding" value="UTF-8" />
    </beans:bean>				
-- 다운로드 뷰			
	<bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<property name="order" value="0"/>
	</bean>			