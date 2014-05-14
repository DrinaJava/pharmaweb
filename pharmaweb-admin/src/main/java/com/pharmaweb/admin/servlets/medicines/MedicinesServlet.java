package com.pharmaweb.admin.servlets.medicines;

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
 * Servlet implementation class MedicamentsServlet
 */
@WebServlet("/Medicines")
public class MedicinesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
	@EJB
	private IMedicineBean medicineBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicinesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setAttribute("produits", medicineBean.getAll());
		
		this.dispatcher = getServletContext().getRequestDispatcher("/medicines.jsp");
		this.dispatcher.forward(request, response);
		
		request.getSession().removeAttribute("message");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
