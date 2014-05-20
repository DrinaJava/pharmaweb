package com.pharmaweb.www.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaweb.controller.IClientBean;
import com.pharmaweb.controller.IMedicineBean;
import com.pharmaweb.controller.IOrderBean;
import com.pharmaweb.model.entities.Client;
import com.pharmaweb.model.entities.CommandeClient;
import com.pharmaweb.model.entities.CommandeLotProduit;
import com.pharmaweb.model.entities.LotProduit;
import com.pharmaweb.model.entities.PharmacieStock;
import com.pharmaweb.www.Cart;
import com.pharmaweb.www.CartLine;

/**
 * Servlet implementation class NewOrder
 */
@WebServlet(name = "Commander", urlPatterns = { "/Commander" })
public class NewOrder extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private RequestDispatcher dispatcher;
	
    @EJB
    private IClientBean clientBean;
    
    @EJB 
    private IOrderBean orderBean;
    
    @EJB IMedicineBean medicineBean;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idClient = (Integer) request.getSession().getAttribute("idClient");
		Client client = this.clientBean.getById(idClient);
		
		if(request.getParameter("etape") != null && request.getParameter("etape").equals("recapitulatif")){

			
			CommandeClient commande = new CommandeClient();
			commande.setClient(client);
			commande.setAdresse(client.getAdresse());
			
		
			
			
			List<CommandeLotProduit> produits = new ArrayList<CommandeLotProduit>();
			List<CartLine> lines = ((Cart) request.getSession().getAttribute("cart")).getLines();
			for (CartLine cartLine : lines) {
				
				long idProduit = cartLine.getProduit().getIdProduit();
				long idPharmacie = 1;
				int quantite = cartLine.getQuantite();
				
				LotProduit lot = this.medicineBean.getLotFromProduct(idProduit,idPharmacie,quantite);
				
				CommandeLotProduit commandeLotProduit = new CommandeLotProduit();
				PharmacieStock stock = this.medicineBean.getPharmacieStockByLot((int) lot.getIdLotProduit());
				
				commandeLotProduit.setCommandeClient(commande);
				commandeLotProduit.setLotProduit(lot);
				commandeLotProduit.setQuantiteCommande(new BigDecimal(cartLine.getQuantite()));
				
				commandeLotProduit.setPrixUnitaireProduitCommande(stock.getPrixUnitaireProduit());
				
				produits.add(commandeLotProduit);
			}
			commande.setEstDansLaCommandeClients(produits);
			orderBean.create(commande);
		}
		
		request.setAttribute("client", client);
		
		this.dispatcher = getServletContext().getRequestDispatcher("/neworder.jsp");
		this.dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}