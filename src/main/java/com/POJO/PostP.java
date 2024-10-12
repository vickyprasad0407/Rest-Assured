package com.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostP {
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	public PostP(String createdBy,String projectName, String status,int i)
	{
		this.createdBy=createdBy;
		this.projectName=projectName;
		this.status=status;
		this.teamSize=i;
	}
	public PostP()
	{
		
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	@Override
	public String toString() {
		return "{createdBy=" + createdBy + ", projectName=" + projectName + ", status=" + status + ", teamSize="
				+ teamSize + "}";
	} 
	
	

}
