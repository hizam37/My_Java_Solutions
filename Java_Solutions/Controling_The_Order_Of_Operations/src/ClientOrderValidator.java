public class ClientOrderValidator {


    static AnswerClient checkClient(ClientOrder clientOrder)
    {
        System.out.println("Checking clients");
        return new AnswerClient();
    }

    static void checkAll() {
        while (true) {
            ClientOrder clientOrder = readClientOrder();
            System.out.println("Start");
            if(clientOrder ==null)
            {
                break;
            }
            System.out.println("Finish");
            AnswerCityRegister cityAnswer = checkCityRegister(clientOrder);
            if(!cityAnswer.success)
            {
                continue;
            }
            AnswerWedding wedAnswer = weddingChecker(clientOrder);
            AnswerChildren answerChildren = checkChildren(clientOrder);
            AnswerClient answerClient = checkClient(clientOrder);

            sendMail(clientOrder);
        }
        System.out.println("Finish 2");
    }


    static ClientOrder readClientOrder()
    {
        ClientOrder clientOrder = new ClientOrder();
        return clientOrder;
    }

    static AnswerCityRegister checkCityRegister(ClientOrder clientOrder)
    {
        System.out.println("CityRegister is running");
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success=false;
        return ans;
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
