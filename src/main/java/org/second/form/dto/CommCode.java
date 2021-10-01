package org.second.form.dto;

public class CommCode {
	private String group_cd;
	private String group_nm;
	private String code;
	private String code_nm;
	
	public CommCode() {}

	public CommCode(String group_cd, String group_nm, String code, String code_nm) {
		super();
		this.group_cd = group_cd;
		this.group_nm = group_nm;
		this.code = code;
		this.code_nm = code_nm;
	}

	public String getGroup_cd() {
		return group_cd;
	}

	public void setGroup_cd(String group_cd) {
		this.group_cd = group_cd;
	}

	public String getGroup_nm() {
		return group_nm;
	}

	public void setGroup_nm(String group_nm) {
		this.group_nm = group_nm;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode_nm() {
		return code_nm;
	}

	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}
}
