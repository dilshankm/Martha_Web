package com.nyleptha.martha.grammer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class DuplicateFinder {

	static File xmlFile;
	static DocumentBuilderFactory docFactory = DocumentBuilderFactory
			.newInstance();
	static DocumentBuilder docBuilder;
	Properties prop = new Properties();
	InputStream input = null;
	boolean status;

	public DuplicateFinder() {
		try {
			status=false;
			input = new FileInputStream("/home/dilshan/office/Martha_Web_V1/config.properties");
			prop.load(input);
			xmlFile = new File(prop.getProperty("rulesFilePath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean findDuplicates(String aop, String sN, String sV, String vN,
			String vV, String oN, String oV) {
		String subjName = null, subjValue = null, verbName = null, verbValue = null, objectName = null, objectValue = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(xmlFile);
			int aopLength = doc.getElementsByTagName(aop).getLength();
			int subLength=doc.getElementsByTagName("subject").getLength();
			for (int i = 0; i < aopLength; i++) {
				int childNodeLength = doc.getElementsByTagName(aop).item(i)
						.getChildNodes().getLength();
				//for (int j = 0; j < childNodeLength; j++) {
					subjName = doc.getElementsByTagName(aop).item(i)
							.getChildNodes().item(1).getChildNodes().item(1).getNodeName();
					subjValue = doc.getElementsByTagName(aop).item(i)
							.getChildNodes().item(1).getChildNodes().item(1).getTextContent();
					verbName = doc.getElementsByTagName(aop).item(i)
							.getChildNodes().item(3).getChildNodes().item(1).getNodeName();
					verbValue = doc.getElementsByTagName(aop).item(i)
							.getChildNodes().item(3).getChildNodes().item(1).getTextContent();
					objectName = doc.getElementsByTagName(aop).item(i)
							.getChildNodes().item(5).getChildNodes().item(1).getNodeName();
					objectValue = doc.getElementsByTagName(aop).item(i)
							.getChildNodes().item(5).getChildNodes().item(1).getTextContent();
					System.out.println(subjName+subjValue+verbName+verbValue+objectName+objectValue);
					if ((sN.equalsIgnoreCase(subjName))
							&& (sV.equalsIgnoreCase(subjValue))
							&& (vN.equalsIgnoreCase(verbName))
							&& (vV.equalsIgnoreCase(verbValue))
							&& (oN.equalsIgnoreCase(objectName))
							&& (oV.equalsIgnoreCase(objectValue))) {
						status=true;
						break;
					}
					else{
						status=false;
					}
			}  

			System.out.println("status is"+status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
