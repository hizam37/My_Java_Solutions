public class ClientOrderValidator {


    static AnswerClient checkClient(ClientOrder clientOrder)
    {
        System.out.println("Checking clients");
        return new AnswerClient();
    }

    static void checkAll() {
        while (true) {
            ClientOrder clientOrder = readClientOrder();

            if(clientOrder ==null)
            {
                break;
            }

            AnswerCityRegister cityAnswer = checkCityRegister(clientOrder);
            if(!cityAnswer.success)
            {
                break;
            }
            AnswerWedding wedAnswer = weddingChecker(clientOrder);
            AnswerChildren answerChildren = checkChildren(clientOrder);
            AnswerClient answerClient = checkClient(clientOrder);

            sendMail(clientOrder);
        }
    }


    static ClientOrder readClientOrder()
    {
        ClientOrder clientOrder = new ClientOrder();
        return clientOrder;
    }

    static AnswerCityRegister checkCityRegister(ClientOrder clientOrder)
    {
        CityRegisterValidator cityRegisterValidator1 = new CityRegisterValidator();
        cityRegisterValidator1.hostname = "Host 1";
        cityRegisterValidator1.login = "Login1";
        cityRegisterValidator1.Password = "Password1";
        CityRegisterValidator cityRegisterValidator2 = new CityRegisterValidator();
        cityRegisterValidator2.hostname = "Host 2";
        cityRegisterValidator2.login = "Login2";
        cityRegisterValidator2.Password = "Password2";
        AnswerCityRegister ans1 = cityRegisterValidator1.checkCityRegister(clientOrder);
        AnswerCityRegister ans2 = cityRegisterValidator2.checkCityRegister(clientOrder);
       return ans1;
    }

    static AnswerWedding weddingChecker(ClientOrder clientOrder)
    {
        System.out.println("Wedding is launched");
        return new AnswerWedding();
    }
    static void sendMail(ClientOrder clientOrder)
    {
        System.out.println("Email sent");
    }

    static AnswerChildren checkChildren(ClientOrder clientOrder)
    {
        System.out.println("Children check is running");
       return new AnswerChildren();
    }
    public static void main(String[] args) {
         checkAll();
    }
}
