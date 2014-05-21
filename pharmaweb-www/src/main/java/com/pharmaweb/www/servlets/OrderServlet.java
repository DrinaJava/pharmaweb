package com.pharmaweb.www.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IOrderBean;
import com.pharmaweb.model.entities.CommandeLotProduit;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet(name = "Commande", urlPatterns = { "/Commande" })
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
      
	
	@EJB
	private IOrderBean orderBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("details")!= null){
			
			try{
				int idOrder= Integer.parseInt(request.getParameter("details"));
				
				double total = getTotal(this.orderBean.getOrderLines(idOrder));
				
				request.setAttribute("totalht", total);
				request.setAttribute("commande", this.orderBean.getOrderById(idOrder));
				request.setAttribute("produits", this.orderBean.getOrderLines(idOrder));
				
				this.dispatcher = this.getServletContext().getRequestDispatcher("/order.jsp");
				this.dispatcher.forward(request, response);
				
			}catch(NumberFormatException e){
				response.sendRedirect("Commandes");
			}
			
		}
		else{
			response.sendRedirect("Commandes");
		}
	}

	private double getTotal(List<CommandeLotProduit> orderLines) {

		double total = 0;
		
		for (CommandeLotProduit commandeLotProduit : orderLines) {
			
			double puht = commandeLotProduit.getPrixUnitaireProduitCommande().doubleValue();
			double qte = commandeLotProduit.getQuantiteCommande().doubleValue();
			
			total += puht * qte;
		}
		
		return total;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

