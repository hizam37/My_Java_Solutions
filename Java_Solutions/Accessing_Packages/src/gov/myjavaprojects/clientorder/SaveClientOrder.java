package gov.myjavaprojects.clientorder;

import gov.myjavaprojects.clientorder.domain.ClientOrder;

public class SaveClientOrder {
    static long saveClientOrder(ClientOrder clientOrder) {
        long ans;
        ans = 199;
        System.out.println("ClientOrder:" + clientOrder.hLastName);
        return ans;
    }
    public static void main(String[] args)
    {
        ClientOrder cl =new ClientOrder();
        cl.hFirstName = "Jimmy";
        cl.hLastName = "Hizam";
        cl.wFirstName = "Elizabeth";
        cl.wLastName = "Abdo";

        ClientOrder cl2 = new ClientOrder();
        cl2.hFirstName = "Roman";
        cl2.hLastName = "Costantinov";
        cl2.wFirstName = "Liza";
        cl2.wLastName = "ALFAKI";
        long ans = saveClientOrder(cl2);
        System.out.println(ans);
    }
}
