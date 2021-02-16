package E15_2;

public class Student implements Comparable
{
    private String firstName;
    private String lastName;
    private int ID;
    public Student(String firstName, String lastName, int ID)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getID()
    {
        return ID;
    }


    // Overrides compareTo method
    @Override
    public int compareTo(Object o)
    {
        Student student = (Student) o;
        int lastNameComp = this.lastName.compareTo(student.lastName);
        if(lastNameComp != 0)
            return lastNameComp;
        int firstNameComp = this.firstName.compareTo(student.firstName);
        if(firstNameComp != 0)
            return firstNameComp;
        return this.ID - student.getID();
    }

    // Overrides toString method
    @Override
    public String toString() {
        return firstName + " " + lastName + "(ID="+ID+"): ";
    }

    // Overrides equals method
    @Override
    public boolean equals(Object o) {

        Student student = (Student) o;
        if((student.firstName.equals(firstName)) && (student.lastName.equals(lastName) && (student.hashCode() == ID)))
            return true;
        else
            return false;
    }

    // Overrides hashcode method to return ID as hashcode
    @Override
    public int hashCode() {
        return ID;
    }
}
