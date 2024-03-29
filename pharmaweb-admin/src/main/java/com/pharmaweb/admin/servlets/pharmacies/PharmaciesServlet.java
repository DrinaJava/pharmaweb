package com.pharmaweb.admin.servlets.pharmacies;

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
 * Servlet implementation class PharmaciesServlet
 */
@WebServlet("/Pharmacies")
public class PharmaciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;

	@EJB
	private IPharmacyBean pharmacyBean;



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PharmaciesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("pharmacies", this.pharmacyBean.getAll());

		this.dispatcher = this.getServletContext().getRequestDispatcher("/pharmacies.jsp");
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
