package org.second.form.dto;

public class CustJoinBill {
	private String ssn, hg_nm, birth_d, hdp_no, bnk_cd, stl_act, bbill_adr1, bill_adr2;

	public CustJoinBill() {}
	
	public CustJoinBill(String ssn, String hg_nm, String birth_d, String hdp_no, String bnk_cd, String stl_act,
			String bbill_adr1, String bill_adr2) {
		super();
		this.ssn = ssn;
		this.hg_nm = hg_nm;
		this.birth_d = birth_d;
		this.hdp_no = hdp_no;
		this.bnk_cd = bnk_cd;
		this.stl_act = stl_act;
		this.bbill_adr1 = bbill_adr1;
		this.bill_adr2 = bill_adr2;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getHg_nm() {
		return hg_nm;
	}

	public void setHg_nm(String hg_nm) {
		this.hg_nm = hg_nm;
	}

	public String getBirth_d() {
		return birth_d;
	}

	public void setBirth_d(String birth_d) {
		this.birth_d = birth_d;
	}

	public String getHdp_no() {
		return hdp_no;
	}

	public void setHdp_no(String hdp_no) {
		this.hdp_no = hdp_no;
	}

	public String getBnk_cd() {
		return bnk_cd;
	}

	public void setBnk_cd(String bnk_cd) {
		this.bnk_cd = bnk_cd;
	}

	public String getStl_act() {
		return stl_act;
	}

	public void setStl_act(String stl_act) {
		this.stl_act = stl_act;
	}

	public String getBbill_adr1() {
		return bbill_adr1;
	}

	public void setBbill_adr1(String bbill_adr1) {
		this.bbill_adr1 = bbill_adr1;
	}

	public String getBill_adr2() {
		return bill_adr2;
	}

	public void setBill_adr2(String bill_adr2) {
		this.bill_adr2 = bill_adr2;
	}
}
