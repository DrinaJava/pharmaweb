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

}
