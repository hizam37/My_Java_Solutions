package gov.myjavaprojects.clientorder;

import gov.myjavaprojects.clientorder.domain.*;
import gov.myjavaprojects.clientorder.domain.register.AnswerCityRegister;
import gov.myjavaprojects.clientorder.domain.student.AnswerClient;
import gov.myjavaprojects.clientorder.mail.MailSender;
import gov.myjavaprojects.clientorder.validator.ChildrenValidator;
import gov.myjavaprojects.clientorder.validator.CityRegisterValidator;
import gov.myjavaprojects.clientorder.validator.ClientValidator;
import gov.myjavaprojects.clientorder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class ClientOrderValidator {


    private CityRegisterValidator cityRegisterValidator;
    private WeddingValidator weddingValidator;
    private ChildrenValidator childrenValidator;
    private ClientValidator clientValidator;
    private MailSender mailSender;

    public ClientOrderValidator()
    {
        cityRegisterValidator = new CityRegisterValidator();
        weddingValidator = new WeddingValidator();
        childrenValidator = new ChildrenValidator();
        clientValidator = new ClientValidator();
        mailSender = new MailSender();
    }
    public AnswerClient checkClient(ClientOrder clientOrder)
    {
        return new ClientValidator().checkClient(clientOrder);
    }

        public void checkAll() {
            List<ClientOrder> clientOrdersList = readClientOrders();
            for(ClientOrder clientOrder:clientOrdersList)
            {
                checkOneOrder(clientOrder);
            }

        }

    public List<ClientOrder> readClientOrders()
    {
        List<ClientOrder> clientOrderList = new LinkedList<>();
        for(int c=0;c<5;c++) {
            ClientOrder clientOrder=SaveClientOrder.buildclientOrder(c);
            clientOrderList.add(clientOrder);
        }
        return clientOrderList;
    }

        public void checkOneOrder(ClientOrder clientOrder)
        {
            AnswerCityRegister cityAnswer = checkCityRegister(clientOrder);
//            AnswerWedding wedAnswer = weddingChecker(clientOrder);
//            AnswerChildren childAnswer = checkChildren(clientOrder);
//            AnswerClient studentAnswer = checkClient(clientOrder);
//            sendMail(clientOrder);
        }



    public  AnswerCityRegister checkCityRegister(ClientOrder clientOrder)
    {
       return cityRegisterValidator.checkCityRegister(clientOrder);
    }

    public AnswerWedding weddingChecker(ClientOrder clientOrder)
    {
       return weddingValidator.weddingChecker(clientOrder);
    }
    public void sendMail(ClientOrder clientOrder)
    {
        mailSender.sendMail(clientOrder);
    }

    public AnswerChildren checkChildren(ClientOrder clientOrder)
    {
        return  childrenValidator.checkChildren(clientOrder);
    }
    public static void main(String[] args) {
        ClientOrderValidator clientOrderValidator = new ClientOrderValidator();
        clientOrderValidator.checkAll();
    }
}
