import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Doctor extends Person{
    private int MedicalLicenseNum;
    private String Specialisation;

    static ArrayList<Doctor> cosmetic = new ArrayList<>();
    static ArrayList<Doctor> medical = new ArrayList<>();
    static ArrayList<Doctor> paediatric = new ArrayList<>();

    public Doctor(String Name, String Surname, Date Dob, int MobileNum, String Gender, int MedicalLicenseNum, String Specialisation){

        super(Name,Surname,Dob, MobileNum,Gender);
        this.MedicalLicenseNum =MedicalLicenseNum;
        this.Specialisation=Specialisation;
    }


    public static Comparator<Doctor>surNameComparator = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor o1, Doctor o2) {
            String  surName1 = o1.getSurname();
            String surName2 = o2.getSurname();
            return surName1.compareTo(surName2);
        }
    };

    public int getMedicalLicenseNum() {
        return MedicalLicenseNum;
    }

    public void setMedicalLicenseNum(int medicalLicenseNum) {
        MedicalLicenseNum = MedicalLicenseNum;
    }

    public String getSpecialisation() {
        return Specialisation;
    }

    public void setSpecialisation(String specialisation) {
        Specialisation = Specialisation;
    }
}
