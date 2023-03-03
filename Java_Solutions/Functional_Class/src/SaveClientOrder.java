public class SaveClientOrder {
    static long saveClientOrder(ClientOrder clientOrder) {
        long ans;
        ans = 199;
        System.out.println("ClientOrder:" + clientOrder.hLastName);
        return ans;
    }
    public static void main(String[] args)
    {
        ClientOrder cl;
        cl = new ClientOrder();
        cl.hFirstName = "Jimmy";
        cl.hLastName = "Hizam";
        cl.wFirstName = "Elizabeth";
        cl.wLastName = "Abdo";

        long ans = saveClientOrder(cl);
        System.out.println(ans);
    }
}
