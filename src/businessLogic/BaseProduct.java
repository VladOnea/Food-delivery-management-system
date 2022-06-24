package businessLogic;

public class BaseProduct extends MenuItem {
    private double rating;
    private double calories;
    private double proteins;
    private double fats;
    private double sodium;
    private double price;

    public BaseProduct(String title, double rating, double calories, double proteins, double fats, double sodium, double price) {
        setTitle(title);
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
    }

    public BaseProduct() {

    }

    @Override
    public double computePrice() {
        return price;
    }

    @Override
    public double computeRating() {
        return rating;
    }

    @Override
    public double computeFats() {
        return fats;
    }

    @Override
    public double computeCalories() {
        return calories;
    }

    @Override
    public double computeSodium() {
        return sodium;
    }

    @Override
    public double computeProtein() {
        return proteins;
    }

    public double getRating(){
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getTitle() +
                ", rating=" + rating +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", sodium=" + sodium +
                ", price=" + price;
    }
    public void set(BaseProduct newItem) {
        setTitle(newItem.getTitle());
        rating= newItem.rating;
        calories=newItem.calories;
        proteins=newItem.proteins;
        fats=newItem.fats;
        sodium=newItem.sodium;
        price=newItem.price;
    }
}
