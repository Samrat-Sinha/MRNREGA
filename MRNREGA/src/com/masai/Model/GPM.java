package com.masai.Model;

public class GPM {
	private int gpmID;
	private String gpmName;
	private String gpmEmail;
	private String gpmpassword;
	private String gpmAddress;
	
	public GPM() {
		// TODO Auto-generated constructor stub
	}

	public GPM(int gpmID, String gpmName, String gpmEmail, String gpmpassword, String gpmAddress) {
		super();
		this.gpmID = gpmID;
		this.gpmName = gpmName;
		this.gpmEmail = gpmEmail;
		this.gpmpassword = gpmpassword;
		this.gpmAddress = gpmAddress;
	}

	public int getGpmID() {
		return gpmID;
	}

	public void setGpmID(int gpmID) {
		this.gpmID = gpmID;
	}

	public String getGpmName() {
		return gpmName;
	}

	public void setGpmName(String gpmName) {
		this.gpmName = gpmName;
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

	public String getGpmAddress() {
		return gpmAddress;
	}

	public void setGpmAddress(String gpmAddress) {
		this.gpmAddress = gpmAddress;
	}

	@Override
	public String toString() {
		return "GPM [gpmID=" + gpmID + ", gpmName=" + gpmName + ", gpmEmail=" + gpmEmail + ", gpmpassword="
				+ gpmpassword + ", gpmAddress=" + gpmAddress + "]";
	}
	
	
	
	
}
