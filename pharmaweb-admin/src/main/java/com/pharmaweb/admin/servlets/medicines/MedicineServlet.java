package com.pharmaweb.admin.servlets.medicines;

import com.pharmaweb.admin.Message;
import com.pharmaweb.admin.i18n.I18n;
import com.pharmaweb.controller.IMedicineBean;
import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.Produit;
import com.pharmaweb.model.entities.Tva;
import com.pharmaweb.model.entities.TypeDeRemboursement;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MedicineServlet
 * @author Anthony DENAUD
 */
@WebServlet("/Medicine")
public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
       
	@EJB
	private IMedicineBean medicineBean;
	
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
		else if(request.getParameter("edit") != null){
			try{
				int idProduit = Integer.parseInt(request.getParameter("edit"));
				Produit produit = this.medicineBean.getByID(idProduit);
				
				boolean ordo = produit.getRequiereOrdonnanceProduit().toString().equals("1") ? true : false;
				
				request.setAttribute("ordonnance", ordo);
				request.setAttribute("remboursements", medicineBean.getTypesRemboursement());
				request.setAttribute("classes", medicineBean.getFamilies());
				request.setAttribute("tvas", medicineBean.getAllTva());
				request.setAttribute("produit", produit);
			}catch(NumberFormatException e){
			}
			this.dispatcher = getServletContext().getRequestDispatcher("/medicine.jsp");
			this.dispatcher.forward(request, response);
		}else{

			request.setAttribute("remboursements", medicineBean.getTypesRemboursement());
			request.setAttribute("classes", medicineBean.getFamilies());
			request.setAttribute("tvas", medicineBean.getAllTva());
			
			this.dispatcher = getServletContext().getRequestDispatcher("/medicine.jsp");
			this.dispatcher.forward(request, response);			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("edit") != null){
			try{
				int idProduit = Integer.parseInt(request.getParameter("edit"));
				Produit produit = this.medicineBean.getByID(idProduit);
				
				this.save(request, produit);
				this.edit(produit);
				
				request.getSession().setAttribute("message", new Message("", "success", I18n._(I18n.MEDICINE_EDIT_SUCCESS)));
				response.sendRedirect("Medicines");
				
			}catch(NumberFormatException e){
			}
		}else{
			Produit produit = new Produit();
			
			this.save(request, produit);
			this.add(produit);
			
			request.getSession().setAttribute("message", new Message("", "success", I18n._(I18n.MEDICINE_CREATE_SUCCESS)));
			response.sendRedirect("Medicines");
		}
	}
	
	private void save(HttpServletRequest request, Produit produit){
		String name = request.getParameter("name");
		String manufacter = request.getParameter("manufacter");
		String description = request.getParameter("description");
		int idClasse = Integer.parseInt(request.getParameter("classe"));
		int idTva = Integer.parseInt(request.getParameter("tva"));
		int idTypeRemboursement = Integer.parseInt(request.getParameter("remboursement"));
		String ordonance = request.getParameter("ordonance");
		ordonance = ordonance == null ? "0" : "1";
		
		ClassePharmaceutique classe = this.medicineBean.getFamilyById(idClasse);
		Tva tva = this.medicineBean.getTvaById(idTva);
		TypeDeRemboursement typeRemboursement = this.medicineBean.getTypeRemboursementById(idTypeRemboursement);	
		
		produit.setNomProduit(name);
		produit.setNomFabriquantProduit(manufacter);
		produit.setDecriptionProduit(description);
		produit.setClassePharmaceutique(classe);
		produit.setTypeDeRemboursement(typeRemboursement);
		produit.setTva(tva);
		produit.setRequiereOrdonnanceProduit(new BigDecimal(ordonance));		
	}
	private void edit(Produit produit){
		medicineBean.update(produit);
	}
	private void add(Produit produit){
		medicineBean.add(produit);
	}
}
