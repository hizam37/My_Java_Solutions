package gov.myjavaprojects.clientorder.validator;

import gov.myjavaprojects.clientorder.domain.AnswerClient;
import gov.myjavaprojects.clientorder.domain.ClientOrder;

public class ClientValidator {
   public AnswerClient checkClient(ClientOrder clientOrder)
    {
        System.out.println("Checking clients");
        return new AnswerClient();
    }
}
