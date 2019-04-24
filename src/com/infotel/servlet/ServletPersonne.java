package com.infotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet("/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private Iservice service = new ServiceImpl();// cest tres important de l'ajouter

	private static final long serialVersionUID = 1L;

	public ServletPersonne() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0-Chargement
		// 1-récupération des données
//		String nom=request.getParameter("lastname");
//		String prenom=request.getParameter("firstname");
//		int age=Integer.parseInt(request.getParameter("age"));
		// 1- récupération des données
		String nom;
		String prenom;
		int age;
		int id;
		int adrs;
//		String login;
//		String mdp;//je nomme comme kje ve meme adr a condition je change apres 
		//Faire traitement
		if (request.getParameter("lastname") != null) { // lastname se trouve dans jsp
			age = Integer.parseInt(request.getParameter("age"));
			nom = request.getParameter("lastname");
			prenom = request.getParameter("firstname");
			adrs=Integer.parseInt(request.getParameter("adr"));//on definit adres au lieu d'adresse
//		      login = request.getParameter("login");
//			  mdp = request.getParameter("mdp");
			
			// 2-envoyer à la couche service
			Personne p = new Personne();// je saisis les objets personne vide
			p.setAge(age); // serveur note sur un papier
			p.setNom(nom);
			p.setPrenom(prenom);
//			
//			Connexion c =new Connexion();
//			c.setLogin(login);
//			c.setMdp(mdp);
//			p.setConnexion(c);

		
			if(adrs!=0) {
				p.setAdresse(service.getAdresse(adrs));
			
			
			if (request.getParameter("ajouter") != null) {
				service.ajouterPersonne(p);
			}

			if (request.getParameter("modifier") != null) {
				id = Integer.parseInt(request.getParameter("id"));//????
				p.setId(id);
				p.setAdresse(service.getAdresse(adrs));
				service.modifierPersonne(p);
			}
			}
		}

		// 3-préparation à l'envoi
 		request.setAttribute("personnes", service.findAllPersonnes());
        request.setAttribute("adresses", service.findAllAdresses());
		// 4-appel de la jsp
		request.getRequestDispatcher("personnes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}