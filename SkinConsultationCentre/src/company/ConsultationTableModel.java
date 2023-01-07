package company;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ConsultationTableModel extends AbstractTableModel {

    private String[] columnNames = {"LicenceNumber","First Name","Specialisation"};
    private ArrayList<Doctor> doctors;

    public ConsultationTableModel(ArrayList<Doctor> doctorList){
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
            doc = doctors.get(rowIndex).getSpecialisation();
        }

        return doc;

    }


    // needed to show column names in JTable
    public String getColumnName(int col) {
        return columnNames[col];
    }


}
