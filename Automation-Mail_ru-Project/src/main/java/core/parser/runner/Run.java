package core.parser.runner;


import core.parser.dom.DomParserUser;
import core.parser.model.User;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public class Run {
    private static final String USERS_XML = "Users.xml";
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
            XMLStreamException {

        System.out.println(" ============================== DOM parser =========================");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(USERS_XML);
        List<User> users = new DomParserUser().parse(document);
        users.forEach(user -> System.out.println(user));
    }
}



