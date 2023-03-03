package gov.myjavaprojects.clientorder;

import gov.myjavaprojects.clientorder.domain.*;
import gov.myjavaprojects.clientorder.mail.MailSender;
import gov.myjavaprojects.clientorder.validator.ChildrenValidator;
import gov.myjavaprojects.clientorder.validator.CityRegisterValidator;
import gov.myjavaprojects.clientorder.validator.ClientValidator;
import gov.myjavaprojects.clientorder.validator.WeddingValidator;

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
        while (true) {
            ClientOrder clientOrder = readClientOrder();

            if(clientOrder ==null)
            {
                break;
            }

            AnswerCityRegister cityAnswer = checkCityRegister(clientOrder);
            if(!cityAnswer.success)
            {
                break;
            }
            AnswerWedding wedAnswer = weddingChecker(clientOrder);
            AnswerChildren answerChildren = checkChildren(clientOrder);
            AnswerClient answerClient = checkClient(clientOrder);

            sendMail(clientOrder);
        }
    }


    public ClientOrder readClientOrder()
    {
        SaveClientOrder.buildclientOrder();
        ClientOrder clientOrder = new ClientOrder();
        return clientOrder;
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
