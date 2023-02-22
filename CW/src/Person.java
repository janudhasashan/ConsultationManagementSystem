import java.util.Date;

public class Person {
    private String Name;
    private String Surname;
    private Date Dob;
    private int MobileNum;
    private String Gender;

    public Person(String Name, String Surname, Date Dob, int MobileNum, String Gender){
        this.Name=Name;
        this.Surname=Surname;
        this.Dob=Dob;
        this.MobileNum=MobileNum;
        this.Gender=Gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = Surname;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date dob) {
        Dob = Dob;
    }

    public int getMobileNum() {
        return MobileNum;
    }

    public void setMobileNum(int mobileNum) {
        MobileNum = MobileNum;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = Gender;
    }
}
