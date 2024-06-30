import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Loader {


    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1572M.xml";
        parseFile(fileName);
    }

    private static void parseFile(String fileName) throws Exception {
        long start = System.currentTimeMillis();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        XMLHandler xmlHandler = new XMLHandler();
        saxParser.parse(new File(fileName),xmlHandler);
        DBConnection.multiInsertQuery();
        long end = System.currentTimeMillis() - start;
        System.out.println("Duration " +end);
    }

}