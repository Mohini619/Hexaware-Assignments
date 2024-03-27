package com.tables;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

public class JobListing {
	private int jobID;
    private int companyID;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private double salary;
    private String jobType;
    private Timestamp postedDate;
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public Timestamp getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Timestamp postedDate) {
		this.postedDate = postedDate;
	}
	public JobListing(int jobID, int companyID, String jobTitle, String jobDescription, String jobLocation,
			double salary, String jobType, Timestamp postedDate) {
		super();
		this.jobID = jobID;
		this.companyID = companyID;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.salary = salary;
		this.jobType = jobType;
		this.postedDate = postedDate;
	}
	
	@Override
	public String toString() {
		return "JobListing [jobID=" + jobID + ", companyID=" + companyID + ", jobTitle=" + jobTitle
				+ ", jobDescription=" + jobDescription + ", jobLocation=" + jobLocation + ", salary=" + salary
				+ ", jobType=" + jobType + ", postedDate=" + postedDate + "]";
	}
	
	Map<Integer,String> applicants=new LinkedHashMap<>();
	 public void apply(int applicantID, String coverLetter) {
	     applicants.put(applicantID, coverLetter);
	        System.out.println("Application submitted successfully.");
	    }

	    public Map<Integer,String> getApplicants() {
	        return applicants;
	    }

}
