package gov.myjavaprojects.clientorder;

import gov.myjavaprojects.clientorder.domain.ClientOrder;

public class SaveClientOrder {
    static long saveClientOrder(ClientOrder clientOrder) {
        long ans;
        ans = 199;
        System.out.println("ClientOrder:" + clientOrder.gethLastName());
        return ans;
    }
    public static void main(String[] args)
    {
        ClientOrder cl =new ClientOrder();
        cl.sethFirstName("Daniel");
        cl.sethLastName("Hizam");
        cl.setwFirstName("Nella");
        cl.setwLastName("novgmanova");
        long ans = saveClientOrder(cl);
        System.out.println(ans);
    }
}
