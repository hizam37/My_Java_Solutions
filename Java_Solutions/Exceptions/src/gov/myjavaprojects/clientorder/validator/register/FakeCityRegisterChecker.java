package gov.myjavaprojects.clientorder.validator.register;

import gov.myjavaprojects.clientorder.domain.Child;
import gov.myjavaprojects.clientorder.domain.register.CityRegisterRespone;
import gov.myjavaprojects.clientorder.domain.Person;
import gov.myjavaprojects.clientorder.domain.Adult;
import gov.myjavaprojects.clientorder.exception.CityRegisterException;
import gov.myjavaprojects.clientorder.exception.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker {

    private static final String GOOD_1 ="1000";
    private static final String GOOD_2 ="2000";
    private static final String BAD_1 ="1431";
    private static final String BAD_2 ="2032";

    private static final String ERROR_1 ="1901";
    private static final String ERROR_2 ="2012";
    private static final String ERROR_T_1 ="2020";
    private static final String ERROR_T_2 ="2015";
    public CityRegisterRespone checkPerson(Person person) throws CityRegisterException, TransportException
    {
        CityRegisterRespone cRRespone = new CityRegisterRespone();
        if(person instanceof Adult) {
            Adult adult = (Adult) person;
            String PS = adult.getPassportSeria();
            if (PS.equals(GOOD_1) || PS.equals(GOOD_2)) {
                cRRespone.setExisting(true);
                cRRespone.setTemporal(false);
            }
            if (PS.equals(BAD_1) || PS.equals(BAD_2)) {
                cRRespone.setExisting(false);
            }
            if (PS.equals(ERROR_1) || PS.equals(ERROR_2)) {
                CityRegisterException ex = new CityRegisterException("1","GRN ERROR " + PS);
                throw ex;
            }
            if (PS.equals(ERROR_T_1) || PS.equals(ERROR_T_2)) {
                TransportException ex = new TransportException("Transport ERROR " + PS);
                throw ex;
            }
        }
            if(person instanceof Child)
            {
                cRRespone.setExisting(true);
                cRRespone.setTemporal(true);
            }

        System.out.println(cRRespone);
        return cRRespone;
    }
}
