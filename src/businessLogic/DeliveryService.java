package businessLogic;

import dataAccess.BillWriter;
import dataAccess.Serializator;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryService {
    private List<User> users;
    private List<MenuItem> menuItems;
    private HashMap<Order,List<MenuItem>> orders;
    private List<Order> activeOrders;

    public DeliveryService() {
        users= (List<User>) Serializator.deserialize("users.txt");
        menuItems=(List<MenuItem>) Serializator.deserialize("items.txt");
        orders=(HashMap<Order, List<MenuItem>>) Serializator.deserialize("orders.txt");
        activeOrders=new ArrayList<>();

        if(users==null){
            users=new ArrayList<>();
            users.add(new User("admin","admin",0));
            users.add(new User("emp","emp",2));
        }
        if(menuItems==null){
            menuItems=new ArrayList<>();
        }
        if(orders==null){
            orders=new HashMap<>();
        }
    }

    public int computeUserId(){
        if(users.size()==0)
            return 1;
        return users.stream().max(Comparator.comparingInt(User::getId)).get().getId()+1;
    }

    public int computeItemId(){
        if(menuItems.size()==0)
            return 1;
        return menuItems.stream().max(Comparator.comparingInt(MenuItem::getId)).get().getId()+1;
    }

    public int computeOrderId(){
        if(orders.keySet().size()==0)
            return 1;
        return orders.keySet().stream().max(Comparator.comparingInt(Order::getId)).get().getId()+1;
    }

    public User findByUsername(String username){
        for(User user:users)
            if(user.getUsername().compareTo(username)==0)
                return user;
        return null;
    }

    public User findById(int id){
        for(User user:users)
            if(user.getId()==id)
                return user;
        return null;
    }

    public void addUser(User user){
        assert findByUsername(user.getUsername())==null:"User already exists.";
        assert user.getUsername()!=null&&user.getUsername().length()!=0:"Invalid username.";
        assert user.getPassword()!=null&&user.getPassword().length()!=0:"Password too weak.";
        user.setId(computeUserId());
        users.add(user);
        Serializator.serialize(users,"users.txt");
    }

    public User login(String username,String password){
        User user=findByUsername(username);
        assert user!=null:"User doesn't exist.";
        assert user.getPassword().compareTo(password)==0:"Incorrect password.";
        return user;
    }

    public void validateItem(MenuItem menuItem){
        assert menuItem.getTitle()!=null&&menuItem.getTitle().length()>0:"Invalid title.";
        assert menuItem.computeCalories()>=0:"Invalid Calories.";
        assert menuItem.computeProtein()>=0:"Invalid Protein.";
        assert menuItem.computeFats()>=0:"Invalid Fats.";
        assert menuItem.computeSodium()>=0:"Invalid sodium.";
        assert menuItem.computePrice()>=0:"Invalid price.";
        assert menuItem.computeRating()>=0&&menuItem.computeRating()<=5:"Invalid Rating.";
        if(menuItem.getClass().equals(CompositeProduct.class)){
            assert ((CompositeProduct) menuItem).getWantedMenu()!=null&&((CompositeProduct) menuItem).getWantedMenu().size()>1:"Not enough items.";
        }
    }

    public void importProducts() throws IOException {
        menuItems=new ArrayList<>();
        File in=new File("products.csv");
        InputStream inFile=new FileInputStream(in);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inFile));

        bufferedReader.lines().skip(1).forEach(line->{
            String[] values=line.split(",");
            BaseProduct baseProduct=new BaseProduct();
            baseProduct.setTitle(values[0]);
            baseProduct.setRating(Double.parseDouble(values[1]));
            baseProduct.setCalories(Double.parseDouble(values[2]));
            baseProduct.setProteins(Double.parseDouble(values[3]));
            baseProduct.setFats(Double.parseDouble(values[4]));
            baseProduct.setSodium(Double.parseDouble(values[5]));
            baseProduct.setPrice(Double.parseDouble(values[6]));
            addMenuItem(baseProduct);
        });

        menuItems=menuItems.stream().filter(n->{
            for(MenuItem menuItem:menuItems){
                if(menuItem.getTitle().equals(n.getTitle()))
                    if(menuItem==n)
                        return true;
                    else
                        return false;
            }
            return true;
        }).collect(Collectors.toList());
        bufferedReader.close();
        inFile.close();
    }

    public void addOrder(int clientId,List<MenuItem> list){
        assert list!=null&&list.size()>0:"Not enough items.";
        Order order=new Order(computeOrderId(),clientId);
        orders.put(order,list);
        activeOrders.add(order);
        BillWriter.bill(order,list);
        Serializator.serialize(orders,"orders.txt");
    }

    public List<MenuItem> search(String title,boolean titleR,double rating,boolean ratingR,double calories,boolean caloriesR,double proteins,boolean proteinsR,double fats,boolean fatsR,double sodium,boolean sodiumR,double price,boolean priceR){
        return menuItems.stream().filter(n-> ((!titleR||n.getTitle().toLowerCase().contains(title.toLowerCase()))&&(!ratingR||n.computeRating()==rating)&&(!caloriesR||n.computeCalories()==calories)&&(!proteinsR||n.computeProtein()==proteins)&&(!fatsR||n.computeFats()==fats)&&(!sodiumR||n.computeSodium()==sodium)&&(!priceR||n.computePrice()==price))).collect(Collectors.toList());
    }

    public void addMenuItem(MenuItem menuItem){
        validateItem(menuItem);
        menuItem.setId(computeItemId());
        menuItems.add(menuItem);
    }

    public void modifyItem(MenuItem original,MenuItem newItem){
        validateItem(newItem);
        assert original instanceof BaseProduct:"Cannot modify menu.";
        ((BaseProduct)original).set((BaseProduct)newItem);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public HashMap<Order, List<MenuItem>> getOrders() {
        return orders;
    }

    public List<Order> getActiveOrders() {
        return activeOrders;
    }

    public List<Order> report(int startHour,int endHour){
        return orders.keySet().stream().filter(n->n.getTime().getHour()>=startHour&&n.getTime().getHour()<endHour).collect(Collectors.toList());
    }
    public List<MenuItem> report(int numberOfTimes){
        List<MenuItem> totalList=new ArrayList<>();
        for(Order order:orders.keySet())
            totalList.addAll(orders.get(order));
        return menuItems.stream().filter(n->Collections.frequency(totalList,n)>=numberOfTimes).collect(Collectors.toList());
    }

    public List<User> report3(int numberOfTimes,int value){
        List<User> totalList=new ArrayList<>();
        for(Order order:orders.keySet()){
            double price=0;
            for(MenuItem menuItem:orders.get(order))
                price+=menuItem.computePrice();
            if(price>=value)
                totalList.add(findById(order.getClientId()));
        }
        return users.stream().filter(n->Collections.frequency(totalList,n)>=numberOfTimes).collect(Collectors.toList());
    }
    public List<Order> report(LocalDate  localDate){
        return orders.keySet().stream().filter(n->n.getTime().toLocalDate().equals(localDate)).collect(Collectors.toList());
    }
}
