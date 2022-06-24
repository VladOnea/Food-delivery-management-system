package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EmployeeGUI extends JFrame {

    private JPanel contentPane;


    public EmployeeGUI() {
        setTitle("Employee menu");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(24, 29, 385, 224);
        contentPane.add(scrollPane);

        this.setVisible(true);

    }

    JScrollPane scrollPane;
    JList list;
    public void updateList(List objectList){
        list=new JList(objectList.toArray());
        scrollPane.setViewportView(list);
        repaint();
        revalidate();
    }

    public JList getList() {
        return list;
    }
}
