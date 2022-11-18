package com.masai.Model;

public class BDO {

	private Integer bdoId;
	private String name;
	private String email;
	private String password;
	
	public BDO() {
		// TODO Auto-generated constructor stub
	}

	public BDO(Integer bdoId, String name, String email, String password) {
		super();
		this.bdoId = bdoId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getBdoId() {
		return bdoId;
	}

	public void setBdoId(Integer bdoId) {
		this.bdoId = bdoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BDO [bdoId=" + bdoId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
