package com.pharmaweb.www.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IClientBean;
import com.pharmaweb.model.entities.Client;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet(name = "Compte", urlPatterns = { "/Compte" })
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
    
	@EJB
	private IClientBean clientBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("idClient") != null){
			int idClient = (Integer) request.getSession().getAttribute("idClient");
			
			Client client = clientBean.getById(idClient);
			
			request.setAttribute("client", client);		
			
			this.dispatcher = this.getServletContext().getRequestDispatcher("/compte.jsp");
			this.dispatcher.forward(request, response);
		}else{
			response.sendRedirect("Connexion");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
