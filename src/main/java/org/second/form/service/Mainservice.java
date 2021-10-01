package org.second.form.service;

import java.util.List;

import org.second.form.dao.SecondTestDAO;
import org.second.form.dto.CommCode;
import org.second.form.dto.Crd;
import org.second.form.dto.Cust;
import org.second.form.dto.CustJoinBill;
import org.second.form.dto.Rcvappl;
import org.second.form.dto.RcvapplJoinCustJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class Mainservice {
	
	@Autowired
	private SecondTestDAO dao;
	
	public List<CommCode> getCommCode(ModelAndView mav, String path) {
		List<CommCode> commCodeList = dao.getCommCode();
		mav.addObject("commCodeList", commCodeList);
		mav.setViewName(path);
		
		return commCodeList;
	}
	
	public Rcvappl selectRcvappl(ModelAndView mav, Integer no) {
		int no1 = (int)no;
		Rcvappl rcvappl = dao.selectRcvappl(no1);
		mav.addObject("rcvappl", rcvappl);
		
		return rcvappl;
	}
	
	public List<Rcvappl> selectRcvapplList(Rcvappl rcvappl) {
		List<Rcvappl> rcvapplList = dao.selectRcvapplList(rcvappl);
//		mav.addObject("rcvapplList", rcvapplList);
//		mav.setViewName(path);
		
		return rcvapplList;
	}
	
	public List<CustJoinBill> selectCustList(CustJoinBill cust) {
		List<CustJoinBill> custList = dao.selectCustList(cust);
		
		return custList;
	}
	public List<RcvapplJoinCustJoin> selectCrdList(String ssn) {
		List<RcvapplJoinCustJoin> crdList = dao.selectCrdList(ssn);
		
		return crdList;
	}
	
	public int getFormCnt(Rcvappl rcvappl) {
		List<Rcvappl> FormList = dao.selectForm(rcvappl);
		int count = FormList.size();
		
		return count;
	}
	
	public int getFormCnt11(Rcvappl rcvappl) {
		List<Rcvappl> FormList = dao.selectForm11(rcvappl);
		int count11 = FormList.size();
		
		return count11;
	}
	
	public int insertRcvappl(Rcvappl rcvappl) {
		return dao.insertRcvappl(rcvappl);
	}
	
	public int insertRcvapplImpsbCd(Rcvappl rcvappl) {
		return dao.insertRcvapplImpsbCd(rcvappl);
	}
	
	public int insertCust(Rcvappl rcvappl) {
		return dao.insertCust(rcvappl);
	}
	
	public int insertBill(Rcvappl rcvappl) {
		return dao.insertBill(rcvappl);
	}
	
	public int insertCrd11(Rcvappl rcvappl, String vld_dur) {
		return dao.insertCrd11(rcvappl, vld_dur);
	}
	
	public int insertCrd12(Rcvappl rcvappl, String custNo, String vld_dur) {
		return dao.insertCrd12(rcvappl, custNo, vld_dur);
	}
	
	public int insertCrd21(Rcvappl rcvappl, Crd crd, String custNo) {
		return dao.insertCrd21(rcvappl, crd, custNo);
	}
	
//	public String selectCust(SignUpForm rcvappl) {
//		return dao.selectCust(rcvappl);
//	}
	
	public Cust selectCust(Rcvappl rcvappl) {
		return dao.selectCust(rcvappl);
	}
	
	public Crd selectCrd(Rcvappl rcvappl, String custNo) {
		return dao.selectCrd(rcvappl, custNo);
	}
	
//	public int updateBill(Bill bill, String custNo) {
//		return dao.updateBill(bill, custNo);
//	}
	
	public int updateCrd(String custNo, Crd crd) {
		return dao.updateCrd(custNo, crd);
	}
}
