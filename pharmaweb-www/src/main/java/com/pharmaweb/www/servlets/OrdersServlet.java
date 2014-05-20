package com.pharmaweb.www.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IOrderBean;
import com.pharmaweb.model.entities.CommandeClient;
import com.pharmaweb.model.entities.CommandeLotProduit;
import com.pharmaweb.www.LoginCookieHandler;

/**
 * Servlet implementation class Orders
 */
@WebServlet(name = "Commandes", urlPatterns = { "/Commandes" })
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
	@EJB
	private IOrderBean orderBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginCookieHandler.login(request);
		
		request.setAttribute("commandes", orderBean.getAll());
		
		double total = 0;
		
		for (CommandeClient commande : orderBean.getAll()) {
			for(CommandeLotProduit produit : orderBean.getOrderLines((int) commande.getIdCommandeClient())){
				if(produit != null){
					total += produit.getPrixUnitaireProduitCommande().doubleValue() * produit.getQuantiteCommande().doubleValue();
					
				}
			}
		}
		
		request.setAttribute("total", total);
		
		this.dispatcher = this.getServletContext().getRequestDispatcher("/orders.jsp");
		this.dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
