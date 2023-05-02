import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class PoisedDBMain {

    // Define static/global variables
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
    static Scanner userInput = new Scanner(System.in); // Camel case

    // Define main function
    public static void main(String[] args) {
        Project currentProject = null;

        while (true) {

            // Request input from the user and store the response in a variable
            System.out.println("1. Create new Project\n2. Edit Existing Project\n3. Exit");
            String menuChoice = userInput.nextLine();

            // Call relevant function based on user's input
            if (menuChoice.equals("1")) {
                currentProject = createProject(); // handle if the project doesn't exsist
                System.out.println(currentProject);// createProject();
            }
            else if (menuChoice.equals("2")) {
                if (currentProject != null) {


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
            }
        }
    }

    private static Project createProject() {

        // Get input from the user
        System.out.println("Enter the Project number.");
        String prjNumber = userInput.nextLine(); // prompt the user to get Project number
        System.out.println("Enter the Project Name.");
        String prjName = userInput.nextLine(); // prompt the user to get project name
        System.out.println("What type of building is being designed? E.g. House, apartment block or\n" + "store, etc");
        String prjBuildingDesign = userInput.nextLine();
        System.out.println("Enter the Physical Address.");
        String prjPhysicalAddress = userInput.nextLine();
        System.out.println("Enter the ERF number");
        String prjErfNum = userInput.nextLine();
        System.out.println("Enter the Total fee being charged for the Project.");
        String prjTotalFee = userInput.nextLine();
        System.out.println("The total amount paid to date.");
        String prjTotalFeePaid = userInput.nextLine();
        System.out.println("Deadline for the project.");
        String prjDeadLine = userInput.nextLine();

        // Create A person object for architect, contractor and customer

        Person personArchitect = createPerson("Architecture");
        Person personContractor = createPerson("Contractor");
        Person personCustomer = createPerson("Customer");
        // Create project object using information gathered from user and person object

        Project tempProg = new Project(prjNumber, prjName, prjBuildingDesign, prjPhysicalAddress, prjErfNum, prjTotalFee, prjTotalFeePaid, prjDeadLine, personArchitect, personContractor, personCustomer);
        return tempProg;

    }

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

        // use this to create person objects
        Person tempPerson = new Person(personName, personEmailAddress, personPhysicalAddress, personTelNumber);
        return tempPerson;

    }

    private static void editDueDate(Project projectObj) {
        // Get information from the user
        System.out.println("Amend the Due Date of the Project");
        String updateDueDate = userInput.nextLine();

        // User setter to change the project information
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


        // if project is outstanding then generate invoice

        // Mark project as complete

        // Write project to finalized text file
    }


}

