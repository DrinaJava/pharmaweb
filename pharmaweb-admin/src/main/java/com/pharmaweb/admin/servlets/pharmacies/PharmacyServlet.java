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
 * @author Mnky
 *
 */
/**
 * Servlet implementation class PharmaciesServlet
 */
@WebServlet("/Pharmacy")
public class PharmacyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;

	@EJB
	private IPharmacyBean pharmacyBean;



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PharmacyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("info") != null){
			try{
				final int id_pharmacy = Integer.parseInt(request.getParameter("info"));

				request.setAttribute("pharmacie", this.pharmacyBean.getPharmacyById(id_pharmacy));
				request.setAttribute("stockLines", this.pharmacyBean.getStockLines(id_pharmacy));
				request.setAttribute("customerOrders", this.pharmacyBean.getCustomerOrders(id_pharmacy));
				request.setAttribute("supplierOrders", this.pharmacyBean.getSupplierOrders(id_pharmacy));
				request.setAttribute("employes", this.pharmacyBean.getEmployes(id_pharmacy));


			}catch(final NumberFormatException e){
			}
			this.dispatcher = this.getServletContext().getRequestDispatcher("/pharmacy.jsp");
			this.dispatcher.forward(request, response);
		}else{


			this.dispatcher = this.getServletContext().getRequestDispatcher("/pharmacy.jsp");
			this.dispatcher.forward(request, response);
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
