package com.pharmaweb.www.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IMedicineBean;
import com.pharmaweb.www.Cart;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(name = "Panier", urlPatterns = { "/Panier" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;   
	
	@EJB
	private IMedicineBean medicineBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		if(cart == null){
			cart = new Cart(medicineBean);
		}		
		
		if(request.getParameter("del") != null){
			int idProduit = Integer.parseInt(request.getParameter("del"));
			cart.delete(idProduit);
		}
		if(request.getParameter("add") != null){
			int idProduit = Integer.parseInt(request.getParameter("add"));
			cart.add(idProduit);
		}

		request.getSession().setAttribute("cart",cart);
		request.setAttribute("panier",cart.getLines());

		this.dispatcher = this.getServletContext().getRequestDispatcher("/cart.jsp");
		this.dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
