package gov.myjavaprojects.clientorder;


import gov.myjavaprojects.clientorder.domain.Address;
import gov.myjavaprojects.clientorder.domain.Child;
import gov.myjavaprojects.clientorder.domain.ClientOrder;
import gov.myjavaprojects.clientorder.domain.Adult;

import java.time.LocalDate;

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
        clientOrder.setMerriageCertificateId(" " + (1000+id));
        clientOrder.setMarriageDate(LocalDate.of(2023,1,1));
        clientOrder.setMerriageOffice("ZAGS OFFICE");
        Address address = new Address("16500","Prospect Naoki","15"," ","50");

        Adult husband = new Adult("Constantinov","Alex","petrovich", LocalDate.of(1991,12,1));
        husband.setPassportNumber("" + (id+1000));
        husband.setPassportSeria("" + (id+2015));
        husband.setIssueDate(LocalDate.of(2022,5,5));
        husband.setIssueDepartment("Sanaa yemen %" + id);
        husband.setClientId(" " + (1312+id));
        husband.setAddress(address);

        Adult wife = new Adult("Romonova","Ksenia","petrovna", LocalDate.of(1991,10,15));
        wife.setPassportNumber("" + (id+5000));
        wife.setPassportSeria("" + (id+5000));
        wife.setIssueDate(LocalDate.of(2022,5,5));
        wife.setIssueDepartment("Sanaa yemen %" + id);
        wife.setClientId(" " + (1312+id));
        wife.setAddress(address);

        Child child1 = new Child("Piskov","Dima","petrov", LocalDate.of(2001,10,15));
        child1.setCertificateNumber("" + (id+1000));
        child1.setIssueDate(LocalDate.of(2022,8,5));
        child1.setIssueDepartment("Sanaa yemen %" + id);
        child1.setAddress(address);

        Child child2 = new Child("Hizam","Nabil","Hizam", LocalDate.of(2001,10,15));
        child2.setCertificateNumber("" + (id+7000));
        child2.setIssueDate(LocalDate.of(2022,8,5));
        child2.setIssueDepartment("Sanaa yemen %" + id);
        child2.setAddress(address);

        clientOrder.setHuzband(husband);
        clientOrder.setWife(wife);
        clientOrder.addChild(child1);
        clientOrder.addChild(child2);


        return clientOrder;
    }
    public static void main(String[] args)
    {
          ClientOrder so = buildclientOrder(10);
    }
}
