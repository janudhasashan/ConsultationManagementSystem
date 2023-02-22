import  org.junit.Test;

import java.util.Date;
import static org.junit.Assert.assertEquals;

public class WestminsterSkinConsultationManagerTesting {
    @Test
    public void addDoctor() {
        Date date1 = new Date();
        date1.setYear(1997);
        date1.setMonth(01);
        date1.setDate(23);
        WestminsterSkinConsultationManager.doctors.add(0,new Doctor("Peter", "Samuel", date1,0703453215,"Male",0024, "Cosmetic"));

        assertEquals("Peter",WestminsterSkinConsultationManager.doctors.get(0).getName());
    }


    @Test
    public void deleteDoctor() {
        Date date1 = new Date();
        date1.setYear(1997);
        date1.setMonth(01);
        date1.setDate(23);

        Date date2 = new Date();
        date2.setYear(1995);
        date2.setMonth(04);
        date2.setDate(15);

        WestminsterSkinConsultationManager.doctors.add(new Doctor("Peter", "Samuel", date1,0703453215,"Male",0024, "Cosmetic"));
        WestminsterSkinConsultationManager.doctors.add(new Doctor("Janudha", "Gunawardena", date2,07012543265,"Male",0045, "Medical"));

        WestminsterSkinConsultationManager.doctors.remove(0);
        assertEquals("Janudha",WestminsterSkinConsultationManager.doctors.get(0).getName());
    }

    @Test
    public void printDoctors() {
        Date date1 = new Date();
        date1.setYear(1997);
        date1.setMonth(01);
        date1.setDate(23);

        Date date2 = new Date();
        date2.setYear(1995);
        date2.setMonth(04);
        date2.setDate(15);

        WestminsterSkinConsultationManager.doctors.add(new Doctor("Peter", "Samuel", date1,0703453215,"Male",0024, "Cosmetic"));
        WestminsterSkinConsultationManager.doctors.add(new Doctor("Janudha", "Gunawardena", date2,07012543265,"Male",0045, "Medical"));


        WestminsterSkinConsultationManager.printDoctors();
        assertEquals("Janudha",WestminsterSkinConsultationManager.doctors.get(0).getName());
    }
}
