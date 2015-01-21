package com.nyleptha.martha.grammer;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class NewFileXMLParser {

	static File xmlFile = new File(
			"/home/dilshan/office/Martha_Web_V1/src/rules.xml");
	static DocumentBuilderFactory docFactory = DocumentBuilderFactory
			.newInstance();
	static DocumentBuilder docBuilder;
	static String objPath = "/home/dilshan/office/Martha/src/main/resources/document.ser";

	// create an xml file with root element and without attribute and value
	public static void createXML(String sentence, String subj, String subjVal,
			String verb, String verbVal, String obj, String objVal) {
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("rules");
			Element ruleElement = doc.createElement("rule");
			Element sentenceElement = doc.createElement(sentence);
			Element subjectElement = doc.createElement("subject");
			
			Element insideSubject = doc.createElement(subj);		
			if (!(subjVal.equals(null)) && !(subjVal.isEmpty())) {
				insideSubject.setTextContent(subjVal);
			}
			Element verbElement = doc.createElement("verb");
			Element insideVerb = doc.createElement(verb);
			if (!(verbVal.equals(null)) && !(verbVal.isEmpty())) {
				insideVerb.setTextContent(verbVal);
			}
			Element objectElement = doc.createElement("object");
			Element insideObject = doc.createElement(obj);
			if (!(objVal.equals(null)) && !(objVal.isEmpty())) {
				insideObject.setTextContent(objVal);
			}

			// appending elements
			doc.appendChild(rootElement);
			rootElement.appendChild(ruleElement);
			ruleElement.appendChild(sentenceElement);
			sentenceElement.appendChild(subjectElement);
			subjectElement.appendChild(insideSubject);
			sentenceElement.appendChild(verbElement);
			verbElement.appendChild(insideVerb);
			sentenceElement.appendChild(objectElement);
			objectElement.appendChild(insideObject);

			TransformXML(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// transform the xml file
	public static Document TransformXML(Document doc) {
		try {
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(xmlFile);
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}


	public static String getString(String tagName, Element element) {
		NodeList list = element.getElementsByTagName(tagName);
		if (list != null && list.getLength() > 0) {
			NodeList subList = list.item(0).getChildNodes();
			if (subList != null && subList.getLength() > 0) {
				return subList.item(0).getNodeValue();
			}
		}
		return null;
	}

}
