package com.pharmaweb.www.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IPharmacyBean;

/**
 * Servlet implementation class PharmaciesServlet
 */
@WebServlet(name = "Pharmacies", urlPatterns = { "/Pharmacies" })
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("pharmacie") != null){
			String idPharmacie = request.getParameter("pharmacie");
			Cookie cookie = new Cookie("idPharmacie", idPharmacie);
			cookie.setMaxAge(172800);
			
			response.addCookie(cookie);
			response.sendRedirect("Catalog");
			
		}else{
			request.setAttribute("pharmacies", pharmacyBean.getAll());
			
			this.dispatcher = this.getServletContext().getRequestDispatcher("/pharmacies.jsp");
			this.dispatcher.forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
