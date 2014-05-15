package com.pharmaweb.www.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IClientBean;
import com.pharmaweb.controller.IStatusBean;
import com.pharmaweb.model.entities.Adresse;
import com.pharmaweb.model.entities.Client;
import com.pharmaweb.model.entities.Statut;

/**
 * Servlet implementation class Register
 * @author Anthony DENAUD
 */
@WebServlet(name = "Inscription", urlPatterns = { "/Inscription" })
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
    
	@EJB
	private IClientBean clientBean;
	
	@EJB
	private IStatusBean statusBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("statuts", statusBean.getAll());
		
		this.dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		this.dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idStatut = Integer.parseInt(request.getParameter("statut"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String password = request.getParameter("password");
		String adresse1 = request.getParameter("adresse");
		String adresse2 = request.getParameter("adresse2");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		Statut statut = this.statusBean.getById(idStatut);
		
		Adresse adresse = new Adresse();
		adresse.setAdresseAdresse(adresse1);
		adresse.setComplementAdresse(adresse2);
		adresse.setCodePostalAdresse(new BigDecimal(codePostal));
		adresse.setVilleAdresse(ville);
		
		Client client = new Client();
		client.setPrenomClient(prenom);
		client.setNomClient(nom);
		client.setMailClient(email);
		client.setMdpClient(password);
		client.setStatut(statut);
		client.setNumeroTelClient(telephone);
		client.setAdresse(adresse);
		
		
		int idClient = this.clientBean.add(client);
		
		request.setAttribute("idClient", idClient);
		request.setAttribute("statuts", statusBean.getAll());
		
		this.dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		this.dispatcher.forward(request, response);
	}
}
