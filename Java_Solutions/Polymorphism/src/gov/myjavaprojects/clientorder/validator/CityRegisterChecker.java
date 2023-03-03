package gov.myjavaprojects.clientorder.validator;

import gov.myjavaprojects.clientorder.domain.CityRegisterCheckerRespone;
import gov.myjavaprojects.clientorder.domain.Person;

public interface CityRegisterChecker {
    CityRegisterCheckerRespone checkPerson(Person person);
}
