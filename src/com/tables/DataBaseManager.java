package com.tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/careerhub";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Mohini@619";

    public void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

            System.out.println("Database schema and tables initialized successfully.");
        } catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public void insertJobListing(JobListing job) {
        String sql = "INSERT INTO job_listings (companyid, jobtitle, jobdescription, joblocation, salary, jobtype, posteddate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);) {
           statement.setInt(1, job.getCompanyID());
           statement.setString(2, job.getJobTitle());
           statement.setString(3, job.getJobDescription());
           statement.setString(4, job.getJobLocation());
           statement.setDouble(5, job.getSalary());
           statement.setString(6, job.getJobType());
           statement.setTimestamp(7, job.getPostedDate());
           statement.executeUpdate();
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	public void insertCompany(Company company) {
        String insertCompanySQL = "INSERT INTO companies (companyname, location) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(insertCompanySQL)) {
            statement.setString(1, company.getCompanyName());
            statement.setString(2, company.getLocation());
            statement.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void insertApplicant(Applicant applicant) {
        String insertApplicantSQL = "INSERT INTO applicants (firstname, lastname, email, phone, resume) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(insertApplicantSQL)) {
            statement.setString(1, applicant.getFirstName());
            statement.setString(2, applicant.getLastName());
            statement.setString(3, applicant.getEmail());
            statement.setInt(4, applicant.getPhone());
            statement.setString(5, applicant.getResume());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void insertJobApplication(JobApplication application) {
        String insertJobApplicationSQL = "INSERT INTO applications (jobid, applicantid, applicationdate, coverletter) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertJobApplicationSQL)) {
            preparedStatement.setInt(1, application.getJobID());
            preparedStatement.setInt(2, application.getApplicantID());
            preparedStatement.setTimestamp(3,application.getApplicationDate());
            preparedStatement.setString(4, application.getCoverLetter());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting job application: " + e.getMessage());
        }
	}
	
	
	
	 public List<JobListing> getJobListings() {
		 	List<JobListing> job=new ArrayList<>();
	 
	        String getJobListingsSQL = "SELECT * FROM jobs";
	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	             PreparedStatement statement = connection.prepareStatement(getJobListingsSQL);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	            	 int jobID = resultSet.getInt("jobid");
	                 int companyID = resultSet.getInt("companyid");
	                 String jobTitle = resultSet.getString("jobtitle");
	                 String jobDescription = resultSet.getString("jobdescription");
	                 String jobLocation = resultSet.getString("joblocation");
	                 double salary = resultSet.getDouble("salary");
	                 String jobType = resultSet.getString("jobtype");
	                 Timestamp postedDate = resultSet.getTimestamp("posteddate");
	                 JobListing jobListing = new JobListing(jobID, companyID, jobTitle, jobDescription, jobLocation, salary, jobType, postedDate);
	                 job.add(jobListing);
	            	}
	            	
	        	} 
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return job;
	    }
	 
	 public List<Company> getCompanies() {
	        List<Company> companies = new ArrayList<>();
	        String getCompaniesSQL = "SELECT * FROM companies";
	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	             PreparedStatement statement = connection.prepareStatement(getCompaniesSQL);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int companyId = resultSet.getInt("companyid");
	                String companyName = resultSet.getString("companyname");
	                String location = resultSet.getString("location");
	                Company company = new Company(companyId, companyName, location);
	                companies.add(company);
	            }
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return companies;
	    }
	 
	 public List<Applicant> getApplicants() throws SQLException{
	        List<Applicant> applicants = new ArrayList<>();
	        String getApplicantsSQL = "SELECT * FROM applicants";
	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	             PreparedStatement statement = connection.prepareStatement(getApplicantsSQL);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int applicantId = resultSet.getInt("applicantid");
	                String firstName = resultSet.getString("firstname");
	                String lastName = resultSet.getString("lastname");
	               String email = resultSet.getString("email");
	                int phone = resultSet.getInt("phone");
	                String resume = resultSet.getString("resume");
	                Applicant applicant = new Applicant(applicantId, firstName, lastName, email, phone, resume);
	                applicants.add(applicant);
	            }
	        } catch (SQLException e) {
	            System.err.println("Error retrieving applicants: " + e.getMessage());
	        }
	        return applicants;
	    }
	 
	 public List<JobApplication> getApplicationsForJob(int jobId) {
	        List<JobApplication> applications = new ArrayList<>();
	        String getApplicationsForJobSQL = "SELECT * FROM applications WHERE jobid = ?";
	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	             PreparedStatement preparedStatement = connection.prepareStatement(getApplicationsForJobSQL)) {
	            preparedStatement.setInt(1, jobId);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    int applicationId = resultSet.getInt("applicationid");
	                    int applicantId = resultSet.getInt("applicantid");
	                    Timestamp applicationDate = resultSet.getTimestamp("applicationdate");
	                    String coverLetter = resultSet.getString("coverletter");
	                    JobApplication application = new JobApplication(applicationId, jobId, applicantId, applicationDate, coverLetter);
	                    applications.add(application);
	                }
	            }
	        } catch (SQLException e) {
	            System.err.println("Error retrieving job applications: " + e.getMessage());
	        }
	        return applications;
	    }
	 
	  
	 
	 
}
