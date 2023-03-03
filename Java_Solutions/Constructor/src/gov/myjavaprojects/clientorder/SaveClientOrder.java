package gov.myjavaprojects.clientorder;


import gov.myjavaprojects.clientorder.domain.ClientOrder;
import gov.myjavaprojects.clientorder.domain.other.Adult;

public class SaveClientOrder {
    static long saveClientOrder(ClientOrder clientOrder) {
        long ans = 199;
        System.out.println("SaveClientOrder:");
        return ans;
    }

    static ClientOrder buildclientOrder()
    {
        ClientOrder clientOrder = new ClientOrder();
        Adult husband = new Adult();
//        husband.setGivenName("Alex");
//        husband.setSureName("Klien");
//        husband.setPassportNumber("12345");
//        clientOrder.setHuzband(husband);
//        Adult husband = new Adult();
//        String ans = husband.getPersonString();
//        System.out.println(ans);
        return clientOrder;
    }
    public static void main(String[] args)
    {

        buildclientOrder();
//        ClientOrder cl =new ClientOrder();
//        long ans = saveClientOrder(cl);
//        System.out.println(ans);
    }
}
