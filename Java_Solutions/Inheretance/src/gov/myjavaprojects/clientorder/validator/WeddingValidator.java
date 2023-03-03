package gov.myjavaprojects.clientorder.validator;

import gov.myjavaprojects.clientorder.domain.AnswerWedding;
import gov.myjavaprojects.clientorder.domain.ClientOrder;

public class WeddingValidator {

    public AnswerWedding weddingChecker(ClientOrder clientOrder)
    {
        System.out.println("Wedding is launched");
        return new AnswerWedding();
    }
}
