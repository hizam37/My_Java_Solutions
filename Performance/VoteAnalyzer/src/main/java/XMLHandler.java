import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        if(qName.equalsIgnoreCase("voter")){
            String name = attributes.getValue("name");
            String birthDay = attributes.getValue("birthDay");
            try {
                DBConnection.countVoter(name,birthDay);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
