package com.nyleptha.martha.grammer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

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

	static File xmlFile;
	static DocumentBuilderFactory docFactory = DocumentBuilderFactory
			.newInstance();
	static DocumentBuilder docBuilder;
	Properties prop = new Properties();
	InputStream input = null;
	
	public NewFileXMLParser(){
		try{
			input = new FileInputStream("/home/dilshan/office/Martha_Web_V1/config.properties");
			prop.load(input);
			xmlFile=new File(prop.getProperty("rulesFilePath"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	// create an xml file
	public void createXML(String sentence, String subj, String subjVal,
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
	public Document TransformXML(Document doc) {
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
}
