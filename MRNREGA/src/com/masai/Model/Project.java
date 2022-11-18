package com.masai.Model;


public class Project {

	private int projectId;
	private String projectName;
	private String projectWorkDetail;
	private String projectWorkLocation;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String projectName, String projectWorkDetail, String projectWorkLocation) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectWorkDetail = projectWorkDetail;
		this.projectWorkLocation = projectWorkLocation;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectWorkDetail() {
		return projectWorkDetail;
	}

	public void setProjectWorkDetail(String projectWorkDetail) {
		this.projectWorkDetail = projectWorkDetail;
	}

	public String getProjectWorkLocation() {
		return projectWorkLocation;
	}

	public void setProjectWorkLocation(String projectWorkLocation) {
		this.projectWorkLocation = projectWorkLocation;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectWorkDetail="
				+ projectWorkDetail + ", projectWorkLocation=" + projectWorkLocation + "]";
	}

	
	
	
	
}
