
public class Main {
    public static void main(String[] args) {
        Basket segreyBasket = new Basket();
        segreyBasket.add("Milk", 40,1,2);
        segreyBasket.add("Pepsi", 40,2,3);
        segreyBasket.print("Sergey");
        Basket kseniaBasket = new Basket();
        System.out.println(segreyBasket.getTotalPrice());
        kseniaBasket.add("Lays", 40,1,2);
        kseniaBasket.add("Fantola", 40,3,3);
        kseniaBasket.print("Ksenia");
        System.out.println(kseniaBasket.getTotalPrice());
        System.out.println("Average Price of Products in all baskets is " + Basket.getAveragePriceOfAllProductsInAllBaskets());
        System.out.println("Average Cost of Products in all baskets is " + Basket.getAverageCostOfAllBaskets());
    }
}
