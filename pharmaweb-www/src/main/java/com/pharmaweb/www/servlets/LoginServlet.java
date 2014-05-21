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

import com.pharmaweb.controller.IClientBean;
import com.pharmaweb.www.I18n;
import com.pharmaweb.www.Message;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Connexion", urlPatterns = { "/Connexion" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
      
	
	@EJB
	private IClientBean clientBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		this.dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int idClient = this.clientBean.login(username, password);
		
		if(idClient == -1){
			
			request.setAttribute("message", new Message("","danger",I18n._(I18n.INVALID_LOGIN)));
			this.dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			this.dispatcher.forward(request, response);			
		}else{
			Cookie cookie = new Cookie("idClient", String.valueOf(idClient));
			cookie.setMaxAge(172800);
			
			response.addCookie(cookie);
			request.getSession().setAttribute("idClient",idClient);
			response.sendRedirect("Compte");
		}
	}
}
