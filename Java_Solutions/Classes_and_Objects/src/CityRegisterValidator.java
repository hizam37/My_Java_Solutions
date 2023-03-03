public class CityRegisterValidator {


    String hostname;
    String login;
    String Password;


    AnswerCityRegister checkCityRegister(ClientOrder clientOrder)
    {
        System.out.println("CityRegister is running : " + hostname + "," + login + "," +Password);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success=false;
        return ans;
    }
}
