package GUI;

import businessLogic.*;
import dataAccess.Serializator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private DeliveryService deliveryService;

    public Controller(){
        List<EmployeeGUI> employees=new ArrayList<>();
        deliveryService=new DeliveryService();
        LoginGUI loginGUI= new LoginGUI();
        loginGUI.getBtnLogin().addActionListener(e->{
            User user;
            try{
                user=deliveryService.login(loginGUI.getUsername(),loginGUI.getPassword());
            }catch (AssertionError error){
                JOptionPane.showMessageDialog(new JFrame(),error.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(user.getRole()==0){   // Administrator
                AdministratorGUI adminGUI=new AdministratorGUI();
                adminGUI.updateList(deliveryService.getMenuItems());
                adminGUI.getBtnGenerateReports().addActionListener(f->{
                    ReportsGUI reportsGUI=new ReportsGUI();
                    reportsGUI.getGenerate1().addActionListener(u->{
                        try{
                            reportsGUI.updateList(deliveryService.report(Integer.parseInt(reportsGUI.getTextFieldStartHour().getText()),Integer.parseInt(reportsGUI.getTextFieldEndHour().getText())));
                        }catch (Exception ex){
                            JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    });
                    reportsGUI.getGenerate2().addActionListener(u->{
                        try{
                            reportsGUI.updateList(deliveryService.report(Integer.parseInt(reportsGUI.getTextFieldOrder().getText())));
                        }catch (Exception ex){
                            JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    });
                    reportsGUI.getGenerate3().addActionListener(u->{
                        try{
                            reportsGUI.updateList(deliveryService.report3(Integer.parseInt(reportsGUI.getTextFieldClients().getText()),Integer.parseInt(reportsGUI.getTextFieldOrderValue().getText())));
                        }catch (Exception ex){
                            JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    });
                    reportsGUI.getGenerate4().addActionListener(u->{
                        try{
                            String[] date=reportsGUI.getTextFieldSpecifiedDays().getText().split("/");
                            reportsGUI.updateList(deliveryService.report(LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]) )));
                        }catch (Exception ex){
                            JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    });
                });
                adminGUI.getBtnAddProducts().addActionListener(f->{
                    try{
                        deliveryService.addMenuItem(new BaseProduct(adminGUI.getTextFieldTitle().getText(),Double.parseDouble(adminGUI.getTextFieldRating().getText()) ,Double.parseDouble(adminGUI.getTextFieldCalories().getText()),Double.parseDouble(adminGUI.getTextFieldProtein().getText()),Double.parseDouble(adminGUI.getTextFieldFat().getText()),Double.parseDouble(adminGUI.getTextFieldSodium().getText()),Double.parseDouble(adminGUI.getTextFieldPrice().getText()) ));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(new JFrame(),"Invalid number format.","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }catch (AssertionError ex) {
                        JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    adminGUI.updateList(deliveryService.getMenuItems());
                    Serializator.serialize(deliveryService.getMenuItems(),"items.txt");
                });
                adminGUI.getBtnDeleteProducts().addActionListener(f->{
                    deliveryService.getMenuItems().removeAll(adminGUI.getList().getSelectedValuesList());
                    adminGUI.updateList(deliveryService.getMenuItems());
                    Serializator.serialize(deliveryService.getMenuItems(),"items.txt");
                });
                adminGUI.getBtnModifyProducts().addActionListener(f->{
                    try{
                        MenuItem newItem=new BaseProduct(adminGUI.getTextFieldTitle().getText(),Double.parseDouble(adminGUI.getTextFieldRating().getText()) ,Double.parseDouble(adminGUI.getTextFieldCalories().getText()),Double.parseDouble(adminGUI.getTextFieldProtein().getText()),Double.parseDouble(adminGUI.getTextFieldFat().getText()),Double.parseDouble(adminGUI.getTextFieldSodium().getText()),Double.parseDouble(adminGUI.getTextFieldPrice().getText()) );
                        MenuItem original= (MenuItem) adminGUI.getList().getSelectedValue();
                        if(original==null){
                            JOptionPane.showMessageDialog(new JFrame(),"Select an item to modify.","Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        deliveryService.modifyItem(original,newItem);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(new JFrame(),"Invalid number format.","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }catch (AssertionError ex) {
                        JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    adminGUI.updateList(deliveryService.getMenuItems());
                    Serializator.serialize(deliveryService.getMenuItems(),"items.txt");
                });
                adminGUI.getBtnNewProducts().addActionListener(f->{
                    try{
                        deliveryService.addMenuItem(new CompositeProduct(adminGUI.getTextFieldTitle().getText(),adminGUI.getList().getSelectedValuesList()));
                    } catch (AssertionError ex) {
                        JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    adminGUI.updateList(deliveryService.getMenuItems());
                    Serializator.serialize(deliveryService.getMenuItems(),"items.txt");
                });
                adminGUI.getBtnImport().addActionListener(f->{
                    try {
                        deliveryService.importProducts();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        return;
                    }
                    adminGUI.updateList(deliveryService.getMenuItems());
                    Serializator.serialize(deliveryService.getMenuItems(),"items.txt");
                });
            } else if(user.getRole()==1){ //Client
                ClientGUI clientGUI=new ClientGUI();
                clientGUI.updateList(deliveryService.getMenuItems());
                clientGUI.getBtnSearch().addActionListener(f->{
                    String title=clientGUI.getTextFieldKeyword().getText();
                    double rating=0,calories=0,proteins=0,fats=0,sodium=0,price=0;
                    boolean titleR=true, ratingR=true,caloriesR=true,proteinsR=true,fatsR=true,sodiumR=true,priceR=true;
                    if(title==null||title.length()==0)
                        titleR=false;
                    try{
                        rating=Double.parseDouble(clientGUI.getTextFieldRating().getText());
                    }catch (Exception exception){
                        ratingR=false;
                    }
                    try{
                        calories=Double.parseDouble(clientGUI.getTextFieldCalories().getText());
                    }catch (Exception exception){
                        caloriesR=false;
                    }
                    try{
                        proteins=Double.parseDouble(clientGUI.getTextFieldProteins().getText());
                    }catch (Exception exception){
                        proteinsR=false;
                    }
                    try{
                        fats=Double.parseDouble(clientGUI.getTextFieldFats().getText());
                    }catch (Exception exception){
                        fatsR=false;
                    }
                    try{
                        sodium=Double.parseDouble(clientGUI.getTextFieldSodium().getText());
                    }catch (Exception exception){
                        sodiumR=false;
                    }
                    try{
                        price=Double.parseDouble(clientGUI.getTextFieldPrice().getText());
                    }catch (Exception exception){
                        priceR=false;
                    }
                    clientGUI.updateList(deliveryService.search(title,titleR,rating,ratingR,calories,caloriesR,proteins,proteinsR,fats,fatsR,sodium,sodiumR,price,priceR));
                });
                clientGUI.getBtnCreateOrder().addActionListener(f->{
                    try{
                        deliveryService.addOrder(user.getId(),clientGUI.getList().getSelectedValuesList());
                    }catch (AssertionError exception){
                        JOptionPane.showMessageDialog(new JFrame(),exception.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    for(EmployeeGUI employeeGUI:employees){
                        employeeGUI.updateList(deliveryService.getActiveOrders());
                    }
                });
            } else if(user.getRole()==2){ // Employee
                EmployeeGUI employeeGUI=new EmployeeGUI();
                employeeGUI.updateList(deliveryService.getActiveOrders());
                employees.add(employeeGUI);
            }
        });
        loginGUI.getBtnRegister().addActionListener(e->{
            try{
                deliveryService.addUser(new User(loginGUI.getUsername(),loginGUI.getPassword(),1));
            }catch (AssertionError error){
                JOptionPane.showMessageDialog(new JFrame(),error.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
        });
    }
}
