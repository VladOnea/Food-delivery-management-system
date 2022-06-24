package dataAccess;

import businessLogic.MenuItem;
import businessLogic.Order;

import java.io.FileWriter;
import java.util.List;

public class BillWriter {
    public static void bill(Order order, List<MenuItem> menuItems){
        try{
            FileWriter file=new FileWriter("Order"+order.getId()+".txt");
            file.write(order+"\n");
            double price=0;
            for(MenuItem menuItem:menuItems){
                file.write(menuItem+"\n");
                price+=menuItem.computePrice();
            }
            file.write("Price: "+price);
            file.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
