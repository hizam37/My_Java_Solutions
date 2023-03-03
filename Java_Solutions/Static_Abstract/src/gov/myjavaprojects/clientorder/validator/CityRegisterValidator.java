package gov.myjavaprojects.clientorder.validator;

import gov.myjavaprojects.clientorder.domain.AnswerCityRegister;
import gov.myjavaprojects.clientorder.domain.ClientOrder;

public class CityRegisterValidator {


   public String hostname;
   protected int port;
    private String login;
    String Password;


    public AnswerCityRegister checkCityRegister(ClientOrder clientOrder)
    {
        System.out.println("CityRegister is running : " + hostname + "," + login + "," +Password);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success=false;
        return ans;
    }
}
