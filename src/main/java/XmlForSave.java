import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

public class XmlForSave {

    public void saveXmlFile(String fileName, String dispatcherId, String targetId) {

        String dir = "D:\\xml\\";
        File file = new File(dir + fileName + ".xml");
        //File file = new File("D:\\xml\\test.xml");

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("message");
            document.appendChild(root);

            Element dispatch = document.createElement("dispatched");
            root.appendChild(dispatch);
            Attr attr = document.createAttribute("id");
            attr.setValue(dispatcherId);
            dispatch.setAttributeNode(attr);

            Element target = document.createElement("target");
            root.appendChild(target);
            Attr attr1 = document.createAttribute("id");
            attr1.setValue(targetId);
            target.setAttributeNode(attr1);

            Element sometag = document.createElement("sometags");
            root.appendChild(sometag);

            Element data = document.createElement("data");
            sometag.appendChild(data);

            Element data1 = document.createElement("data");
            sometag.appendChild(data1);

            Element data2 = document.createElement("data");
            sometag.appendChild(data2);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult =new StreamResult(new FileOutputStream(file));
            transformer.transform(domSource,streamResult);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
