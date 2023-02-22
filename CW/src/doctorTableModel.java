import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class doctorTableModel extends AbstractTableModel {

    private ArrayList<Doctor> docList;
    private String[] columnNames = { "Medical License Number ", " First Name ", " Surname", " Specialization ", " Mobile Number"};

    public doctorTableModel(ArrayList<Doctor> list){
        docList = list;
    }

    @Override
    public int getRowCount() {
        return docList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;


        if (columnIndex == 0) { // first column - ML Number
            temp = docList.get(rowIndex).getMedicalLicenseNum();

        } else if (columnIndex == 1) { // second column - First Name
            temp = docList.get(rowIndex).getName();

        }else if (columnIndex == 2) { // second column - Surname
            temp = docList.get(rowIndex).getSurname();

        }else if (columnIndex == 3) { // third column - Specialization
            temp = docList.get(rowIndex).getSpecialisation();

        }
        else if (columnIndex == 4) { // fourth column - Mobile Number
            temp = docList.get(rowIndex).getMobileNum();

        }
        return temp;

    }



    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }



}
