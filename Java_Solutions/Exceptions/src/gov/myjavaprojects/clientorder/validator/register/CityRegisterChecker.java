package gov.myjavaprojects.clientorder.validator.register;

import gov.myjavaprojects.clientorder.domain.register.CityRegisterRespone;
import gov.myjavaprojects.clientorder.domain.Person;
import gov.myjavaprojects.clientorder.exception.CityRegisterException;
import gov.myjavaprojects.clientorder.exception.TransportException;

public interface CityRegisterChecker {
    CityRegisterRespone checkPerson(Person person) throws CityRegisterException, TransportException;
}
