package entity;



public class User {
	private String user_id, user_pw, firstname, lastname, create_ymd, update_ymd;

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCreate_ymd() {
		return create_ymd;
	}

	public void setCreate_ymd(String create_ymd) {
		this.create_ymd = create_ymd;
	}

	public String getUpdate_ymd() {
		return update_ymd;
	}

	public void setUpdate_ymd(String update_ymd) {
		this.update_ymd = update_ymd;
	}
	
	
}
