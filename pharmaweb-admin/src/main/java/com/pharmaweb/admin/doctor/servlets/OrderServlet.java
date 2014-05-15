package com.pharmaweb.admin.doctor.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IOrderBean;
/**
 * @author Mnky
 *
 */
/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/Order" )
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
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("info") != null){
			try{
				final int id_order = Integer.parseInt(request.getParameter("info"));

				request.setAttribute("commande", this.orderBean.getOrderById(id_order));
				request.setAttribute("lignesCommande", this.orderBean.getOrderLines(id_order));


			}catch(final NumberFormatException e){
			}
			this.dispatcher = this.getServletContext().getRequestDispatcher("/order.jsp");
			this.dispatcher.forward(request, response);
		}else{


			this.dispatcher = this.getServletContext().getRequestDispatcher("/order.jsp");
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
