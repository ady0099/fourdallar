package admin;

import java.io.Serializable;
import java.util.List;


public class Protocol implements Serializable{
	/*
		cmd 0 -> 종료(접속해제)
		
		cmd 601-> 회원관리 DB 전체보기
		cmd 602-> 회원관리 ID로 회원검색해서 정보 보기(1명만)
		cmd 603
		
		cmd 611 -> 영화관리 DB 전체보기
	*/
	int cmd;
	int result ;
	List<CustomerVO> list;
	CustomerVO vo ;
//	List<MovieScheduleVO> list2;
//	MovieScheduleVO vo2;
//	
//	public List<MovieScheduleVO> getList2() {
//		return list2;
//	}
//	public void setList2(List<MovieScheduleVO> list2) {
//		this.list2 = list2;
//	}
//	public MovieScheduleVO getVo2() {
//		return vo2;
//	}
//	public void setVo2(MovieScheduleVO vo2) {
//		this.vo2 = vo2;
//	}
	
	
	
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<CustomerVO> getList() {
		return list;
	}
	public void setList(List<CustomerVO> list) {
		this.list = list;
	}
	public CustomerVO getVo() {
		return vo;
	}
	public void setVo(CustomerVO vo) {
		this.vo = vo;
	}
	
	
}
