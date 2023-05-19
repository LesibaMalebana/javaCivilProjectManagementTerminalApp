/*
Author Lesiba Mokete Malebana
Dev Date : 03 February 2023
java version "19.0.1" 2022-10-18
Java(TM) SE Runtime Environment (build 19.0.1+10-21)
Java HotSpot(TM) 64-Bit Server VM (build 19.0.1+10-21, mixed mode, sharing)

 */

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class PoisedDBMain {

    // Define global variables
    String prjNumber;
    String prjName;
    String prjBuildingDesign;
    String prjPhysicalAddress;
    String prjErfNum;
    String prjTotalFee;
    String prjTotalFeePaid;
    String prjDeadLine;
    String outstandingFee;
    double amount;
    static Scanner userInput = new Scanner(System.in); // Java scanner Variable named userInput named Camel Case

    // main function
    public static void main(String[] args) {
        Project currentProject = null; //  An empty Object to utilize later in the Code

        while (true) {

            // MenuChoice is a variable that stores userInput as a String
            System.out.println("1. Create new Project\n2. Edit Existing Project\n3. Exit");
            String menuChoice = userInput.nextLine();

            // if statement to condition the user choice and action
            if (menuChoice.equals("1")) {
                currentProject = createProject(); // handle if the project doesn't Exist
                System.out.println(currentProject);// createProject();
            }
            // Menu choice for condition 2
            else if (menuChoice.equals("2")) {
                if (currentProject != null) {

                    // If the project doesn't exist you will be requested to create so you can edit it.
                    // This code runs for as long as Project is not created
                    while (true) {
                        // Write code to determine if the project has been completed. if project has been completed then
                        // inform user and break out of loop
                        // if project  is found then display menu and save user input
                        System.out.println("1. Change Due Date\n2. Update Contractor Information\n3. Finalize Project\n4. exit\nSelection:");
                        String editChoice = userInput.nextLine();

                        // based on user input call the relevant function
                        if (editChoice.equals("1")) {
                            editDueDate(currentProject);
//                            System.out.println("Enter a new due Date");
//                            String userNewDueDate = userInput.nextLine();
//                            currentProject.setDueDate(userNewDueDate);
//                            System.out.println(currentProject);


                        } else if (editChoice.equals("2")) {

                            updateContractor(currentProject);

//                            System.out.println("Update Contractor Name and Surname.");
//                            String userUpdateContractorNameSurname = userInput.nextLine();
//
//                            System.out.println("Update Contractor Email Address");
//                            String updateContractorEmailaddress = userInput.nextLine();
//                            System.out.println("Update Contractor Telephone Number");
//                            String updateContractorTelNumber = userInput.nextLine();
//                            System.out.printf("Update Contractor Physical Address");
//                            String updateContractorPhysicalAddress = userInput.nextLine();


                        } else if (editChoice.equals("3")) {
                            System.out.println("Finale Project status :\n ");
//                            String tempProjectfinalise = currentProject.toString();
                            System.out.println("Project has been finalized");
                            // System.out.println(finaliseProject());
                        } else if (editChoice.equals("4")) {
                            System.out.println("Exit to main menu.");
                            break;
                        }
                    }

                } else {
                    System.out.println("You need to create a project first before you can edit it.");
                }
            }
            else if (menuChoice.equals("5")) {
                break;
                // used to break out of the while loop/Stop the Loop
            }
        }
    }

    private static Project createProject() {

        // Getting input from the user
        System.out.println("Enter the Project number.");
        String prjNumber = userInput.nextLine(); // Storing user Input in Variable prjNumber
        System.out.println("Enter the Project Name.");
        String prjName = userInput.nextLine(); // Storing user Input in Variable prjName
        System.out.println("What type of building is being designed? E.g. House, apartment block or\n" + "store, etc");
        String prjBuildingDesign = userInput.nextLine(); // Storing user Input in Variable prjBuildingDesign
        System.out.println("Enter the Physical Address.");
        String prjPhysicalAddress = userInput.nextLine(); // Storing user Input in Variable prjPhysicalAddress
        System.out.println("Enter the ERF number");
        String prjErfNum = userInput.nextLine(); // Storing user Input in Variable prjErfNum
        System.out.println("Enter the Total fee being charged for the Project.");
        String prjTotalFee = userInput.nextLine(); // Storing user Input in Variable prjTotalFee
        System.out.println("The total amount paid to date.");
        String prjTotalFeePaid = userInput.nextLine(); // Storing user Input in Variable prjTotalFeePaid
        System.out.println("Deadline for the project.");
        String prjDeadLine = userInput.nextLine(); // Storing user Input in Variable prjDeadLine

        // Objects to hold different Data Customer ,Contractor and Architect

        Person personArchitect = createPerson("Architecture");
        Person personContractor = createPerson("Contractor");
        Person personCustomer = createPerson("Customer");

        // project to hold Global Variables
        Project tempProg = new Project(prjNumber, prjName, prjBuildingDesign, prjPhysicalAddress, prjErfNum, prjTotalFee, prjTotalFeePaid, prjDeadLine, personArchitect, personContractor, personCustomer);
        return tempProg;

    }


    // Person Method to hold person Data
    private static Person createPerson(String personType) {
        // get input from user
        System.out.println("Enter the " + personType + " Name: ");
        String personName = userInput.nextLine();
        System.out.println("Enter " + personType + " Email Address: ");
        String personEmailAddress = userInput.nextLine();
        System.out.println("Enter " + personType + " Telephone Number: ");
        String personTelNumber = userInput.nextLine();
        System.out.println("Enter " + personType + " Physical Address: ");
        String personPhysicalAddress = userInput.nextLine();

        // Temporary Objects to hold Person data
        Person tempPerson = new Person(personName, personEmailAddress, personPhysicalAddress, personTelNumber);
        return tempPerson;

    }

    // private Method to edit date
    // restriction is applied here as is specific to certain roles only
    private static void editDueDate(Project projectObj) {
        // Get information from the user
        System.out.println("Amend the Due Date of the Project");
        String updateDueDate = userInput.nextLine();

        System.out.println("Due Date has been update :" + projectObj.getProjectDeadline());
        projectObj.setProjectDeadline(updateDueDate);


        System.out.println("Date has been Successfully updated :" + projectObj.getProjectDeadline());

        // Inform user that the update was successful
    }

    private static void updateContractor(Project projectObj) {

        // Request option from user and store in a variable
        System.out.println("1. Change Email\n2. Change Tell NO\n3. Change Physical Address\n4. exit\nSelection: ");
        String contractorEditChoice = userInput.nextLine();

        // Based on user choice, request the relevant information from user and user relevant setters to change values
        if (contractorEditChoice.equals("1")) {
            System.out.println("Please Enter an Emails Address");
            String emailUserInput = userInput.nextLine();
            projectObj.contractor.setPersonEmail(emailUserInput);
            System.out.println("Email updated to :" + emailUserInput);

        } else if (contractorEditChoice.equals("2")) {
            System.out.println("Please Enter the Telephone Number.");
            String userTelNumber = userInput.nextLine();
            projectObj.contractor.setPersonTelNumber(userTelNumber);
            System.out.println("Telephone has been updated to :" + userTelNumber);

        } else if (contractorEditChoice.equals("3")) {
            System.out.println("Please Enter the Physical Address.");
            String userPhysicalAddress = userInput.nextLine();
            projectObj.contractor.setPersonPhysicalAddress(userPhysicalAddress);
            System.out.println("Physical Address has been updated " + userPhysicalAddress);

        } else if (contractorEditChoice.equals("4")) {
            System.out.println("Going to main");
        } else {
            System.out.println("Incorrect option");
        }
    }

    public String getOutstandingFee() {
        return outstandingFee;
    }

    public void setOutstandingFee(String outstandingFee, String amount) {
        this.outstandingFee = amount;
    }

    public boolean isOutstanding() {
        return this.amount > 0;
    }

    private static void finaliseProject(Project projectObj) {
        // Determine if there is any outstanding fee using getters and setter
        // if statement to determine if variable fee is greater than zero or not
        // outstandingFee = amount;
        int tempProjectCost = Integer.parseInt(projectObj.projectCosts); //Type Cast
        int temAmountPaid = Integer.parseInt(projectObj.totalPaid);
        if ((tempProjectCost - temAmountPaid) == 0) {
            System.out.println("Payment is Up-to Date.");
            System.out.println("Project is Finalised.");
        } else {
            System.out.println("Payment is Outstanding");
        }



    }


}

