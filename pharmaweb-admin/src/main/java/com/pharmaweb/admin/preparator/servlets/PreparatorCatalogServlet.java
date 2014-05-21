package com.pharmaweb.admin.preparator.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

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
import com.pharmaweb.controller.IPharmacyBean;
import com.pharmaweb.controller.ISupplierBean;
import com.pharmaweb.model.entities.ClassePharmaceutique;
import com.pharmaweb.model.entities.Fournisseur;
import com.pharmaweb.model.entities.LotProduit;
import com.pharmaweb.model.entities.Pharmacie;
import com.pharmaweb.model.entities.PharmacieStock;
import com.pharmaweb.model.entities.PharmacieStockPK;
import com.pharmaweb.model.entities.Produit;
import com.pharmaweb.model.entities.Tva;
import com.pharmaweb.model.entities.TypeDeRemboursement;
/**
 * @author Mnky
 *
 * Servlet implementation class PharmaciesServlet
 */
@WebServlet("/PreparatorCatalog")
public class PreparatorCatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;

	@EJB
	private IMedicineBean medicineBean;
	@EJB
	private IPharmacyBean pharmacyBean;
	@EJB
	private ISupplierBean supplierBean;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreparatorCatalogServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		
		int idPharmacie = 1; //TODO fix that

		request.setAttribute("stockLines", this.medicineBean.getPharmacieStockByPharmacie(idPharmacie));
		request.getSession().removeAttribute("message");

		if(request.getParameter("edit") != null){
		
			final int idProduit = Integer.parseInt(request.getParameter("edit"));
			request.setAttribute("stocks", this.medicineBean.getLotsFromProduct(idProduit, idPharmacie));

			if(request.getParameter("lot") != null){
				
				final int idLot = Integer.parseInt(request.getParameter("lot"));
				request.setAttribute("stock", this.medicineBean.getPharmacieStockByLot(idLot));
			}
			
			this.dispatcher = this.getServletContext().getRequestDispatcher("/preparatormedicine.jsp");
			this.dispatcher.forward(request, response);
			
		}else if(request.getParameter("new") != null){

			request.setAttribute("produits", this.medicineBean.getAll());

			this.dispatcher = this.getServletContext().getRequestDispatcher("/preparatormedicine.jsp");
			this.dispatcher.forward(request, response);

		}

		this.dispatcher = this.getServletContext().getRequestDispatcher("/preparatorcatalog.jsp");
		this.dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		
		int idPharmacie = 1; //TODO fix that
		Pharmacie pharmacie = this.pharmacyBean.getPharmacyById(idPharmacie);
		
		
		if(request.getParameter("edit") != null){
			
			final int idProduit = Integer.parseInt(request.getParameter("edit"));
			Produit produit = this.medicineBean.getByID(idProduit);
			
			if(request.getParameter("lot") != null){
				final int idLot = Integer.parseInt(request.getParameter("lot"));
				
				LotProduit lot = this.medicineBean.getLotById(idLot);
				PharmacieStock stock = this.medicineBean.getPharmacieStockByLot(idLot);
				
				String numLotProduit = request.getParameter("numlot");
				BigDecimal prixAchat = new BigDecimal(request.getParameter("prixachat"));
				String dateExpirationLotProduit = request.getParameter("expiredate");
				BigDecimal prixUnitaireProduit = new BigDecimal(request.getParameter("puht"));
				BigDecimal quantiteStockProduit = new BigDecimal(request.getParameter("qte"));
						
				lot.setNumLotProduit(numLotProduit);
				lot.setPrixDAchatLotProduit(prixAchat);
				lot.setDateExpirationLotProduit(dateExpirationLotProduit);
				
				stock.setPrixUnitaireProduit(prixUnitaireProduit);
				stock.setQuantiteStockProduit(quantiteStockProduit);
				
				this.medicineBean.updateLot(lot);
				this.medicineBean.updatePharmacieStock(stock);

			}else{ //New
				
				Fournisseur supplier = this.supplierBean.getById(1); //TODO fix that
				
				LotProduit lot = new LotProduit();
				PharmacieStock stock = new PharmacieStock();
				
				String numLotProduit = request.getParameter("numlot");
				BigDecimal prixAchat = new BigDecimal(request.getParameter("prixachat"));
				String dateExpirationLotProduit = request.getParameter("expiredate");
				BigDecimal prixUnitaireProduit = new BigDecimal(request.getParameter("puht"));
				BigDecimal quantiteStockProduit = new BigDecimal(request.getParameter("qte"));
				
				lot.setProduit(produit);
				lot.setNumLotProduit(numLotProduit);
				lot.setPrixDAchatLotProduit(prixAchat);
				lot.setDateExpirationLotProduit(dateExpirationLotProduit);
				lot.setFournisseur(supplier);
				
				int idLot = this.medicineBean.addLot(lot);
				lot = this.medicineBean.getLotById(idLot);
				
				PharmacieStockPK pk = new PharmacieStockPK();
				pk.setIdLotProduit(idLot);
				pk.setIdPharmacie(idPharmacie);
				
				stock.setPrixUnitaireProduit(prixUnitaireProduit);
				stock.setQuantiteStockProduit(quantiteStockProduit);
				stock.setLotProduit(lot);
				stock.setPharmacie(pharmacie);
				stock.setId(pk);
				
				this.medicineBean.addPharmacieStock(stock);
			}
			
			request.setAttribute("stocks", this.medicineBean.getLotsFromProduct(idProduit, idPharmacie));
			
			this.dispatcher = this.getServletContext().getRequestDispatcher("/preparatormedicine.jsp");
			this.dispatcher.forward(request, response);			
		}
		else if(request.getParameter("new") != null){

			final int idProduit = Integer.parseInt(request.getParameter("produit"));
			Produit produit = this.medicineBean.getByID(idProduit);
			
			Fournisseur supplier = this.supplierBean.getById(1); //TODO fix that
			
			LotProduit lot = new LotProduit();
			PharmacieStock stock = new PharmacieStock();
			
			String numLotProduit = request.getParameter("numlot");
			BigDecimal prixAchat = new BigDecimal(request.getParameter("prixachat"));
			String dateExpirationLotProduit = request.getParameter("expiredate");
			BigDecimal prixUnitaireProduit = new BigDecimal(request.getParameter("puht"));
			BigDecimal quantiteStockProduit = new BigDecimal(request.getParameter("qte"));
			
			lot.setProduit(produit);
			lot.setNumLotProduit(numLotProduit);
			lot.setPrixDAchatLotProduit(prixAchat);
			lot.setDateExpirationLotProduit(dateExpirationLotProduit);
			lot.setFournisseur(supplier);
			
			int idLot = this.medicineBean.addLot(lot);
			lot = this.medicineBean.getLotById(idLot);
			
			PharmacieStockPK pk = new PharmacieStockPK();
			pk.setIdLotProduit(idLot);
			pk.setIdPharmacie(idPharmacie);
			
			stock.setPrixUnitaireProduit(prixUnitaireProduit);
			stock.setQuantiteStockProduit(quantiteStockProduit);
			stock.setLotProduit(lot);
			stock.setPharmacie(pharmacie);
			stock.setId(pk);
			
			this.medicineBean.addPharmacieStock(stock);

			request.getSession().setAttribute("message", new Message("", "success", I18n._(I18n.MEDICINE_CREATE_SUCCESS)));
			response.sendRedirect("PreparatorCatalog");
		}
	}
}
