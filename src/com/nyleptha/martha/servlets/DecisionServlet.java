package com.nyleptha.martha.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.nyleptha.martha.grammer.XMLParser;

/**
 * Servlet implementation class DecisionServlet
 */
@WebServlet("/DecisionServlet")
public class DecisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	@Override
	public void init() throws ServletException {
		XMLParser.createXML("rules");
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
			String sentencetype = (request.getParameter("sentence").trim())
					.replaceAll("\\s+", "");
			String subject = (request.getParameter("subject").trim())
					.replaceAll("\\s+", "");
			String subjectNew = (request.getParameter("subjectNewValue").trim())
					.replaceAll("\\s+", "");
			String verb = (request.getParameter("verb").trim()).replaceAll(
					"\\s+", "");
			String verbNew = (request.getParameter("verbNewValue").trim())
					.replaceAll("\\s+", "");
			String object = (request.getParameter("object").trim()).replaceAll(
					"\\s+", "");
			String objectNew = (request.getParameter("objectNewValue").trim())
					.replaceAll("\\s+", "");
			XMLParser.addChildElement("rules", "rule");
			XMLParser.addChildElement("rule", sentencetype);
			XMLParser.addChildElement(sentencetype, "subject");
			XMLParser.addChildElement("subject", subject, subjectNew);
			XMLParser.addChildElement(sentencetype, "verb");
			XMLParser.addChildElement("verb", verb,verbNew);
			XMLParser.addChildElement(sentencetype, "object");
			XMLParser.addChildElement("object", object);
			response.setContentType("text/string");
			response.getWriter().write(sentencetype);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
