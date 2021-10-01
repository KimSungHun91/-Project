package org.second.form.dto;

public class Crd {
	private String
	crd_no
	, cust_no
	, reg_d
	, ssn
	, vld_dur
	, brd
	, scrt_no
	, eng_nm
	, bf_crd_no
	, lst_crd_f
	, fst_reg_d
	, crd_grd;
	
	public Crd(String crd_no, String cust_no, String bf_crd_no, String lst_crd_f, String brd) {
		super();
		this.crd_no = crd_no;
		this.cust_no = cust_no;
		this.bf_crd_no = bf_crd_no;
		this.lst_crd_f = lst_crd_f;
		this.brd = brd;
	}

	public Crd(String crd_no, String cust_no, String reg_d, String ssn, String vld_dur, String brd, String scrt_no,
			String eng_nm, String bf_crd_no, String lst_crd_f, String fst_reg_d, String crd_grd) {
		super();
		this.crd_no = crd_no;
		this.cust_no = cust_no;
		this.reg_d = reg_d;
		this.ssn = ssn;
		this.vld_dur = vld_dur;
		this.brd = brd;
		this.scrt_no = scrt_no;
		this.eng_nm = eng_nm;
		this.bf_crd_no = bf_crd_no;
		this.lst_crd_f = lst_crd_f;
		this.fst_reg_d = fst_reg_d;
		this.crd_grd = crd_grd;
	}

	public String getCrd_no() {
		return crd_no;
	}

	public void setCrd_no(String crd_no) {
		this.crd_no = crd_no;
	}

	public String getCust_no() {
		return cust_no;
	}

	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}

	public String getReg_d() {
		return reg_d;
	}

	public void setReg_d(String reg_d) {
		this.reg_d = reg_d;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getVld_dur() {
		return vld_dur;
	}

	public void setVld_dur(String vld_dur) {
		this.vld_dur = vld_dur;
	}

	public String getBrd() {
		return brd;
	}

	public void setBrd(String brd) {
		this.brd = brd;
	}

	public String getScrt_no() {
		return scrt_no;
	}

	public void setScrt_no(String scrt_no) {
		this.scrt_no = scrt_no;
	}

	public String getEng_nm() {
		return eng_nm;
	}

	public void setEng_nm(String eng_nm) {
		this.eng_nm = eng_nm;
	}

	public String getBf_crd_no() {
		return bf_crd_no;
	}

	public void setBf_crd_no(String bf_crd_no) {
		this.bf_crd_no = bf_crd_no;
	}

	public String getLst_crd_f() {
		return lst_crd_f;
	}

	public void setLst_crd_f(String lst_crd_f) {
		this.lst_crd_f = lst_crd_f;
	}

	public String getFst_reg_d() {
		return fst_reg_d;
	}

	public void setFst_reg_d(String fst_reg_d) {
		this.fst_reg_d = fst_reg_d;
	}

	public String getCrd_grd() {
		return crd_grd;
	}

	public void setCrd_grd(String crd_grd) {
		this.crd_grd = crd_grd;
	}
}
