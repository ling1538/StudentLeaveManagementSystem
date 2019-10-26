package com.imooc.bean;

public class Login {
	/**
	 * ID帐号
	 */
	private int id;
	
	/**
	 * 身份
	 */
	private String l_identity;
	/**
	 * 密码
	 */
	private String l_password;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getL_identity() {
		return l_identity;
	}
	public void setL_identity(String l_identity) {
		this.l_identity = l_identity;
	}
	public String getL_password() {
		return l_password;
	}
	public void setL_password(String l_password) {
		this.l_password = l_password;
	}
	
}
