package com.pharmaweb.www.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IMedicineBean;
import com.pharmaweb.controller.IPharmacyBean;
import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.Produit;
import com.pharmaweb.www.Cart;
import com.pharmaweb.www.I18n;
import com.pharmaweb.www.LoginCookieHandler;
import com.pharmaweb.www.Message;

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
	
	@EJB
	private IPharmacyBean pharmacyBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CatalogServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		LoginCookieHandler.login(request);
		
		int idPharmacie = this.getIdPharmacie(request);
		
		if(request.getParameter("cartadd") != null){
			int idProduit = Integer.parseInt(request.getParameter("cartadd"));
					
			this.addtocart(request, idProduit);
			
			request.setAttribute("message", new Message("","success",I18n._(I18n.CART_ADD)));
		}
		
		List<Produit> produits = new ArrayList<Produit>();
		
		if(request.getParameter("cat") != null){
			int idClasse = Integer.parseInt(request.getParameter("cat"));
			
			produits = this.medicineBean.getPharmacieStockByPharmacie(idPharmacie,idClasse);
			
		}else{
			produits = this.medicineBean.getPharmacieStockByPharmacie(idPharmacie);
		}
		
		request.setAttribute("pharmacie", this.pharmacyBean.getPharmacyById(idPharmacie));
		request.setAttribute("produits", produits);
		request.setAttribute("categories", this.medicineBean.getFamilies());

		this.dispatcher = this.getServletContext().getRequestDispatcher("/catalog.jsp");
		this.dispatcher.forward(request, response);

	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	}
	
	private void addtocart(HttpServletRequest request, int idProduit) throws IOException {
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		if(cart == null){
			cart = new Cart(medicineBean,this.getIdPharmacie(request));
		}	
		cart.add(idProduit);

		request.getSession().setAttribute("cart",cart);
	}	
	
	private int getIdPharmacie(HttpServletRequest request){
		int idPharmacie = 0;		
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("idPharmacie")){
				idPharmacie = Integer.parseInt(cookies[i].getValue());
			}
		}	
		return idPharmacie;
	}
}
