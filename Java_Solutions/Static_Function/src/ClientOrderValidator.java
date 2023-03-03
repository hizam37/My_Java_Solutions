public class ClientOrderValidator {

    static void checkCityRegister()
    {
        System.out.println("CityRegister is Running");
    }

    static void weddingChecker()
    {
        System.out.println("Wedding is Running");
    }

    static void checkChildren()
    {
        System.out.println("Children check is Running");
    }

    static void checkClient()
    {
        System.out.println("Checking clients");
    }

    static void checkAll()
    {
        checkCityRegister();
        weddingChecker();
        checkChildren();
        checkClient();
    }
    public static void main(String[] args) {
        checkAll();
    }
}
