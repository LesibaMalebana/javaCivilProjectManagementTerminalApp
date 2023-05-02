public class Project {

    // Field. Attributes are defined in the field
    String projectName;
    String projectNumber;
    String building;

    String projectAddress;
    String erfNumber;
    String projectCosts;
    String totalPaid;
    String projectDeadline;

    Person architect; // Attributes
    Person contractor;
    Person customer;
//    String dueDate;

    String outstandingFee;
    // Complete the constructor
    public Project(String projectName, String projectNumber, String building, String projectAddress, String erfNumber, String projectCosts, String totalPaid, String projectDeadline, Person architect, Person contractor, Person customer) {
        this.projectName = projectName;
        this.projectNumber = projectNumber;
        this.building = building;
        this.projectAddress = projectAddress;
        this.erfNumber = erfNumber;
        this.projectCosts = projectCosts;
        this.totalPaid = totalPaid;
        this.projectDeadline = projectDeadline;
        this.architect = architect;
        this.contractor = contractor;
        this.customer = customer;

    }



    // define getters and setters

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public String getErfNumber() {
        return erfNumber;
    }

    public void setErfNumber(String erfNumber) {
        this.erfNumber = erfNumber;
    }

    public String getProjectCosts() {
        return projectCosts;
    }

    public void setProjectCosts(String projectCosts) {
        this.projectCosts = projectCosts;
    }

    public String getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(String totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getProjectDeadline() {
        return projectDeadline;
    }

    public void setProjectDeadline(String projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    public Person getArchitect() {
        return architect;
    }

    public void setArchitect(Person architect) {
        this.architect = architect;
    }

    public Person getContractor() {
        return contractor;
    }

    public void setContractor(Person contractor) {
        this.contractor = contractor;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }


    // define toString


    // Setter and getter Edit Due Date

//    public String getDueDate() {
//        return pro;
//    }
//    public void setDueDate(String dueDate) {
//        this.dueDate = dueDate;
//    }


    public String getOutstandingFee() {
        return outstandingFee = totalPaid;
    }

    public void setOutstandingFee(String outstandingFee) {
        this.outstandingFee = outstandingFee;
    }
    @Override
    public String toString() {
        return "Project" +
                "\nProject Name=" + projectName + '\'' +
                "\nproject Number=" + projectNumber + '\'' +
                "\nBuilding=" + building + '\'' +
                "\nProject Address=" + projectAddress + '\'' +
                "\nErf Number=" + erfNumber + '\'' +
                "\nProject Costs=" + projectCosts + '\'' +
                "\nTotal Paid=" + totalPaid + '\'' +
                "\nProject Deadline=" + projectDeadline + '\'' +
                "\nArchitect=" + architect.toString() + // Fix Customer,Contractor it should display their names
                "\nContractor=" + contractor.toString() +
                "\nCustomer=" + customer.toString() + "\n";
    }
}