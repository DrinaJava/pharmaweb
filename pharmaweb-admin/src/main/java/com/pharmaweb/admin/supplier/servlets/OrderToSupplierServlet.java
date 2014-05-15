package com.pharmaweb.admin.supplier.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IOrderToSupplierBean;
/**
 * @author Mnky
 *
 */
/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderToSupplier" )
public class OrderToSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;

	@EJB
	private IOrderToSupplierBean orderToSupplierBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderToSupplierServlet() {
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
				final int id_order = Integer.parseInt(request.getParameter("info"));

				request.setAttribute("commande", this.orderToSupplierBean.getOrderById(id_order));
				request.setAttribute("lignesCommande", this.orderToSupplierBean.getOrderLines(id_order));


			}catch(final NumberFormatException e){
			}
			this.dispatcher = this.getServletContext().getRequestDispatcher("/ordertosupplier.jsp");
			this.dispatcher.forward(request, response);
		}else{


			this.dispatcher = this.getServletContext().getRequestDispatcher("/ordertosupplier.jsp");
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
