package xml_parsing;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParser {

    public static void main(String[] args) {

        try {
            File inputFile = new File("./input.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //get document
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            //get root element
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            //get list of "student" elements
            NodeList nList = doc.getElementsByTagName("student");
            System.out.println("----------------------------");

            //process list of students
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                //strict check of node's type
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    //convert Node to Element
                    Element eElement = (Element) nNode;
                    //print Element tags and attributes
                    System.out.println("Student roll no : "
                            + eElement.getAttribute("rollno"));
                    System.out.println("First Name : "
                            + eElement
                            .getElementsByTagName("firstname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Last Name : "
                            + eElement
                            .getElementsByTagName("lastname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Nick Name : "
                            + eElement
                            .getElementsByTagName("nickname")
                            .item(0)
                            .getTextContent());
                    System.out.println("Marks : "
                            + eElement
                            .getElementsByTagName("marks")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            //handle exception
            e.printStackTrace();
        }
    }
}
