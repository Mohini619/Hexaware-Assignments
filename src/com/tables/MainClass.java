package com.tables;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	
	 public static void main(String[] args) {
	        DataBaseManager databaseManager = new DataBaseManager();
	        Scanner scanner = new Scanner(System.in);

	        
	        while (true) {
	            System.out.println("Job Board Application Menu:");
	            System.out.println("1. Initialize Database");
	            System.out.println("2. Insert Job Listing");
	            System.out.println("3. Insert Company");
	            System.out.println("4. Insert Applicant");
	            System.out.println("5. Insert Application");
	            System.out.println("6. Retrieve Job Listings");
	            System.out.println("7. Retrieve Companies");
	            System.out.println("8. Retrieve Applicants");
	            System.out.println("9. Retrieve Applications");
	            System.out.println("10. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); 
	         

	            try {
	                switch (choice) {
	                    case 1:
	                        databaseManager.initializeDatabase();
	                        break;
	                    case 2:
	                  
	                        JobListing newJobListing = new JobListing(1,"Software Developer", "Job description", "New York", 80000.0, "Full-time", 2024-03-27 17:45:30);
	                        databaseManager.insertJobListing(newJobListing);
	                        System.out.println("Job listing inserted successfully.");
	                        break;
	                    case 3:
	                       
	                        Company newCompany = new Company(1, "Example Company", "New York");
	                        databaseManager.insertCompany(newCompany);
	                        System.out.println("Company inserted successfully.");
	                        break;
	                    case 4:
	                        
	                        Applicant applicant = new Applicant(1, "John", "Doe", "john.doe@example.com", 123-456-7890, "Resume content for John Doe");
	                        databaseManager.insertApplicant(applicant);
	                        break;
	                    case 5:
	                       
	                        JobApplication jobApplication = new JobApplication(1, 1, 1, 2024-03-12 09:30:00, "Cover letter content for job 1");
	                        databaseManager.insertJobApplication(jobApplication);
	                        break;
	                    case 6:
	                        
	                        System.out.println("Retrieving Job Listings:");
	                        List<JobListing> c=new ArrayList<>();
	                        c=databaseManager.getJobListings();
	                        for(JobListing a:c) {
	                        	System.out.println(a);}
	                        break;
	                    case 7:
	                       
	                        System.out.println("Retrieving Companies:");
	                        List<Company> b=new ArrayList<>();
	                        b=databaseManager.getCompanies();
	                        for(Company a:b) {
	                        	System.out.println(a);}
	                        break;
	                     case 8:
	                       
	                            List<Applicant> applicants = databaseManager.getApplicants();
	                            for (Applicant applicant1 : applicants) {
	                                System.out.println(applicant1);
	                            }
	                            break;
	                            
	                     case 9:
	                      
	                         System.out.print("Enter Job ID: ");
	                         int jobId = scanner.nextInt();
	                         List<JobApplication> jobApplications = databaseManager.getApplicationsForJob(jobId);
	                         for (JobApplication application : jobApplications) {
	                             System.out.println(application);
	                         }
	                         break;
	                    case 10:
	                        System.out.println("Exiting...");
	                        return;
	                    default:
	                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
	                }
	            } catch (Exception e) {
	                System.err.println("Error: " + e.getMessage());
	            }
	        }
	    }

}
