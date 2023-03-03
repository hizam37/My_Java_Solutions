package gov.myjavaprojects.clientorder;

import gov.myjavaprojects.clientorder.domain.*;
import gov.myjavaprojects.clientorder.mail.MailSender;
import gov.myjavaprojects.clientorder.validator.ChildrenValidator;
import gov.myjavaprojects.clientorder.validator.CityRegisterValidator;
import gov.myjavaprojects.clientorder.validator.ClientValidator;
import gov.myjavaprojects.clientorder.validator.WeddingValidator;

public class ClientOrderValidator {


    static AnswerClient checkClient(ClientOrder clientOrder)
    {
     return new ClientValidator().checkClient(clientOrder);
    }

    static void checkAll() {
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


    static ClientOrder readClientOrder()
    {
        ClientOrder clientOrder = new ClientOrder();
        return clientOrder;
    }

    static AnswerCityRegister checkCityRegister(ClientOrder clientOrder)
    {
        CityRegisterValidator cityRegisterValidator1 = new CityRegisterValidator();
        cityRegisterValidator1.hostname = "Host 1";




        AnswerCityRegister ans1 = cityRegisterValidator1.checkCityRegister(clientOrder);
       return ans1;
    }

    static AnswerWedding weddingChecker(ClientOrder clientOrder)
    {
        WeddingValidator weddingValidator = new WeddingValidator();
        return weddingValidator.weddingChecker(clientOrder);
    }
    static void sendMail(ClientOrder clientOrder)
    {
        new MailSender().sendMail(clientOrder);
    }

    static AnswerChildren checkChildren(ClientOrder clientOrder)
    {
        ChildrenValidator childrenValidator = new ChildrenValidator();
        return  childrenValidator.checkChildren(clientOrder);
    }
    public static void main(String[] args) {
         checkAll();
    }
}
