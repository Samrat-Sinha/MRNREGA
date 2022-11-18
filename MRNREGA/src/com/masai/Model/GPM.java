package com.masai.Model;

public class GPM {

	private int gpmId;
	private String gpmName;
	private String gpmVillage;
	private String gpmEmail;
	private String gpmpassword;
	
	public GPM() {
		super();
	}
	
	public GPM(int gpmId, String gpmName, String gpmVillage, String gpmEmail, String gpmpassword) {
		super();
		this.gpmId = gpmId;
		this.gpmName = gpmName;
		this.gpmVillage = gpmVillage;
		this.gpmEmail = gpmEmail;
		this.gpmpassword = gpmpassword;
	}

	public int getGpmId() {
		return gpmId;
	}

	public void setGpmId(int gpmId) {
		this.gpmId = gpmId;
	}

	public String getGpmName() {
		return gpmName;
	}

	public void setGpmName(String gpmName) {
		this.gpmName = gpmName;
	}

	public String getGpmVillage() {
		return gpmVillage;
	}

	public void setGpmVillage(String gpmVillage) {
		this.gpmVillage = gpmVillage;
	}

	public String getGpmEmail() {
		return gpmEmail;
	}

	public void setGpmEmail(String gpmEmail) {
		this.gpmEmail = gpmEmail;
	}

	public String getGpmpassword() {
		return gpmpassword;
	}

	public void setGpmpassword(String gpmpassword) {
		this.gpmpassword = gpmpassword;
	}

	@Override
	public String toString() {
		return "GPM [gpmId=" + gpmId + ", gpmName=" + gpmName + ", gpmVillage=" + gpmVillage + ", gpmEmail=" + gpmEmail
				+ ", gpmpassword=" + gpmpassword + "]";
	}
	
	
}
