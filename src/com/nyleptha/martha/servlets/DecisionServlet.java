package com.nyleptha.martha.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.nyleptha.martha.grammer.ExistingFileXmlParser;
import com.nyleptha.martha.grammer.NewFileXMLParser;
import com.nyleptha.martha.grammer.XMLParser;

/**
 * Servlet implementation class DecisionServlet
 */
@WebServlet("/DecisionServlet")
public class DecisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static File xmlFile = new File(
			"/home/dilshan/office/Martha_Web_V1/src/rules.xml");
	public int id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	@Override
	public void init() throws ServletException {
		id=0;
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String sentenceType = (request.getParameter("sentence").trim())
					.replaceAll("\\s+", "");
			String subject = (request.getParameter("subject").trim())
					.replaceAll("\\s+", "");
			String subjectNew = (request.getParameter("subjectNewValue").trim())
					.replaceAll("\\s+", "");
			String verb = (request.getParameter("verb").trim()).replaceAll(
					"\\s+", "");
			System.out.println("Hi"+verb);
			String verbNew = (request.getParameter("verbNewValue").trim())
					.replaceAll("\\s+", "");
			String object = (request.getParameter("object").trim()).replaceAll(
					"\\s+", "");
			String objectNew = (request.getParameter("objectNewValue").trim())
					.replaceAll("\\s+", "");
			System.out.println(subject);
			if(xmlFile.exists()){
				ExistingFileXmlParser.createXML(sentenceType, subject, subjectNew, verb, verbNew, object, "");
			}else{
				NewFileXMLParser.createXML(sentenceType, subject, subjectNew, verb, verbNew, object, "");
			}
			id++;
			response.setContentType("text/string");
			response.getWriter().write(sentenceType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
