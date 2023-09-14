package com.example.first.vo;

import java.sql.Date;

public class UserVO {
	private String user_id, user_pw, user_name;
	private Date create_ymd, update_ymd;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public Date getCreate_ymd() {
		return create_ymd;
	}

	public void setCreate_ymd(Date create_ymd) {
		this.create_ymd = create_ymd;
	}

	public Date getUpdate_ymd() {
		return update_ymd;
	}

	public void setUpdate_ymd(Date update_ymd) {
		this.update_ymd = update_ymd;
	}



	
	
}
