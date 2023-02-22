import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class viewTableModel extends AbstractTableModel{

    private ArrayList<Consultation>consultationArray;

    private String[] columnNames = { " Dr. Surname ", "Patient First Name ", " Patient ID ", " Consultation Date and Time ", " Consultation Cost ", " Special Note "};
    public viewTableModel(ArrayList<Consultation> list){
        consultationArray = list;
    }

    @Override
    public int getRowCount() {
        return consultationArray.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;


        if (columnIndex == 0) { // first column - Doctor Surname
            temp = consultationArray.get(rowIndex).getDocFName();

        } else if (columnIndex == 1) { // second column - Patient First Name
            temp = consultationArray.get(rowIndex).getPtFName();

        }else if (columnIndex == 2) { // second column - Patient ID
            temp = consultationArray.get(rowIndex).getPtId();

        }else if (columnIndex == 3) { // third column - Consultation Date and Time
            temp = consultationArray.get(rowIndex).getConDate();

        }
        else if (columnIndex == 4) { // fourth column - Consultation Cost
            temp = consultationArray.get(rowIndex).getCost();

        }
        else if (columnIndex == 5) { // fifth column - Special Note
            temp = consultationArray.get(rowIndex).getNotes();

        }
        return temp;

    }


    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

}
