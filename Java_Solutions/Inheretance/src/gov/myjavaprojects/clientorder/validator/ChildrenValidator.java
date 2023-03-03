package gov.myjavaprojects.clientorder.validator;

import gov.myjavaprojects.clientorder.domain.AnswerChildren;
import gov.myjavaprojects.clientorder.domain.ClientOrder;

public class ChildrenValidator {
    public AnswerChildren checkChildren(ClientOrder clientOrder)
    {
        System.out.println("Children check is running");
        return new AnswerChildren();
    }
}
