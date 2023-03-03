package gov.myjavaprojects.clientorder.validator;

import gov.myjavaprojects.clientorder.domain.CityRegisterCheckerRespone;
import gov.myjavaprojects.clientorder.domain.Person;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    public CityRegisterCheckerRespone checkPerson(Person person)
    {
        return null;
    }
}
