package com.pharmaweb.admin.servlets.medicines;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MedicineServlet
 */
@WebServlet("/Medicine")
public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("del") != null){
			try{
				int id_medicine = Integer.parseInt(request.getParameter("del"));
				
				//TODO delete code
				
				response.sendRedirect("Medicines");
				
			}catch(NumberFormatException e){
			}
		}
		if(request.getParameter("edit") != null){
			try{
				int id_medicine = Integer.parseInt(request.getParameter("del"));
				
				//TODO load medicine code
							
				
			}catch(NumberFormatException e){
			}
			this.dispatcher = getServletContext().getRequestDispatcher("/medicine.jsp");
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
