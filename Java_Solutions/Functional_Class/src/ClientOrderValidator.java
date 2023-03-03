public class ClientOrderValidator {


    static AnswerClient checkClient(ClientOrder clientOrder)
    {
        System.out.println("Checking clients");
        return new AnswerClient();
    }

    static void checkAll()
    {
        ClientOrder clientOrder = readClientOrder();
        AnswerCityRegister cityAnswer = checkCityRegister(clientOrder);
        AnswerWedding wedAnswer = weddingChecker(clientOrder);
        AnswerChildren answerChildren = checkChildren(clientOrder);
        AnswerClient answerClient = checkClient(clientOrder);
        sendMail(clientOrder);
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
        return ans;
    }

    static AnswerWedding weddingChecker(ClientOrder clientOrder)
    {
        System.out.println("Wedding is launched");
        return new AnswerWedding();
    }
    static void sendMail(ClientOrder clientOrder)
    {

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
