package businessLogic;

import java.io.Serializable;
import java.util.Objects;

public abstract class  MenuItem implements Serializable {
    private int id;
    private String title;

    public abstract double computePrice();
    public abstract double computeRating();
    public abstract double computeFats();
    public abstract double computeCalories();
    public abstract double computeSodium();
    public abstract double computeProtein();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return id == menuItem.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
