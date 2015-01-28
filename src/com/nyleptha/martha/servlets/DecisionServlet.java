package com.nyleptha.martha.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.IfStatement;

import com.nyleptha.martha.grammer.DuplicateFinder;
import com.nyleptha.martha.grammer.ExistingFileXmlParser;
import com.nyleptha.martha.grammer.NewFileXMLParser;

/**
 * Servlet implementation class DecisionServlet
 */
@WebServlet("/DecisionServlet")
public class DecisionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static File xmlFile = new File(
			"/home/dilshan/office/Martha_Web_V1/src/rules.xml");
	boolean status = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Override
	public void init() throws ServletException {
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
			String verbNew = (request.getParameter("verbNewValue").trim())
					.replaceAll("\\s+", "");
			String object = (request.getParameter("object").trim()).replaceAll(
					"\\s+", "");
			String objectNew = (request.getParameter("objectNewValue").trim())
					.replaceAll("\\s+", "");

			ExistingFileXmlParser exParser = new ExistingFileXmlParser();
			ExistingFileXmlParser newParser = new ExistingFileXmlParser();

			DuplicateFinder finder = new DuplicateFinder();
			status = finder.findDuplicates(sentenceType, subject, subjectNew,
					verb, verbNew, object, objectNew);

			if (status) {
				System.out.println("Hello");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/plain");
				response.getWriter().write(
						"මෙම ව්‍යාකරණ නීතිය කලින් ඇතුලත් කර ඇත.");
			} else {
				if (xmlFile.exists()) {
					exParser.createXML(sentenceType, subject, subjectNew, verb,
							verbNew, object, "");
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/plain");
					response.getWriter()
							.write("ව්‍යාකරණ නීතිය සාර්ථකව ඇතුලත් කරන ලදී.");
				} else {
					newParser.createXML(sentenceType, subject, subjectNew,
							verb, verbNew, object, "");
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/plain");
					response.getWriter()
							.write("ව්‍යාකරණ නීතිය සාර්ථකව ඇතුලත් කරන ලදී.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
