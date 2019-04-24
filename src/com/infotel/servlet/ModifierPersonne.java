package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class ModifierPersonne
 */
@WebServlet("/ModifierPersonne")
public class ModifierPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private Iservice service =new ServiceImpl();
    public ModifierPersonne() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  Personne p =service.affichagePersonne(Integer.parseInt(request.getParameter("idPersonne")));//remplace 3 lignes//????
  
   request.setAttribute("id", p.getId());//id lastanme firstname sont definis dans le formulaire et jsp  //
   request.setAttribute("lastname", p.getNom());//seter cest a dire metrre dans la case
   request.setAttribute("firstname", p.getPrenom());//apres p.geton trouve les classe
   request.setAttribute("age", p.getAge());
   
	//3-préparation à l'envoi
   request.setAttribute("personnes", service.findAllPersonnes());//personnes dans jsp sert a parcourir les personnes 
   request.setAttribute("adresses", service.findAllAdresses());
                       //4-appel de la jsp
 		request.getRequestDispatcher("personnes.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
