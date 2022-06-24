package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.util.List;

public class ReportsGUI extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldStartHour;
    private JTextField textFieldEndHour;
    private JTextField textFieldOrder;
    private JTextField textFieldOrderValue;
    private JTextField textFieldClients;
    private JTextField textFieldSpecifiedDays;

    private JButton generate1;
    private JButton generate2;
    private JButton generate3;
    private JButton generate4;

    /**
     * Create the frame.
     */
    public ReportsGUI() {
        setTitle("Reports");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(300, 28, 409, 325);
        contentPane.add(scrollPane);

        JLabel lblTimeIntervals = new JLabel("Time intervals:");
        lblTimeIntervals.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTimeIntervals.setBounds(10, 63, 77, 13);
        contentPane.add(lblTimeIntervals);

        textFieldStartHour = new JTextField();
        textFieldStartHour.setBounds(10, 116, 77, 19);
        contentPane.add(textFieldStartHour);
        textFieldStartHour.setColumns(10);

        generate1=new JButton("R1");
        generate1.setBounds(215, 116, 70, 19);
        contentPane.add(generate1);

        textFieldEndHour = new JTextField();
        textFieldEndHour.setColumns(10);
        textFieldEndHour.setBounds(124, 116, 77, 19);
        contentPane.add(textFieldEndHour);

        JLabel lblNewLabel = new JLabel("Start hour");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(10, 93, 56, 13);
        contentPane.add(lblNewLabel);

        JLabel lblEndHour = new JLabel("End hour");
        lblEndHour.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEndHour.setBounds(124, 93, 63, 13);
        contentPane.add(lblEndHour);

        JLabel lblSpecifiedNumber = new JLabel("Items ordered more than");
        lblSpecifiedNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSpecifiedNumber.setBounds(10, 158, 163, 13);
        contentPane.add(lblSpecifiedNumber);

        textFieldOrder = new JTextField();
        textFieldOrder.setBounds(10, 181, 77, 19);
        contentPane.add(textFieldOrder);
        textFieldOrder.setColumns(10);

        generate2=new JButton("R2");
        generate2.setBounds(215, 181, 70, 19);
        contentPane.add(generate2);

        JLabel lblOrderValue = new JLabel("Times ordered:      Value:");
        lblOrderValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblOrderValue.setBounds(10, 220, 163, 13);
        contentPane.add(lblOrderValue);

        textFieldOrderValue = new JTextField();
        textFieldOrderValue.setBounds(124, 243, 77, 19);
        contentPane.add(textFieldOrderValue);
        textFieldOrderValue.setColumns(10);

        textFieldClients = new JTextField();
        textFieldClients.setBounds(10, 243, 77, 19);
        contentPane.add(textFieldClients);
        textFieldClients.setColumns(10);

        generate3=new JButton("R3");
        generate3.setBounds(215, 243, 70, 19);
        contentPane.add(generate3);

        JLabel lblSpecifiedDays = new JLabel("Specified days");
        lblSpecifiedDays.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSpecifiedDays.setBounds(10, 279, 163, 13);
        contentPane.add(lblSpecifiedDays);

        textFieldSpecifiedDays = new JTextField();
        textFieldSpecifiedDays.setBounds(10, 302, 77, 19);
        contentPane.add(textFieldSpecifiedDays);
        textFieldSpecifiedDays.setColumns(10);

        generate4=new JButton("R4");
        generate4.setBounds(215, 302, 70, 19);
        contentPane.add(generate4);

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

    public JTextField getTextFieldStartHour() {
        return textFieldStartHour;
    }

    public JTextField getTextFieldEndHour() {
        return textFieldEndHour;
    }

    public JTextField getTextFieldOrder() {
        return textFieldOrder;
    }

    public JTextField getTextFieldOrderValue() {
        return textFieldOrderValue;
    }

    public JTextField getTextFieldClients() {
        return textFieldClients;
    }

    public JTextField getTextFieldSpecifiedDays() {
        return textFieldSpecifiedDays;
    }

    public JButton getGenerate1() {
        return generate1;
    }

    public JButton getGenerate2() {
        return generate2;
    }

    public JButton getGenerate3() {
        return generate3;
    }

    public JButton getGenerate4() {
        return generate4;
    }


}
