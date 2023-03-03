package gov.myjavaprojects.clientorder;


import gov.myjavaprojects.clientorder.domain.ClientOrder;
import gov.myjavaprojects.clientorder.domain.Person;
import gov.myjavaprojects.clientorder.domain.other.Adult;

public class SaveClientOrder {
    static long saveClientOrder(ClientOrder clientOrder) {
        long ans = 199;
        System.out.println("SaveClientOrder:");
        return ans;
    }

    public static ClientOrder buildclientOrder(long id)
    {
        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setClientorderid(id);
        Adult husband = new Adult("Constantinov","Alex","petrovich",null);
        return clientOrder;
    }
    public static void main(String[] args)
    {

    }
}
