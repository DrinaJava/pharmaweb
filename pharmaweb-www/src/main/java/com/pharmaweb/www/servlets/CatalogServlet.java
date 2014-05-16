package com.pharmaweb.www.servlets;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IMedicineBean;
import com.pharmaweb.www.Cart;
import com.pharmaweb.www.I18n;

/**
 * Servlet implementation class MedicineServlet
 * @author Mnky
 */
@WebServlet("/Catalog")
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;

	@EJB
	private IMedicineBean medicineBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CatalogServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("cartadd") != null){
			int idProduit = Integer.parseInt(request.getParameter("cartadd"));
					
			this.addtocart(request, idProduit);
			
			request.setAttribute("message", new Message("","success",I18n._(I18n.CART_ADD)));
		}
		
		request.setAttribute("produits", this.medicineBean.getAll());
		request.setAttribute("categories", this.medicineBean.getFamilies());

		this.dispatcher = this.getServletContext().getRequestDispatcher("/catalog.jsp");
		this.dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		//TODO

	}
	
	private void addtocart(HttpServletRequest request, int idProduit) throws IOException {
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		if(cart == null){
			cart = new Cart(medicineBean);
		}	
		cart.add(idProduit);

		request.getSession().setAttribute("cart",cart);
	}	
}
