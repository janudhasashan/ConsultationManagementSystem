import java.util.ArrayList;
import java.util.Date;

public class Patient extends Person{
    private int PatientUID;
    static ArrayList<Patient> patientsDetails = new ArrayList<Patient>();

    public Patient(String Name, String Surname, Date Dob, int MobileNum, String Gender, int PatientUID){
        super(Name,Surname,Dob, MobileNum,Gender);
        this.PatientUID=PatientUID;
    }

    public void setPatientUID(int patientUID) {
        PatientUID = PatientUID;
    }

    public int getPatientUID() {
        return PatientUID;
    }
}
