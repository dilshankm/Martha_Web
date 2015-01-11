package com.nyleptha.martha.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public DecisionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sentencetype=(request.getParameter("sentence").trim()).replaceAll("\\s+","");
		System.out.println(sentencetype);
		XMLParser parser=new XMLParser();
		parser.createXML("rules");
		parser.addChildElement("rules","rule");
		parser.addChildElement("rule", sentencetype);
		response.setContentType("text/string");
		response.getWriter().write(sentencetype);
	}

}
