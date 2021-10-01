package org.second.form.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.second.form.dto.CommCode;
import org.second.form.dto.Crd;
import org.second.form.dto.Cust;
import org.second.form.dto.CustJoinBill;
import org.second.form.dto.Rcvappl;
import org.second.form.dto.RcvapplJoinCustJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SecondTestDAO {
	
	@Autowired
	private JdbcTemplate jdbcTmp;
	
	@Value("#{sql['comm_code_dtl.getCommCode']}")
	private String getCommCode;
	
	@Value("#{sql['rcvappl.insertRcvappl']}")
	private String insertRcvappl;
	
	@Value("#{sql['cust.insertCust']}")
	private String insertCust;
	
	@Value("#{sql['bill.insertBill']}")
	private String insertBill;
	
	@Value("#{sql['crd.insertCrd11']}")
	private String insertCrd11;
	
	@Value("#{sql['crd.insertCrd12']}")
	private String insertCrd12;
	
	@Value("#{sql['crd.insertCrd21']}")
	private String insertCrd21;
	
	@Value("#{sql['bill.updateBill']}")
	private String updateBill;
	
	@Value("#{sql['cust.selectCust']}")
	private String selectCust;
	
	@Value("#{sql['crd.updateCrd']}")
	private String updateCrd;
	
	@Value("#{sql['rcvappl.updateRcvappl']}")
	private String updateRcvappl;
	
	@Value("#{sql['crd.selectCrd']}")
	private String selectCrd;
	
	@Value("#{sql['rcvappl.selectForm']}")
	private String selectForm;
	
	@Value("#{sql['rcvappl.selectForm11']}")
	private String selectForm11;
	
	@Value("#{sql['rcvappl.insertRcvapplImpsbCd']}")
	private String insertRcvapplImpsbCd;
	
	@Value("#{sql['rcvappl.selectRcvapplList']}")
	private String selectRcvapplList;
	
	@Value("#{sql['custJoinBill.selectCustList']}")
	private String selectCustList;
	
	@Value("#{sql['rcvapplJoinCustJoinCrd.selectCrdList']}")
	private String selectCrdList;
	
	@Value("#{sql['rcvappl.selectRcvappl']}")
	private String selectRcvappl;
	
	public List<CommCode> getCommCode() {
		return jdbcTmp.query(getCommCode, new CodeMapper());
	}
	
	public List<Rcvappl> selectRcvapplList(Rcvappl rcvappl) {
		return jdbcTmp.query(selectRcvapplList, new Object[] {rcvappl.getRcv_d(), rcvappl.getRcv_d2(), rcvappl.getAppl_clas(), rcvappl.getSsn()}, new FormMapper());
	}
	
	public List<CustJoinBill> selectCustList(CustJoinBill cust) {
		List<CustJoinBill> test = jdbcTmp.query(selectCustList, new Object[] {cust.getHg_nm(), cust.getBirth_d(), cust.getHdp_no()}, new CustJoinBillMapper());
		return test;
	}
	
	public List<RcvapplJoinCustJoin> selectCrdList(String ssn) {
		return jdbcTmp.query(selectCrdList, new Object[] {ssn}, new CrdListMapper());
	}
	
	public Rcvappl selectRcvappl(int no) {
		return jdbcTmp.queryForObject(selectRcvappl, new Object[]{no}, new FormMapper2());
	}
	
	public int insertRcvappl(Rcvappl rcvappl) {
		return jdbcTmp.update(insertRcvappl
				, rcvappl.getSsn(), rcvappl.getRcv_d(), rcvappl.getAppl_d(), rcvappl.getBirth_d()
				, rcvappl.getHg_nm(), rcvappl.getEng_nm(), rcvappl.getStl_mtd() , rcvappl.getStl_act(), rcvappl.getBnk_cd()
				, rcvappl.getStl_dd(), rcvappl.getAppl_clas(), rcvappl.getStmt_snd_mtd(), rcvappl.getBilladr_adr1(), rcvappl.getBilladr_adr2()
				, rcvappl.getBilladr_zip(), rcvappl.getHdp_no(), rcvappl.getBrd(), rcvappl.getScrt_no(), rcvappl.getEmail_adr());
	}
	
	public int insertRcvapplImpsbCd(Rcvappl rcvappl) {
		return jdbcTmp.update(insertRcvapplImpsbCd
				, rcvappl.getSsn(), rcvappl.getRcv_d(), rcvappl.getAppl_d(), rcvappl.getBirth_d()
				, rcvappl.getHg_nm(), rcvappl.getEng_nm(), rcvappl.getStl_mtd() , rcvappl.getStl_act(), rcvappl.getBnk_cd()
				, rcvappl.getStl_dd(), rcvappl.getAppl_clas(), rcvappl.getStmt_snd_mtd(), rcvappl.getBilladr_adr1(), rcvappl.getBilladr_adr2()
				, rcvappl.getBilladr_zip(), rcvappl.getHdp_no(), rcvappl.getBrd(), rcvappl.getScrt_no(), rcvappl.getEmail_adr(), rcvappl.getImpsb_clas(), rcvappl.getImpsb_cd());
	}
	
	public int insertCust(Rcvappl rcvappl) {
		return jdbcTmp.update(insertCust, rcvappl.getSsn(), rcvappl.getRcv_d(), rcvappl.getHg_nm(), rcvappl.getBirth_d(), rcvappl.getHdp_no());
	}
	
	public int insertBill(Rcvappl rcvappl) {
		return jdbcTmp.update(insertBill, rcvappl.getStl_act(), rcvappl.getBnk_cd(), rcvappl.getEng_nm(), rcvappl.getStl_mtd(), rcvappl.getStl_dd(), rcvappl.getStmt_snd_mtd(), rcvappl.getBilladr_zip(), rcvappl.getBilladr_adr1(), rcvappl.getBilladr_adr2(), rcvappl.getEmail_adr());
	}
	
	public int insertCrd11(Rcvappl rcvappl, String vld_dur) {
		return jdbcTmp.update(insertCrd11, rcvappl.getRcv_d(), rcvappl.getSsn(), vld_dur, rcvappl.getBrd(), rcvappl.getScrt_no(), rcvappl.getEng_nm(), rcvappl.getRcv_d());
	}
	
	public int insertCrd12(Rcvappl rcvappl, String custNo, String vld_dur) {
		return jdbcTmp.update(insertCrd12, custNo, rcvappl.getRcv_d(), rcvappl.getSsn(), vld_dur, rcvappl.getBrd(), rcvappl.getScrt_no(), rcvappl.getEng_nm(), rcvappl.getRcv_d());
	}
	
	public int insertCrd21(Rcvappl rcvappl, Crd crd, String custNo) {
		return jdbcTmp.update(insertCrd21, custNo, rcvappl.getRcv_d(), rcvappl.getSsn(), crd.getVld_dur(), rcvappl.getBrd(), rcvappl.getScrt_no(), rcvappl.getEng_nm(), rcvappl.getRcv_d(), crd.getCrd_no());
	}
	
//	public int updateBill(Bill bill, String custNo) {
//		return jdbcTmp.update(updateBill, new Object[] {bill.getStl_act(), bill.getBnk_cd(), bill.getDps_nm(), bill.getStl_mtd(), bill.getStl_dd(), bill.getStmt_snd_mtd(), bill.getBill_zip(), bill.getBill_adr1(), bill.getBill_adr2(), bill.getEmail_adr(), custNo});
//	}
	
	public Cust selectCust(Rcvappl rcvappl) {
		try {
			return jdbcTmp.queryForObject(selectCust, new Object[] {rcvappl.getSsn()}, new CustMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	public int updateCrd(String custNo, Crd crd) {
		return jdbcTmp.update(updateCrd, new Object[] {custNo, crd.getCrd_no()});
	}
	
	public Crd selectCrd(Rcvappl rcvappl ,String custNo) {
		try {
			return jdbcTmp.queryForObject(selectCrd, new Object[] {custNo, rcvappl.getBrd()}, new CrdMapper());
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	public List<Rcvappl> selectForm(Rcvappl rcvappl) {
		return jdbcTmp.query(selectForm, new Object[] {rcvappl.getSsn(), rcvappl.getRcv_d()}, new FormMapper());
	}
	
	public List<Rcvappl> selectForm11(Rcvappl rcvappl) {
		return jdbcTmp.query(selectForm11, new Object[] {rcvappl.getSsn(), rcvappl.getRcv_d(), rcvappl.getAppl_clas()}, new FormMapper());
	}
	
	public List<Rcvappl> getFormList(Rcvappl rcvappl) {
		return jdbcTmp.query(selectForm, new Object[] {rcvappl.getSsn(), rcvappl.getRcv_d()}, new FormMapper());
	}
	
	class CustMapper implements RowMapper<Cust> {
		@Override
		public Cust mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Cust(rs.getString("cust_no"), rs.getString("ssn"), rs.getString("reg_d"), rs.getString("hg_nm"), rs.getString("birth_d"), rs.getString("hdp_no"));
		}
	}
	
	class CodeMapper implements RowMapper<CommCode> {
		@Override
		public CommCode mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new CommCode(rs.getString("group_cd"), rs.getString("group_nm"), rs.getString("code"), rs.getString("code_nm"));
		}
	}
	
	class CrdMapper implements RowMapper<Crd> {
		@Override
		public Crd mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Crd(rs.getString("crd_no"), rs.getString("cust_no"), rs.getString("bf_crd_no"), rs.getString("lst_crd_f"), rs.getString("brd"));
		}
	}
	
	class FormMapper implements RowMapper<Rcvappl> {
		@Override
		public Rcvappl mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Rcvappl(rs.getString("rcv_d"), rs.getString("rcv_seq_no"), rs.getString("ssn"), rs.getString("hg_nm"), rs.getString("eng_nm"), rs.getString("appl_clas"), rs.getString("brd"), rs.getString("hdp_no"), rs.getString("impsb_clas"), rs.getString("impsb_cd"));
		}
	}
	
	class FormMapper2 implements RowMapper<Rcvappl> {
		@Override
		public Rcvappl mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Rcvappl(rs.getString("ssn"), rs.getString("rcv_d"), rs.getString("rcv_seq_no"), rs.getString("appl_d"), rs.getString("birth_d")
			, rs.getString("hg_nm"), rs.getString("eng_nm"), rs.getString("stl_mtd"), rs.getString("stl_act"), rs.getString("bnk_cd"), rs.getString("stl_dd")
			, rs.getString("appl_clas"), rs.getString("stmt_snd_mtd"), rs.getString("billadr_adr1"), rs.getString("billadr_adr2"), rs.getString("billadr_zip")
			, rs.getString("hdp_no"), rs.getString("brd"), rs.getString("scrt_no"), rs.getString("email_adr"), rs.getString("impsb_clas"), rs.getString("impsb_cd"));
		}
	}
	
	class CustJoinBillMapper implements RowMapper<CustJoinBill> {
		@Override
		public CustJoinBill mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new CustJoinBill(rs.getString("ssn"), rs.getString("hg_nm"), rs.getString("birth_d"), rs.getString("hdp_no"), rs.getString("bnk_cd"), rs.getString("stl_act"), rs.getString("bill_adr1"), rs.getString("bill_adr2"));
		}
	}
	
	class CrdListMapper implements RowMapper<RcvapplJoinCustJoin> {
		@Override
		public RcvapplJoinCustJoin mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new RcvapplJoinCustJoin(rs.getString("ssn"), rs.getString("hg_nm"), rs.getString("hdp_no"), rs.getString("rcv_d")
			, rs.getString("stl_mtd"), rs.getString("bnk_cd"), rs.getString("stl_act"), rs.getString("stl_dd"), rs.getString("stmt_snd_mtd"), rs.getString("email_adr")
			, rs.getString("billadr_zip"), rs.getString("billadr_adr1"), rs.getString("billadr_adr2"), rs.getString("crd_no"), rs.getString("eng_nm"), rs.getString("vld_dur")
			, rs.getString("brd"), rs.getString("crd_grd"), rs.getString("reg_d"), rs.getString("bf_crd_no"), rs.getString("lst_crd_f"));
		}
	}
}
