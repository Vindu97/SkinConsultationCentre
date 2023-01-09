package company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Table extends JFrame {

    JTable myTable;
    TableModel tableModel;
    ArrayList<Doctor> doctors;

    public Table(ArrayList<Doctor> doctors){


        this.doctors = doctors;
        tableModel = new TableModel(doctors);
        myTable =  new JTable(tableModel);

        setBounds(10,10,400,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        myTable.setAutoCreateRowSorter(true);

        myTable.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer(){
            Color originalColor = null;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                Component renderer =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                return renderer;
            }
        });



        JScrollPane scrollPane = new JScrollPane(myTable);
        scrollPane.setPreferredSize(new Dimension(500,400));

//        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);
//        panel.setBackground(new Color(0xE3B8B8));
        this.setBounds(0, 50, 90, 40);
        this.setSize(600, 540);

        this.setTitle("SkinConsultation ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.getContentPane().setBackground(new Color(0xE3B8B8));





        setLayout(new FlowLayout(FlowLayout.CENTER,5,10));

        add(new JLabel("Doctor Information ")).setFont(new Font("SERIF", Font.BOLD, 20));



        this.add(panel);



    }

}

