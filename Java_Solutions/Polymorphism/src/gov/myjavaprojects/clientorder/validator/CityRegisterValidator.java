package gov.myjavaprojects.clientorder.validator;
import gov.myjavaprojects.clientorder.domain.AnswerCityRegister;
import gov.myjavaprojects.clientorder.domain.ClientOrder;

public class CityRegisterValidator {

   public String hostname;
   protected int port;
   private String login;
   String Password;

   private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(ClientOrder clientOrder)
    {
        personChecker.checkPerson(clientOrder.getHuzband());
        personChecker.checkPerson(clientOrder.getWife());
        personChecker.checkPerson(clientOrder.getChild());
        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
