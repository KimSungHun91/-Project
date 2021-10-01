package org.second.form.dto;

public class Cust {
	private String 
	cust_no
	,ssn
	,reg_d
	,hg_nm
	,birth_d
	,hdp_no;

	public Cust(String cust_no) {
		super();
		this.cust_no = cust_no;
	}

	public Cust(String cust_no, String ssn, String reg_d, String hg_nm, String birth_d, String hdp_no) {
		super();
		this.cust_no = cust_no;
		this.ssn = ssn;
		this.reg_d = reg_d;
		this.hg_nm = hg_nm;
		this.birth_d = birth_d;
		this.hdp_no = hdp_no;
	}

	public String getCust_no() {
		return cust_no;
	}

	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getReg_d() {
		return reg_d;
	}

	public void setReg_d(String reg_d) {
		this.reg_d = reg_d;
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
}
