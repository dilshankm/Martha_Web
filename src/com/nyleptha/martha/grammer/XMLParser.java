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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {

	static File xmlFile = new File(
			"/home/dilshan/office/Martha_Web_V1/src/rules.xml");
	static DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	static DocumentBuilder docBuilder;
	static String objPath = "/home/dilshan/office/Martha/src/main/resources/document.ser";

	//create an xml file with root element and without attribute and value
	public static void createXML(String root) {
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement(root);
			doc.appendChild(rootElement);
			TransformXML(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//create an xml file with root element and with attribute and value
	public static void createXML(String root,String attribute,String value) {
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement(root);
			rootElement.setAttribute(attribute, value);
			doc.appendChild(rootElement);
			TransformXML(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//transform the xml file
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
	
   //add child elemnts without attributes
	public static void addChildElement(String parent, String child) {
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(xmlFile);
			Node parentNode = doc.getElementsByTagName(parent).item(0);
			Element childElement = doc.createElement(child);
			parentNode.appendChild(childElement);
			TransformXML(doc);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	   //add child elemnts without attributes but with contents
		public static void addChildElement(String parent, String child,String content) {
			try {
				docBuilder = docFactory.newDocumentBuilder();
				Document doc = docBuilder.parse(xmlFile);
				Node parentNode = doc.getElementsByTagName(parent).item(0);
				Element childElement = doc.createElement(child);
				parentNode.appendChild(childElement);
				childElement.setTextContent(content);
				TransformXML(doc);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//add child element with attributes without value
	public static void addChildElement(String parent, String child,String attribute,String value) {
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(xmlFile);
			Node parentNode = doc.getElementsByTagName(parent).item(0);
			Element childElement = doc.createElement(child);
			childElement.setAttribute(attribute, value);
			parentNode.appendChild(childElement);
			TransformXML(doc);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//add child element with attributes without values and attributes and contents
	public static void addChildElement(String parent, String child,String attribute,String value,String content) {
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(xmlFile);
			Node parentNode = doc.getElementsByTagName(parent).item(0);
			Element childElement = doc.createElement(child);
			childElement.setAttribute(attribute, value);
			childElement.setTextContent(content);
			parentNode.appendChild(childElement);
			TransformXML(doc);	
		} catch (Exception e) {
			e.printStackTrace();
		}
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
