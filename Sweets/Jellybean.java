package CandyGift.Sweets;

public class Jellybean extends Sweet {
    private String uniqueParameter;


    public Jellybean(String name, double weight, double price, String uniqueParameter) {
        super(name, weight, price);
        this.uniqueParameter = uniqueParameter;
    }

    @Override
    public String toString() {
        return super.toString() + " Уникальный Параметр = " +uniqueParameter;
    }


    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String getUniqueParameter() {
        return uniqueParameter;
    }
}