package gov.myjavaprojects.clientorder.validator;
import gov.myjavaprojects.clientorder.domain.Person;
import gov.myjavaprojects.clientorder.domain.register.AnswerCityRegister;
import gov.myjavaprojects.clientorder.domain.Child;
import gov.myjavaprojects.clientorder.domain.register.AnswerCityRegisterItem;
import gov.myjavaprojects.clientorder.domain.register.CityRegisterRespone;
import gov.myjavaprojects.clientorder.domain.ClientOrder;
import gov.myjavaprojects.clientorder.exception.CityRegisterException;
import gov.myjavaprojects.clientorder.exception.TransportException;
import gov.myjavaprojects.clientorder.validator.register.CityRegisterChecker;
import gov.myjavaprojects.clientorder.validator.register.FakeCityRegisterChecker;

import java.util.List;

public class CityRegisterValidator {
    public static final String IN_CODE="NO_GRN";

   private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(ClientOrder clientOrder)
    {
        AnswerCityRegister acr = new AnswerCityRegister();
            acr.addItem(checkPerson(clientOrder.getHuzband()));
            acr.addItem(checkPerson(clientOrder.getWife()));
            for(Child child:clientOrder.getChildren())
            {
              acr.addItem(checkPerson(child));
            }
        return acr;
    }
    private AnswerCityRegisterItem checkPerson(Person person)
    {
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
        try
        {
           CityRegisterRespone tmp = personChecker.checkPerson(person);
           status = tmp.isExisting() ? AnswerCityRegisterItem.CityStatus.YES : AnswerCityRegisterItem.CityStatus.NO;
        }catch (CityRegisterException exception) {
            exception.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(exception.getCode(), exception.getMessage());
        }catch (TransportException exception) {
            exception.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, exception.getMessage());
        }catch (Exception e) {
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, e.getMessage());
        }
        AnswerCityRegisterItem aci = new AnswerCityRegisterItem(status,person,error);

        return aci;
    }
}
