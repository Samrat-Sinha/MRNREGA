package com.masai.Model;


public class Project {

	private int projectId;
	private String projectDesc;
	private String projectDist;
	private String projectVillage;
	//private LocalDate projectDate;
	
	public Project() {
		super();
	}

	public Project(int projectId, String projectDesc, String projectDist, String projectVillage
			) {
		super();
		this.projectId = projectId;
		this.projectDesc = projectDesc;
		this.projectDist = projectDist;
		this.projectVillage = projectVillage;
		//this.projectDate = projectDate;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getProjectDist() {
		return projectDist;
	}

	public void setProjectDist(String projectDist) {
		this.projectDist = projectDist;
	}

	public String getProjectVillage() {
		return projectVillage;
	}

	public void setProjectVillage(String projectVillage) {
		this.projectVillage = projectVillage;
	}

//	public LocalDate getProjectDate() {
//		return projectDate;
//	}
//
//	public void setProjectDate(LocalDate projectDate) {
//		this.projectDate = projectDate;
//	}

	@Override
	public String toString() {
		return "CreateProject [projectId=" + projectId + ", projectDesc=" + projectDesc + ", projectDist=" + projectDist
				+ ", projectVillage=" + projectVillage + "]";
	}
	
	
	
}
