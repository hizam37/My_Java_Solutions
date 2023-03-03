public class SaveClientOrder {
    static void saveClientOrder(ClientOrder cl){
        if(cl.LastName==null | cl.LastName==null)
        {
            System.out.println("hlastName or hFirstName is skipped");
        }
        System.out.println("saveClientOrder :" + cl.FirstName + " " + cl.LastName);
    }
    public static void main(String[] args)
    {
        ClientOrder cl;
        cl = new ClientOrder();
        cl.FirstName = "Jimmy";
        cl.LastName = "Hizam";
        saveClientOrder(cl);
    }
}
