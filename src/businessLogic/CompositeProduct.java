package businessLogic;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {
    List<BaseProduct> wantedMenu= new ArrayList<>();

    public CompositeProduct(String title,List<BaseProduct> wantedMenu) {
        setTitle(title);
        this.wantedMenu=wantedMenu;
    }

    public double computePrice(){
        double price=0;
        for(MenuItem menuItem:wantedMenu)
            price+=menuItem.computePrice();
        return price;
    }

    @Override
    public double computeRating() {
        double number=0;
        for(MenuItem menuItem:wantedMenu)
            number+=menuItem.computeFats();
        return number/wantedMenu.size();
    }

    @Override
    public double computeFats() {
        double number=0;
        for(MenuItem menuItem:wantedMenu)
            number+=menuItem.computeFats();
        return number;
    }

    @Override
    public double computeCalories() {
        double number=0;
        for(MenuItem menuItem:wantedMenu)
            number+=menuItem.computeCalories();
        return number;
    }

    @Override
    public double computeSodium() {
        double number=0;
        for(MenuItem menuItem:wantedMenu)
            number+=menuItem.computeSodium();
        return number;
    }

    @Override
    public double computeProtein() {
        double number=0;
        for(MenuItem menuItem:wantedMenu)
            number+=menuItem.computeProtein();
        return number;
    }

    public String toString() {
        return "Menu "+getTitle() +
                ", rating=" + computeRating() +
                ", calories=" + computeCalories() +
                ", proteins=" + computeProtein() +
                ", fats=" + computeFats() +
                ", sodium=" + computeSodium() +
                ", price=" + computePrice();
    }

    public List<BaseProduct> getWantedMenu() {
        return wantedMenu;
    }
}
