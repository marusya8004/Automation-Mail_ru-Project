package core.parser.runner;

import core.parser.dom.DomParserUser;
import core.parser.model.User;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public class Parsing {
    private static final String USERS_XML = "Users.xml";

    public List<User> parse() throws ParserConfigurationException, IOException,
            XMLStreamException, org.xml.sax.SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(USERS_XML);
        List<User> users = new DomParserUser().parse(document);
        return users;
    }
}

