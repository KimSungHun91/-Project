package org.second.form.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.second.form.dto.CommCode;
import org.second.form.dto.Crd;
import org.second.form.dto.Cust;
import org.second.form.dto.CustJoinBill;
import org.second.form.dto.Rcvappl;
import org.second.form.dto.RcvapplJoinCustJoin;
import org.second.form.service.Mainservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	private String custNo;
	
	@Autowired
	private Mainservice service;
	
	@RequestMapping(value = {"/", "goHome"})
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value = {"/goSignup", "goSignup"})
	public ModelAndView goSignup(ModelAndView mav, Integer no) {
		String path = "signup";
		if (no != null) {
			Rcvappl rcvappl = service.selectRcvappl(mav, no);
			mav.addObject(rcvappl);
		}
		List<CommCode> commCodeList = service.getCommCode(mav, path);
		setComCode(commCodeList, mav);
		mav.addObject(commCodeList);
		
		return mav;
	}
	
	@RequestMapping(value = {"/rcvapplList", "goRcvapplList"})
	public ModelAndView goRcvapplList(ModelAndView mav) {
		String path = "rcvapplList";
		List<CommCode> commCodeList = service.getCommCode(mav, path);
//		List<Rcvappl> rcvapplList = service.selectRcvapplList(mav);
		setComCode(commCodeList, mav);
		mav.addObject(commCodeList);
//		mav.addObject(rcvapplList);
		
		return mav;
	}
	
	@RequestMapping(value = {"/getRcvapplList", "getRcvapplList"})
	public String getRcvapplList(Rcvappl rcvappl, HttpServletRequest req) {
		List<Rcvappl> rcvapplList = service.selectRcvapplList(rcvappl);
		HttpSession session = req.getSession();
		session.setAttribute("rcvapplList", rcvapplList);
		
		return "redirect:/rcvapplList";
	}
	
	@RequestMapping(value = {"/custList", "goCustList"})
	public ModelAndView goCustList(ModelAndView mav) {
		String path = "custList";
		List<CommCode> commCodeList = service.getCommCode(mav, path);
//		List<Rcvappl> rcvapplList = service.selectRcvapplList(mav);
		setComCode(commCodeList, mav);
		mav.addObject(commCodeList);
//		mav.addObject(rcvapplList);
		
		return mav;
	}
	
	@RequestMapping(value = {"/getCustList", "getCustList"})
	public String getCustList(CustJoinBill cust, HttpServletRequest req) {
		List<CustJoinBill> custList = service.selectCustList(cust);
		HttpSession session = req.getSession();
		session.setAttribute("custList", custList);
		
		return "redirect:/custList";
	}
	
	@RequestMapping(value = {"/crdList", "goCrdList"})
	public ModelAndView goCrdList(ModelAndView mav, String ssn) {
		String path = "crdList";
		System.out.println(ssn);
		List<RcvapplJoinCustJoin> crdList = service.selectCrdList(ssn);
		mav.addObject("crdList", crdList);
		
		RcvapplJoinCustJoin custInfo = crdList.iterator().next();
		mav.addObject("custInfo", custInfo);
		//		HttpSession session = req.getSession();
//		session.setAttribute("joinInfo", joinInfo);
		
		List<CommCode> commCodeList = service.getCommCode(mav, path);
		setComCode(commCodeList, mav);
		mav.addObject(commCodeList);
		
		
		
		return mav;
	}
	
	@RequestMapping(value = {"/crdDetail", "goCrdDetail"})
	public String goCrdDetail() {
		return "crdDetail";
	}
	
	@RequestMapping(value="doSignup", method=RequestMethod.POST)
	public String doSignup(Rcvappl rcvappl) throws Exception {
		/*
		 * 접수 일련 번호, 매일 1로 초기화
		 * 1. 접수 일련 번호를 오늘 날짜로 SELECT
		 * 2. 카운트가 0이면 접수 일련 번호 1로 초기화
		 * 위 두가지 쿼리 적용
		*/
			
//		if(service.getFormCnt(rcvappl) == 0) {
//			rcvappl.setRcv_seq_no("0");
//		}
		/*
		 * 신청서 접수날짜 AND 일련번호로 객체생성해서 리스트에 넣음
		 * 리스트 size가 0이면 해당 접수날짜에는 일련번호 없으니까, 날짜바뀜 따라서 rcvappl.setRcv_seq_no("0");
		 * 마지막 접수 번호는 리스트의 마지막 인덱스 번호로 가져오고
		 * INSERT UPDATE 직전에 받아옴
		 */
		
		// 불능 체크
		/*
		 * 동일인이 당일 두번 등록하는 경우, 주민번호, 접수일, 불능여부 확인 후 
		 * 해당날짜에 불능이 아닌 신청서 카운트가 2이상이면 "1", "01" SET
		 * 최초신규, 추가신규 일 때만 불능
		*/
//		Cust cust = null;
//		Crd crd = null;
//		if(count == 0 || service.selectCrd(rcvappl, custNo)) {
//			service.insertRcvappl(rcvappl);
		Cust cust = service.selectCust(rcvappl);
		if (cust != null) {
			custNo = cust.getCust_no();
		}
		Crd crd = service.selectCrd(rcvappl, custNo);
		
		boolean flag = false;
		if(!flag && rcvappl.getAppl_clas().equals("11") || rcvappl.getAppl_clas().equals("12")) {
			int count = service.getFormCnt(rcvappl);
			int count11 = service.getFormCnt11(rcvappl);
			if (count11 != 0) {
				rcvappl.setImpsb_clas("1");
				rcvappl.setImpsb_cd("01");
				flag = true;
			}
			if(count > 1) {
				// 동일인이 당일 두번 등록하는 경우, 정상 등록된 신청서 갯수가 2개 이상인 경우
				// 불능 정보 SET
				rcvappl.setImpsb_clas("1");
				rcvappl.setImpsb_cd("01");
				flag = true;
			} else if(cust != null && crd != null) {
				if(!flag && rcvappl.getBrd().equals(crd.getBrd())) {
					// 최초신규, 추가신규인 경우 이미 같은 브랜드의 카드를 소지하고 있는 경우
					// 이미 같은 브랜드 카드 소지 -> 고객이고, 카드도 정상 발급 받음
					// 카드 브랜드 비교 후 불능 정보 SET
					rcvappl.setImpsb_clas("1");
					rcvappl.setImpsb_cd("04");
					flag = true;
				}
			}
		} else if(!flag && rcvappl.getAppl_clas().equals("21")) {
			if(crd == null || cust == null) {
				// 재발급으로 신청하였는데 카드를 미소지하고 있는 경우
				rcvappl.setImpsb_clas("1");
				rcvappl.setImpsb_cd("05");
			}
		}
		// 불능 코드 존재
		if(rcvappl.getImpsb_cd() != null) {
			// 불능코드에 따른 로직 추가
			// 해당 rcvappl 테이블에 불능코드를 포함한 정보 삽입
			service.insertRcvapplImpsbCd(rcvappl);
//			if(rcvappl.getImpsb_cd().equals("01")) {
//			}
			return "redirect:/";
		} else {
			// 불능 코드 없음
			// 입회 신청서 INSERT
			service.insertRcvappl(rcvappl);
//			cust = service.selectCust(rcvappl);
//			custNo = cust.getCust_no();
//			crd = service.selectCrd(rcvappl, custNo);
			// 유효기간(접수일+5년) 값 구함
			String vld_dur = addDate(rcvappl.getRcv_d(), 5);;
			// 최초신규, "11"
			if(rcvappl.getAppl_clas().equals("11")) {
				// rcv_seq_no(접수 일련 번호), cust_no(고객 번호) 시퀀스 사용해서 + 1
				service.insertCust(rcvappl);
				service.insertBill(rcvappl);
				service.insertCrd11(rcvappl, vld_dur);
				
				return "redirect:/";
			// 추가신규, "12"
			} else if(rcvappl.getAppl_clas().equals("12")) {
				// 추가신규 로직
				// 고객 정보 먼저 가져오기
				if(cust != null) {
					cust = service.selectCust(rcvappl);
					custNo = cust.getCust_no();
					service.insertCrd12(rcvappl, custNo, vld_dur);

					return "redirect:/";
				} else {
					// 최초신규를 하지않고 추가신규를 먼저 한 경우
					System.out.println("확인");
					return "redirect:/";
				}
			// 재발급, "13" 
			} else if(rcvappl.getAppl_clas().equals("21")){
				// 재발급 로직
				// 해당 고객의 번호 SELECT
				cust = service.selectCust(rcvappl);
				custNo = cust.getCust_no();
				// 해당 고객의 현재 카드 정보 SELECT
				crd = service.selectCrd(rcvappl, custNo);
				// 카드 테이블 UPDATE, 최종 카드 여부만 ""로 UPDATE
				service.updateCrd(custNo, crd);
				// 재발급 카드 INSERT 하기 전 유효기간 SET
				crd.setVld_dur(vld_dur);
				// 카드 테이블 INSERT, 현카드번호, 최종카드여부, 전카드번호
				service.insertCrd21(rcvappl, crd, custNo);
				
				
//				for (Crd crd : crdList) {
//					// 최종카드이고, 사용자가 입력한 브랜드 값과 같은 카드인 것
//					
//					if (crd.getLst_crd_f().equals("1") && rcvappl.getBrd().equals(crd.getBrd())) {
//						// 카드 테이블 UPDATE, 최종 카드 여부만 ""로 UPDATE
//						service.updateCrd(custNo, crd);
//						// 재발급 카드 INSERT 하기 전 유효기간 SET
//						crd.setVld_dur(vld_dur);
//						// 카드 테이블 INSERT, 현카드번호, 최종카드여부, 전카드번호
//						service.insertCrd21(rcvappl, crd, custNo);
//						
//						return "redirect:/";
//					}
//				}
				return "redirect:/";
			} else {
				// 나머지 오류
				return "redirect:/goSignup";
			}
		}
	}
	
	private String addDate(String dt, int y) throws Exception {
		SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		Date date = form.parse(dt);
		cal.setTime(date);
		cal.add(Calendar.YEAR, y);
		
		String vld_dur = form.format(cal.getTime());
		vld_dur = vld_dur.substring(4,6) + vld_dur.substring(0, 4); 
		
		return vld_dur;
	}
	
	private void setComCode(List<CommCode> commCodeList, ModelAndView mav) {
//		Map<String, List<CommCode>> codeGroup = commCodeList.stream().collect(Collectors.groupingBy(CommCode::getGroup_cd));
		List<CommCode> c001 = new ArrayList<CommCode>();
		List<CommCode> c002 = new ArrayList<CommCode>();
		List<CommCode> c003 = new ArrayList<CommCode>();
		List<CommCode> c004 = new ArrayList<CommCode>();
		List<CommCode> c005 = new ArrayList<CommCode>();
		List<CommCode> c006 = new ArrayList<CommCode>();
		List<CommCode> c007 = new ArrayList<CommCode>();
		List<CommCode> c008 = new ArrayList<CommCode>();
		List<CommCode> c009 = new ArrayList<CommCode>();
		for (CommCode commCode : commCodeList) {
			if (commCode.getGroup_cd().equals("C001")) {
				c001.add(commCode);
				mav.addObject("c001", c001);
			} else if(commCode.getGroup_cd().equals("C002")) {
				c002.add(commCode);
				mav.addObject("c002", c002);
			} else if(commCode.getGroup_cd().equals("C003")) {
				c003.add(commCode);
				mav.addObject("c003", c003);
			} else if(commCode.getGroup_cd().equals("C004")) {
				c004.add(commCode);
				mav.addObject("c004", c004);
			} else if(commCode.getGroup_cd().equals("C005")) {
				c005.add(commCode);
				mav.addObject("c005", c005);
			} else if(commCode.getGroup_cd().equals("C006")) {
				c006.add(commCode);
				mav.addObject("c006", c006);
			} else if(commCode.getGroup_cd().equals("C007")) {
				c007.add(commCode);
				mav.addObject("c007", c007);
			} else if(commCode.getGroup_cd().equals("C008")) {
				c008.add(commCode);
				mav.addObject("c008", c008);
			} else if(commCode.getGroup_cd().equals("C009")) {
				c009.add(commCode);
				mav.addObject("c009", c009);
			}
		}
	}
	
}
