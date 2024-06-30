import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(1104);
        System.out.println(container.getCount());

        for(int i=1040;i< container.getCount();i++)
        {
            System.out.println(i + " " + (char)i);
        }
        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.
    }
}

