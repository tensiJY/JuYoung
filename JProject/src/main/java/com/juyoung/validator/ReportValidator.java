package com.juyoung.validator;

import java.sql.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.juyoung.domain.ReportVO;
/**
 * 
 * @author  : 
 * @since   : 2017. 12. 28.
 * @version : 1.0
 * @see 
 *  == 개정이력(Modification Information) ==
 *   
 *  수정일             		   수정자   		  수정내용
 *  -------   		 --------    ---------------------------
 *  2017. 12. 28.				  최초생성			
 * 
 *
 */
public class ReportValidator implements Validator{
		
	private Date rdate;
	private String rname;
	private String rtime1;
	private String rtime2;
	private String rtime3;
	private String rtime4;
	private String rtime5;
	private String rtime6;
	private String reduc;
	private String rprog;
	private String rsumm;
	private String rtrou;
	
	
	@Override
	public boolean supports(Class<?> arg0) {
		
		return ReportVO.class.isAssignableFrom(arg0);
	}
	

	@Override
	public void validate(Object arg0, Errors arg1) {
		ReportVO rvo = (ReportVO) arg0;
		this.rdate = rvo.getRdate();
		this.rname = rvo.getRname();
		this.rtime1 = rvo.getRtime1();
		this.rtime2 = rvo.getRtime2();
		this.rtime3 = rvo.getRtime3();
		this.rtime4 = rvo.getRtime4();
		this.rtime5 = rvo.getRtime5();
		this.rtime6 = rvo.getRtime6();
		this.reduc = rvo.getReduc();
		this.rprog = rvo.getRprog();
		this.rsumm = rvo.getRsumm();
		this.rtrou = rvo.getRtrou();
		
		if(rdate == null) arg1.reject("00", "rdate null");
		
		if(rname == null || rname.trim().length()==0){
			arg1.reject("01", "rname null");
		}
		
		if(rtime1 == null || rtime1.trim().length()==0){
			arg1.reject("02", "rtime1 null");
		}
		
		if(rtime2 == null || rtime2.trim().length()==0){
			arg1.reject("03", "rtime2 null");
		}
		
		if(rtime3 == null || rtime3.trim().length()==0){
			arg1.reject("04", "rtime3 null");
		}
		
		if(rtime4 == null || rtime4.trim().length()==0){
			arg1.reject("05", "rtime4 null");
		}
		
		if(rtime5 == null || rtime5.trim().length()==0){
			arg1.reject("06", "rtime5 null");
		}
		
		if(rtime6 == null || rtime6.trim().length()==0){
			arg1.reject("07", "rtime6 null");
		}
		
		if(reduc == null || reduc.trim().length() == 0){
			arg1.reject("08", "reduc null");
		}
		
		if(rprog == null || rprog.trim().length() == 0){
			arg1.reject("09", "rprog null");
		}
		
		
		if(rsumm == null || rsumm.trim().length() == 0){
			arg1.reject("10", "rsumm null");
		}
		
		if(rtrou== null || rtrou.trim().length() == 0){
			arg1.reject("11", "rtrou null");
		}
	}// validate method end;
	
	
	
}// class end;
