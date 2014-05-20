package com.pharmaweb.admin.preparator.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IPharmacyBean;
/**
 * @author Mnky
 *
 */
/**
 * Servlet implementation class PharmaciesServlet
 */
@WebServlet("/PreparatorCatalog")
public class PreparatorCatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;

	@EJB
	private IPharmacyBean pharmacyBean;



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreparatorCatalogServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {


		try{


			request.setAttribute("pharmacie", this.pharmacyBean.getPharmacyById(1));
			request.setAttribute("stockLines", this.pharmacyBean.getStockLines(1));


		}catch(final NumberFormatException e){

			this.dispatcher = this.getServletContext().getRequestDispatcher("/preparatorcatalog.jsp");
			this.dispatcher.forward(request, response); }



		this.dispatcher = this.getServletContext().getRequestDispatcher("/preparatorcatalog.jsp");
		this.dispatcher.forward(request, response);

	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
