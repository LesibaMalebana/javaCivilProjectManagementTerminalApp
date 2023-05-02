public class Person {

    // Field. Define;

    String personName;
    String personTelNumber;
    String personEmail;
    String personPhysicalAddress;


    public Person(String personName, String personTelNumber, String personEmail, String personPhysicalAddress) {
        this.personName = personName;
        this.personTelNumber = personTelNumber;
        this.personEmail = personEmail;
        this.personPhysicalAddress = personPhysicalAddress;
    }


    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonTelNumber() {
        return personTelNumber;
    }

    public void setPersonTelNumber(String personTelNumber) {
        this.personTelNumber = personTelNumber;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonPhysicalAddress() {
        return personPhysicalAddress;
    }

    public void setPersonPhysicalAddress(String personPhysicalAddress) {
        this.personPhysicalAddress = personPhysicalAddress;
    }

    @Override
    public String toString() {
        return "Person" +
                "\nPerson Name=" + personName + '\'' +
                "\nPerson Telephone Number=" + personTelNumber + '\'' +
                "\nPerson Email=" + personEmail + '\'' +
                "\nperson PhysicalAddress=" + personPhysicalAddress + '\n';
    }
}
