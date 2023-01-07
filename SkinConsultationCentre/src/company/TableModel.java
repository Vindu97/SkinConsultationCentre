package company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {
    private String[] columnNames = {"LicenceNumber","First Name","Surname","Specialisation","DateOfBirth","MobileNumber"};
    private ArrayList<Doctor> doctors;

    public TableModel(ArrayList<Doctor> doctorList){
        doctors = doctorList;
    }

    @Override
    public int getRowCount() {
        return doctors.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object doc = null;
        if (columnIndex == 0) {
            doc = doctors.get(rowIndex).getLicenceNumber();
        }
        else if (columnIndex == 1) {
            doc = doctors.get(rowIndex).getName();
        }
        else if (columnIndex == 2) {
            doc = doctors.get(rowIndex).getSurname();
        }
        else if (columnIndex == 3) {
            doc = doctors.get(rowIndex).getSpecialisation();
        }
        else if (columnIndex == 4) {
            doc = doctors.get(rowIndex).getDateOfBirth();
        }
        else if (columnIndex == 5) {
            doc = doctors.get(rowIndex).getMobileNumber();
        }
        return doc;

    }

    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }

}
