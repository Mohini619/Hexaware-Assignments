package com.tables;
import java.util.LinkedHashMap;
import java.util.Map;

public class Applicant {

	
	private int applicantID;
    private String firstName;
    private String lastName;
    private String email;
    private int phone;
    private String resume;
	public int getApplicantID() {
		return applicantID;
	}
	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public Applicant(int applicantID, String firstName, String lastName, String email, int phone, String resume) {
		super();
		this.applicantID = applicantID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.resume = resume;
	}
	@Override
	public String toString() {
		return "Applicant [applicantID=" + applicantID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", resume=" + resume + "]";
	}
	 public void createProfile(String email, String firstName, String lastName, int phone) {
	        setEmail(email);
	        setFirstName(firstName);
	        setLastName(lastName);
	        setPhone(phone);
	        System.out.println("Applicant profile created successfully.");
	    }

	    public void applyForJob(int jobID, String coverLetter) {
	    	Map<Integer,String> job=new LinkedHashMap<>();
	    	job.put(jobID, coverLetter);
	        System.out.println("Application submitted successfully for Job ID: " + jobID);
	    }
    
    
}
