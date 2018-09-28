package com.metacube.training.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="job_details")
public class JobDetails {

	@Id
	@Column(name = "id")
	int id;
	
	@Column(name="date_of_joining")
	Date dateOfJoining;
	
	@Column(name="emp_id")
	int empId;
	
	@Column(name="total_exp")
	int totalExp;
	
	@Column(name="job_code")
	int jobCode;
	
	@Column(name="reporting_manager")
	int reportingManager;
	
	@Column(name="team_lead")
	int teamLead;
	
	@Column(name="project_id")
	int projectId;
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}
	public int getJobCode() {
		return jobCode;
	}
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	public int getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(int reportingManager) {
		this.reportingManager = reportingManager;
	}
	public int getTeamLead() {
		return teamLead;
	}
	public void setTeamLead(int teamLead) {
		this.teamLead = teamLead;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
