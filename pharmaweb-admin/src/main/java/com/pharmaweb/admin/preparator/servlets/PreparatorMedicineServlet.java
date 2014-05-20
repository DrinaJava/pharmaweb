package com.pharmaweb.admin.preparator.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.admin.Message;
import com.pharmaweb.admin.i18n.I18n;
import com.pharmaweb.controller.IMedicineBean;
import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.Produit;
import com.pharmaweb.model.entities.Tva;
import com.pharmaweb.model.entities.TypeDeRemboursement;

/**
 * Servlet implementation class MedicineServlet
 * @author Anthony DENAUD
 */
@WebServlet("/PreparatorMedicine")
public class PreparatorMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;

	@EJB
	private IMedicineBean medicineBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreparatorMedicineServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("del") != null)
			try{
				final int idProduit = Integer.parseInt(request.getParameter("del"));

				request.setAttribute("visible", this.medicineBean.getVisibleProduit(idProduit));

				response.sendRedirect("Medicines");

			}catch(final NumberFormatException e){
			}
		else if(request.getParameter("edit") != null){
			try{
				final int idProduit = Integer.parseInt(request.getParameter("edit"));
				final Produit produit = this.medicineBean.getByID(idProduit);

				final boolean ordo = produit.getRequiereOrdonnanceProduit().toString().equals("1") ? true : false;

				request.setAttribute("ordonnance", ordo);
				request.setAttribute("remboursements", this.medicineBean.getTypesRemboursement());
				request.setAttribute("classes", this.medicineBean.getFamilies());
				request.setAttribute("tvas", this.medicineBean.getAllTva());
				request.setAttribute("produit", produit);
			}catch(final NumberFormatException e){
			}
			this.dispatcher = this.getServletContext().getRequestDispatcher("/medicine.jsp");
			this.dispatcher.forward(request, response);
		}else{

			request.setAttribute("remboursements", this.medicineBean.getTypesRemboursement());
			request.setAttribute("classes", this.medicineBean.getFamilies());
			request.setAttribute("tvas", this.medicineBean.getAllTva());

			this.dispatcher = this.getServletContext().getRequestDispatcher("/medicine.jsp");
			this.dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("edit") != null)
			try{
				final int idProduit = Integer.parseInt(request.getParameter("edit"));
				final Produit produit = this.medicineBean.getByID(idProduit);

				this.save(request, produit);
				this.edit(produit);

				request.getSession().setAttribute("message", new Message("", "success", I18n._(I18n.MEDICINE_EDIT_SUCCESS)));
				response.sendRedirect("Medicines");

			}catch(final NumberFormatException e){
			}
		else{
			final Produit produit = new Produit();

			this.save(request, produit);
			this.add(produit);

			request.getSession().setAttribute("message", new Message("", "success", I18n._(I18n.MEDICINE_CREATE_SUCCESS)));
			response.sendRedirect("Medicines");
		}
	}

	private void save(final HttpServletRequest request, final Produit produit){
		final String name = request.getParameter("name");
		final String manufacter = request.getParameter("manufacter");
		final String description = request.getParameter("description");
		final int idClasse = Integer.parseInt(request.getParameter("classe"));
		final int idTva = Integer.parseInt(request.getParameter("tva"));
		final int idTypeRemboursement = Integer.parseInt(request.getParameter("remboursement"));
		String ordonance = request.getParameter("ordonance");
		ordonance = ordonance == null ? "0" : "1";

		final ClassePharmaceutique classe = this.medicineBean.getFamilyById(idClasse);
		final Tva tva = this.medicineBean.getTvaById(idTva);
		final TypeDeRemboursement typeRemboursement = this.medicineBean.getTypeRemboursementById(idTypeRemboursement);

		produit.setNomProduit(name);
		produit.setNomFabriquantProduit(manufacter);
		produit.setDecriptionProduit(description);
		produit.setClassePharmaceutique(classe);
		produit.setTypeDeRemboursement(typeRemboursement);
		produit.setTva(tva);
		produit.setRequiereOrdonnanceProduit(new BigDecimal(ordonance));

	}
	private void edit(final Produit produit){
		this.medicineBean.update(produit);
	}
	private void add(final Produit produit){
		this.medicineBean.add(produit);
	}
}
