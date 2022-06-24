package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import javax.swing.JList;

public class ClientGUI extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldKeyword;
    private JTextField textFieldRating;
    private JTextField textFieldCalories;
    private JTextField textFieldProteins;
    private JTextField textFieldFats;
    private JTextField textFieldSodium;
    private JTextField textFieldPrice;

    JButton btnCreateOrder;
    JButton btnSearch;

    /**
     * Create the frame.
     */
    public ClientGUI() {
        setTitle("Client menu");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblKeyword = new JLabel("Keyword");
        lblKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblKeyword.setBounds(70, 25, 62, 13);
        contentPane.add(lblKeyword);

        textFieldKeyword = new JTextField();
        textFieldKeyword.setBounds(70, 48, 117, 19);
        contentPane.add(textFieldKeyword);
        textFieldKeyword.setColumns(10);

        JLabel lblRating = new JLabel("Rating");
        lblRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblRating.setBounds(70, 77, 62, 13);
        contentPane.add(lblRating);

        textFieldRating = new JTextField();
        textFieldRating.setColumns(10);
        textFieldRating.setBounds(70, 100, 117, 19);
        contentPane.add(textFieldRating);

        JLabel lblCalories = new JLabel("Calories");
        lblCalories.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCalories.setBounds(70, 129, 45, 13);
        contentPane.add(lblCalories);

        textFieldCalories = new JTextField();
        textFieldCalories.setColumns(10);
        textFieldCalories.setBounds(70, 152, 117, 19);
        contentPane.add(textFieldCalories);

        JLabel lblProteins = new JLabel("Proteins");
        lblProteins.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblProteins.setBounds(70, 182, 45, 13);
        contentPane.add(lblProteins);

        textFieldProteins = new JTextField();
        textFieldProteins.setColumns(10);
        textFieldProteins.setBounds(70, 205, 117, 19);
        contentPane.add(textFieldProteins);

        JLabel lblFats = new JLabel("Fats");
        lblFats.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFats.setBounds(70, 234, 45, 13);
        contentPane.add(lblFats);

        textFieldFats = new JTextField();
        textFieldFats.setColumns(10);
        textFieldFats.setBounds(70, 257, 117, 19);
        contentPane.add(textFieldFats);

        JLabel lblSodium = new JLabel("Sodium");
        lblSodium.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSodium.setBounds(70, 286, 45, 13);
        contentPane.add(lblSodium);

        textFieldSodium = new JTextField();
        textFieldSodium.setColumns(10);
        textFieldSodium.setBounds(70, 309, 117, 19);
        contentPane.add(textFieldSodium);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPrice.setBounds(70, 336, 45, 13);
        contentPane.add(lblPrice);

        textFieldPrice = new JTextField();
        textFieldPrice.setColumns(10);
        textFieldPrice.setBounds(70, 359, 117, 19);
        contentPane.add(textFieldPrice);

         btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSearch.setBounds(70, 388, 117, 21);
        contentPane.add(btnSearch);

         btnCreateOrder = new JButton("Create order");
        btnCreateOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnCreateOrder.setBounds(70, 419, 117, 21);
        contentPane.add(btnCreateOrder);

        scrollPane= new JScrollPane();
        scrollPane.setBounds(282, 32, 394, 408);
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

    public JButton getBtnCreateOrder() {
        return btnCreateOrder;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JTextField getTextFieldKeyword() {
        return textFieldKeyword;
    }

    public JTextField getTextFieldRating() {
        return textFieldRating;
    }

    public JTextField getTextFieldCalories() {
        return textFieldCalories;
    }

    public JTextField getTextFieldProteins() {
        return textFieldProteins;
    }

    public JTextField getTextFieldFats() {
        return textFieldFats;
    }

    public JTextField getTextFieldSodium() {
        return textFieldSodium;
    }

    public JTextField getTextFieldPrice() {
        return textFieldPrice;
    }
}
