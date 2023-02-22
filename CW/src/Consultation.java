import java.io.File;
import java.sql.Time;
import java.util.*;

public class Consultation {

    private String DocFName;
    private String DocLName;
    private String DocSpec;
    private int DocId;
    private String PtFName;
    private String PtLName;
    private int PtId;
    private int PtMNum;
    private Double Cost;
    private String Notes;
    private Date ConDate;
    private File ImageFile;

    public Consultation(String docFName, String docLName, String docSpec, int docId, String ptFName, String ptLName, int ptId, int ptMNum, Double cost, String notes, Date conDate, File imageFile) {
        DocFName = docFName;
        DocLName = docLName;
        DocSpec = docSpec;
        DocId = docId;
        PtFName = ptFName;
        PtLName = ptLName;
        PtId = ptId;
        PtMNum = ptMNum;
        Cost = cost;
        Notes = notes;
        ConDate = conDate;
        ImageFile = imageFile;
    }

    public String getDocFName() {
        return DocFName;
    }

    public String getDocLName() {
        return DocLName;
    }

    public String getDocSpec() {
        return DocSpec;
    }

    public int getDocId() {
        return DocId;
    }

    public String getPtFName() {
        return PtFName;
    }

    public String getPtLName() {
        return PtLName;
    }

    public int getPtId() {
        return PtId;
    }

    public int getPtMNum() {
        return PtMNum;
    }

    public Double getCost() {
        return Cost;
    }

    public String getNotes() {
        return Notes;
    }

    public Date getConDate() {
        return ConDate;
    }

    public File getImageFile() {
        return ImageFile;
    }
}
