package company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultationTable extends JFrame implements ActionListener {

    JTable myTable;
    ConsultationTableModel tableModel;
    ArrayList<Doctor> doctors;
    JLabel label = new JLabel();
    JButton submitButton1;
    JButton BackBtn;
    JComboBox comboBox;


    public ConsultationTable(ArrayList<Doctor> doctors){
        this.doctors = doctors;
        tableModel = new ConsultationTableModel(doctors);
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
        this.setBounds(0, 50, 90, 40);
//        this.setSize(600, 540);
        this.add(panel);
        panel.setBackground(new Color(0xE3B8B8));

        this.setTitle("SkinConsultation ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setLayout(null);
        this.setResizable(true);
        this.setSize(600, 600);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0xE3B8B8));



        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        add(new JLabel("Enter LicenceNumber :")).setFont(new Font("SERIF", Font.BOLD, 20));
//        add(new JLabel("        *  ID")).setFont(new Font("SERIF", Font.BOLD, 20));
//        add(new JTextField(12)).setFont(new Font("SERIF",Font.PLAIN, 20));
//        WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();

//        String[] a = {"ddoo","cat","adad"};

        ArrayList<Doctor> Object = new ArrayList<Doctor>(doctors);
        JComboBox<String> comboBox = new JComboBox<>();

        for (Doctor obj : Object){
            comboBox.addItem(obj.getName());
        }




        submitButton1 = new JButton("Submit");
        submitButton1.setVerticalAlignment(JButton.CENTER);
        submitButton1.setHorizontalAlignment(JButton.CENTER);
        submitButton1.setFont(new Font("SERIF", Font.PLAIN, 20));
        submitButton1.setBounds(180,360,200,50);
        submitButton1.setBackground(new Color(0xAD86CB86));

        this.add(comboBox);
        this.add(submitButton1);
        this.add(panel);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==comboBox){
//            submitButton.setVisible(true);
            System.out.println(comboBox.getSelectedIndex());

        }
    }
}
