package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.util.List;

public class AdministratorGUI extends JFrame {

    private JPanel panel;
    private JTextField textFieldTitle;
    private JTextField textFieldRating;
    private JTextField textFieldCalories;
    private JTextField textFieldProtein;
    private JTextField textFieldFat;
    private JTextField textFieldSodium;
    private JTextField textFieldPrice;

    JButton btnImport;
    JButton btnAddProducts;
    JButton btnDeleteProducts;
    JButton btnModifyProducts;
    JButton btnNewProducts;
    JButton btnGenerateReports;

    public JButton getBtnImport() {
        return btnImport;
    }

    public void setBtnImport(JButton btnImport) {
        this.btnImport = btnImport;
    }

    public JButton getBtnAddProducts() {
        return btnAddProducts;
    }

    public void setBtnAddProducts(JButton btnAddProducts) {
        this.btnAddProducts = btnAddProducts;
    }

    public JButton getBtnDeleteProducts() {
        return btnDeleteProducts;
    }

    public void setBtnDeleteProducts(JButton btnDeleteProducts) {
        this.btnDeleteProducts = btnDeleteProducts;
    }

    public JButton getBtnModifyProducts() {
        return btnModifyProducts;
    }

    public void setBtnModifyProducts(JButton btnModifyProducts) {
        this.btnModifyProducts = btnModifyProducts;
    }

    public JButton getBtnNewProducts() {
        return btnNewProducts;
    }

    public void setBtnNewProducts(JButton btnNewProducts) {
        this.btnNewProducts = btnNewProducts;
    }

    public JButton getBtnGenerateReports() {
        return btnGenerateReports;
    }

    public void setBtnGenerateReports(JButton btnGenerateReports) {
        this.btnGenerateReports = btnGenerateReports;
    }

    /**
     * Create the frame.
     */
    public AdministratorGUI() {
        setTitle("Administrator menu");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 500);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(414, 32, 531, 421);
        panel.add(scrollPane);

        btnImport = new JButton("Import products");
        btnImport.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnImport.setBounds(10, 80, 136, 32);
        panel.add(btnImport);

        btnAddProducts = new JButton("Add products");
        btnAddProducts.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnAddProducts.setBounds(10, 137, 136, 32);
        panel.add(btnAddProducts);

        btnDeleteProducts = new JButton("Delete products");
        btnDeleteProducts.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnDeleteProducts.setBounds(10, 198, 136, 32);
        panel.add(btnDeleteProducts);

        btnModifyProducts = new JButton("Modify products");
        btnModifyProducts.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnModifyProducts.setBounds(10, 255, 136, 32);
        panel.add(btnModifyProducts);

        btnNewProducts = new JButton("New products");
        btnNewProducts.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnNewProducts.setBounds(10, 315, 136, 32);
        panel.add(btnNewProducts);

        btnGenerateReports = new JButton("Generate reports ");
        btnGenerateReports.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnGenerateReports.setBounds(10, 372, 136, 32);
        panel.add(btnGenerateReports);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTitle.setBounds(226, 61, 45, 13);
        panel.add(lblTitle);

        textFieldTitle = new JTextField();
        textFieldTitle.setBounds(226, 80, 96, 19);
        panel.add(textFieldTitle);
        textFieldTitle.setColumns(10);

        textFieldRating = new JTextField();
        textFieldRating.setColumns(10);
        textFieldRating.setBounds(226, 128, 96, 19);
        panel.add(textFieldRating);

        JLabel lblRating = new JLabel("Rating");
        lblRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblRating.setBounds(226, 109, 45, 13);
        panel.add(lblRating);

        textFieldCalories = new JTextField();
        textFieldCalories.setColumns(10);
        textFieldCalories.setBounds(226, 176, 96, 19);
        panel.add(textFieldCalories);

        JLabel lblCalories = new JLabel("Calories");
        lblCalories.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCalories.setBounds(226, 157, 45, 13);
        panel.add(lblCalories);

        textFieldProtein = new JTextField();
        textFieldProtein.setColumns(10);
        textFieldProtein.setBounds(226, 224, 96, 19);
        panel.add(textFieldProtein);

        JLabel lblProtein = new JLabel("Protein");
        lblProtein.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblProtein.setBounds(226, 205, 45, 13);
        panel.add(lblProtein);

        textFieldFat = new JTextField();
        textFieldFat.setColumns(10);
        textFieldFat.setBounds(226, 274, 96, 19);
        panel.add(textFieldFat);

        JLabel lblFat = new JLabel("Fat");
        lblFat.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFat.setBounds(226, 255, 45, 13);
        panel.add(lblFat);

        textFieldSodium = new JTextField();
        textFieldSodium.setColumns(10);
        textFieldSodium.setBounds(226, 322, 96, 19);
        panel.add(textFieldSodium);

        JLabel lblSodium = new JLabel("Sodium");
        lblSodium.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSodium.setBounds(226, 303, 45, 13);
        panel.add(lblSodium);

        textFieldPrice = new JTextField();
        textFieldPrice.setColumns(10);
        textFieldPrice.setBounds(226, 370, 96, 19);
        panel.add(textFieldPrice);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPrice.setBounds(226, 351, 45, 13);
        panel.add(lblPrice);

        this.setContentPane(panel);
        this.setVisible(true);
        repaint();
        revalidate();
    }

    public JTextField getTextFieldTitle() {
        return textFieldTitle;
    }

    public JTextField getTextFieldRating() {
        return textFieldRating;
    }

    public JTextField getTextFieldCalories() {
        return textFieldCalories;
    }

    public JTextField getTextFieldProtein() {
        return textFieldProtein;
    }

    public JTextField getTextFieldFat() {
        return textFieldFat;
    }

    public JTextField getTextFieldSodium() {
        return textFieldSodium;
    }

    public JTextField getTextFieldPrice() {
        return textFieldPrice;
    }

    JScrollPane scrollPane;
    JList list;
    public void updateList(List objectList){
        list=new JList(objectList.toArray());
        //list.setBounds(0, 0, 531, 421);
        scrollPane.setViewportView(list);
        repaint();
        revalidate();
    }

    public JList getList() {
        return list;
    }
}
