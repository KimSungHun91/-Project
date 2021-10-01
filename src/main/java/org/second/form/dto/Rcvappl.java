package org.second.form.dto;

public class Rcvappl {
	private String 
	ssn
	, rcv_d
	, rcv_d2
	, rcv_seq_no
	, appl_d
	, birth_d
	, hg_nm
	, eng_nm
	, stl_mtd
	, stl_act
	, bnk_cd
	, stl_dd
	, appl_clas
	, stmt_snd_mtd
	, billadr_adr1
	, billadr_adr2
	, billadr_zip
	, hdp_no
	, brd
	, scrt_no
	, email_adr
	, impsb_clas
	, impsb_cd;

	public Rcvappl() {}

	public Rcvappl(String rcv_d, String rcv_seq_no) {
		super();
		this.rcv_d = rcv_d;
		this.rcv_seq_no = rcv_seq_no;
	}


	public Rcvappl(String rcv_d, String rcv_seq_no, String ssn, String hg_nm, String eng_nm, String appl_clas,
			String brd, String hdp_no, String impsb_clas, String impsb_cd) {
		super();
		this.rcv_d = rcv_d;
		this.rcv_seq_no = rcv_seq_no;
		this.ssn = ssn;
		this.hg_nm = hg_nm;
		this.eng_nm = eng_nm;
		this.appl_clas = appl_clas;
		this.brd = brd;
		this.hdp_no = hdp_no;
		this.impsb_clas = impsb_clas;
		this.impsb_cd = impsb_cd;
	}

	public Rcvappl(String ssn, String rcv_d, String rcv_seq_no, String appl_d, String birth_d, String hg_nm,
			String eng_nm, String stl_mtd, String stl_act, String bnk_cd, String stl_dd, String appl_clas,
			String stmt_snd_mtd, String billadr_adr1, String billadr_adr2, String billadr_zip, String hdp_no,
			String brd, String scrt_no, String email_adr) {
		super();
		this.ssn = ssn;
		this.rcv_d = rcv_d;
		this.rcv_seq_no = rcv_seq_no;
		this.appl_d = appl_d;
		this.birth_d = birth_d;
		this.hg_nm = hg_nm;
		this.eng_nm = eng_nm;
		this.stl_mtd = stl_mtd;
		this.stl_act = stl_act;
		this.bnk_cd = bnk_cd;
		this.stl_dd = stl_dd;
		this.appl_clas = appl_clas;
		this.stmt_snd_mtd = stmt_snd_mtd;
		this.billadr_adr1 = billadr_adr1;
		this.billadr_adr2 = billadr_adr2;
		this.billadr_zip = billadr_zip;
		this.hdp_no = hdp_no;
		this.brd = brd;
		this.scrt_no = scrt_no;
		this.email_adr = email_adr;
	}
	
	public Rcvappl(String ssn, String rcv_d, String rcv_seq_no, String appl_d, String birth_d, String hg_nm,
			String eng_nm, String stl_mtd, String stl_act, String bnk_cd, String stl_dd, String appl_clas,
			String stmt_snd_mtd, String billadr_adr1, String billadr_adr2, String billadr_zip, String hdp_no,
			String brd, String scrt_no, String email_adr, String impsb_clas, String impsb_cd) {
		super();
		this.ssn = ssn;
		this.rcv_d = rcv_d;
		this.rcv_seq_no = rcv_seq_no;
		this.appl_d = appl_d;
		this.birth_d = birth_d;
		this.hg_nm = hg_nm;
		this.eng_nm = eng_nm;
		this.stl_mtd = stl_mtd;
		this.stl_act = stl_act;
		this.bnk_cd = bnk_cd;
		this.stl_dd = stl_dd;
		this.appl_clas = appl_clas;
		this.stmt_snd_mtd = stmt_snd_mtd;
		this.billadr_adr1 = billadr_adr1;
		this.billadr_adr2 = billadr_adr2;
		this.billadr_zip = billadr_zip;
		this.hdp_no = hdp_no;
		this.brd = brd;
		this.scrt_no = scrt_no;
		this.email_adr = email_adr;
		this.impsb_clas = impsb_clas;
		this.impsb_cd = impsb_cd;
	}

//	public SignUpForm(String impsb_clas, String impsb_cd) {
//		super();
//		this.impsb_clas = impsb_clas;
//		this.impsb_cd = impsb_cd;
//	}
	public String getRcv_d2() {
		return rcv_d2;
	}
	
	public void setRcv_d2(String rcv_d2) {
		this.rcv_d2 = rcv_d2;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getRcv_d() {
		return rcv_d;
	}

	public void setRcv_d(String rcv_d) {
		this.rcv_d = rcv_d;
	}

	public String getRcv_seq_no() {
		return rcv_seq_no;
	}

	public void setRcv_seq_no(String rcv_seq_no) {
		this.rcv_seq_no = rcv_seq_no;
	}

	public String getAppl_d() {
		return appl_d;
	}

	public void setAppl_d(String appl_d) {
		this.appl_d = appl_d;
	}

	public String getBirth_d() {
		return birth_d;
	}

	public void setBirth_d(String birth_d) {
		this.birth_d = birth_d;
	}

	public String getHg_nm() {
		return hg_nm;
	}

	public void setHg_nm(String hg_nm) {
		this.hg_nm = hg_nm;
	}

	public String getEng_nm() {
		return eng_nm;
	}

	public void setEng_nm(String eng_nm) {
		this.eng_nm = eng_nm;
	}

	public String getStl_mtd() {
		return stl_mtd;
	}

	public void setStl_mtd(String stl_mtd) {
		this.stl_mtd = stl_mtd;
	}

	public String getStl_act() {
		return stl_act;
	}

	public void setStl_act(String stl_act) {
		this.stl_act = stl_act;
	}

	public String getBnk_cd() {
		return bnk_cd;
	}

	public void setBnk_cd(String bnk_cd) {
		this.bnk_cd = bnk_cd;
	}

	public String getStl_dd() {
		return stl_dd;
	}

	public void setStl_dd(String stl_dd) {
		this.stl_dd = stl_dd;
	}

	public String getAppl_clas() {
		return appl_clas;
	}

	public void setAppl_clas(String appl_clas) {
		this.appl_clas = appl_clas;
	}

	public String getStmt_snd_mtd() {
		return stmt_snd_mtd;
	}

	public void setStmt_snd_mtd(String stmt_snd_mtd) {
		this.stmt_snd_mtd = stmt_snd_mtd;
	}

	public String getBilladr_adr1() {
		return billadr_adr1;
	}

	public void setBilladr_adr1(String billadr_adr1) {
		this.billadr_adr1 = billadr_adr1;
	}

	public String getBilladr_adr2() {
		return billadr_adr2;
	}

	public void setBilladr_adr2(String billadr_adr2) {
		this.billadr_adr2 = billadr_adr2;
	}

	public String getBilladr_zip() {
		return billadr_zip;
	}

	public void setBilladr_zip(String billadr_zip) {
		this.billadr_zip = billadr_zip;
	}

	public String getHdp_no() {
		return hdp_no;
	}

	public void setHdp_no(String hdp_no) {
		this.hdp_no = hdp_no;
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

	public String getEmail_adr() {
		return email_adr;
	}

	public void setEmail_adr(String email_adr) {
		this.email_adr = email_adr;
	}

	public String getImpsb_clas() {
		return impsb_clas;
	}

	public void setImpsb_clas(String impsb_clas) {
		this.impsb_clas = impsb_clas;
	}

	public String getImpsb_cd() {
		return impsb_cd;
	}

	public void setImpsb_cd(String impsb_cd) {
		this.impsb_cd = impsb_cd;
	}
}
