package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class SupprimerPersonne
 */
@WebServlet("/SupprimerPersonne")
public class SupprimerPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service = new ServiceImpl();

	public SupprimerPersonne() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idPersonne"));
		service.supprimerPersonne(service.getPersonne(id));// id doit etre le meme dans la jsp
		// 3-pr�paration � l'envoi
		request.setAttribute("personnes", service.findAllPersonnes());
		request.setAttribute("adresses", service.findAllAdresses());

		// 4-appel de la jsp
		request.getRequestDispatcher("personnes.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
